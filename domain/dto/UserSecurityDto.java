package com.rallyce.Petroleum_Inventario.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSecurityDto {


    private String username;


    private String password;


    private String role;
}
