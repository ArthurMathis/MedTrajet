package medtrajet.backend.infrastructure.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import medtrajet.backend.presentation.dtos.authentifications.TokenUserData;
import medtrajet.backend.infrastructure.security.jwt.exceptions.ExpiredJwtException;
import medtrajet.backend.infrastructure.security.jwt.exceptions.InvalidJwtException;
import medtrajet.backend.presentation.apiResponse.ApiError;
import medtrajet.backend.presentation.apiResponse.ApiResponseUtils;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            @NonNull HttpServletResponse httpServletResponse,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String token = null;
        if (httpServletRequest.getCookies() != null) {
            for (Cookie cookie : httpServletRequest.getCookies()) {
                if ("access_token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token == null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        try {
            final TokenUserData tokenUserData = jwtProvider.extract(token);
            if (tokenUserData != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(tokenUserData.userId(), null, null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch(ExpiredJwtException | InvalidJwtException jwtException) {
            ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, jwtException.getMessage(), httpServletRequest.getRequestURI());
            ApiResponseUtils.jsonError(httpServletResponse, apiError);
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);

        /*
        final String authorizationHeader = httpServletRequest.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        final String token = authorizationHeader.substring(7);
        try {
            final TokenUserData tokenUserData = jwtProvider.extract(token);
            if (tokenUserData != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authToken =  new UsernamePasswordAuthenticationToken(tokenUserData.userId(), null, null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch(ExpiredJwtException | InvalidJwtException jwtException) {
            ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, jwtException.getMessage(), httpServletRequest.getRequestURI());
            ApiResponseUtils.jsonError(httpServletResponse, apiError);
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        */
    }

}
