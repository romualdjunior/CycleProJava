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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yasmine
 */
public class ServiceFournisseur {
        Connection cnx = DataSource.getInstance().getCnx();
    public void ajouter (Fournisseur f){
    String reg;
        reg = "insert into fournisseur (raisonSociale, matricule,addresse, mail,  telephone) values (?,?,?,?,?);";
    
    try{
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst.setString(1, f.getRaisonSociale());
            pst.setString(2, f.getMatricule());
            pst.setString(3, f.getAddresse());
            pst.setString(4, f.getMail());
            pst.setString(5, f.getTelephone());
            pst.executeUpdate();
            System.out.println("fournisseur ajoute");
            
    } catch (SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
    
    public Boolean ExistFournisseur(int id) throws SQLException{
        int p=0;
        String query="select * from founisseur where id="+id;
        PreparedStatement pst=cnx.prepareStatement(query);  
        ResultSet rs=pst.executeQuery(query);
        while(rs.next())
        {
            p++;
        }
        if(p==0){
            return false;
        }
        else{
            return true;
        }
    }
     public boolean supprimer(Fournisseur f) throws SQLException {
    String reg ="delete from fournisseur where id= ?";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst .setInt(1, f.getId());
            pst.executeUpdate();
             System.out.println("fournisseur supprimer");
            return true;
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
              return false;
        }

    }

    
     public ObservableList<Fournisseur> affichier() {
         ObservableList<Fournisseur> c = FXCollections.observableArrayList();
         
       List<Fournisseur> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Fournisseur";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Fournisseur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return c;
        
         
    }
   public ObservableList<Fournisseur>  search(String input) {
         ObservableList<Fournisseur> c = FXCollections.observableArrayList();
         
       List<Fournisseur> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Fournisseur where raisonSociale like '%"+input+"%' OR addresse like '%"+input+"%'  ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Fournisseur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return c;
        
         
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
       public Fournisseur getFournisseur(int id)
      {
          try {
            String requete = "SELECT * FROM fournisseur where id="+id;
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Fournisseur  v=new Fournisseur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                return v;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
      }
       
}
