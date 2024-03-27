package com.rallyce.Petroleum_Inventario.services;

import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;


public interface UserSecurityService {


    UserSecurityEntity crearUsuario(UserSecurityEntity userSecurityEntity);

    List<UserSecurityEntity> findAll();

    Optional<UserSecurityEntity> findOne(Long id);

    Optional<UserSecurityEntity> encontrarInformantePorNombre(String nombre);

    public boolean isExists(Long id);

    void eliminarUsuario(Long id);

}
