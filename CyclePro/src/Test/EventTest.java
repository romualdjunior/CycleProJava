/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entitie.Evenement.Participants;
import Service.Evenement.ParticipantsService;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class EventTest {
    public static void main(String [] args) {
      Scanner sc=new Scanner(System.in);
        int rep3 = 0;
         
         
         
         
        do
        {
            System.out.println("-------------------------Participant--------------------------");
            System.out.println("               1.Ajouter                                  ");//ajouter un departement
            System.out.println("               2.Modifier                               ");
            System.out.println("               3.Supprimer                            ");
           System.out.println("                4.Lister                            ");
            System.out.println("               5.Quitter                              ");
            System.out.println("Taper votre choix :                                       ");
            rep3=sc.nextInt();// <--- ligne modifiée
            ParticipantsService ps =new ParticipantsService();
             int idPart,idUser,idEvent;
            switch(rep3)
            {
            case 1: 
                    Participants p;
                    System.out.println("Taper l'id d'utilisateur");
                    idUser=sc.nextInt();
                    System.out.println("Taper l'id d'evenement");
                    idEvent=sc.nextInt();
                    p= new Participants(idUser,idEvent);
                    
                    ps.ajouter(p);
                    break;
            case 2:
               
                    Participants p2;
                    System.out.println("Taper l'id du participant");
                    idPart=sc.nextInt();
                    System.out.println("Taper l'id d'utilisateur");
                    idUser=sc.nextInt();
                    System.out.println("Taper l'id d'evenement");
                    idEvent=sc.nextInt();
                    p2=new Participants(idPart,idUser,idEvent);
   
                    ps.modifier(p2);
                
                    break;
            case 3:
                
                    Participants p1;
                    System.out.println("Taper l'id d'utilisateur");
                    idPart=sc.nextInt();
                    p1=new Participants(idPart);
   
                    ps.supprimer(p1);
                    break;     
            case 4:
                
                    ps.afficher().forEach(System.out::println);
                    
            case 5:
                sc.close();
                    break;
            default:System.out.println("Veuillez respecter le menu!");
            }
        }while(rep3!=6);
         
    
    
    
    }
    
}
