package pe.edu.upc.center.seniorhub.users.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.center.seniorhub.users.domain.model.aggregates.FamilyMember;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
}
