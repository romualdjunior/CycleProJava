/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Stock;

import Entitie.Stock.Fournisseur;
import Entitie.Stock.Velo;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.swing.UIManager.getString;

/**
 *
 * @author Yasmine
 */
public class ServiceVelo {
          Connection cnx = DataSource.getInstance().getCnx();
    public void ajouter (Velo v){
    String reg;
        reg = "insert into velo (  marque,  couleur,  nbrDePlace,  taille, qtEnStock, qtStockSecurite,"
                + " prixAchat, prixLocH,photoV,  Fournisseur, categorie,"
                + "  description, etat,  soldee,   type, photoV1,  photoV2,  photoV3, Caracteristiques)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
     ServiceFournisseur sf=new ServiceFournisseur();
      Fournisseur f=new Fournisseur();
    f=sf.getFournisseurNom(v.getFournisseur());
    try{
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst.setString(1, v.getMarque());
            pst.setString(2, v.getCouleur());
             pst.setInt(3, v.getNbrDePlace());
              pst.setString(4, v.getTaille());
              pst.setInt(5, v.getQtEnStock());
            pst.setInt(6, v.getQtStockSecurite());
            pst.setDouble(7, v.getPrixAchat());
            pst.setDouble(8, v.getPrixLocH());
             pst.setString(9, v.getPhotoV());
             pst.setInt(10, f.getId());                        
            pst.setString(11, v.getCategorie());
            pst.setString(12, v.getDescription());
            pst.setString(13, v.getEtat());
            pst.setInt(14, v.getSoldee());
            pst.setString(15, v.getType());
             pst.setString(16, v.getPhotoV1());
              pst.setString(17, v.getPhotoV2());
               pst.setString(18, v.getPhotoV3());
                  pst.setString(19, v.getCaracteristiques());
            pst.executeUpdate();
            System.out.println("velo ajoute");
    } catch (SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
     public void supprimer(Velo v) {
    String reg ="delete from velo where id= ?";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst .setInt(1, v.getId());
            pst.executeUpdate();
             System.out.println("velo supprimer");
            
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }
     
      public ObservableList<Velo> affichier() {
         ObservableList<Velo> c = FXCollections.observableArrayList();
       List<Velo> list = new ArrayList<>();
     
        try {
            String requete = "SELECT * FROM Velo inner join fournisseur on Velo.Fournisseur=fournisseur.id";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Velo (rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9),rs.getString(10),rs.getString(22), rs.getString(12),getString(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20)));}
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }return c;}
      
      public ObservableList<Velo> afficherType(String type) {
         ObservableList<Velo> c = FXCollections.observableArrayList();
       List<Velo> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM Velo where type=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, type);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Velo (rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9),rs.getString(10),rs.getString(11), rs.getString(12),getString(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20)));}
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }return c;}
      public void modifier(Velo v) 
      {
           ServiceFournisseur sf=new ServiceFournisseur();
      Fournisseur f=new Fournisseur();
    f=sf.getFournisseurNom(v.getFournisseur());
        try {
            String requete = "UPDATE velo SET marque=?,  couleur=?,  nbrDePlace=?,  taille=?, qtEnStock=?, qtStockSecurite=?, prixAchat=?, prixLocH=?,photoV=?,  Fournisseur=?, categorie=?,description=?, etat=?,  soldee=?,   type=?, photoV1=?,  photoV2=?,  photoV3=?, Caracteristiques=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(20, v.getId());
           pst.setString(1, v.getMarque());
            pst.setString(2, v.getCouleur());
             pst.setInt(3, v.getNbrDePlace());
              pst.setString(4, v.getTaille());
              pst.setInt(5, v.getQtEnStock());
            pst.setInt(6, v.getQtStockSecurite());
            pst.setDouble(7, v.getPrixAchat());
            pst.setDouble(8, v.getPrixLocH());
             pst.setString(9, v.getPhotoV());
             pst.setInt(10, f.getId());                        
            pst.setString(11, v.getCategorie());
            pst.setString(12, v.getDescription());
            pst.setString(13, v.getEtat());
            pst.setInt(14, v.getSoldee());
            pst.setString(15, v.getType());
             pst.setString(16, v.getPhotoV1());
              pst.setString(17, v.getPhotoV2());
               pst.setString(18, v.getPhotoV3());
                  pst.setString(19, v.getCaracteristiques());
            pst.executeUpdate();
            System.out.println("velo modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }}
public ObservableList<Velo> search(String input) {
           ObservableList<Velo> c = FXCollections.observableArrayList();
List<Velo> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM Velo where marque like '%"+input+"%' OR couleur like '%"+input+"%' OR categorie LIKE '%"+input+"%' ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Velo(rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9),rs.getString(10),rs.getString(11), rs.getString(12),getString(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return c;
    
        }

public int NbVelo() {
        int nV=0;

        try {
            String requete = "SELECT COUNT(*) FROM Velo ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
              nV =rs.getInt(1);
            }
           return nV;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return 0;
        }
    }

      public void modifierQnt(int id,int qnt) 
      {
        try {
            String requete = "UPDATE velo SET qtEnStock=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(2,id);
            pst.setInt(1,qnt);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      }
      public Velo getVelo(int id)
      {
          try {
            String requete = "SELECT * FROM Velo where id="+id;
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Velo v=new Velo(rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9),rs.getString(10),rs.getString(11), rs.getString(12),getString(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20));
                return v;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
      }
      
      public Velo getVeloMarque(String marque)
      {
          try {
            String requete = "SELECT * FROM Velo where marque=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1,marque);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Velo v=new Velo(rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9),rs.getString(10),rs.getString(11), rs.getString(12),getString(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20));
                return v;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
      }

}