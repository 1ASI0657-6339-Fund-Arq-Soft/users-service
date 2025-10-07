package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

public record AddressResource(
        String street,
        String city,
        String state,
        String zipCode,
        String country
) {}
