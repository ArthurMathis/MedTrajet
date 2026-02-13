package medtrajet.backend.domain.repositories;

import medtrajet.backend.infrastructure.jpa.TripJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<TripJPA, Long> {

    Optional<TripJPA> findByUserIdAndEndedAtIsNull(Long userId);

}
