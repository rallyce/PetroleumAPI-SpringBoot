package com.rallyce.Petroleum_Inventario.mappers.impl;

import com.rallyce.Petroleum_Inventario.domain.dto.AuthoritySecurityDto;
import com.rallyce.Petroleum_Inventario.domain.entities.AuthoritySecurityEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorityMapperImpl implements Mapper<AuthoritySecurityEntity, AuthoritySecurityDto> {

    private ModelMapper modelMapper;

    public AuthorityMapperImpl(ModelMapper modelMapper){

        this.modelMapper = modelMapper;

    }


    @Override
    public AuthoritySecurityDto mapto(AuthoritySecurityEntity authoritySecurityEntity) {
        return modelMapper.map(authoritySecurityEntity, AuthoritySecurityDto.class);
    }

    @Override
    public AuthoritySecurityEntity mapFrom(AuthoritySecurityDto authoritySecurityDto) {
        return modelMapper.map(authoritySecurityDto, AuthoritySecurityEntity.class);
    }
}
