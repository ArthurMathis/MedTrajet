package medtrajet.backend.infrastructure.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import medtrajet.backend.presentation.dtos.authentifications.AuthToken;
import medtrajet.backend.presentation.dtos.authentifications.TokenUserData;
import medtrajet.backend.infrastructure.security.jwt.exceptions.ExpiredJwtException;
import medtrajet.backend.infrastructure.security.jwt.exceptions.InvalidJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtProvider {

    private final SecretKey secretKey;
    private final long expirationTime;

    public JwtProvider(
            @Value("${security.jwt.secret-key}") String secretKey,
            @Value("${security.jwt.expiration-time}") long expirationTime
    ) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        this.secretKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
        this.expirationTime = expirationTime;
    }

    public long getExpirationTimeInSeconds() {
        return expirationTime / 1000;
    }

    public AuthToken generateToken(TokenUserData tokenUserData) {
        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date expirationDate = new Date(now + expirationTime);

        String token = Jwts.builder()
                .claim("userId", tokenUserData.userId())
                .setIssuedAt(issuedAt)
                .setExpiration(expirationDate)
                .signWith(secretKey)
                .compact();

        return new AuthToken(token);
    }

    public TokenUserData extract(String  token) throws ExpiredJwtException, InvalidJwtException {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            Long userId = claims.get("userId", Long.class);
            return TokenUserData.builder()
                    .userId(userId)
                    .build();

        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            throw new ExpiredJwtException("Token expired");
        } catch (io.jsonwebtoken.JwtException e) {
            throw new InvalidJwtException("Invalid JWT token");
        }
    }

}
