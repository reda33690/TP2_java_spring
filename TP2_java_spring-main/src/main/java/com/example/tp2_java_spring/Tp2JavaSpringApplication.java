package com.example.tp2_java_spring;

import com.example.tp2_java_spring.entities.*;
import com.example.tp2_java_spring.repositories.*;

import com.example.tp2_java_spring.service.IHospitalService;
import com.example.tp2_java_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


@SpringBootApplication
public class Tp2JavaSpringApplication implements CommandLineRunner {
 @Autowired
    private PatientRepository PatientRepository;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private RendezVousRepository rendezVousRepository;
    @Autowired
    private ConsultationRepository consultationRepository;


    @Autowired
    private IHospitalService iHospitalService;

    @Autowired
    private UserService userService ;


    public static void main(String[] args) {
        SpringApplication.run(Tp2JavaSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        List<String> names = Arrays.asList(
                "Mohamed", "Ahmed", "Hussein", "Ali", "Youssef", "Amir", "Ibrahim", "Omar",
                "Mahmoud", "Khaled", "Hassan", "Karim", "Sami", "Tarek", "Faisal", "Adel",
                "Zain", "Bilal", "Nasser", "Said", "Ammar", "Hadi", "Jalal", "Hamza",
                "Rashid", "Salem", "Ayman", "Sherif", "Fadi", "Majid",
                "Nabil", "Waleed", "Faris", "Yasin", "Malik", "Harun", "Ismael", "Fares",
                "Mounir", "Jamal", "Elias", "Taher", "Rami", "Bashar", "Samir", "Musa",
                "Nazir", "Adnan", "Samer", "Imran", "Hakim", "Kamal", "Raed", "Asim",
                "Tamer", "Wasim", "Amer", "Sufyan", "Iyad", "Jaber", "Mufid", "Yahya",
                "Fahad", "Anwar", "Saif", "Nawaf", "Majed", "Ghassan", "Latif", "Qasim",
                "Ziad", "Marwan", "Hisham", "Montaser", "Saber", "Rafiq", "Basel", "Akram",
                "Murad", "Hani", "Nour", "Hazem", "Usama", "Luay", "Awni", "Talal",
                "Zakaria", "Rayan", "Najib", "Sari", "Daud", "Mukhtar", "Yacoub", "Thamer"
        );

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            String randomName = names.get(random.nextInt(names.size())); // Get a random name
            iHospitalService.savePatient(new Patient(null, randomName, new Date(), Math.random()>0.5?true:false, (int)(Math.random()*100),null)) ;
        }

        for (int i = 0; i < 42; i++) {
            String randomName = names.get(random.nextInt(names.size())); // Get a random name
            iHospitalService.saveMedecin(new Medecin(null, randomName, randomName+"@gmail.com", Math.random()>0.5?"Cardio":"Dentiste",null));
        }

        Page<Patient> Patients = PatientRepository.findAll(PageRequest.of(0,5));
        System.out.println("Total pages : "+Patients.getTotalPages());
        System.out.println("Total elements : "+Patients.getTotalElements());
        System.out.println("Num page : "+ Patients.getNumber() );
        List<Patient> content = Patients.getContent() ;
        Page<Patient> byMalade = PatientRepository.findByMalade( true , PageRequest.of(0,4));
        List<Patient> patientList=PatientRepository.chercherPatients( "%h%" ,  40);
        patientList.forEach(p -> {
            System.out.println("------------------------------");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
        });

        System.out.println("");
        Patient patient = PatientRepository.findById(1L).orElse(null);
        if (patient != null) {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(870);
        PatientRepository.save(patient);
        //PatientRepository.deleteById(1L);

        Medecin medecin=medecinRepository.findByNom("Rashid");

        RendezVous rendezVous= new RendezVous();
        rendezVous.setDate(new Date());
        rendezVous.setStatus(StatusRDV.PENDING);
        rendezVous. setMedecin(medecin) ;
        rendezVous.setPatient(patient) ;
        rendezVousRepository.save(rendezVous);
        RendezVous saveDRDV = rendezVousRepository.save(rendezVous);
        System.out.println(saveDRDV.getId());

        RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse( null) ;
        Consultation consultation=new Consultation() ;


        consultation.setDateConsultation(new Date());
        consultation.setRendezVous(rendezVous1);
        consultation.setRapport("Rapport de la consultion .....");
        consultationRepository.save(consultation);

        //Users & Roles

        User u1=new User() ;
        u1.setUsername ("user1");
        u1.setPassword ("azzerty");
        userService.addNewUser(u1);

        User u2=new User() ;
        u2.setUsername ("admin");
        u2.setPassword ("123456");
        userService.addNewUser(u2);

        Stream.of ("STUDENT", "USER", "ADMIN") .forEach(r->{
            Role role1=new Role();
            role1. setRoleName (r) ;
            userService.addNewRole(role1);
    });
        userService.addRoleToUser ("user1", "STUDENT");
        userService.addRoleToUser (  "user1",  "USER");
        userService.addRoleToUser (  "admin",  "USER");
        userService.addRoleToUser (  "admin", "ADMIN");


        try {
        User user= userService.authenticate ( "admin", "123456");
        System.out.println(user.getUserId());
        System.out.println(user.getUsername());
        System.out.println ("============= Roles ============");
        user.getRoles().forEach( r->{
            System.out.println("Role=>"+ r);
        }) ;
        }
        catch (Exception e){
            e.printStackTrace();

        }



    }

}