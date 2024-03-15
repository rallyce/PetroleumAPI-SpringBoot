package com.rallyce.Petroleum_Inventario.services;

import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    EmpleadoEntity crearEmpleado(EmpleadoEntity empleado);

    EmpleadoEntity actualizarParcialEmpleado(Long id, EmpleadoEntity empleado);

    List<EmpleadoEntity> encontrarTodos();

    Optional<EmpleadoEntity> encontrarEmpleado(Long id);

    public boolean encontrarId(Long id);

    void eliminarEmpleado(Long id);
}
