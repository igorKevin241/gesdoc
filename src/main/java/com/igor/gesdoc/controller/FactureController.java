package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.Facture;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facture")
public class FactureController {

    private final FactureService factureService;

    @Autowired
    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }
    @GetMapping("get-all")
    public List<Facture> getAllFactures(){
        return factureService.getAllProjets();
    }
    @GetMapping("{factureId}")
    public Facture getFactureById(@PathVariable Long factureId){
        return factureService.getFactureById(factureId);
    }

    @PostMapping("create")
    public Facture createFacture(@RequestBody Facture facture, Long projetId){
        return factureService.createFacture(facture, projetId);
    }

    @PutMapping("{factureId}")
    public Facture updateFacture(@PathVariable Long factureId, @RequestBody Facture facture){
        return factureService.updateFacture(factureId, facture);
    }
    @DeleteMapping("{factureId}")
    public String deleteFactureById(@PathVariable Long factureId){

        return factureService.deleteFactureById(factureId);
    }
}
