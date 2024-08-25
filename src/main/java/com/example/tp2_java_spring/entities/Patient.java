package com.example.tp2_java_spring.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="Nom" , length = 50)
    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private boolean malade;

    private int score;
    @OneToMany (mappedBy = "patient" , fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

}
