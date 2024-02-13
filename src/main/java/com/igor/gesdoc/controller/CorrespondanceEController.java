package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.CorrespondanceE;
import com.igor.gesdoc.entity.Facture;
import com.igor.gesdoc.enums.Correspondant;
import com.igor.gesdoc.service.CorrespondanceEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/correspondanceE")
public class CorrespondanceEController {

    private final CorrespondanceEService correspondanceEService;

    @Autowired
    public CorrespondanceEController(CorrespondanceEService correspondanceEService) {
        this.correspondanceEService = correspondanceEService;
    }

    public List<CorrespondanceE> getAllCorrepondancesE(){

        return correspondanceEService.getAllCorrespondancesE();
    }

//    public List<CorrespondanceE> getCoByCo(@PathVariable Correspondant correspondant){
//
//        return correspondanceEService.getCoByCo(correspondant);
//    }
}
