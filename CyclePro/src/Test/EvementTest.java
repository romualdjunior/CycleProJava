/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import Test.*;
import Entitie.Evenement.*;
import Entitie.Evenement.Participants;
import Service.Evenement.*;
import Entitie.Evenement.Classe;
import Utils.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class EvementTest {
    public static void main(String [] args){
    
     // Connexion de la BD
        DataSource ds=DataSource.getInstance();
        DataSource ds1=DataSource.getInstance();
        DataSource ds2=DataSource.getInstance();
        System.out.println(ds.hashCode());
        
    
         
         
         
         
         
         
         
         
         
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
      Date dt = new Date(2,3,2020);
   Event evt = new Event("event2", "hello2", 20, "event1", "event1", 133, 122, 2, 2, dt, dt, 15, "Debutant", "Formation", "Adulte", 120, "hello");
      es.ajouter(evt);
   //es.ajouter(evt);
    
         
    
    }
    
    
}
