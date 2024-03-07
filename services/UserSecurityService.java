package com.rallyce.Petroleum_Inventario.services;

import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;


public interface UserSecurityService {


    UserSecurityEntity crearUsuario(UserSecurityEntity userSecurityEntity);

    List<UserSecurityEntity> findAll();

    Optional<UserSecurityEntity> findOne(String userName);

    public boolean isExists(String username);

    void eliminarUsuario(String userName);

}
