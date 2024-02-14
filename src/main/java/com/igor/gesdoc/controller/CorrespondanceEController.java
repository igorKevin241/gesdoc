package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.CorrespondanceEntree;
import com.igor.gesdoc.enums.CorrespondantEnum;
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
    public List<CorrespondanceEntree> getAllCorrepondancesE(){
        return correspondanceEService.getAllCorrespondancesE();
    }
    @GetMapping("{correspondanceEId}")
    public CorrespondanceEntree getCorrespondanceEById(@PathVariable Long correspondanceEId){
        return correspondanceEService.getCorrespondanceEById(correspondanceEId);
    }
    @PostMapping("create")
    public CorrespondanceEntree createCorrespondanceE(@RequestBody CorrespondanceEntree correspondanceEntree, Long projetId){
        return correspondanceEService.createCorrespondanceE(correspondanceEntree, projetId);
    }
    @PutMapping("{correspondanceEId}")
    public CorrespondanceEntree updateCorrespondanceE(@PathVariable Long correspondanceEId, @RequestBody CorrespondanceEntree correspondanceEntree){
        return correspondanceEService.updateCorrespondanceE(correspondanceEId, correspondanceEntree);
    }
    @DeleteMapping("{correspondanceEId}")
    public String deleteCorrespondanceEById(@PathVariable Long correspondanceEId){
        return correspondanceEService.deleteCorrespondanceEById(correspondanceEId);
    }

    @GetMapping("{correspondantEum}")
    public List<CorrespondanceEntree> getCorrespondanceEByCorrespondant(@PathVariable("correspondantEum") CorrespondantEnum correspondantEnum){

        return correspondanceEService.getCorrespondanceEByCorrespondant(correspondantEnum);
    }
}
