package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

public record CreateUserResource(
        String name,
        String email,
        String role
) {
}
