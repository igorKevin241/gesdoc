package com.igor.gesdoc.entity;

import com.igor.gesdoc.enums.StatutInstance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instance")
public class Instance {

    @Id
    @GeneratedValue
    @Column(name = "instanceId")
    private Long instanceId;
    @Column(name = "dateInstance")
    private LocalDate dateInstance;
    @Column(name = "libelleInstance")
    private String libelleInstance;
    @Column(name = "instructionsH")
    private String instructionsH;
    @Enumerated(EnumType.STRING)
    private StatutInstance statutInstance;

    @ManyToOne
    @JoinColumn(
            name = "projetId",
            nullable = false,
            referencedColumnName = "projetId",
            foreignKey = @ForeignKey(name = "projet_facture_fk")

    )
    private Projet projet;

}
