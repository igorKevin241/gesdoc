package com.igor.gesdoc.repository;

import com.igor.gesdoc.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository <Projet, Long> {
}
