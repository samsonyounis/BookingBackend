package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    private String nomClient;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private String nationalite;
    private String profession;
    private String provenance;
    private String destination;
    private String dateArriv;
    private String dateDepart;
    private String motif;
    private String etatCivil;
    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private List<Reservation> reservationList;
}
