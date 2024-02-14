package com.igor.gesdoc.service;

import com.igor.gesdoc.repository.DemandeExoRepository;
import com.igor.gesdoc.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeExoService {
    private final DemandeExoRepository demandeExoRepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public DemandeExoService(DemandeExoRepository demandeExoRepository, ProjetRepository projetRepository) {
        this.demandeExoRepository = demandeExoRepository;
        this.projetRepository = projetRepository;
    }
}
