/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Commande;

import Entitie.Commande.LignePanier;
import IService.Commande.IServiceLignePanier;
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
public class ServiceLignePanier implements IServiceLignePanier<LignePanier> {

    private Connection cnx;
    private Statement ste;

    public ServiceLignePanier() {
        cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void ajouter(LignePanier p) throws SQLException {

        String req = "insert into ligne_panier (commande_id,produit_id,quantite) values (?,?,?)";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.get$idCommande());
            pst.setInt(2, p.get$idProduit());
            pst.setInt(3, p.get$quantite());
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("panier mis à jour dans la base de données");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public boolean delete(int idPanier ) throws SQLException {
        String req = "delete from ligne_panier where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, idPanier);
            pst.executeUpdate();
            System.out.println("Produit supprime de la commande");
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(LignePanier l) throws SQLException {
 String req = "update lignePanier set quantite=? where id=?";
 try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, l.get$quantite());
            pst.setInt(2, l.getId());
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("Commande mis à jour avec success");
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;    }

    @Override
    public List<LignePanier> readAll() throws SQLException {
List<LignePanier> list = new ArrayList();
        String req = "select *from ligne_panier";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                 LignePanier p = new LignePanier(rs.getInt(1),rs.getInt(2),rs.getInt(3));
                list.add(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
            return list;    }

}
