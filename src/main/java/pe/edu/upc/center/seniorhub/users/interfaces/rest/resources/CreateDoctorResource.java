package pe.edu.upc.center.seniorhub.users.interfaces.rest.resources;

import pe.edu.upc.center.seniorhub.users.domain.model.valueobjects.ContactInfo;
import pe.edu.upc.center.seniorhub.users.domain.model.valueobjects.FullName;
import pe.edu.upc.center.seniorhub.users.domain.model.valueobjects.Schedule;

public record CreateDoctorResource(
        String licenseNumber,
        String specialty,
        //Schedule schedule,
        FullName fullName,
        ContactInfo contactInfo
) {}
