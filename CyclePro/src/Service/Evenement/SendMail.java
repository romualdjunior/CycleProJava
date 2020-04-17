/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Evenement;

import com.email.durgesh.Email;

/**
 *
 * @author ASUS
 */
public class SendMail {
    public static void main(String [] args){
    
    
    try{
        
    Email email = new Email("cyclepro.event@gmail.com","cyclepro.event");
   email.setFrom("cyclepro.event@gmail.com", "Annonce d'evenement");
   email.setSubject("l'evenement est repoté  ");
   email.setContent("<h1>hello this message for test</h1>", "text/html");
   email.addRecipient("oumaymaboudokhane12@gmail.com");
    email.send();
        
    }catch(Exception e){}
    }
   
    
}
