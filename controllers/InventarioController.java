package com.rallyce.Petroleum_Inventario.controllers;

import com.rallyce.Petroleum_Inventario.domain.dto.InventarioDto;
import com.rallyce.Petroleum_Inventario.domain.entities.InventarioEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import com.rallyce.Petroleum_Inventario.services.InventarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173/")
public class InventarioController {

    private InventarioService inventarioService;

    private Mapper<InventarioEntity, InventarioDto> inventarioMapper;

    public InventarioController(InventarioService inventarioService,
                                Mapper<InventarioEntity, InventarioDto> inventarioMapper){

        this.inventarioService = inventarioService;
        this.inventarioMapper = inventarioMapper;
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<InventarioDto> agregarProducto(
            @PathVariable("id") String idProducto,
            @RequestBody InventarioDto producto){

        InventarioEntity inventarioEntity = inventarioMapper.mapFrom(producto);
        boolean productoExiste = inventarioService.isExists(idProducto);
        InventarioEntity savedInventarioEntity = inventarioService.agregarProducto(idProducto, inventarioEntity);
        InventarioDto savedInventarioDto =  inventarioMapper.mapto(savedInventarioEntity);

        if (productoExiste){

            return new ResponseEntity<>(savedInventarioDto, HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(savedInventarioDto, HttpStatus.CREATED);
        }


    }

    @PatchMapping("/producto/{id}")
    public ResponseEntity<InventarioDto> actualizarParcialProducto(
            @PathVariable("id") String idProducto,
            @RequestBody InventarioDto inventarioDto){

        if (!inventarioService.isExists(idProducto)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        InventarioEntity inventarioEntity = inventarioMapper.mapFrom(inventarioDto);
        InventarioEntity savedInventarioEntity = inventarioService.actualizarParcialProducto(idProducto, inventarioEntity);

        return new ResponseEntity<>(inventarioMapper.mapto(savedInventarioEntity), HttpStatus.OK);
    }

    @GetMapping("/producto")
    public List<InventarioDto> listaProductos(){

        List<InventarioEntity> productosList =  inventarioService.listaProductos();

       return productosList.stream()
                .map(inventarioMapper::mapto)
                .collect(Collectors.toList());
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<InventarioDto> encontrarProducto(@PathVariable("id") String idProducto){

        Optional<InventarioEntity> inventarioEntity = inventarioService.encontrarProducto(idProducto);

        return inventarioEntity.map(inventarioEntity1 -> {

            InventarioDto inventarioDto = inventarioMapper.mapto(inventarioEntity1);
            return new ResponseEntity<>(inventarioDto, HttpStatus.OK);

        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/producto/{id}")
    public ResponseEntity eliminarProducto(@PathVariable("id") String idProducto){

        inventarioService.eliminarProducto(idProducto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
