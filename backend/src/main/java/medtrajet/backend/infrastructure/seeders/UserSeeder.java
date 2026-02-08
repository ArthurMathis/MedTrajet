package medtrajet.backend.infrastructure.seeders;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.repositories.UserRepository;
import medtrajet.backend.infrastructure.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Value("${data.seed.enabled}")
    private boolean isSeedEnabled;

    @Value("${data.seed.admin.email}")
    private String adminEmail;

    @Value("${data.seed.admin.password}")
    private String adminPassword;

    @Value("${data.seed.user.email}")
    private String userEmail;

    @Value("${data.seed.user.password}")
    private String userPassword;

    @Override
    public void run(String... args) throws Exception {
        this.seedUsers();
    }

    private void seedUsers() {
        if(this.isSeedEnabled && userRepository.count() == 0) {
            List<UserJPA> users = new ArrayList<>();
            users.add(UserJPA.builder()
                    .email(userEmail)
                    .password(this.passwordEncoder.encode(userPassword))
                    .isAdmin(false)
                    .build()
            );
            users.add(UserJPA.builder()
                    .email(adminEmail)
                    .password(this.passwordEncoder.encode(adminPassword))
                    .isAdmin(true)
                    .build()
            );
            userRepository.saveAll(users);
        }
    }

}
