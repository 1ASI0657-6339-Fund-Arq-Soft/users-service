package pe.edu.upc.center.seniorhub.users.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.center.seniorhub.users.domain.model.aggregates.Doctor;
import pe.edu.upc.center.seniorhub.users.domain.services.DoctorCommandService;
import pe.edu.upc.center.seniorhub.users.domain.services.DoctorQueryService;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.*;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.transform.DoctorResourceAssembler;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/doctors")
@Tag(name = "Doctors", description = "Operations related to Doctors")
public class DoctorController {

    private final DoctorCommandService doctorCommandService;
    private final DoctorQueryService doctorQueryService;

    public DoctorController(DoctorCommandService doctorCommandService, DoctorQueryService doctorQueryService) {
        this.doctorCommandService = doctorCommandService;
        this.doctorQueryService = doctorQueryService;
    }

    @Operation(
            summary = "Get all doctors",
            description = "Retrieve a list of all doctors",
            operationId = "getAllDoctors",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List of doctors retrieved successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DoctorResource.class)
                            )
                    )
            }
    )
    @GetMapping
    public List<DoctorResource> getAllDoctors() {
        return doctorQueryService.getAllDoctors().stream()
                .map(DoctorResourceAssembler::toResource)
                .toList();
    }

    @Operation(
            summary = "Get doctor by ID",
            description = "Retrieve a doctor's details by their ID",
            operationId = "getDoctorById",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Doctor found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DoctorResource.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Doctor not found",
                            content = @Content
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<DoctorResource> getDoctorById(@PathVariable Long id) {
        return doctorQueryService.getDoctorById(id)
                .map(DoctorResourceAssembler::toResource)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Create a new doctor",
            description = "Register a new doctor in the system",
            operationId = "createDoctor",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Doctor created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DoctorResource.class)
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
    public ResponseEntity<DoctorResource> createDoctor(@RequestBody CreateDoctorResource resource) {
        Doctor doctor = DoctorResourceAssembler.toEntity(resource);
        Doctor saved = doctorCommandService.createDoctor(doctor);
        return ResponseEntity.status(201).body(DoctorResourceAssembler.toResource(saved));
    }

    @Operation(
            summary = "Update doctor",
            description = "Update the details of an existing doctor",
            operationId = "updateDoctor",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Doctor updated successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DoctorResource.class)
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
    public ResponseEntity<DoctorResource> updateDoctor(@PathVariable Long id, @RequestBody UpdateDoctorResource resource) {
        Doctor updatedDoctor = doctorCommandService.updateDoctor(id, resource);
        return ResponseEntity.ok(DoctorResourceAssembler.toResource(updatedDoctor));
    }

    @Operation(
            summary = "Delete doctor",
            description = "Remove a doctor from the system",
            operationId = "deleteDoctor",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Doctor deleted successfully"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid ID supplied",
                            content = @Content
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorCommandService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

}
