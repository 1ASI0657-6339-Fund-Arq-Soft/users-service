package pe.edu.upc.center.seniorhub.users.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.center.seniorhub.users.domain.model.entities.Carer;
import pe.edu.upc.center.seniorhub.users.domain.services.CarerQueryService;
import pe.edu.upc.center.seniorhub.users.infrastructure.persistence.jpa.repositories.CarerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarerQueryServiceImpl implements CarerQueryService {
    private final CarerRepository carerRepository;

    public CarerQueryServiceImpl(CarerRepository carerRepository) {
        this.carerRepository = carerRepository;
    }

    @Override
    public List<Carer> getAllCarers() {
        return carerRepository.findAll();
    }

    @Override
    public Optional<Carer> getCarerById(Long id) {
        return carerRepository.findById(id);
    }
}
