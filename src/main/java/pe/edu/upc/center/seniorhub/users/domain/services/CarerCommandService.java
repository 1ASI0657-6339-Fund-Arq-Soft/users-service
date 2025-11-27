package pe.edu.upc.center.seniorhub.users.domain.services;

import pe.edu.upc.center.seniorhub.users.domain.model.entities.Carer;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.CreateCarerResource;

import java.util.Optional;

public interface CarerCommandService {
    Carer createCarer(Carer carer);
    void deleteCarer(Long id);
    Optional<Carer> updateCarer(Long id, CreateCarerResource resource);
}
