package com.salesianostriana.ejemploCompletoSeguridad.security.jwt.access;

import com.salesianostriana.ejemploCompletoSeguridad.model.User;
import com.salesianostriana.ejemploCompletoSeguridad.repos.UserRepository;
import com.salesianostriana.ejemploCompletoSeguridad.security.exceptionhandling.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //private final UserService userService;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getJwtAccessTokenFromRequest(request);

        try {



        // Validar el token
        // Si es válido, autenticar al usuario
        if(StringUtils.hasText(token) && jwtService.validateAccessToken(token)) {
            UUID id = jwtService.getUserIdFromAccessToken(token);
            Optional<User> optUser = userRepository.findById(id);

            if(optUser.isPresent()) {
                User user = optUser.get();
                UsernamePasswordAuthenticationToken authenticationToken
                        = new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            user.getAuthorities()
                );

                authenticationToken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        } catch(JwtException ex) {
            resolver.resolveException(request, response, null, ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtAccessTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(JwtService.TOKEN_HEADER);
        // Bearer aksjdhasdkjghadskjfghadkfg.sadgadfgdfadskljfhS.sdkfhsdgkdsag
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtService.TOKEN_PREFIX)) {
            return bearerToken.substring(JwtService.TOKEN_PREFIX.length());
        }

        return null;
    }


}
