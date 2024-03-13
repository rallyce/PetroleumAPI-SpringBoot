package com.rallyce.Petroleum_Inventario.controllers;

import com.rallyce.Petroleum_Inventario.domain.dto.UserSecurityDto;
import com.rallyce.Petroleum_Inventario.domain.entities.UserSecurityEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import com.rallyce.Petroleum_Inventario.services.UserSecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173/")
public class UserController {

    private UserSecurityService userSecurityService;

    private Mapper<UserSecurityEntity, UserSecurityDto> userSecurityMapper;

    public UserController(UserSecurityService userSecurityService, Mapper<UserSecurityEntity, UserSecurityDto> userSecurityMapper){

        this.userSecurityService = userSecurityService;
        this.userSecurityMapper = userSecurityMapper;
    }

    @PostMapping("/users")
    public ResponseEntity<UserSecurityDto> crearUsuario(@RequestBody UserSecurityDto user){


        UserSecurityEntity userSecurityEntity = userSecurityMapper.mapFrom(user);
        UserSecurityEntity savedUserSecurityEntity = userSecurityService.crearUsuario(userSecurityEntity);
        return new ResponseEntity<>(userSecurityMapper.mapto(savedUserSecurityEntity), HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public List<UserSecurityDto> DevolverUsuarios(){

        List<UserSecurityEntity> users = userSecurityService.findAll();
        return users.stream()
                .map(userSecurityMapper::mapto)
                .collect(Collectors.toList()
                );
    }

    @GetMapping("/users/{idUsuario}")
    public ResponseEntity<UserSecurityDto> encontrarUsuario(@PathVariable("idUsuario") Long id){

        Optional<UserSecurityEntity> findUserEntity = userSecurityService.findOne(id);

       return findUserEntity.map(userEntity ->{

          UserSecurityDto userDto = userSecurityMapper.mapto(userEntity);
          return new ResponseEntity<>(userDto, HttpStatus.OK);

        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/users/{idUsuario}")
    public ResponseEntity<UserSecurityDto> actualizacionCompleta(
            @PathVariable("idUsuario") Long id,
            @RequestBody UserSecurityDto userSecurityDto){

        if (!userSecurityService.isExists(id)) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userSecurityDto.setId(id);
        UserSecurityEntity userSecurityEntity = userSecurityMapper.mapFrom(userSecurityDto);
        UserSecurityEntity savedUserEntity = userSecurityService.crearUsuario(userSecurityEntity);

        return new ResponseEntity<>(userSecurityMapper.mapto(savedUserEntity), HttpStatus.OK);

    }

    @DeleteMapping("/users/{idUsuario}")
    public ResponseEntity eliminarUsuario(@PathVariable("idUsuario") Long id){

        userSecurityService.eliminarUsuario(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

}
