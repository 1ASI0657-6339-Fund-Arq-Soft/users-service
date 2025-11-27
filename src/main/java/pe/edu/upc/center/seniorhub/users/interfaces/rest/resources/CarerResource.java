package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

public record CarerResource(
        Long id,
        String dni,
        String fullName,
        String email
) {}
