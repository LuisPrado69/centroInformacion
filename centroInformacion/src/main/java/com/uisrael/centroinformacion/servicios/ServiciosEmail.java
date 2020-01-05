/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.centroinformacion.servicios;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author LUCHO
 */
@Service
public class ServiciosEmail {
    
    private JavaMailSender mailSender;

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String emailId) {
        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper mimeHelper;
        try {
            mimeHelper = new MimeMessageHelper(message, true);
            mimeHelper.setTo(emailId);
            // TODO: NAME TO EMAIL FROM PRODUCTION
            mimeHelper.setFrom("example@gmail.com");
            mimeHelper.setSubject("RECUPERACIÓN DE CONTRASEÑA");
            // TODO: URL FROM PRODUCTION
            mimeHelper.setText("<html><body>Hola,<br/><a href='http://localhost:8080/ForgotPassword/newPassword/" + emailId + "/'> Haga click en el enlace</a> para cambiar su contraseña</body></html>", true);
            mailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("Error al enviar email " + e.getMessage());
        }

    }
    
}
