package com.rallyce.Petroleum_Inventario.services;

import com.rallyce.Petroleum_Inventario.domain.auth.AuthResponse;
import com.rallyce.Petroleum_Inventario.domain.auth.LoginRequest;
import com.rallyce.Petroleum_Inventario.domain.auth.RegisterRequest;
import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import com.rallyce.Petroleum_Inventario.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final EmpleadoRepository empleadoRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder; // Password encoder for the obtained password from registering a new user.
    private final AuthenticationManager authenticationManager; // Required for the login and methods which require authentication.

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = empleadoRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .build()
                ;
    }

    public AuthResponse register(RegisterRequest request) {
        EmpleadoEntity empleado = EmpleadoEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .nombre(request.getNombre())
                .pais(request.getPais())
                .ciudad(request.getCiudad())
                .role(request.getRole())
                .build();

        empleadoRepository.save(empleado);

        return AuthResponse.builder()
                .token(jwtService.getToken(empleado))
                .build();

    }
}
