package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

import pe.edu.upc.center.seniorhub.users.domain.model.valueobjects.ContactInfo;
import pe.edu.upc.center.seniorhub.users.domain.model.valueobjects.FullName;

public record CreateDoctorResource(
        String licenseNumber,
        String specialty,
        FullName fullName,
        ContactInfo contactInfo
) {}
