package com.rallyce.Petroleum_Inventario.services;


import com.rallyce.Petroleum_Inventario.domain.entities.AuthoritySecurityEntity;

import java.util.List;
import java.util.Optional;

public interface AuthoritySecurityService {

    AuthoritySecurityEntity asignarAutoridad(String authorityname, AuthoritySecurityEntity authoritySecurityEntity);

    List<AuthoritySecurityEntity> findAll();

    Optional<AuthoritySecurityEntity> findOne(String authorityName);

    public boolean isExists(String authorityName);

    void eliminarAutoridad(String authorityName);

}
