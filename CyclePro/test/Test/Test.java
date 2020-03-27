package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toshiba
 */
public class Test {
    public static void main(String[] args) {
        // Hacher un mot de passe
       String password="clinton";
String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        System.out.println("/n");

// Tester si un mot de passe est identique à un autre
if (BCrypt.checkpw("william", "$2a$13$qGAHVOzLKH/Q2kWPyuKE.uK016u0SPLeXcnWiqT7LBu27USHTHaY2"))
        System.out.println("It matched");
else
	System.out.println("It does not match");
    }
    
  
}
