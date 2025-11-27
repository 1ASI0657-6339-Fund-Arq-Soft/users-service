package pe.edu.upc.center.seniorhub.users.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.seniorhub.users.domain.model.entities.Carer;
import pe.edu.upc.center.seniorhub.users.domain.services.CarerCommandService;
import pe.edu.upc.center.seniorhub.users.infrastructure.persistence.jpa.repositories.CarerRepository;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.CreateCarerResource;

import java.util.Optional;

@Service
public class CarerCommandServiceImpl implements CarerCommandService {
    private final CarerRepository carerRepository;

    public CarerCommandServiceImpl(CarerRepository carerRepository) {
        this.carerRepository = carerRepository;
    }

    @Override
    public Carer createCarer(Carer carer) {
        return carerRepository.save(carer);
    }

    @Override
    public void deleteCarer(Long id) {
        carerRepository.deleteById(id);
    }

    @Override
    public Optional<Carer> updateCarer(Long id, CreateCarerResource resource) {
        return carerRepository.findById(id).map(existing -> {
            existing.setDni(resource.dni());
            existing.setFullName(resource.fullName());
            existing.setEmail(resource.email());
            existing.setPassword(resource.password());
            return carerRepository.save(existing);
        });
    }
}
