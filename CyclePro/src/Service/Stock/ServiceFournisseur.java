/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Stock;

import Entitie.Stock.Fournisseur;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yasmine
 */
public class ServiceFournisseur {
        Connection cnx = DataSource.getInstance().getCnx();
    public void ajouter (Fournisseur f){
    String reg;
        reg = "insert into fournisseur (raisonSociale, matricule, mail, addresse, telephone) values (?,?,?,?,?);";
    
    try{
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst.setString(1, f.getRaisonSociale());
            pst.setString(2, f.getMatricule());
            pst.setString(3, f.getMail());
            pst.setString(4, f.getAddresse());
            pst.setString(5, f.getTelephone());
            pst.executeUpdate();
            System.out.println("fournisseur ajoute");
            
    } catch (SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
     public void supprimer(Fournisseur f) {
    String reg ="delete from fournisseur where id= ?";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst .setInt(1, f.getId());
            pst.executeUpdate();
             System.out.println("fournisseur supprimer");
            
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }
    
     
      public List<Fournisseur> afficher (){
    List<Fournisseur> list = new ArrayList <>();
    
    String reg ="select * from Fournisseur ";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            ResultSet rs = pst.executeQuery(); //matrice
            while (rs.next()){
               Fournisseur f ;
                f = new Fournisseur(rs.getInt(1)/*("id")*/, rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));
               list.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return list;
    } 
       public void modifier(Fournisseur f) {
        try {
            String requete = "UPDATE fournisseur SET raisonSociale=?, matricule=?, mail=?, addresse=?, telephone=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(6, f.getId());
           pst.setString(1, f.getRaisonSociale());
            pst.setString(2, f.getMatricule());
            pst.setString(3, f.getMail());
            pst.setString(4, f.getAddresse());
            pst.setString(5, f.getTelephone());
            pst.executeUpdate();
            System.out.println("fournisseur modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
       
}
