/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Stock;

import Entitie.Stock.Accessoires;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yasmine
 */
public class ServiceAccessoires {
         Connection cnx = DataSource.getInstance().getCnx();
    public void ajouter (Accessoires a){
    String reg;
        reg = "insert into accessoires ( photoA, nom, marque, categorie,prix,description,  photoA1, photoA2,  photoA3, soldee,Caracteristiques,qtEnStock ) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?);";
    
    try{
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst.setString(1, a.getPhotoA());
            pst.setString(2, a.getNom());
             pst.setString(3, a.getMarque());
              pst.setString(4, a.getCategorie());
               pst.setDouble(5, a.getPrix());
              pst.setString(6, a.getDescription());
                pst.setString(7, a.getPhotoA1());
               pst.setString(8, a.getPhotoA2());
                pst.setString(9, a.getPhotoA3());
                     pst.setInt(10, a.getSoldee());
                      pst.setString(11, a.getCaracteristiques());
            pst.setInt(12, a.getQtEnStock());
            pst.executeUpdate();
            System.out.println("Accessoires ajoute");
    } catch (SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
     public void supprimer(Accessoires a) {
    String reg ="delete from accessoires where id= ?";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst .setInt(1, a.getId());
            pst.executeUpdate();
             System.out.println("Accessoires supprimer");
            
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }
     
    public ObservableList<Accessoires> affichier() {
         ObservableList<Accessoires> c = FXCollections.observableArrayList();
         
       List<Accessoires> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Accessoires";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(      new Accessoires(rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getInt(11), rs.getString(12),rs.getInt(13)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return c;
        
         
    }
    
       public void modifier(Accessoires a) {
        try {
            String requete = "UPDATE accessoires SET photoA=?, nom=?, marque=?, categorie=?,prix=?,description=?,  photoA1=?, photoA2=?,  photoA3=?, soldee=?,Caracteristiques=?,qtEnStock=?  WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(13, a.getId());
           pst.setString(1, a.getPhotoA());
            pst.setString(2, a.getNom());
             pst.setString(3, a.getMarque());
              pst.setString(4, a.getCategorie());
               pst.setDouble(5, a.getPrix());
              pst.setString(6, a.getDescription());
                pst.setString(7, a.getPhotoA1());
               pst.setString(8, a.getPhotoA2());
                pst.setString(9, a.getPhotoA3());
                     pst.setInt(10, a.getSoldee());
                      pst.setString(11, a.getCaracteristiques());
            pst.setInt(12, a.getQtEnStock());
            pst.executeUpdate();
            System.out.println("ACCESOIRSE modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 public ObservableList<Accessoires> search(String input) {
         ObservableList<Accessoires> c = FXCollections.observableArrayList();
         
       List<Accessoires> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Accessoires where nom like '%"+input+"%' OR marque like '%"+input+"%' OR categorie LIKE '%"+input+"%' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Accessoires(rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getInt(11), rs.getString(12),rs.getInt(13)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return c;
        
         
    }
 
}
