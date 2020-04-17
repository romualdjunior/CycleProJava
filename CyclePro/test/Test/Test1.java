package Test;

import Service.Commande.ServiceAdresse;
import Service.Commande.ServiceCommande;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toshiba
 */
public class Test1 {
    public static void main(String[] args) throws SQLException {
    

// Tester si un mot de passe est identique à un autre
if (BCrypt.checkpw("llllllllll", "$2a$10$h7tl.s.T96/43Bp5Q/uUVe6tnHxjEGSgZPjpWo/poUSj66l7pSg1u"))
        System.out.println("It matched");
else
	System.out.println("It does not match");
        ServiceCommande serviceCommande=new ServiceCommande();
        System.out.println(serviceCommande.getCommande(44));
    }
    
    
    
  
}
