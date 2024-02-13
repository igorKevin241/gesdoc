package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.Activity;
import com.igor.gesdoc.entity.Facture;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.repository.FactureRepository;
import com.igor.gesdoc.repository.ProjetRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FactureService {

    private final FactureRepository factureRepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public FactureService(FactureRepository factureRepository, ProjetRepository projetRepository) {
        this.factureRepository = factureRepository;
        this.projetRepository = projetRepository;
    }

    public List<Facture> getAllProjets() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long factureId) {
        return factureRepository.findById(factureId)
                .orElseThrow(() -> new RuntimeException("Cette facture n'est pas enregistrée !"));
    }

    public Facture createFacture(Facture facture, Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non enregistré !"));
        projet.addFacture(facture);
        return factureRepository.save(facture);
    }

    public Facture updateFacture(Long factureId, Facture facture) {
        Facture factureUpdated =factureRepository.findById(factureId)
                .orElseThrow(() -> new RuntimeException("Cette facture n'est pas enregistrée !"));
        factureUpdated.setNumeroFacture(facture.getNumeroFacture());
        factureUpdated.setDateFacture(facture.getDateFacture());
        factureUpdated.setLibelleFacture(facture.getLibelleFacture());
        factureUpdated.setNomEntreprise(facture.getNomEntreprise());
        factureUpdated.setMontantFacture(facture.getMontantFacture());

        return factureRepository.save(factureUpdated);
    }

    public String deleteFactureById(Long factureId) {
        factureRepository.findById(factureId)
                .orElseThrow(() -> new RuntimeException("Facture non enregistrée !"));
        factureRepository.deleteById(factureId);
        return "La facture ID : "+factureId+" a été supprimée !";
    }
}
