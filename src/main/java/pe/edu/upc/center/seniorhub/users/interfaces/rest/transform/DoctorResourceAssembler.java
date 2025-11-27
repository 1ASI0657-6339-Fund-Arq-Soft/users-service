package pe.edu.upc.center.seniorhub.users.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.users.domain.model.aggregates.Doctor;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.CreateDoctorResource;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.DoctorResource;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.UpdateDoctorResource;

import java.time.LocalTime;
import java.util.ArrayList;

public class DoctorResourceAssembler {

    public static DoctorResource toResource(Doctor doctor) {
        return new DoctorResource(
                doctor.getId(),
                doctor.getLicenseNumber(),
                doctor.getSpecialty(),
                doctor.getFullName(),
                doctor.getContactInfo()
        );
    }

    public static Doctor toEntity(CreateDoctorResource resource) {
        Doctor doctor = new Doctor();
        doctor.setLicenseNumber(resource.licenseNumber());
        doctor.setSpecialty(resource.specialty());
        doctor.setFullName(resource.fullName());
        doctor.setContactInfo(resource.contactInfo());
        return doctor;
    }

    public static Doctor toEntity(UpdateDoctorResource resource, Doctor existing) {
        existing.setLicenseNumber(resource.licenseNumber());
        existing.setSpecialty(resource.specialty());
        existing.setFullName(resource.fullName());
        existing.setContactInfo(resource.contactInfo());
        return existing;
    }


}
