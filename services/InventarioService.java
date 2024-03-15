package com.rallyce.Petroleum_Inventario.services;

import com.rallyce.Petroleum_Inventario.domain.entities.InventarioEntity;

import java.util.List;
import java.util.Optional;

public interface InventarioService {

    InventarioEntity agregarProducto(String idProducto, InventarioEntity producto);

    InventarioEntity actualizarParcialProducto(String idProducto, InventarioEntity producto);

    public boolean isExists(String idProducto);

    List<InventarioEntity> listaProductos();

    Optional<InventarioEntity> encontrarProducto(String idProducto);

    void eliminarProducto(String idProducto);

}
