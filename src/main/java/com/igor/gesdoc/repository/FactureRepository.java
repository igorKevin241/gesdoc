package com.igor.gesdoc.repository;

import com.igor.gesdoc.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository <Facture, Long> {
}
