package pe.edu.upc.center.seniorhub.users.interfaces.rest.transform;

import pe.edu.upc.center.seniorhub.users.domain.model.entities.Carer;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.CarerResource;
import pe.edu.upc.center.seniorhub.users.interfaces.rest.resources.CreateCarerResource;

public class CarerResourceAssembler {
    public static CarerResource toResource(Carer carer) {
        return new CarerResource(
                carer.getId(),
                carer.getDni(),
                carer.getFullName(),
                carer.getEmail()
        );
    }

    public static Carer toEntity(CreateCarerResource resource) {
        Carer carer = new Carer();
        carer.setDni(resource.dni());
        carer.setFullName(resource.fullName());
        carer.setEmail(resource.email());
        carer.setPassword(resource.password());
        return carer;
    }
}
