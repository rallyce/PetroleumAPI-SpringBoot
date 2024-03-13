package com.rallyce.Petroleum_Inventario.domain.dto;

import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
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

    private EmpleadoEntity empleadoId;

    private String producto;

    private String fecha;

    private String descripcion;


}
