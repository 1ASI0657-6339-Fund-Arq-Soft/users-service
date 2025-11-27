package pe.edu.upc.center.seniorhub.users.domain.services;

import pe.edu.upc.center.seniorhub.users.domain.model.aggregates.Doctor;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.UpdateDoctorResource;

public interface DoctorCommandService {
    Doctor createDoctor(Doctor doctor);


    Doctor updateDoctor(Long id, UpdateDoctorResource resource);

    void deleteDoctor(Long id);

    Doctor assignShift(Long doctorId, String day, String startTime, String endTime, Long appointmentId);
}
