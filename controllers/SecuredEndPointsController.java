package com.rallyce.Petroleum_Inventario.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SecuredEndPointsController {

    @PostMapping(value = "secured")
    public String secured(){
        return "Welcome to secured endpoint";
    }
}
