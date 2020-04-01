/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Produit;

import Entitie.Produit.Velo;
import Entitie.User.BCrypt;
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
public class ServiceProduit implements IService.Produit.IServiceProduit {

        private Connection cnx;
    private Statement ste;

    public ServiceProduit() {
                cnx = DataSource.getInstance().getCnx();

    }
    

    @Override
    public List<Velo> readAll() throws SQLException {
        List<Velo> list = new ArrayList();
        String req = "select id , photoV,Caracteristiques,marque,type,categorie,description,etat,couleur,nbrDePlace,taille,soldee,qtEnStock,prixAchat from velo ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                 Velo p = new Velo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getInt(14));
                list.add(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
            return list;

    }

    @Override
    public boolean verifierQuantite(int idProduit, int quantite) throws SQLException {
         String req = "select qtEnStock from velo where id=?";
        try {
           PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, idProduit);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                if(rs.getInt(1)<quantite) return false;
                else return true;
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;
    }

}
