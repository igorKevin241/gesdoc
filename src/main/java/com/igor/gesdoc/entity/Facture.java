package com.igor.gesdoc.entity;

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
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factureId")
    private Long factureId;
    @Column(name = "numero")
    private String numeroFacture;
    @Column(name = "date")
    private LocalDate dateFacture;
    @Column(name = "libelle")
    private String libelleFacture;
    @Column(name = "entreprise")
    private String nomEntreprise;
    @Column(name = "montant")
    private Double montantFacture;
    @Column(name = "montantTotal")
    private Double totalDesFactures;

    @ManyToOne
    @JoinColumn(
            name = "projetId",
            nullable = false,
            referencedColumnName = "projetId",
            foreignKey = @ForeignKey(name = "projet_facture_fk")

    )
    private Projet projet;
}
