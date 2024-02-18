package com.igor.gesdoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "activityId")
    private Long activityId;
    @Column(name = "libelle")
    private String libelle;

    @OneToMany(mappedBy = "activity")
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "activity")
    @JsonIgnore
    private List<Projet> projets = new ArrayList<>();

    public void addProjet(Projet projet) {
        if (!this.projets.contains(projet)) {
            this.projets.add(projet);
            projet.setActivity(this);
        }
    }

    public void addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
            user.setActivity(this);
        }
    }
}

