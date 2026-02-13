package medtrajet.backend.presentation.controllers;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.exceptions.InvalidAuthentificationException;
import medtrajet.backend.application.services.UserService;
import medtrajet.backend.infrastructure.security.jwt.JwtProvider;
import medtrajet.backend.presentation.dtos.authentifications.AuthToken;
import medtrajet.backend.presentation.dtos.users.LoginUserDTO;
import medtrajet.backend.presentation.dtos.users.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "auth")
@AllArgsConstructor
public class LoginController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @GetMapping(path = "/me")
    public UserDTO getConnectedUser(Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();
        if(userId == null) {
            throw new InvalidAuthentificationException("Access denied");
        }
        return this.userService.get(userId);
    }

    @PostMapping(path = "/login", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody LoginUserDTO loginUserDTO) {
        AuthToken authToken = this.userService.authenticate(loginUserDTO);

        ResponseCookie jwtCookie = ResponseCookie.from("access_token", authToken.token())
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(jwtProvider.getExpirationTimeInSeconds())
                .sameSite("Lax")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .build();
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie jwtCookie = ResponseCookie.from("access_token", "")
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(0)
                .sameSite("Strict")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .build();
    }

}
