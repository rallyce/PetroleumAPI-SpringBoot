package com.rallyce.Petroleum_Inventario.domain.dto;

import com.rallyce.Petroleum_Inventario.domain.entities.InventarioEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSecurityDto {

    private Long id;

    private String nombre;


    private String correo;


    private List<InventarioEntity> productos;
}
