package medtrajet.backend.domain.repositories;

import medtrajet.backend.infrastructure.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserJPA, Long> {

    Optional<UserJPA> findByEmail(String email);

}