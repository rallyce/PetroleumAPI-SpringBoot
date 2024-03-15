package com.rallyce.Petroleum_Inventario.controllers;

import com.rallyce.Petroleum_Inventario.domain.dto.EmpleadoDto;
import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import com.rallyce.Petroleum_Inventario.services.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173/")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    private UserSecurityEntity userSecurityEntity;

    private Mapper<EmpleadoEntity, EmpleadoDto> empleadoMapper;



    public EmpleadoController (EmpleadoService empleadoService, Mapper<EmpleadoEntity, EmpleadoDto> empleadoMapper){
        this.empleadoService = empleadoService;
        this.empleadoMapper= empleadoMapper;
    }

    @PostMapping("/empleado")
    public ResponseEntity<EmpleadoDto> crearEmpleado(@RequestBody EmpleadoDto empleadoDto){
        EmpleadoEntity empleadoEntity = empleadoMapper.mapFrom(empleadoDto);
        EmpleadoEntity savedEmpleadoEntity = empleadoService.crearEmpleado(empleadoEntity);
        return new ResponseEntity<>(empleadoMapper.mapto(savedEmpleadoEntity), HttpStatus.CREATED);
    }

    @GetMapping("/empleado")
    public List<EmpleadoDto> listaEmpleados(){
        List<EmpleadoEntity> empleadosList = empleadoService.encontrarTodos();

        return empleadosList.stream()
                .map(empleadoMapper::mapto)
                .collect(Collectors.toList());

    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<EmpleadoDto> empleadoEsp(@PathVariable("id") Long idEmpleado){

        Optional<EmpleadoEntity> findempleadoEntity = empleadoService.encontrarEmpleado(idEmpleado);

        return findempleadoEntity.map(empleado -> {

            EmpleadoDto empleadoDto = empleadoMapper.mapto(empleado);
            return new ResponseEntity<>(empleadoDto, HttpStatus.OK);

        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @PutMapping("/empleado/{id}")
    public ResponseEntity<EmpleadoDto> actualizarEmpleado(
            @PathVariable("id") Long idEmpleado,
            @RequestBody EmpleadoDto empleadoDto){

        if(!empleadoService.encontrarId(idEmpleado)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        empleadoDto.setId(idEmpleado);

        EmpleadoEntity empleadoEntity = empleadoMapper.mapFrom(empleadoDto);
        EmpleadoEntity savedEmpleadoEntity = empleadoService.crearEmpleado(empleadoEntity);

        return new ResponseEntity<>(empleadoMapper.mapto(savedEmpleadoEntity), HttpStatus.OK);
    }

    @PatchMapping("/empleado/{id}")
    public ResponseEntity<EmpleadoDto> actualizarParcialEmpleado(
            @PathVariable("id") Long idEmpleado,
            @RequestBody EmpleadoDto empleadoDto){

        if (!empleadoService.encontrarId(idEmpleado)){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        EmpleadoEntity empleadoEntity = empleadoMapper.mapFrom(empleadoDto);
        EmpleadoEntity savedEmpleadoEntity = empleadoService.actualizarParcialEmpleado(idEmpleado, empleadoEntity);

        return new ResponseEntity<>(empleadoMapper.mapto(savedEmpleadoEntity), HttpStatus.OK);
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity eliminarEmpleado(@PathVariable("id") Long idEmpleado){

        empleadoService.eliminarEmpleado(idEmpleado);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
