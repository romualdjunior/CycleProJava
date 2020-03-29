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
    public static void test(){
  String password="lll";
String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        System.out.println("/n");
  }
    public static void main(String[] args) {
        Test:test(); 

// Tester si un mot de passe est identique à un autre
if (BCrypt.checkpw("lll", "$2a$10$/HMaE6NLvyxNOvqdrQBEUebRYKLMeuIlWaKGZbcBKHKQhvU5VsLd2"))
        System.out.println("It matched");
else
	System.out.println("It does not match");
    }
    
  
}
