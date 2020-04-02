/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entitie.Evenement.Classe;
import Entitie.Evenement.CommentaireEvent;
import Entitie.Evenement.Event;
import Entitie.Evenement.Participants;
import Service.Evenement.ClasseService;
import Service.Evenement.CommentaireEventService;
import Service.Evenement.EventService;
import Service.Evenement.ParticipantsService;
import Utils.DataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
      public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
      public static void main(String [] args) throws ParseException{
          
          
          
    
     // Connexion de la BD
        DataSource ds=DataSource.getInstance();
        DataSource ds1=DataSource.getInstance();
        DataSource ds2=DataSource.getInstance();
        System.out.println(ds.hashCode());
        
        //table evennement 
         
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
         
         
         
        /*pour verifier qu'on a meme connection et il faut pas a chaque instance faire appele une autre fois connxion*/
      
     /*   Personne p=new Personne("wassim","rbai");
        Personne p1=new Personne(7);
         Personne p2=new Personne("aa","zz");
        PersonneService ps=new PersonneService();
        
  
        ps.supprimer(p1);
        ps.afficher().forEach(System.out::println);
*/
    /* User user= new User("oumayma","oumayma@gmail.com","oumayma");
     User user1= new User(2,"Nourchene","Nourchene14@gmail.com","Nourchene");
      User user2= new User(1);
     UserService us=new UserService();
     EventService es=new EventService();
    // us.ajouter(user);
    // us.ajouter(user1);
     us.afficher().forEach(System.out::println);
     //us.supprimer(user2);
     us.modifier(user1);
     us.afficher().forEach(System.out::println);
         System.out.println("***************************");
         es.afficher().forEach(System.out::println);
     */ 
    //commetaire
      
         /*CommentaireEvent comment = new CommentaireEvent(0,"hello",1,3);
         CommentaireEventService cs=new CommentaireEventService();
         cs.ajouter(comment);*/
         
         
    //table participants 
    
    Participants part = new Participants(3,16);// contient iduser et idEvent
    Participants part1 = new Participants(3,32);
    Participants part2 = new Participants(3,33);
    Participants part3 = new Participants(28);//contient idParticipant
    ParticipantsService ps =new ParticipantsService(); //service de la classe participant
    
        //ajout d'un participant
        /*ps.ajouter(part);
        ps.ajouter(part1);
        ps.ajouter(part2);
        */
        
        

    //table Event
    
    EventService es=new EventService();
   
 Date date = getDate(2020,2,2);
java.sql.Date sqlDate = new java.sql.Date(date.getTime());

 Event evt = new Event("event2", "hello2", 20, "event1", "event1", 133, 122, 2, 2, sqlDate, sqlDate, 15, "Debutant", "Formation", "Adulte", 120, "hello");
      es.ajouter(evt);
  
    CommentaireEventService ces = new CommentaireEventService();
    ClasseService cs = new ClasseService();
    List<Participants> participants = ps.afficher();
    CommentaireEvent comment = new CommentaireEvent(0,"hello",1,3);
    //ces.ajouter(comment);
    //ps.ajouter(part);
  //ps.supprimer(part1);
         //ces.getComments().forEach(System.out::println);
         
         
       //  es.search("event1").forEach(System.out::println);
 //Ajouter la table classe pour stat   
    Classe c= new  Classe(ps.Nbparticipants(), "Adulte",ps.NbAdult() );
    Classe c1= new  Classe(ps.Nbparticipants(), "adolescents",ps.NbAdo() );
    Classe c2= new  Classe(ps.Nbparticipants(), "Enfants",ps.NbEnfant() );
    Classe c3= new  Classe(ps.Nbparticipants(), "Personnes agées",ps.NbPersonneAgees() );
    
    //modification de la classe d'ajout
    cs.modifier(c);
    cs.modifier(c1);
    cs.modifier(c2);
    cs.modifier(c3);
          System.out.println(ps.Nbparticipants());
      
   //es.ajouter(evt);
    
         
    
    }
    
}
