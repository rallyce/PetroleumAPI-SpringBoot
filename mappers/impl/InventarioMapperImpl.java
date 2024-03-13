package com.rallyce.Petroleum_Inventario.mappers.impl;

import com.rallyce.Petroleum_Inventario.domain.dto.InventarioDto;
import com.rallyce.Petroleum_Inventario.domain.entities.InventarioEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InventarioMapperImpl implements Mapper<InventarioEntity, InventarioDto> {

    private ModelMapper modelMapper;

    public InventarioMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }


    @Override
    public InventarioDto mapto(InventarioEntity inventarioEntity) {
        return modelMapper.map(inventarioEntity, InventarioDto.class);
    }

    @Override
    public InventarioEntity mapFrom(InventarioDto inventarioDto) {
        return modelMapper.map(inventarioDto, InventarioEntity.class);
    }
}
