package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

import pe.edu.upc.center.seniorhub.users.domain.model.valueobjects.FullName;
import pe.edu.upc.center.seniorhub.users.domain.model.valueobjects.ContactInfo;

public record UpdateDoctorResource(
        String licenseNumber,
        String specialty,
        FullName fullName,
        ContactInfo contactInfo
) {}

