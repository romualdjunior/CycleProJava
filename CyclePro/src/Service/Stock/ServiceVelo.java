/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Stock;

import Entitie.Stock.Velo;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
             pst.setInt(10, v.getFournisseur());                        
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
     
      public List<Velo> afficher (){
    List<Velo> list = new ArrayList <>();
    
    String reg ="select * from Velo ";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            ResultSet rs = pst.executeQuery(); //matrice
            while (rs.next()){
               Velo v ;
                v = new Velo(rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3),rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getDouble(8),rs.getDouble(9),rs.getString(10),rs.getInt(11), rs.getString(12),getString(13),rs.getString(14),rs.getInt(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20));
               list.add(v);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return list;
    } 
      public void modifier(Velo v) {
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
             pst.setInt(10, v.getFournisseur());                        
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
        }
    }
}
