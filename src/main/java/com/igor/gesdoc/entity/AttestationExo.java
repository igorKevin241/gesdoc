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
@Table(name = "attestationDExo")
public class AttestationExo {
    @Id
    @GeneratedValue
    @Column(name = "attestationId")
    private Long attestationExoId;
    @Column(name = "dateDeReception")
    private LocalDate dateReceptionAexo;
    @Column(name = "entreprise")
    private String nomEntreprise;

}
