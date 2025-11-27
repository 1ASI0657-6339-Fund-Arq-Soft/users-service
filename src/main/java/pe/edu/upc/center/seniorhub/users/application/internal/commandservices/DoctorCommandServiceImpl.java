package pe.edu.upc.center.seniorhub.users.application.internal.commandservices;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.center.seniorhub.users.domain.model.aggregates.Doctor;
import pe.edu.upc.center.seniorhub.users.domain.services.DoctorCommandService;
import pe.edu.upc.center.seniorhub.users.infrastructure.persistence.jpa.repositories.DoctorRepository;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.transform.DoctorResourceAssembler;

@Service
public class DoctorCommandServiceImpl implements DoctorCommandService {
    private final DoctorRepository doctorRepository;

    public DoctorCommandServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Long id, pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.UpdateDoctorResource resource) {
        var existing = doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found with id " + id));
        return doctorRepository.save(DoctorResourceAssembler.toEntity(resource, existing));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor assignShift(Long doctorId, String day, String startTime, String endTime, Long appointmentId) {
        throw new UnsupportedOperationException("assignShift is not supported");
    }
}
