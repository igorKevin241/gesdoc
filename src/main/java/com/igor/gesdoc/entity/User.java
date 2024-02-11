package com.igor.gesdoc.entity;

import com.igor.gesdoc.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Utilisateur")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(
            name = "activityId",
            nullable = false,
            referencedColumnName = "activityId",
            foreignKey = @ForeignKey(name = "activity_user_fk")

    )
    private Activity activity;

}

