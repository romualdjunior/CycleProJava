/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Commande;

import Entitie.Commande.Commande;
import Entitie.User.User;
import IService.Commande.IServiceCommande;
import Utils.DataSource;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class ServiceCommande implements IServiceCommande<Commande> {

    private Connection cnx;
    private Statement ste;

    public ServiceCommande() {
        cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void ajouter(Commande c) throws SQLException {
        String req = "insert into commande (total,etat,date,user_id,adresse_id) values (?,?,?,?,?)";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, c.getTotal());
            pst.setString(2, c.getEtat());
            pst.setString(3, c.getDate());
            pst.setInt(4, c.getIdUser());
            pst.setInt(5, c.getAdresse());
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("votre commande a été validée");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public boolean delete(int idCommande) throws SQLException {
        String req = "delete from commande where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, idCommande);
            String req2 = "select id from ligne_panier where commande_id=?";
            try {
                PreparedStatement pst2 = cnx.prepareStatement(req2);
                pst2.setInt(1, idCommande);
                ResultSet rs = pst2.executeQuery();
                while (rs.next()) {
                    ServiceLignePanier sl = new ServiceLignePanier();
                    sl.delete(rs.getInt(1));
                }

            } catch (SQLException err) {
                System.out.println(err.getMessage());

            }

            pst.executeUpdate();
            System.out.println("commande annulée");
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(int idCommande) throws SQLException {
        String req = "update commande set etat='paye' where id=?";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, idCommande);
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("Commande mis à jour avec success");
            return true;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return false;
    }

    @Override
    public void readAll() throws SQLException {
        String req = "select c.total , c.etat,c.date,c.user_id,c.adresse_id,a.adresseLivraison,c.id from commande c inner join adresse a on c.adresse_id=a.id";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(" Total :" + rs.getInt(1) + " etat :" + rs.getString(2) + " date :" + rs.getString(3) + " user_id :" + rs.getInt(4) + " addresse_id :" + rs.getString(5) + " adresseLivraison :" + rs.getString(6) + " id :" + rs.getInt(7));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public void readAll2(String champ) throws SQLException {
        String req = "select c.total , c.etat,c.date,c.user_id,c.adresse_id,a.adresseLivraison,c.id from commande c inner join adresse a on c.adresse_id=a.id where  c.total like '%" + champ + "%' or  c.etat like '%" + champ + "%'or c.date like '%" + champ + "%'"
                + "or c.user_id like '%" + champ + "%'or c.adresse_id like '%" + champ + "%'or a.adresseLivraison like '%" + champ + "%' or c.id like '%" + champ + "%' ";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(" Total :" + rs.getInt(1) + " etat :" + rs.getString(2) + " date :" + rs.getString(3) + " user_id :" + rs.getInt(4) + " addresse_id :" + rs.getString(5) + " adresseLivraison :" + rs.getString(6) + " id :" + rs.getInt(7));

            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public int getLastCommande() throws SQLException {
        String req = "select * from commande order by id desc limit 1";
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

    @Override
    public void historique(User user, Integer Total) throws SQLException, DocumentException, FileNotFoundException {

        String req = "select c.total , c.etat,c.date,c.user_id,c.adresse_id,l.produit_id,l.quantite,l.id from commande c inner join ligne_Panier l on c.id=l.commande_id";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            Document document = new Document();
            String file_name = "E:\\3ème_année\\PiJava\\CycleProJava\\CyclePro\\src\\GUI\\Commande\\Facture.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            Paragraph p = new Paragraph("Ci-joint votre facture");
            Phrase p1 = new Phrase("Utilisateur: " + user.getUsername() + " ");
            Phrase p2 = new Phrase("Montant: " + Total + "$ ");
            document.add(p);
            document.add(p1); 
            document.add(p2);

            while (rs.next()) {
                System.out.println("id " + rs.getInt(7) + " Total:" + rs.getInt(1) + " etat :" + rs.getString(2) + " date:" + rs.getString(3) + " user_id :" + rs.getInt(4) + " addresse_id :" + rs.getString(4) + " produit_id :" + rs.getInt(5) + " quantite :" + rs.getInt(6));
                document.add(new Phrase("etat: " + rs.getString(2) + " "));
                document.add(new Phrase("etat: " + rs.getString(2) + " "));
                document.add(new Phrase(" date:" + rs.getString(3) + " "));
                document.add(new Phrase(" addresse_id :" + rs.getString(4) + " "));
                document.add(new Phrase("   produit_id :" + rs.getInt(5) + " "));
                document.add(new Phrase(" quantite : " + rs.getInt(6) + " "));
                document.add(new Paragraph(""));
                document.add(new Paragraph(""));

            }
            document.close();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

 

}
