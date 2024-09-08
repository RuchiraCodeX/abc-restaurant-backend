package com.example.abc_restaurant.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Payments;
import com.example.abc_restaurant.repository.PaymentsRepository;

@Service
public class PaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

    public Payments addPayment(Payments payment) {
        
        payment.setStatus("Completed");
        payment.setPaymentDate(new Date());
        return paymentsRepository.save(payment);
    }

    public Payments updatePaymentStatus(String id, String status) throws Exception {
        Optional<Payments> optionalPayment = paymentsRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payments payment = optionalPayment.get();
            payment.setStatus(status);
            return paymentsRepository.save(payment);
        } else {
            throw new Exception("Payment not found with id: " + id);
        }
    }

    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
   
    }
    public Optional<Payments> getPaymentById(String paymentId) {
        return paymentsRepository.findById(paymentId);
    }
}
