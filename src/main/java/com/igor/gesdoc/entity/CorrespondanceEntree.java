package com.igor.gesdoc.entity;

import com.igor.gesdoc.enums.CorrespondantEnum;
import com.igor.gesdoc.enums.StatutCorrespondanceEnum;
import com.igor.gesdoc.enums.TypeCorrespondanceEnum;
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
@Table(name = "correspondanceDEntree")
public class CorrespondanceEntree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private StatutCorrespondanceEnum statutCorrespondanceEnum;
    @Enumerated(EnumType.STRING)
    private TypeCorrespondanceEnum typeCorrespondanceEnum;
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
