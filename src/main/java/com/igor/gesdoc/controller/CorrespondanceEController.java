package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.CorrespondanceE;
import com.igor.gesdoc.entity.Facture;
import com.igor.gesdoc.enums.Correspondant;
import com.igor.gesdoc.service.CorrespondanceEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/correspondanceE")
public class CorrespondanceEController {

    private final CorrespondanceEService correspondanceEService;

    @Autowired
    public CorrespondanceEController(CorrespondanceEService correspondanceEService) {
        this.correspondanceEService = correspondanceEService;
    }
    @GetMapping("get-all")
    public List<CorrespondanceE> getAllCorrepondancesE(){
        return correspondanceEService.getAllCorrespondancesE();
    }
    @GetMapping("{correspondanceEId}")
    public CorrespondanceE getCorrespondanceEById(@PathVariable Long correspondanceEId){
        return correspondanceEService.getCorrespondanceEById(correspondanceEId);
    }
    @PostMapping("create")
    public CorrespondanceE createCorrespondanceE(@RequestBody CorrespondanceE correspondanceE, Long projetId){
        return correspondanceEService.createCorrespondanceE(correspondanceE, projetId);
    }
    @PutMapping("{correspondanceEId}")
    public CorrespondanceE updateCorrespondanceE(@PathVariable Long correspondanceEId, @RequestBody CorrespondanceE correspondanceE){
        return correspondanceEService.updateCorrespondanceE(correspondanceEId, correspondanceE);
    }
    @DeleteMapping("{correspondanceEId}")
    public String deleteCorrespondanceEById(@PathVariable Long correspondanceEId){
        return correspondanceEService.deleteCorrespondanceEById(correspondanceEId);
    }



//    public List<CorrespondanceE> getCoByCo(@PathVariable Correspondant correspondant){
//
//        return correspondanceEService.getCoByCo(correspondant);
//    }
}
