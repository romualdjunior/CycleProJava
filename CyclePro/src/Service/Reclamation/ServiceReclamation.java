/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Reclamation;

import Entitie.Reclamation.Reclamation;
import Entitie.Reclamation.Categorie;
import Utils.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
/**
 *
 * @author mywindows
 */
public class ServiceReclamation implements IService.Reclamation.IService<Reclamation>{
    
   private static String url ="jdbc:mysql://localhost:3306/pidev";
  private static String login = "root";
  private static String pwd ="";
   Connection cnx = null ; 
   FileInputStream fis = null ; 
   File image = new File ("event1.jpg"); 
        
  
    IService.Reclamation.IService<Categorie> sc = new ServiceCategorie();
    IService.User.IService su = new Service.User.UserService();
    
   /* @Override
    public boolean ajouter(Reclamation entity) throws SQLException {
        if (entity == null || entity.getUser() == null || entity.getCategorie() == null) return false;
        
        String req = "insert into reclamations (user_id, categorie_id, sujet, description , image) values (?, ?, ?, ?,?)";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, entity.getUser().getId());
        pst.setInt(2, entity.getCategorie().getId());
        pst.setString(3, entity.getSujet());
        pst.setString(4, entity.getDescription());
        pst.setBinaryStream(5,fis, (int) image.length());

        return this.isUpdated(pst.executeUpdate(), "ajoutée");
        
    }*/
    
     @Override
    public boolean ajouter(Reclamation entity) throws SQLException {
       
       
         if (entity == null || entity.getUser() == null || entity.getCategorie() == null) return false;
       
       
       String req = "insert into reclamations (user_id, categorie_id, sujet, description , image) values (?, ?, ?, ?,?)";

        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, entity.getUser().getId());
        pst.setInt(2, entity.getCategorie().getId());
        pst.setString(3, entity.getSujet());
        pst.setString(4, entity.getDescription());
        pst.setString(5,entity.getImage());
       
        return this.isUpdated(pst.executeUpdate(), "ajoutée");
        }
        
    
    
    

    @Override
    public Reclamation getById(int id) throws SQLException {
        String req = "select id, user_id, categorie_id, sujet, description , photo from reclamations where id = ?";
        
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return this.getReclamation(rs);
        }
        
        return null;
    }

    @Override
    public List<Reclamation> getAll() throws SQLException {
        String req = "select id, user_id, categorie_id , sujet , description , image   from reclamations";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        List<Reclamation> reclamations = new LinkedList<Reclamation>();
        while (rs.next()) {
             reclamations.add(this.getReclamation(rs));
        }
        return reclamations;
    }

    @Override
    public boolean update(Reclamation entity) throws SQLException {
        if (entity == null || entity.getUser() == null || entity.getCategorie() == null) return false;
        String req = "UPDATE reclamations SET user_id = ?, categorie_id = ?, sujet = ?, description = ?  WHERE id=?";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, entity.getUser().getId());
        pst.setInt(2, entity.getCategorie().getId());
        pst.setString(3, entity.getSujet());
        pst.setString(4, entity.getDescription());
        pst.setInt(6, entity.getId());

        return this.isUpdated(pst.executeUpdate(), "modifié");
    }

    @Override
    public boolean supprimer(Reclamation entity) throws SQLException {
        if (entity == null) return false;
        return this.supprimer(entity.getId());
    }

    @Override
    public boolean supprimer(int id) throws SQLException {
        String req = "DELETE FROM reclamations WHERE id=?";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, id);
        pst.executeUpdate();
        return this.isUpdated(pst.executeUpdate(), "supprimé");
    }
    private boolean isUpdated(int rows, String action) {
            if (rows > 0){
                String message  = "Reclamation " + action;
                System.out.printf(message);
                JOptionPane.showMessageDialog(null, message);
                return true;
            } else {
                return false;
            }
    }
    
    private Reclamation getReclamation(ResultSet rs) throws SQLException{
        int user_id = rs.getInt(2);
        int categorie_id = rs.getInt(3);
        return Reclamation.builder().id(rs.getInt(1))
                    .user(su.utilisateur(user_id))
                    .categorie(sc.getById(categorie_id))
                    .sujet(rs.getString(4))
                    .description(rs.getString(5))
                    .build();
    }
    
    
    public Reclamation getBySujet(String sujet) throws SQLException {
        String req = "select id, user_id, categorie_id, sujet, description , photo from reclamations where sujet = ?";
        
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setString(1, sujet);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return this.getReclamation(rs);
        }
        
        return null;
    }
    
    
    
    
    
    
    
    
}


