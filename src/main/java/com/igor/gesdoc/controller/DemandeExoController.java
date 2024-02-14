package com.igor.gesdoc.controller;

import com.igor.gesdoc.service.DemandeExoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demandeExo")
public class DemandeExoController {
    private final DemandeExoService demandeExoService;

    @Autowired
    public DemandeExoController(DemandeExoService demandeExoService) {
        this.demandeExoService = demandeExoService;
    }

}
