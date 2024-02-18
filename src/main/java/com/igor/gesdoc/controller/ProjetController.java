package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.Instance;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.entity.User;
import com.igor.gesdoc.enums.SelectionEnum;
import com.igor.gesdoc.enums.StatutInstanceEnum;
import com.igor.gesdoc.enums.TypeProjetEnum;
import com.igor.gesdoc.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projet")
public class ProjetController {
    private final ProjetService projetService;

    @Autowired
    public ProjetController(ProjetService projetService) {

        this.projetService = projetService;
    }

    @GetMapping("get-all")
    public List<Projet> getAllProjets(){

        return projetService.getAllProjets();
    }
    @GetMapping("{projetId}")
    public Projet getProjetById(@PathVariable Long projetId){
        return projetService.getProjetById(projetId);
    }

    @PostMapping("create")
    public Projet createProjet(@RequestBody Projet projet, Long activityId){

        return projetService.createProjet(projet, activityId);
    }

    @PutMapping("{projetId}")
    public Projet updateProjet(@PathVariable Long projetId, @RequestBody Projet projet){
        return projetService.updateProjet(projetId, projet);
    }
    @DeleteMapping("{projetId}")
    public String deleteProjetById(@PathVariable Long projetId){

        return projetService.deleteProjetById(projetId);
    }

    @GetMapping("/selection/{selectionEnum}")
    public List<Projet> getProjetEBySelection(@PathVariable("selectionEnum") SelectionEnum selectionEnum){

        return projetService.getProjetEBySelection(selectionEnum);

    }

    @GetMapping("/typeProjet/{typeProjetEnum}")
    public List<Projet> getProjetByType(@PathVariable("typeProjetEnum") TypeProjetEnum typeProjetEnum){

        return projetService.getProjetByType(typeProjetEnum);

    }
}
