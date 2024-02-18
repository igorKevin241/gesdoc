package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.Instance;
import com.igor.gesdoc.entity.Projet;
import com.igor.gesdoc.enums.SelectionEnum;
import com.igor.gesdoc.enums.StatutInstanceEnum;
import com.igor.gesdoc.repository.InstanceRepository;
import com.igor.gesdoc.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        instanceUpdated.setStatutInstanceEnum(instance.getStatutInstanceEnum());

        return instanceRepository.save(instanceUpdated);
    }
    public String deleteInstanceById(Long instanceId) {
        instanceRepository.findById(instanceId)
                .orElseThrow(() -> new RuntimeException("Instance non enregistrée !"));
        instanceRepository.deleteById(instanceId);
        return "L'instance ID : "+instanceId+" a été supprimée !";
    }

    public List<Instance> getInstanceEBySelection(SelectionEnum selectionEnum) {
        List<Instance> list = instanceRepository.findAll();
        List<Instance> list1 = new ArrayList<>();
        for (Instance instance :list){
            if (instance.getSelectionEnum().getValue().equals(selectionEnum.getValue())){
                list1.add(instance);
            }
        }
        return list1;
    }

    public List<Instance> getInstanceEByStatut(StatutInstanceEnum statutInstanceEnum) {
        List<Instance> list = instanceRepository.findAll();
        List<Instance> list1 = new ArrayList<>();
        for (Instance instance :list){
            if (instance.getStatutInstanceEnum().getValue().equals(statutInstanceEnum.getValue())){
                list1.add(instance);
            }
        }
        return list1;
    }
}
