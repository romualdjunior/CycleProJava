/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Evenement;

import Entitie.Evenement.Event;
import IService.Evenement.IServices;
import static Test.Main.getDate;
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
public class EventService implements IServices<Event> {
Connection cnx=DataSource.getInstance().getCnx();
    @Override
    public void ajouter(Event t) {
         try{
    String requete = "INSERT INTO event(nom, description, prix, longitude_arrv, latitude_dep,latitude_arrv, dateDebut, nbrplace, evaluation, photoEvent, dateFin, niveau, type, membre, tel, email, longitude_Dep, adresse) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getNom());
            pst.setString(2, t.getDescription());
            pst.setFloat(3, t.getPrix());
            pst.setFloat(4, t.getLongitudeArrv());
            pst.setFloat(5, t.getLatitudeDep());
            pst.setFloat(6, t.getLatitudeArrv());
            pst.setDate(7,  t.getDateDebut());
            pst.setInt(8, t.getNbrplace());
            pst.setFloat(9, 0);
            pst.setString(10, t.getPhotoEvent());
            pst.setDate(11,  t.getDateFin());
            pst.setString(12, t.getNiveau());
            pst.setString(13, t.getType());
            pst.setString(14, t.getMembre());
            pst.setInt(15, t.getTel());
            pst.setString(16, t.getEmail());
            pst.setFloat(17, t.getLogitudeDep());
            pst.setString(18, t.getAdresse());
            
             
          
             
            pst.executeUpdate();
            System.out.println("Event ajoutée !"); /*tout les methodes qui ont des modification on met executrUpdate*/
             }catch(SQLException e){
                 System.out.println(e.getMessage());
             }  
         }

    @Override
    public void supprimer(Event t) {
        try {
            String requete = "DELETE FROM Event WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Event supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
    }

    @Override
    public void modifier(Event t) {
        
          try {
            String requete = "UPDATE personne SET nom=?, description=?, prix=?, longitude_arrv=?, latitude_dep,latitude_arrv=?, dateDebut=?, nbrplace=?, photoEvent=?, dateFin=?, niveau=?, type=?, membre=?, tel=?, email=?, longitude_Dep=?, adresse==? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
           
            pst.setString(1, t.getNom());
            pst.setString(2, t.getDescription());
             pst.setFloat(3, t.getPrix());
            pst.setFloat(4, t.getLongitudeArrv());
            pst.setFloat(5, t.getLatitudeDep());
            pst.setFloat(6, t.getLatitudeArrv());
            pst.setDate(7,  t.getDateDebut());
            pst.setInt(8, t.getNbrplace());
            pst.setString(9, t.getPhotoEvent());
            pst.setDate(10,  t.getDateFin());
            pst.setString(11, t.getNiveau());
            pst.setString(12, t.getType());
            pst.setString(13, t.getMembre());
            pst.setInt(14, t.getTel());
            pst.setString(15, t.getEmail());
            pst.setFloat(16, t.getLogitudeDep());
            pst.setString(17, t.getAdresse());
            pst.setInt(18, t.getId());
            pst.executeUpdate();
            System.out.println("Event modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         }

    @Override
    public List<Event> afficher() {
          List<Event> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM event";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Event(rs.getInt("id"), rs.getString("nom"), rs.getString("description") , rs.getFloat("prix"), rs.getString("photoEvent") , rs.getString("adresse") , rs.getFloat("longitude_Dep") , rs.getFloat("longitude_Arrv") , rs.getFloat("latitude_Dep") , rs.getFloat("latitude_Arrv") , rs.getDate("dateDebut") , rs.getDate("dateFin") , rs.getInt("nbrplace") , rs.getFloat("evaluation") , rs.getString ("niveau"), rs.getString("Type"), rs.getString("membre"), rs.getInt("tel"), rs.getString("email")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    
        }
    
    
    
    /// decrementer le nbr de place d'un evt
    
   public void participer(int idEvent ){
         
           try {
            String requete = "update event set nbrplace = nbrplace-1 where id = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
           
            pst.setInt(1, idEvent);
            pst.executeUpdate();
           

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
         
         }
    public void departiciper(int idEvent ){
         
          try {
              ParticipantsService ps = new ParticipantsService();
             
            String requete = "update event set nbrplace = nbrplace+1 where id = ?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            
           
            pst.setInt(1, idEvent);
            pst.executeUpdate();
           

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
         
         }
         
     public List<Event> search(String input) {
          List<Event> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM event where type like '%"+input+"%' OR Membre like '%"+input+"%' OR contenue LIKE '%"+input+"%' OR niveau like '%"+input+"%' Or nom like '%"+input+"%' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                 list.add(new Event(rs.getInt("id"), rs.getString("nom"), rs.getString("description") , rs.getFloat("prix"), rs.getString("photoEvent") , rs.getString("adresse") , rs.getFloat("longitude_Dep") , rs.getFloat("longitude_Arrv") , rs.getFloat("latitude_Dep") , rs.getFloat("latitude_Arrv") , rs.getDate("dateDebut") , rs.getDate("dateFin") , rs.getInt("nbrplace") , rs.getFloat("evaluation") , rs.getString ("niveau"), rs.getString("Type"), rs.getString("membre"), rs.getInt("tel"), rs.getString("email")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    
        }
}
