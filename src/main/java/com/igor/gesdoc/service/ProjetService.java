package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.Activity;
import com.igor.gesdoc.entity.Instance;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.enums.SelectionEnum;
import com.igor.gesdoc.enums.TypeProjetEnum;
import com.igor.gesdoc.repository.ActivityRepository;
import com.igor.gesdoc.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetService {

    private final ProjetRepository projetRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public ProjetService(ProjetRepository projetRepository, ActivityRepository activityRepository) {
        this.projetRepository = projetRepository;
        this.activityRepository = activityRepository;
    }

    public List<Projet> getAllProjets() {
        return projetRepository.findAll();

    }
    public Projet getProjetById(Long projetId) {
        return projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Ce projet n'est pas enregistré !"));
    }
    public Projet createProjet(Projet projet, Long activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Service non enregistré !"));
        activity.addProjet(projet);
        return projetRepository.save(projet);
    }

    public Projet updateProjet(Long projetId, Projet projet) {
        Projet projetUpdated =projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Ce projet n'est pas enregistré !"));
        projetUpdated.setIntituleProjet(projet.getIntituleProjet());
        projetUpdated.setBudgetProjet(projet.getBudgetProjet());
        projetUpdated.setCleComptable(projet.getCleComptable());
        projetUpdated.setTypeProjetEnum(projet.getTypeProjetEnum());
        projetUpdated.setNumeroProjet(projet.getNumeroProjet());

        return projetRepository.save(projetUpdated);
    }

    public String deleteProjetById(Long projetId) {
        projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non enregistré !"));
        projetRepository.deleteById(projetId);
        return "Le projet ID : "+projetId+" a été supprimé !";
    }

    public List<Projet> getProjetEBySelection(SelectionEnum selectionEnum) {
        List<Projet> list = projetRepository.findAll();
        List<Projet> list1 = new ArrayList<>();
        for (Projet projet :list){
            if (projet.getSelectionEnum().equals(selectionEnum)){
                list1.add(projet);
            }
        }
        return list1;
    }

    public List<Projet> getProjetByType(TypeProjetEnum typeProjetEnum) {
        List<Projet> list = projetRepository.findAll();
        List<Projet> list1 = new ArrayList<>();
        for (Projet projet :list){
            if (projet.getTypeProjetEnum().getValue().equals(typeProjetEnum.getValue())){
                list1.add(projet);
            }
        }
        return list1;

    }
}

