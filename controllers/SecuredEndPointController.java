package com.rallyce.Petroleum_Inventario.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SecuredEndPointController {

    @PostMapping(value = "secured")
    public String secured(){
        return "This is the secured endpoint";
    }
}
