/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Reclamation;

import Entitie.Reclamation.user;
import Test.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author toshiba
 */
public class SendEmail {

    final String senderEmailID = "wiem.saddem@esprit.tn";
    final String senderPassword = "waoumajomhouria1997*";
    final String emailSMTPserver = "smtp.gmail.com";
    final String emailServerPort = "465";
    String receiverEmailID = "cyclePro.Reclamation@gmail.tn";
    user usr = new user () ; 
    static String emailSubject = "Validation de l'envoi du reclamation";
     String emailBody = "Bonjour M/Mme" + usr.getNom() + usr.getPrenom()+"Votre reclamation a été bien envoyé , Merci pour votre fidélité" ;

    public SendEmail(String receiverEmailID, String Subject,
            String Body) {

        // Receiver Email Address
        this.receiverEmailID = receiverEmailID;
        // Subject
        this.emailSubject = Subject;
        // Body
        this.emailBody = Body;
        Properties props = new Properties();
        props.put("mail.smtp.user", senderEmailID);
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", emailServerPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        SecurityManager security = System.getSecurityManager();
        try {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(emailBody);
            msg.setSubject(emailSubject);
            msg.setFrom(new InternetAddress(senderEmailID));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(receiverEmailID));
            Transport.send(msg);
            System.out.println("Message send Successfully:)");
        } catch (Exception mex) {
            mex.printStackTrace();
        }

    }

    public class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(senderEmailID, senderPassword);
        }
    }
   
}
