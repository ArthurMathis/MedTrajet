package medtrajet.backend.domain.repositories;

import medtrajet.backend.infrastructure.jpa.DestinationJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<DestinationJPA, Long> {
}
