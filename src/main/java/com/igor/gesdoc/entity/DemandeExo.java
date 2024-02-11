package com.igor.gesdoc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demandeExoneration")
public class DemandeExo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demandeExoId")
    private Long demandeExoId;
    @Column(name = "entreprise")
    private String nomEntreprise;
    @Column(name = "libelle")
    private String libelleDemande;
    @Column(name = "dateDeReception")
    private LocalDate dateReceptionDexo;
    @Column(name = "montant")
    private Double montantExo;
    @Column(name = "statut")
    private Enum statutDemandeExo;
}
