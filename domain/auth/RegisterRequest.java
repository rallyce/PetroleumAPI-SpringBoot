package com.rallyce.Petroleum_Inventario.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    String nombre;

    String pais;

    String ciudad;

    String username;

    String password;

    String role;

}
