/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Commande;

import Entitie.Commande.Adresse;
import Entitie.User.BCrypt;
import IService.Commande.IServiceAdresse;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class ServiceAdresse implements IServiceAdresse<Adresse>{

       private Connection cnx;
    private Statement ste;

    public ServiceAdresse() {
        cnx = DataSource.getInstance().getCnx();
    }
    @Override
    public void ajouter(Adresse a) throws SQLException {

    String req = "insert into adresse (nom,prenom,phone,email,pays,ville,etat,pincode,adresseLivraison) values (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setInt(3, a.getPhone());
            pst.setString(4, a.getEmail());
            pst.setString(5, a.getPays());
            pst.setString(6, a.getVille());
            pst.setString(7, a.getEtat());
            pst.setInt(8, a.getPincode());
            pst.setString(9, a.getAdresseLivraison());
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("adresse ajoutée");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }    }

    @Override
    public boolean delete(Adresse a) throws SQLException {
   String req = "delete from adresse where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, a.getId());
            pst.executeUpdate();
            System.out.println("adresse supprime ");
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;    }

    @Override
    public boolean update(Adresse a) throws SQLException {
 String req = "update adresse set ville='Tunis' where id=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, a.getId());
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("Commande mis à jour avec success");
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;    }

    @Override
    public List<Adresse> readAll() throws SQLException {
List<Adresse> list = new ArrayList();
        String req = "select * from adresse ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                 Adresse p = new Adresse(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
                list.add(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
            return list;    }

    @Override
    public int getLastAdresse() throws SQLException {
String req = "select * from adresse order by id desc limit 1";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

               return rs.getInt(1);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return -1;    
    }
    
}
