package com.rallyce.Petroleum_Inventario.controllers;

import com.rallyce.Petroleum_Inventario.domain.dto.AuthoritySecurityDto;
import com.rallyce.Petroleum_Inventario.domain.entities.AuthoritySecurityEntity;
import com.rallyce.Petroleum_Inventario.mappers.Mapper;
import com.rallyce.Petroleum_Inventario.services.AuthoritySecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:5173/")
public class AuthorityController {

    private AuthoritySecurityService authoritySecurityService;

    private Mapper<AuthoritySecurityEntity, AuthoritySecurityDto> authoritySecurityMapper;

    public AuthorityController(AuthoritySecurityService authoritySecurityService,
                               Mapper<AuthoritySecurityEntity, AuthoritySecurityDto> authoritySecurityMapper) {

        this.authoritySecurityService = authoritySecurityService;
        this.authoritySecurityMapper = authoritySecurityMapper;

    }

    @PutMapping("/authority/{nombreAutoridad}")
    public ResponseEntity<AuthoritySecurityDto> asignarAutoridad(
            @PathVariable("nombreAutoridad") String authorityName,
            @RequestBody AuthoritySecurityDto autoridad){

        AuthoritySecurityEntity authoritySecurityEntity = authoritySecurityMapper.mapFrom(autoridad);
        boolean autoridadExiste = authoritySecurityService.isExists(authorityName);
        AuthoritySecurityEntity savedAuthorityEntity = authoritySecurityService.asignarAutoridad(authorityName, authoritySecurityEntity);
        AuthoritySecurityDto authoritySecurityDto = authoritySecurityMapper.mapto(savedAuthorityEntity);


        if (autoridadExiste) {
            return new ResponseEntity<>(authoritySecurityDto, HttpStatus.OK);
        }

        else{

            return new ResponseEntity<>(authoritySecurityDto, HttpStatus.CREATED);
        }

    }

    @GetMapping("/authority")
    public List<AuthoritySecurityDto> DevolverAutoridades(){

        List<AuthoritySecurityEntity> autoridad =  authoritySecurityService.findAll();
        return autoridad.stream()
                .map(authoritySecurityMapper::mapto)
                .collect(Collectors.toList());

    }

    @GetMapping("/authority/{nombreAutoridad}")
    public ResponseEntity<AuthoritySecurityDto> encontrarAutoridad(@PathVariable("nombreAutoridad") String authorityName){

        Optional<AuthoritySecurityEntity> findAuthority = authoritySecurityService.findOne(authorityName);

       return findAuthority.map(authoritySecurityEntity -> {

            AuthoritySecurityDto authoritySecurityDto = authoritySecurityMapper.mapto(authoritySecurityEntity);
            return new ResponseEntity<>(authoritySecurityDto, HttpStatus.OK);

        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/authority/{nombreAutoridad}")
    public ResponseEntity eliminarAutoridad(@PathVariable("nombreAutoridad") String authorityName){

        authoritySecurityService.eliminarAutoridad(authorityName);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
