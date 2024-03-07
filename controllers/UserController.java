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

    @GetMapping("/users/{nombreUsuario}")
    public ResponseEntity<UserSecurityDto> encontrarUsuario(@PathVariable("nombreUsuario") String username){

        Optional<UserSecurityEntity> findUserEntity = userSecurityService.findOne(username);

       return findUserEntity.map(userEntity ->{

          UserSecurityDto userDto = userSecurityMapper.mapto(userEntity);
          return new ResponseEntity<>(userDto, HttpStatus.OK);

        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/users/{nombreUsuario}")
    public ResponseEntity<UserSecurityDto> actualizacionCompleta(
            @PathVariable("nombreUsuario") String username,
            @RequestBody UserSecurityDto userSecurityDto){

        if (!userSecurityService.isExists(username)) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userSecurityDto.setUsername(username);
        UserSecurityEntity userSecurityEntity = userSecurityMapper.mapFrom(userSecurityDto);
        UserSecurityEntity savedUserEntity = userSecurityService.crearUsuario(userSecurityEntity);

        return new ResponseEntity<>(userSecurityMapper.mapto(savedUserEntity), HttpStatus.OK);

    }

    @DeleteMapping("/users/{nombreUsuario}")
    public ResponseEntity eliminarUsuario(@PathVariable("nombreUsuario") String username){

        userSecurityService.eliminarUsuario(username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

}
