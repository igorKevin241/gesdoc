package com.igor.gesdoc.controller;

import com.igor.gesdoc.entity.CorrespondanceE;
import com.igor.gesdoc.entity.CorrespondanceS;
import com.igor.gesdoc.service.CorrespondanceSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/correspondanceS")
public class CorrespondanceSController {
private final CorrespondanceSService correspondanceSService;
    @Autowired
    public CorrespondanceSController(CorrespondanceSService correspondanceSService) {
        this.correspondanceSService = correspondanceSService;
    }
    @GetMapping("get-all")
    public List<CorrespondanceS> getAllCorrepondancesS(){
        return correspondanceSService.getAllCorrespondancesS();
    }
    @GetMapping("{correspondanceSId}")
    public CorrespondanceS getCorrespondanceSById(@PathVariable Long correspondanceSId){
        return correspondanceSService.getCorrespondanceSById(correspondanceSId);
    }
    @PostMapping("create")
    public CorrespondanceS createCorrespondanceS(@RequestBody CorrespondanceS correspondanceS, Long projetId){
        return correspondanceSService.createCorrespondanceS(correspondanceS, projetId);
    }
    @PutMapping("{correspondanceSId}")
    public CorrespondanceS updateCorrespondanceS(@PathVariable Long correspondanceSId, @RequestBody CorrespondanceS correspondanceS){
        return correspondanceSService.updateCorrespondanceS(correspondanceSId, correspondanceS);
    }
    @DeleteMapping("{correspondanceSId}")
    public String deleteCorrespondanceSById(@PathVariable Long correspondanceSId){
        return correspondanceSService.deleteCorrespondanceSById(correspondanceSId);
    }
}
