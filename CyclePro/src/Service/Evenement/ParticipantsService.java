/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Evenement;


import Entitie.Evenement.Participants;
import IService.Evenement.IServices;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ParticipantsService implements IServices<Participants> {
    
    
Connection cnx=DataSource.getInstance().getCnx();


//ajouter un participant et decrementer le nbrplce d'un evt avec la methode participer
    @Override
    public void ajouter(Participants t) {
         if(this.participantExist(t.getEvent(), t.getUser())==0){
         try{
           
            long millis=System.currentTimeMillis();  
         Date date=new Date(millis);  
    String requete = "INSERT INTO participants (user,datePart,event) VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getUser());
            pst.setDate(2, date);
            pst.setInt(3, t.getEvent());
 
             
            pst.executeUpdate();
            EventService es = new EventService();
            es.participer(t.getEvent());
            System.out.println("participant ajoutée !"); /*tout les methodes qui ont des modification on met executrUpdate*/
             }catch(SQLException e){
                 System.out.println(e.getMessage());
             } }
         else{
                try {
             
             EventService es = new EventService();
            es.departiciper(t.getEvent());
            String requete = "DELETE FROM participants WHERE event=? And user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getEvent());
             pst.setInt(2, t.getUser());
            
            
            pst.executeUpdate();
           
            System.out.println("participant supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
         
         }
        
         }
//supprimer le participant et incrementer le nbre de place d'un evt avec la methode départiciper
    
    @Override
    public void supprimer(Participants t) {
        
         try {
             
             EventService es = new EventService();
            es.departiciper(this.getEvent(t.getId()));
            String requete = "DELETE FROM participants WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getId());
            
            
            pst.executeUpdate();
           
            System.out.println("participant supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
         }

    @Override
    public void modifier(Participants t) {
         try {
               long millis=System.currentTimeMillis();  
         Date date=new Date(millis);  
            String requete = "UPDATE participants SET event=?,user=?,datePart=? where id =?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(4, t.getId());
            pst.setInt(1, t.getEvent());
            pst.setInt(2, t.getUser());
            pst.setDate(3, date);
            
           
           
            System.out.println("Participant modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         }


    @Override
    public List<Participants> afficher() {
         List<Participants> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM participants";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                list.add(new Participants(rs.getInt(2), rs.getDate(3), rs.getInt(4)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
     public List<Participants> afficherParticipantEvent(int id ) {
         List<Participants> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM participants where event=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                list.add(new Participants(rs.getInt(2), rs.getDate(3), rs.getInt(4)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
    //les metiers
    
    
    public int NbAdo() {
        int deb=0;

        try {
            String requete = "SELECT COUNT(*) FROM participants p , event e where p.Event=e.id AND e.membre LIKE '%Ado%' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              deb =rs.getInt(1);
            }
           return deb;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }

     
    }
     
     
    public int NbEnfant() {
        int deb=0;

        try {
            String requete = "SELECT COUNT(*) FROM participants p , event e where p.Event=e.id AND e.membre LIKE '%Enfant%' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              deb =rs.getInt(1);
            }
           return deb;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }

     
    }
      
    public int NbAdult() {
        int deb=0;

        try {
            String requete = "SELECT COUNT(*) FROM participants p , event e where p.Event=e.id AND e.membre LIKE '%Adult%' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              deb =rs.getInt(1);
            }
           return deb;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }

     
    }
       
    public int NbPersonneAgees() {
        int deb=0;

        try {
            String requete = "SELECT COUNT(*) FROM participants p , event e where p.Event=e.id AND e.membre LIKE '%personnes agees%' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              deb =rs.getInt(1);
            }
           return deb;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }

     
    }
    
    
    public int Nbparticipants() {
        int deb=0;

        try {
            String requete = "SELECT COUNT(*) FROM participants ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              deb =rs.getInt(1);
            }
           return deb;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }

        
     
    }
         
    public int getEvent(int idPart) {
        int id=0;

        try {
            String requete = "SELECT event FROM participants p where p.id=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, idPart);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              id =rs.getInt(1);
            }
           return id;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }

         
           }
    
    public int participantExist(int idEvent,int idUser){
      
       int nbr=0;
     try {
            String requete = "SELECT COUNT(*) FROM participants p where p.event=?  And p.user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,idEvent);
             pst.setInt(2,idUser);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              nbr =rs.getInt(1);
            }
           return nbr;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return nbr;
        }
    
    }
     public String getEventP(int idEvent) {
        
         String ch="";
        try {
            String requete = "SELECT nom FROM event  where id =?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,idEvent);
            ResultSet rs = pst.executeQuery();
           while (rs.next()) {
                
             ch =rs.getString(1);
            }
           return ch;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return ch; 
    
    
    }
    public String getUserName(int idUser) {
         String ch="";
        try {
            String requete = "SELECT username FROM  user  where id =? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,idUser);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
             ch =rs.getString(1);
            }
           return ch;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        
        }

        return ch; 
    
    
    }
    
}
