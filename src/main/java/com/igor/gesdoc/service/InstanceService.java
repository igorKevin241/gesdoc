package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.Facture;
import com.igor.gesdoc.entity.Instance;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.enums.StatutInstance;
import com.igor.gesdoc.repository.InstanceRepository;
import com.igor.gesdoc.repository.ProjetRepository;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InstanceService {
    private final InstanceRepository instanceRepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public InstanceService(InstanceRepository instanceRepository, ProjetRepository projetRepository) {
        this.instanceRepository = instanceRepository;
        this.projetRepository = projetRepository;
    }
    public List<Instance> getAllInstances() {
        return instanceRepository.findAll();
    }
    public Instance getInstanceById(Long instanceId) {
        return instanceRepository.findById(instanceId)
                .orElseThrow(() -> new RuntimeException("Cette instance n'est pas enregistrée !"));
    }
    public Instance createInstance(Instance instance, Long projetId) {
        Projet projet = projetRepository.findById(projetId)
                .orElseThrow(() -> new RuntimeException("Projet non enregistré !"));
        projet.addInstance(instance);
        return instanceRepository.save(instance);
    }
    public Instance updateInstance(Long instanceId, Instance instance) {
        Instance instanceUpdated =instanceRepository.findById(instanceId)
                .orElseThrow(() -> new RuntimeException("Cette instance n'est pas enregistrée !"));
        instanceUpdated.setDateInstance(instance.getDateInstance());
        instanceUpdated.setLibelleInstance(instance.getLibelleInstance());
        instanceUpdated.setInstructionsH(instance.getInstructionsH());
        instanceUpdated.setStatutInstance(instance.getStatutInstance());

        return instanceRepository.save(instanceUpdated);
    }
    public String deleteInstanceById(Long instanceId) {
        instanceRepository.findById(instanceId)
                .orElseThrow(() -> new RuntimeException("Instance non enregistrée !"));
        instanceRepository.deleteById(instanceId);
        return "L'instance ID : "+instanceId+" a été supprimée !";
    }
}
