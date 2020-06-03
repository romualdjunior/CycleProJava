/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Stock;

import Entitie.Stock.Offre_a;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Yasmine
 */
public class ServiceOffreA {
      Connection cnx = DataSource.getInstance().getCnx();
    public void ajouter (Offre_a o){
    String reg;
        reg = "insert into fournisseur (nvPrix,dateDebut,dateFin,pourcentage,accessoires) values (?,?,?,?,?);";
    
    try{
            PreparedStatement pst=cnx.prepareStatement(reg);
            pst.setDouble(1, o.getNvPrix());
            pst.setDate(2, o.getDateDebut());
            pst.setDate(3, o.getDateFin());
            pst.setInt(4, o.getPourcentage());
            pst.setInt(5, o.getAccessoires());
            
            pst.executeUpdate();
            System.out.println("offre ajoute");
            
    } catch (SQLException ex){
    System.out.println(ex.getMessage());
    }
    
}}
