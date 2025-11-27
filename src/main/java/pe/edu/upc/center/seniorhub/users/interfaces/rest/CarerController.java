package pe.edu.upc.center.seniorhub.users.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.seniorhub.users.domain.model.entities.Carer;
import pe.edu.upc.center.seniorhub.users.domain.services.CarerCommandService;
import pe.edu.upc.center.seniorhub.users.domain.services.CarerQueryService;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.CarerResource;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.CreateCarerResource;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.transform.CarerResourceAssembler;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/carers")
@Tag(name = "Carers", description = "Operations related to Carers")
public class CarerController {

    private final CarerCommandService carerCommandService;
    private final CarerQueryService carerQueryService;

    public CarerController(CarerCommandService carerCommandService, CarerQueryService carerQueryService) {
        this.carerCommandService = carerCommandService;
        this.carerQueryService = carerQueryService;
    }

    @Operation(
            summary = "Get all carers",
            description = "Retrieve a list of all carers",
            operationId = "getAllCarers",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of carers retrieved successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CarerResource.class)
                            )
                    )
            }
    )
    @GetMapping
    public List<CarerResource> getAllCarers() {
        return carerQueryService.getAllCarers().stream()
                .map(CarerResourceAssembler::toResource)
                .toList();
    }

    @Operation(
            summary = "Get carer by ID",
            description = "Retrieve a carer's details by their ID",
            operationId = "getCarerById",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Carer found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CarerResource.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Carer not found",
                            content = @Content
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<CarerResource> getCarerById(@PathVariable Long id) {
        return carerQueryService.getCarerById(id)
                .map(CarerResourceAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Create a new carer",
            description = "Register a new carer in the system",
            operationId = "createCarer",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Carer created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CarerResource.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request data",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<CarerResource> createCarer(@RequestBody CreateCarerResource resource) {
        Carer carer = CarerResourceAssembler.toEntity(resource);
        Carer saved = carerCommandService.createCarer(carer);
        return ResponseEntity.status(201).body(CarerResourceAssembler.toResource(saved));
    }

    @Operation(
            summary = "Update carer",
            description = "Update the details of an existing carer",
            operationId = "updateCarer",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Carer updated successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CarerResource.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request data",
                            content = @Content
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<CarerResource> updateCarer(@PathVariable Long id, @RequestBody CreateCarerResource resource) {
        return carerCommandService.updateCarer(id, resource)
                .map(CarerResourceAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Delete carer",
            description = "Remove a carer from the system",
            operationId = "deleteCarer",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Carer deleted successfully"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid ID supplied",
                            content = @Content
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarer(@PathVariable Long id) {
        carerCommandService.deleteCarer(id);
        return ResponseEntity.noContent().build();
    }
}
