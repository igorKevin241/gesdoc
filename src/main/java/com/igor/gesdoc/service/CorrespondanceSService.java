package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.CorrespondanceS;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.repository.CorrespondanceSRepository;
import com.igor.gesdoc.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrespondanceSService {

    private final CorrespondanceSRepository correspondanceSRepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public CorrespondanceSService(CorrespondanceSRepository correspondanceSRepository, ProjetRepository projetRepository) {
        this.correspondanceSRepository = correspondanceSRepository;
        this.projetRepository = projetRepository;
    }

    public List<CorrespondanceS> getAllCorrespondancesS() {
        return correspondanceSRepository.findAll();
    }
    public CorrespondanceS getCorrespondanceSById(Long correspondanceSId) {
        return correspondanceSRepository.findById(correspondanceSId)
                .orElseThrow(() -> new RuntimeException("Ce document n'est pas enregistré !"));
    }
    public CorrespondanceS createCorrespondanceS(CorrespondanceS correspondanceS, Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non enregistré !"));
        projet.addCorrespondanceS(correspondanceS);
        return correspondanceSRepository.save(correspondanceS);
    }
    public CorrespondanceS updateCorrespondanceS(Long correspondanceSId, CorrespondanceS correspondanceS) {
        CorrespondanceS coSUpdated =correspondanceSRepository.findById(correspondanceSId)
                .orElseThrow(() -> new RuntimeException("Ce document n'est pas enregistré !"));
        coSUpdated.setDateEmission(correspondanceS.getDateEmission());
        coSUpdated.setObjetCoS(correspondanceS.getObjetCoS());
        coSUpdated.setReferenceCoS(correspondanceS.getReferenceCoS());

        return correspondanceSRepository.save(coSUpdated);
    }
    public String deleteCorrespondanceSById(Long correspondanceSId) {
        correspondanceSRepository.findById(correspondanceSId)
                .orElseThrow(() -> new RuntimeException("Document non enregistré !"));
        correspondanceSRepository.deleteById(correspondanceSId);
        return "Le document ID : "+correspondanceSId+" a été supprimé !";
    }
}
