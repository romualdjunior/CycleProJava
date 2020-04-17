/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entitie.Stock.Accessoires;
import Entitie.Stock.Fournisseur;
import Entitie.Stock.Velo;
import Service.Stock.ServiceAccessoires;
import Service.Stock.ServiceFournisseur;
import Service.Stock.ServiceVelo;
import java.util.Scanner;

/**
 *
 * @author Yasmine
 */
public class Yasmine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        // TODO code application logic here
   Velo V = new Velo("ATALA","noir",1,"grand",20,4,300,0,  "photo", /*Fournisseur*/21,"cross","des","dispo",0,"vendre", "photo", "photo", "photo","car");
    Accessoires A = new Accessoires ("photo", "casque", "atala", "casque",120,"des",  "photo", "photo",  "photo", 0,"vitesse",20 );
    Fournisseur F = new Fournisseur("ZALTA", "1223665", "ffg@hh.com","1324", "ADRESSE");
    ServiceAccessoires SA = new ServiceAccessoires();
    ServiceFournisseur SF = new ServiceFournisseur();
    ServiceVelo SV = new ServiceVelo();
    //SA.ajouter(A);
    //SF.ajouter(F);
  //SV.ajouter(V);
   // int id = sc.nextInt();Accessoires AS = new Accessoires (id) ;SA.supprimer(AS);
   // int id = sc.nextInt();Fournisseur FS = new Fournisseur (id) ;SF.supprimer(FS);
   //int id = sc.nextInt();Velo VS = new Velo (id) ;SV.supprimer(VS);
 //SA.afficher().forEach(System.out::println);
// SF.affichier().forEach(System.out::println);
//SV.afficher().forEach(System.out::println);
//Accessoires AM = new Accessoires (7,"photo", "sonnette", "atala", "casque",120,"des",  "photo", "photo",  "photo", 0,"vitesse",20) ;SA.modifier(AM);
//Fournisseur FM = new Fournisseur(21,"ZALTA", "1223665", "ffg@hh.TN","1324", "ADRESSE");SF.modifier(FM);
// VM = new Velo(43,"ATALA","noir",1,"petit",20,4,300,0,  "photo", /*Fournisseur*/21,"cross","des","dispo",0,"vendre", "photo", "photo", "photo","car");SV.modifier(VM);

    }
    
}
