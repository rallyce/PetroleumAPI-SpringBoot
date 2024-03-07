package com.rallyce.Petroleum_Inventario.services.impl;

import com.rallyce.Petroleum_Inventario.domain.entities.AuthoritySecurityEntity;
import com.rallyce.Petroleum_Inventario.repositories.AuthoritySecurityRepository;
import com.rallyce.Petroleum_Inventario.services.AuthoritySecurityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthoritySecurityServiceImpl implements AuthoritySecurityService {

    private AuthoritySecurityRepository authoritySecurityRepository;

    public AuthoritySecurityServiceImpl(AuthoritySecurityRepository authoritySecurityRepository){

        this.authoritySecurityRepository = authoritySecurityRepository;
    }


    @Override
    public AuthoritySecurityEntity asignarAutoridad(String authorityName, AuthoritySecurityEntity authoritySecurityEntity) {
        authoritySecurityEntity.setAuthority(authorityName);
        return authoritySecurityRepository.save(authoritySecurityEntity);
    }

    @Override
    public List<AuthoritySecurityEntity> findAll() {
        return StreamSupport.stream(authoritySecurityRepository
                .findAll()
                .spliterator(),
                false)
                .collect(Collectors.toList()

                );
    }

    @Override
    public Optional<AuthoritySecurityEntity> findOne(String authorityName){

        return authoritySecurityRepository.findById(authorityName);
    }

    @Override
    public boolean isExists(String authorityName) {
        return authoritySecurityRepository.existsById(authorityName);
    }

    @Override
    public void eliminarAutoridad(String authorityName){

        authoritySecurityRepository.deleteById(authorityName);

    }

}
