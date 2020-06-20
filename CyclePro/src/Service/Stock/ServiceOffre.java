/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Stock;

import Entitie.Stock.Offre;
import Utils.DataSource;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yasmine
 */
public class ServiceOffre {
      Connection cnx = DataSource.getInstance().getCnx();
    public void ajouter (Offre o){
    String reg;
        reg = "insert into fournisseur (pourcentage,Velo,nvPrix,dateDebut,dateFin) values (?,?,?,?,?);";
    
    try{
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst.setInt(1, o.getPourcentage());
            pst.setInt(2, o.getVelo());
            pst.setDouble(3, o.getNvPrix());
            pst.setDate(4, o.getDateDebut());
            pst.setDate(5, o.getDateFin());
            pst.executeUpdate();
            System.out.println("offre ajoute");
            
    } catch (SQLException ex){
    System.out.println(ex.getMessage());
    }
    }
     public ObservableList<Offre> affichier() {
         ObservableList<Offre> c = FXCollections.observableArrayList();
         this.checkVerifOffre();
       List<Offre> list = new ArrayList<>();

        try {
            String requete = "SELECT * FROM Offre";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c.add(new Offre(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return c;
        
         
    }
     public Offre getOffre(int id)
      {
          try {
            String requete = "SELECT * FROM Offre where velo="+id;
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Offre v=new Offre(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6));
                return v;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
      }
     
     public void supprimer(Offre v) {
    String reg ="delete from Offre where id= ?";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst .setInt(1, v.getId());
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }
     public void supprimerV(int id_v) {
    String reg ="delete from Offre where velo= ?";
        try {
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst .setInt(1, id_v);
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }
    public void checkVerifOffre()
    {
        try {
            String requete = "SELECT * FROM Offre";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Offre o=new Offre(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6));
                if(o.getDateFin().getDay()< new java.util.Date().getDay())
                {
                    this.supprimer(o);
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
