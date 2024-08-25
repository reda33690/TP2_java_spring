package com.example.tp2_java_spring.service;

import com.example.tp2_java_spring.entities.Consultation;
import com.example.tp2_java_spring.entities.Medecin;
import com.example.tp2_java_spring.entities.Patient;
import com.example.tp2_java_spring.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin (Medecin medecin) ;
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
