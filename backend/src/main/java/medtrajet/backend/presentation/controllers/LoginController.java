package medtrajet.backend.presentation.controllers;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.services.UserService;
import medtrajet.backend.infrastructure.security.jwt.JwtProvider;
import medtrajet.backend.presentation.dtos.authentifications.AuthToken;
import medtrajet.backend.presentation.dtos.users.LoginUserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "auth")
@AllArgsConstructor
public class LoginController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> authenticate(@RequestBody LoginUserDTO loginUserDTO) {
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

        // return this.userService.authenticate(loginUserDTO);
    }

}
