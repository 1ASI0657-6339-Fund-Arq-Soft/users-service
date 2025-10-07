package pe.edu.upc.center.seniorhub.users.domain.services;

import pe.edu.upc.center.seniorhub.users.domain.model.aggregates.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorQueryService {
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorById(Long id);
}
