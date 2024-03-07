package com.rallyce.Petroleum_Inventario.mappers.impl;

import com.rallyce.Petroleum_Inventario.domain.dto.UserSecurityDto;
import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<UserSecurityEntity, UserSecurityDto> {

    private ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper){

        this.modelMapper = modelMapper;
    }

    @Override
    public UserSecurityDto mapto(UserSecurityEntity userSecurityEntity) {
        return modelMapper.map(userSecurityEntity, UserSecurityDto.class);
    }

    @Override
    public UserSecurityEntity mapFrom(UserSecurityDto userSecurityDto) {
        return modelMapper.map(userSecurityDto, UserSecurityEntity.class);
    }
}
