package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.Instance;
import com.igor.gesdoc.enums.SelectionEnum;
import com.igor.gesdoc.enums.StatutInstanceEnum;
import com.igor.gesdoc.service.InstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instance")
public class InstanceController {
    private final InstanceService instanceService;

    @Autowired
    public InstanceController(InstanceService instanceService) {
        this.instanceService = instanceService;
    }

    @GetMapping("get-all")
    public List<Instance> getAllInstances(){
        return instanceService.getAllInstances();
    }
    @GetMapping("{instanceId}")
    public Instance getInstanceById(@PathVariable Long instanceId){
        return instanceService.getInstanceById(instanceId);
    }

    @PostMapping("create")
    public Instance createInstance(@RequestBody Instance instance, Long projetId){
        return instanceService.createInstance(instance, projetId);
    }

    @PutMapping("{instanceId}")
    public Instance updateInstance(@PathVariable Long instanceId, @RequestBody Instance instance){
        return instanceService.updateInstance(instanceId, instance);
    }
    @DeleteMapping("{instanceId}")
    public String deleteInstanceById(@PathVariable Long instanceId){
        return instanceService.deleteInstanceById(instanceId);
    }

    @GetMapping("/selection/{selectionEnum}")
    public List<Instance> getInstanceEBySelection(@PathVariable("selectionEnum") SelectionEnum selectionEnum){

        return instanceService.getInstanceEBySelection(selectionEnum);

    }

    @GetMapping("/statutInstance/{statutInstanceEnum}")
    public List<Instance> getInstanceEByStatut(@PathVariable("statutInstanceEnum") StatutInstanceEnum statutInstanceEnum){

        return instanceService.getInstanceEByStatut(statutInstanceEnum);

    }
}
