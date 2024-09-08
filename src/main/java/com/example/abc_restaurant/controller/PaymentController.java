package com.example.abc_restaurant.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.abc_restaurant.Models.Payments;
import com.example.abc_restaurant.service.PaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping
    public ResponseEntity<Payments> addPayment(@RequestBody Payments payment) {
        Payments savedPayment = paymentsService.addPayment(payment);
        return ResponseEntity.ok(savedPayment);
    }

     @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePaymentStatus(@PathVariable String id, @RequestBody Map<String, Object> updateData) {
        try {
            String status = (String) updateData.get("status");
            Payments updatedPayment = paymentsService.updatePaymentStatus(id, status);
            return ResponseEntity.ok(updatedPayment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating payment status: " + e.getMessage());
        }
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable String paymentId) {
        Optional<Payments> paymentOpt = paymentsService.getPaymentById(paymentId);
        return paymentOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payments>> getAllPayments() {
        List<Payments> payments = paymentsService.getAllPayments();
        return ResponseEntity.ok(payments);
    }
    
}
