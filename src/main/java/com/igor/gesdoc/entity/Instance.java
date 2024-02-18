package com.igor.gesdoc.entity;

import com.igor.gesdoc.enums.SelectionEnum;
import com.igor.gesdoc.enums.StatutInstanceEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instance")
public class Instance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instanceId")
    private Long instanceId;
    @Column(name = "dateInstance")
    private LocalDate dateInstance;
    @Column(name = "libelleInstance")
    private String libelleInstance;
    @Column(name = "instructionsH")
    private String instructionsH;
    @Enumerated(EnumType.STRING)
    private StatutInstanceEnum statutInstanceEnum;
    @Enumerated(EnumType.STRING)
    private SelectionEnum selectionEnum;

    @ManyToOne
    @JoinColumn(
            name = "projetId",
            nullable = false,
            referencedColumnName = "projetId",
            foreignKey = @ForeignKey(name = "projet_facture_fk")

    )
    private Projet projet;

}
