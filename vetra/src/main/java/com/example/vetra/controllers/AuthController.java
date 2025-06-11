package com.example.vetra.controllers;

import com.example.vetra.dto.auth.AuthenticationRequest;
import com.example.vetra.dto.auth.AuthenticationResponse;
import com.example.vetra.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
// Esto permite que el front pueda hacer request, si no estuviera, al hacer una request lanzaria CORS error.
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        log.info("Intento de autenticación para el email: {}", request.getEmail());
        try {
            AuthenticationResponse response = authenticationService.authenticate(request);
            log.info("Autenticación exitosa para el email: {}", request.getEmail());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error en la autenticación para el email: {}", request.getEmail(), e);
            throw e;
        }
    }
} 