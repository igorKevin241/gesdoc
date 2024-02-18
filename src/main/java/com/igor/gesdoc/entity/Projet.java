package com.igor.gesdoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.igor.gesdoc.enums.SelectionEnum;
import com.igor.gesdoc.enums.TypeProjetEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projet")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projetId")
    private Long projet_id;
    @Column(name = "intitule")
    private String intituleProjet;
    @Column(name = "budget")
    private Float budgetProjet;
    @Column(name = "ccf")
    private String cleComptable;
    @Column(name = "numero")
    private String numeroProjet;
    @Enumerated(EnumType.STRING)
    private TypeProjetEnum typeProjetEnum;
    @Enumerated(EnumType.STRING)
    private SelectionEnum selectionEnum;

    @ManyToOne
    @JoinColumn(
            name = "activityId",
            nullable = false,
            referencedColumnName = "activityId",
            foreignKey = @ForeignKey(name = "activity_projet_fk")

    )
    private Activity activity;

    @OneToMany(mappedBy = "projet",
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Facture> factures = new ArrayList<>();

    @OneToMany(mappedBy = "projet",
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CorrespondanceEntree> correspondanceEntrees = new ArrayList<>();

    @OneToMany(mappedBy = "projet",
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CorrespondanceS> correspondanceSS = new ArrayList<>();

    @OneToMany(mappedBy = "projet",
            cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Instance> instances = new ArrayList<>();

    public void addFacture(Facture facture) {
        if (!this.factures.contains(facture)) {
            this.factures.add(facture);
            facture.setProjet(this);
        }
    }

    public void addCorrespondanceE(CorrespondanceEntree correspondanceEntree) {
        if (!this.correspondanceEntrees.contains(correspondanceEntree)) {
            this.correspondanceEntrees.add(correspondanceEntree);
            correspondanceEntree.setProjet(this);
        }
    }

    public void addCorrespondanceS(CorrespondanceS correspondanceS) {
        if (!this.correspondanceSS.contains(correspondanceS)) {
            this.correspondanceSS.add(correspondanceS);
            correspondanceS.setProjet(this);
        }
    }
    public void addInstance(Instance instance) {
        if (!this.instances.contains(instance)) {
            this.instances.add(instance);
            instance.setProjet(this);
        }
    }
}
