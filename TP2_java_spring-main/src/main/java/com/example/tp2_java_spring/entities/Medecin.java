package com.example.tp2_java_spring.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin {
        @Id @GeneratedValue(strategy = GenerationType. IDENTITY)
        private Long id;
        private String nom;
        private String email;
        private String specialite;
        @OneToMany(mappedBy = "medecin" , fetch = FetchType.LAZY)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Collection<RendezVous> rendezVous;

}