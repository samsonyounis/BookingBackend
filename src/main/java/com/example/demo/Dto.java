package com.example.demo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Dto {
    //client info
    private String nomClient;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private String motif;
    private String dateArriv;
    private String dateDepart;

    private String nationalite;
    private String profession;
    private String provenance;
    private String destination;
    private String etatCivil;

    //payment info
    private int montant;
    private String modePaiement;
}
