package com.example.vetra.services;

import com.example.vetra.dto.auth.AuthenticationRequest;
import com.example.vetra.dto.auth.AuthenticationResponse;
import com.example.vetra.entities.Usuario;
import com.example.vetra.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            log.info("Intentando autenticar usuario: {}", request.getEmail());
            
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            
            var user = usuarioRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado después de autenticación exitosa"));
            
            var jwtToken = jwtService.generateToken(user);
            log.info("Autenticación exitosa para usuario: {}", request.getEmail());
            
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
                    
        } catch (BadCredentialsException e) {
            log.error("Credenciales inválidas para usuario: {}", request.getEmail());
            throw new BadCredentialsException("Credenciales inválidas");
        } catch (AuthenticationException e) {
            log.error("Error de autenticación para usuario: {}", request.getEmail(), e);
            throw e;
        } catch (Exception e) {
            log.error("Error inesperado durante la autenticación para usuario: {}", request.getEmail(), e);
            throw new RuntimeException("Error durante la autenticación", e);
        }
    }
} 