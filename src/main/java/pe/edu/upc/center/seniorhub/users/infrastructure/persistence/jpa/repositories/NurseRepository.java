package pe.edu.upc.center.seniorhub.users.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.seniorhub.users.domain.model.entities.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
