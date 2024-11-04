package com.example.demo.service;

import com.example.demo.Dto;
import com.example.demo.model.Client;
import com.example.demo.model.Email;
import com.example.demo.model.Paiement;
import com.example.demo.model.Reservation;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepo reservationRepo;
    private final ClientRepo clientRepo;
    private final PaiementRepo paiementRepo;
    private final EmailRepo emailRepo;
    private final MessageRepo messageRepo;
    private final NotificationService notificationService;

    public Reservation saveReservation(Dto dto){
        Client client = Client.builder()
                .nomClient(dto.getNomClient())
                .email(dto.getEmail())
                .telephone(dto.getTelephone())
                .adresse(dto.getAdresse())
                .motif(dto.getMotif())
                .dateArriv(dto.getDateArriv())
                .dateDepart(dto.getDateDepart())
                .build();
        Client savedClient = clientRepo.save(client);

        Reservation reservation = Reservation.builder()
                .dateReservation(dto.getDateArriv())
                .depFin(dto.getDateDepart())
                .client(savedClient).build();
       Reservation savedReservation = reservationRepo.save(reservation);

        Paiement paiement = Paiement.builder()
                .datePaiement(dto.getDateArriv())
                .modePaiement(dto.getModePaiement())
                .montant(dto.getMontant()).build();
        paiementRepo.save(paiement);
        //send notifcation
        String to = dto.getEmail();
        String subject = "Reservation Notification";
        String message = " you have succeffully booked the room";
        notificationService.sendEmail(to,subject,message);
        Email email = Email.builder()
                .dateEnvoi(dto.getDateArriv())
                .contenu(message)
                .destinataire(to).build();
        emailRepo.save(email);
        return savedReservation;
    }
}
