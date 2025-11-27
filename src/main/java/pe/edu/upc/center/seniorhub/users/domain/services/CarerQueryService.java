package pe.edu.upc.center.seniorhub.users.domain.services;

import pe.edu.upc.center.seniorhub.users.domain.model.entities.Carer;

import java.util.List;
import java.util.Optional;

public interface CarerQueryService {
    List<Carer> getAllCarers();
    Optional<Carer> getCarerById(Long id);
}
