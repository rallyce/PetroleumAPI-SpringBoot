package com.rallyce.Petroleum_Inventario.services.impl;


import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import com.rallyce.Petroleum_Inventario.repositories.UserSecurityRepository;
import com.rallyce.Petroleum_Inventario.services.UserSecurityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    private UserSecurityRepository userSecurityRepository;

    public UserSecurityServiceImpl(UserSecurityRepository userSecurityRepository){

        this.userSecurityRepository = userSecurityRepository;
    }


    @Override
    public UserSecurityEntity crearUsuario(UserSecurityEntity userSecurityEntity) {
        return userSecurityRepository.save(userSecurityEntity);
    }

    @Override
    public List<UserSecurityEntity> findAll() {
        return StreamSupport.stream(userSecurityRepository
                .findAll()
                .spliterator(),
                false)
                .collect(Collectors.toList()

                );
    }

    @Override
    public Optional<UserSecurityEntity> findOne(Long id) {
        return userSecurityRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id){
        
        return userSecurityRepository.existsById(id);
    }

    @Override
    public void eliminarUsuario(Long id) {
        userSecurityRepository.deleteById(id);
    }


}
