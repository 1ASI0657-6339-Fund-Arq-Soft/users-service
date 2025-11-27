package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

public record CreateCarerResource(
        String dni,
        String fullName,
        String email,
        String password
) {}
