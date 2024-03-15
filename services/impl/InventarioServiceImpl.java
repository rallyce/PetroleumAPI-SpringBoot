package com.rallyce.Petroleum_Inventario.services.impl;

import com.rallyce.Petroleum_Inventario.domain.entities.InventarioEntity;
import com.rallyce.Petroleum_Inventario.repositories.InventarioRepository;
import com.rallyce.Petroleum_Inventario.services.InventarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InventarioServiceImpl implements InventarioService {

    private InventarioRepository inventarioRepository;

    public InventarioServiceImpl (InventarioRepository inventarioRepository){
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public InventarioEntity agregarProducto(String idProducto, InventarioEntity producto) {
        producto.setId(idProducto);
        return inventarioRepository.save(producto);
    }

    @Override
    public InventarioEntity actualizarParcialProducto(String idProducto, InventarioEntity producto) {
        producto.setId(idProducto);

        return inventarioRepository.findById(idProducto).map(inventarioEntity -> {
            Optional.ofNullable(producto.getProducto()).ifPresent(inventarioEntity::setProducto);
            Optional.ofNullable(producto.getFecha()).ifPresent(inventarioEntity::setFecha);
            Optional.ofNullable(producto.getDescripcion()).ifPresent(inventarioEntity::setDescripcion);

            return inventarioRepository.save(inventarioEntity);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public boolean isExists(String idProducto){
        return inventarioRepository.existsById(idProducto);
    }

    @Override
    public List<InventarioEntity> listaProductos(){
        return StreamSupport.stream(inventarioRepository.findAll()
                .spliterator(), false).
                collect(Collectors.toList());
    }

    @Override
    public Optional<InventarioEntity> encontrarProducto(String idProducto) {
        return inventarioRepository.findById(idProducto);
    }

    @Override
    public void eliminarProducto(String idProducto) {
        inventarioRepository.deleteById(idProducto);
    }



}
