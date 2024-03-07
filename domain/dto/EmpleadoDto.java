package com.rallyce.Petroleum_Inventario.domain.dto;

import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDto {

    private Long id;

    private UserSecurityEntity empleadoUsername;

    private String nombre;

    private String apellido;

}
