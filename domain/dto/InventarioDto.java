package com.rallyce.Petroleum_Inventario.domain.dto;

import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventarioDto {

    private String id;

    private UserSecurityEntity informanteId;

    private String maquina;

    private String producto;

    private String fecha;

    private String descripcion;


}
