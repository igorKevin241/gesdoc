package com.igor.gesdoc.entity;

import com.igor.gesdoc.enums.CorrespondantEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "correspondanceDeSortie")
public class CorrespondanceS {
    @Id
    @GeneratedValue
    @Column(name = "correspodanceSId")
    private Long corespondanceSId;
    @Column(name = "date")
    private LocalDate dateEmission;
    @Column(name = "reference")
    private String referenceCoS;
    @Column(name = "objet")
    private String objetCoS;
    @Enumerated(EnumType.STRING)
    private CorrespondantEnum correspondantEnum;

    @ManyToOne
    @JoinColumn(
            name = "projetId",
            nullable = false,
            referencedColumnName = "projetId",
            foreignKey = @ForeignKey(name = "projet_facture_fk")

    )
    private Projet projet;



}
