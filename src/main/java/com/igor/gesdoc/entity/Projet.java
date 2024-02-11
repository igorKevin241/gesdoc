package com.igor.gesdoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projet")
public class Projet {
    @Id
    @GeneratedValue
    @Column(name = "projetId")
    private Long projet_id;
    @Column(name = "intitule")
    private String intituleProjet;
    @Column(name = "budget")
    private Float budgetProjet;
    @Column(name = "ccf")
    private String cleComptable;
    @Column(name ="type" )
    private Enum typeProjet;
    @Column(name = "numero")
    private String numeroProjet;

    @ManyToOne
    @JoinColumn(
            name = "activityId",
            nullable = false,
            referencedColumnName = "activityId",
            foreignKey = @ForeignKey(name = "activity_projet_fk")

    )
    private Activity activity;

    @OneToMany(mappedBy = "projet")
    @JsonIgnore
    private List<Facture> factures = new ArrayList<>();

    public void addFacture(Facture facture){
        if (!this.factures.contains(facture)){
            this.factures.add(facture);
            facture.setProjet(this);
        }
    }


}
