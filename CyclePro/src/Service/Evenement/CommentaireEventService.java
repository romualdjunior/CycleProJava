/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Evenement;


import Entitie.Evenement.CommentaireEvent;
import IService.Evenement.IServices;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CommentaireEventService implements IServices<CommentaireEvent>{
        Connection cnx=DataSource.getInstance().getCnx();
    @Override
    public void ajouter(CommentaireEvent t) {
        long millis=System.currentTimeMillis();  
         Date date=new Date(millis);  
         String req="insert into commentaire_event(likes,contenue,DateComment,Event_id,user) values ('"+t.getLikes()+"','"+t.getContenue()+"','"+date+"','"+t.getEvent()+"','"+t.getUser()+"')";
    try{
     Statement st =cnx.createStatement();
     st.executeUpdate(req);
             }catch(SQLException e){
                 System.out.println(e.getMessage());
             }
        }

    @Override
    public void supprimer(CommentaireEvent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(CommentaireEvent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentaireEvent> afficher() {
         List<CommentaireEvent> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM commentaire_event";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                list.add(new CommentaireEvent(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getByte(5), rs.getInt(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list; 
    
    
    }
    
    //metiers
    //getComments recent limit 5
    public List<CommentaireEvent> getComments() {
         List<CommentaireEvent> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM commentaire_event Order by dateComment DESC limit 5";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                list.add(new CommentaireEvent(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getByte(5), rs.getInt(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list; 
    
    
    }
    
     public List<CommentaireEvent> getCommentsByID(int idEvent) {
         List<CommentaireEvent> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM commentaire_event Order by dateComment where id =?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,idEvent);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                list.add(new CommentaireEvent(rs.getInt(1), rs.getString(3), rs.getDate(4), rs.getByte(5), rs.getInt(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list; 
    
    
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
    
       public String getEvent(int idEvent) {
         List<CommentaireEvent> list = new ArrayList<>();
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
    
    
  
    
}
