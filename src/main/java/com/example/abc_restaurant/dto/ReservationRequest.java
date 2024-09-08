package com.example.abc_restaurant.dto;


import com.example.abc_restaurant.Models.Payments;
import com.example.abc_restaurant.Models.Reservation;

public class ReservationRequest {

    private Reservation reservation;
    private Payments payment;


    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }
}

