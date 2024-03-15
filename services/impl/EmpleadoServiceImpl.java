package com.rallyce.Petroleum_Inventario.services.impl;

import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import com.rallyce.Petroleum_Inventario.repositories.EmpleadoRepository;
import com.rallyce.Petroleum_Inventario.services.EmpleadoService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }


    @Override
    public EmpleadoEntity crearEmpleado(EmpleadoEntity empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public EmpleadoEntity actualizarParcialEmpleado(Long id, EmpleadoEntity empleado) {
        empleado.setId(id);

       return empleadoRepository.findById(id).map(empleado1 -> {
            Optional.ofNullable(empleado.getNombre()).ifPresent(empleado1::setNombre);
            Optional.ofNullable(empleado.getPais()).ifPresent(empleado1::setPais);
            Optional.ofNullable(empleado.getCiudad()).ifPresent(empleado1::setCiudad);
            Optional.ofNullable(empleado.getRole()).ifPresent(empleado1::setRole);

            return empleadoRepository.save(empleado1);
        }).orElseThrow(() -> new RuntimeException("El empleado no existe"));
    }

    @Override
    public List<EmpleadoEntity> encontrarTodos(){
        return StreamSupport.stream(empleadoRepository.findAll()
                .spliterator(),
                false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpleadoEntity> encontrarEmpleado(Long id){
        return empleadoRepository.findById(id);
    }

    @Override
    public boolean encontrarId(Long id){
        return empleadoRepository.existsById(id);
    }

    @Override
    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }


}
