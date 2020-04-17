/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Service.Evenement.CommentaireEventService;
import Service.Evenement.EventService;
import Service.Evenement.ParticipantsService;

/**
 *
 * @author ASUS
 */
public class ListTest {
    public static void main(String [] args){
    
    ParticipantsService ps= new ParticipantsService();
    EventService es = new EventService();
        CommentaireEventService cs = new CommentaireEventService();
        cs.getCommentsByID(44).forEach(System.out::println);
      
    
    }
    
}
