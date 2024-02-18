package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.CorrespondanceEntree;
import com.igor.gesdoc.enums.CorrespondantEnum;
import com.igor.gesdoc.enums.StatutCorrespondanceEnum;
import com.igor.gesdoc.service.CorrespondanceEService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/correspondances")
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
//    @ApiOperation(value = "Ajouter une correspondance reçue", notes = "Méthode permettant d'ajouter une correspondance reçue", response = CorrespondanceEntree.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Correspondance ajoutée avec succès!"),
//            @ApiResponse(code = 400, message = "Format des données incorrect"),
//            @ApiResponse(code = 500, message = "Erreur interne"),
//    })
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

    @GetMapping("/correspondant/{correspondantEum}")
    public List<CorrespondanceEntree> getCorrespondanceEByCorrespondant(@PathVariable("correspondantEum") CorrespondantEnum correspondantEnum){

        return correspondanceEService.getCorrespondanceEByCorrespondant(correspondantEnum);
    }

    @GetMapping("/statutCorrespondance/{statutCorrespondanceEnum}")
    public List<CorrespondanceEntree> getCorrespondanceEByStatut(@PathVariable("statutCorrespondanceEnum") StatutCorrespondanceEnum statutCorrespondanceEnum){

        return correspondanceEService.getCorrespondanceEByStatut(statutCorrespondanceEnum);
    }
}
