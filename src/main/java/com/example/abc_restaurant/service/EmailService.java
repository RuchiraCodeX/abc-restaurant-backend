package com.example.abc_restaurant.service;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.abc_restaurant.Models.Reservation;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

   
    private static final Logger logger = Logger.getLogger(EmailService.class.getName());

    public void sendReservationConfirmation(Reservation reservation, String userEmail) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(userEmail);
            message.setSubject("Reservation Confirmed");
            message.setText("Dear Customer,\n\nYour reservation has been confirmed. Details:\n" 
                            + reservation.toString() + "\n\nThank you for choosing us!");

            mailSender.send(message);

          
            logger.info("Email sent successfully to " + userEmail);

        } catch (Exception e) {
           
            logger.log(Level.SEVERE, "Failed to send email to " + userEmail + ": " + e.getMessage(), e);

           
        }
    }

    
    private void notifyAdmin(Exception e) {
        SimpleMailMessage adminMessage = new SimpleMailMessage();
        adminMessage.setTo("kalanamaduranga222@gmail.com");
        adminMessage.setSubject("Email Sending Failure");
        adminMessage.setText("Failed to send email: " + e.getMessage());

        try {
            mailSender.send(adminMessage);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to notify admin: " + ex.getMessage(), ex);
        }
    }
}




