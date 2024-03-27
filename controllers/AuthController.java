package com.rallyce.Petroleum_Inventario.controllers;

import com.rallyce.Petroleum_Inventario.domain.auth.AuthResponse;
import com.rallyce.Petroleum_Inventario.domain.auth.LoginRequest;
import com.rallyce.Petroleum_Inventario.domain.auth.RegisterRequest;
import com.rallyce.Petroleum_Inventario.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
