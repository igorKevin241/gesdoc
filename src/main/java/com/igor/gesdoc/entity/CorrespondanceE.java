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
@Table(name = "correspondanceDEntree")
public class CorrespondanceE {
    @Id
    @GeneratedValue
    @Column(name = "correspodanceEId")
    private Long corespondanceEId;
    @Column(name = "dateDeReception")
    private LocalDate dateReception;
    @Column(name = "reference")
    private String referenceCoE;
    @Column(name = "objet")
    private String objetCoE;
    @Column(name = "expediteur")
    private String expediteurCo;
    @Column(name = "statut")
    private Enum statutCoE;
    @Column(name = "dateDeTraitement")
    private LocalDate dateTraitement;
}
