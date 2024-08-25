package com.example.tp2_java_spring.repositories;

import com.example.tp2_java_spring.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    Medecin findByNom(String nom);

}
