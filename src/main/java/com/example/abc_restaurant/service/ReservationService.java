package com.example.abc_restaurant.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Payments;
import com.example.abc_restaurant.Models.Reservation;
import com.example.abc_restaurant.Models.User;
import com.example.abc_restaurant.repository.ReservationRepository;



@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PaymentsService paymentsService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation makeReservation(Reservation reservation, Payments payment) {
      
        Payments processedPayment = paymentsService.addPayment(payment);

      
        if ("Completed".equalsIgnoreCase(processedPayment.getStatus())) {
            reservation.setPaymentId(processedPayment.getId());
            reservation.setStatus("Confirmed");
            reservation.setReservationDate(new Date());
            reservation.setCreatedAt(LocalDateTime.now());
            reservation.setUpdatedAt(LocalDateTime.now());

            Reservation savedReservation = reservationRepository.save(reservation);

          
            Optional<User> user = userService.getUserById(reservation.getUserID());
            user.ifPresent(value -> emailService.sendReservationConfirmation(savedReservation, value.getEmail()));

            return savedReservation;
        } else {
            
            reservation.setStatus("Pending");
            reservation.setReservationDate(new Date());
            reservation.setCreatedAt(LocalDateTime.now());
            reservation.setUpdatedAt(LocalDateTime.now());

            return reservationRepository.save(reservation);
        }
    }

    public Reservation updateReservation(String id, Reservation reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setUserID(reservationDetails.getUserID());
        reservation.setServiceType(reservationDetails.getServiceType());
        reservation.setReservationDate(reservationDetails.getReservationDate());
        reservation.setNumberOfGuests(reservationDetails.getNumberOfGuests());
        reservation.setStatus(reservationDetails.getStatus());
        reservation.setUpdatedAt(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }
}



