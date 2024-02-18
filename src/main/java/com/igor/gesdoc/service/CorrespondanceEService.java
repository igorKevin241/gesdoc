package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.CorrespondanceEntree;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.enums.CorrespondantEnum;
import com.igor.gesdoc.enums.StatutCorrespondanceEnum;
import com.igor.gesdoc.repository.CorrespondanceERepository;
import com.igor.gesdoc.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<CorrespondanceEntree> getAllCorrespondancesE() {
        return correspondanceERepository.findAll();
    }
    public CorrespondanceEntree getCorrespondanceEById(Long correspondanceEId) {
        return correspondanceERepository.findById(correspondanceEId)
                .orElseThrow(() -> new RuntimeException("Ce document n'est pas enregistré !"));
    }
    public CorrespondanceEntree createCorrespondanceE(CorrespondanceEntree correspondanceEntree, Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non enregistré !"));
        projet.addCorrespondanceE(correspondanceEntree);
        return correspondanceERepository.save(correspondanceEntree);
    }
    public CorrespondanceEntree updateCorrespondanceE(Long correspondanceEId, CorrespondanceEntree correspondanceEntree) {
        CorrespondanceEntree coEUpdated =correspondanceERepository.findById(correspondanceEId)
                .orElseThrow(() -> new RuntimeException("Ce document n'est pas enregistré !"));
        coEUpdated.setDateReception(correspondanceEntree.getDateReception());
        coEUpdated.setObjetCoE(correspondanceEntree.getObjetCoE());
        coEUpdated.setReferenceCoE(correspondanceEntree.getReferenceCoE());
        coEUpdated.setCorrespondantEnum(correspondanceEntree.getCorrespondantEnum());
        coEUpdated.setStatutCorrespondanceEnum(correspondanceEntree.getStatutCorrespondanceEnum());
        coEUpdated.setDateTraitement(correspondanceEntree.getDateTraitement());
        coEUpdated.setTypeCorrespondanceEnum(correspondanceEntree.getTypeCorrespondanceEnum());

        return correspondanceERepository.save(coEUpdated);
    }
    public String deleteCorrespondanceEById(Long correspondanceEId) {
        correspondanceERepository.findById(correspondanceEId)
                .orElseThrow(() -> new RuntimeException("Document non enregistré !"));
        correspondanceERepository.deleteById(correspondanceEId);
        return "Le document ID : "+correspondanceEId+" a été supprimé !";
    }

    public List<CorrespondanceEntree> getCorrespondanceEByCorrespondant(CorrespondantEnum correspondantEnum) {
        List<CorrespondanceEntree> list = correspondanceERepository.findAll();
        List<CorrespondanceEntree> list1 = new ArrayList<>();
        for (CorrespondanceEntree correspondanceEntree :list){
            if (correspondanceEntree.getCorrespondantEnum().getValue().equals(correspondantEnum.getValue())){
                list1.add(correspondanceEntree);
            }
        }
        return list1;
    }

    public List<CorrespondanceEntree> getCorrespondanceEByStatut(StatutCorrespondanceEnum statutCorrespondanceEnum) {
        List<CorrespondanceEntree> list = correspondanceERepository.findAll();
        List<CorrespondanceEntree> list1 = new ArrayList<>();
        for (CorrespondanceEntree correspondanceEntree :list){
            if (correspondanceEntree.getStatutCorrespondanceEnum().getValue().equals(statutCorrespondanceEnum.getValue())){
                list1.add(correspondanceEntree);
            }
        }
        return list1;
    }
}
