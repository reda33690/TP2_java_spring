package com.example.tp2_java_spring.repositories;

import com.example.tp2_java_spring.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository <Patient , Long> {

    List<Patient> findByMalade(boolean m);
    Page<Patient> findByMalade (boolean m, Pageable pageable);

    List<Patient> findByMaladeAndScoreLessThan(boolean m, int score);
    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomNotLike(Date d1, Date d2, String mc);

    @Query("select p from Patient p where p.nom Like :x and p.score <:y")
    List<Patient> chercherPatients(@Param("x") String nom, @Param("y") int scoreMin);


}


