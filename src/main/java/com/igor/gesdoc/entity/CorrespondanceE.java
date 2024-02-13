package com.igor.gesdoc.entity;

import com.igor.gesdoc.enums.Correspondant;
import com.igor.gesdoc.enums.StatutCorrespondance;
import com.igor.gesdoc.enums.TypeCorrespondance;
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
    @Column(name = "dateDeTraitement")
    private LocalDate dateTraitement;
    @Enumerated(EnumType.STRING)
    private StatutCorrespondance statutCorrespondance;
    @Enumerated(EnumType.STRING)
    private TypeCorrespondance typeCorrespondance;
    @Enumerated(EnumType.STRING)
    private Correspondant correspondant;

}
