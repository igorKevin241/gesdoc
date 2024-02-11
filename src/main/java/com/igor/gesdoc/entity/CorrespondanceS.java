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
    @Column(name = "destinataire")
    private String destinataireCoS;
    @Column(name = "statut")
    private Enum statutCoS;

}