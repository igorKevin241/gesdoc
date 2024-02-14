package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.CorrespondanceE;
import com.igor.gesdoc.entity.Facture;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.enums.Correspondant;
import com.igor.gesdoc.enums.StatutCorrespondance;
import com.igor.gesdoc.enums.TypeCorrespondance;
import com.igor.gesdoc.repository.CorrespondanceERepository;
import com.igor.gesdoc.repository.ProjetRepository;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CorrespondanceEService {

    private final CorrespondanceERepository correspondanceERepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public CorrespondanceEService(CorrespondanceERepository correspondanceERepository, ProjetRepository projetRepository) {
        this.correspondanceERepository = correspondanceERepository;
        this.projetRepository = projetRepository;
    }
    public List<CorrespondanceE> getAllCorrespondancesE() {
        return correspondanceERepository.findAll();
    }
    public CorrespondanceE getCorrespondanceEById(Long correspondanceEId) {
        return correspondanceERepository.findById(correspondanceEId)
                .orElseThrow(() -> new RuntimeException("Ce document n'est pas enregistré !"));
    }
    public CorrespondanceE createCorrespondanceE(CorrespondanceE correspondanceE, Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non enregistré !"));
        projet.addCorrespondanceE(correspondanceE);
        return correspondanceERepository.save(correspondanceE);
    }
    public CorrespondanceE updateCorrespondanceE(Long correspondanceEId, CorrespondanceE correspondanceE) {
        CorrespondanceE coEUpdated =correspondanceERepository.findById(correspondanceEId)
                .orElseThrow(() -> new RuntimeException("Ce document n'est pas enregistré !"));
        coEUpdated.setDateReception(correspondanceE.getDateReception());
        coEUpdated.setObjetCoE(correspondanceE.getObjetCoE());
        coEUpdated.setReferenceCoE(correspondanceE.getReferenceCoE());
        coEUpdated.setCorrespondant(correspondanceE.getCorrespondant());
        coEUpdated.setStatutCorrespondance(correspondanceE.getStatutCorrespondance());
        coEUpdated.setDateTraitement(correspondanceE.getDateTraitement());
        coEUpdated.setTypeCorrespondance(correspondanceE.getTypeCorrespondance());

        return correspondanceERepository.save(coEUpdated);
    }
    public String deleteCorrespondanceEById(Long correspondanceEId) {
        correspondanceERepository.findById(correspondanceEId)
                .orElseThrow(() -> new RuntimeException("Document non enregistré !"));
        correspondanceERepository.deleteById(correspondanceEId);
        return "Le document ID : "+correspondanceEId+" a été supprimé !";
    }


//    public List<CorrespondanceE> getCoByCo(Correspondant correspondant) {
//        switch (Correspondant correspondant1){
//            case Correspondant.TOUS -> correspondanceERepository.findAll();
//        }
//    }

}
