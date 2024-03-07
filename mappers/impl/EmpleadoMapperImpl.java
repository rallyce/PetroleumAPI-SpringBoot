package com.rallyce.Petroleum_Inventario.mappers.impl;

import com.rallyce.Petroleum_Inventario.domain.dto.EmpleadoDto;
import com.rallyce.Petroleum_Inventario.domain.entities.EmpleadoEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapperImpl implements Mapper<EmpleadoEntity, EmpleadoDto> {

    private ModelMapper modelMapper;

    public EmpleadoMapperImpl (ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public EmpleadoDto mapto(EmpleadoEntity empleadoEntity) {
        return modelMapper.map(empleadoEntity, EmpleadoDto.class);
    }

    @Override
    public EmpleadoEntity mapFrom(EmpleadoDto empleadoDto) {
        return modelMapper.map(empleadoDto, EmpleadoEntity.class);
    }
}
