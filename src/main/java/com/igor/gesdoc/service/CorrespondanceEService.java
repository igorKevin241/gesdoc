package com.igor.gesdoc.service;

import com.igor.gesdoc.entity.CorrespondanceE;
import com.igor.gesdoc.enums.Correspondant;
import com.igor.gesdoc.repository.CorrespondanceERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrespondanceEService {

    private final CorrespondanceERepository correspondanceERepository;

    @Autowired
    public CorrespondanceEService(CorrespondanceERepository correspondanceERepository) {
        this.correspondanceERepository = correspondanceERepository;
    }

    public List<CorrespondanceE> getAllCorrespondancesE() {
        return correspondanceERepository.findAll();
    }

//    public List<CorrespondanceE> getCoByCo(Correspondant correspondant) {
//        Correspondant correspondant1 = Correspondant.TOUS;
//        switch (correspondant1){
//            case DOF -> correspondanceERepository.findAll();
//        }
//    }
}
