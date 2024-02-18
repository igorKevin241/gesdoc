package com.igor.gesdoc.entity;

import com.igor.gesdoc.enums.StatutExonerationEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demandeExoneration")
public class DemandeExo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Enumerated(EnumType.STRING)
    private StatutExonerationEnum statutExonerationEnum;

}
