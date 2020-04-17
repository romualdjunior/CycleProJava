/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Commande;

import Entitie.Commande.Adresse;
import Entitie.Commande.Commande;
import Entitie.Commande.CommandeAdresse;
import Entitie.Commande.Panier;
import Entitie.User.User;
import IService.Commande.IServiceCommande;
import Utils.DataSource;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
    public int[] statistiques() throws SQLException {
        int nbreVentes[]={0,0,0,0,0,0,0,0,0,0,0,0};
        String req = "select date from  commande";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).contains("-01-")) {
                    nbreVentes[0]++;
                }
                else if (rs.getString(1).contains("-02-")) {
                    nbreVentes[1]++;
                }
                 else if (rs.getString(1).contains("-03-")) {
                    nbreVentes[2]++;
                }
                 else if (rs.getString(1).contains("-04-")) {
                    nbreVentes[3]++;
                }
                 else if (rs.getString(1).contains("-05-")) {
                    nbreVentes[4]++;
                }
                 else if (rs.getString(1).contains("-06-")) {
                    nbreVentes[5]++;
                }
                 else if (rs.getString(1).contains("-07-")) {
                    nbreVentes[6]++;
                }
                 else if (rs.getString(1).contains("-08-")) {
                    nbreVentes[7]++;
                }
                 else if (rs.getString(1).contains("-09-")) {
                    nbreVentes[8]++;
                }
                 else if (rs.getString(1).contains("-10-")) {
                    nbreVentes[9]++;
                }
                 else if (rs.getString(1).contains("-11-")) {
                    nbreVentes[10]++;
                }
                 else if (rs.getString(1).contains("-12-")) {
                    nbreVentes[11]++;
                }
              
            }
            return nbreVentes;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return nbreVentes;

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
    public List<CommandeAdresse> readAll2() throws SQLException {
        List<CommandeAdresse> list = new ArrayList();
        String req = "select c.total ,c.etat,c.date,u.username,u.email,a.pays,a.ville,a.adresseLivraison,a.pincode,c.id,a.id from commande c inner join adresse a on c.adresse_id=a.id inner join user u on u.id=c.user_id";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CommandeAdresse(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
            }
            return list;
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return list;

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
    public Commande getCommande(int idCommande) throws SQLException {
        String req = "select * from commande where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, idCommande);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return new Commande(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(2), rs.getInt(3));
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return new Commande();
    }

    @Override
    public void historique(User user, int idCommande, ObservableList<Panier> paniers) throws DocumentException, FileNotFoundException, BadElementException, SQLException {
        Document document = new Document();
        String file_name = "E:\\3ème_année\\PiJava\\CycleProJava\\CyclePro\\src\\GUI\\Commande\\Facture.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        document.open();
        System.out.println("Montant " + this.getCommande(idCommande).getTotal());
        Paragraph p7 = new Paragraph(" ");
        Paragraph p4 = new Paragraph(" ");
        Paragraph p5 = new Paragraph(" ");
        Paragraph p6 = new Paragraph(" ");
        Paragraph p = new Paragraph("Ci-joint votre facture");
        Paragraph p1 = new Paragraph("Utilisateur: " + user.getUsername());
        Paragraph p3 = new Paragraph("Email: " + user.getEmail());
        Paragraph p2 = new Paragraph("Montant: " + this.getCommande(idCommande).getTotal() + "$ ");
        try {
            document.add(Image.getInstance("E:\\3ème_année\\PiJava\\CycleProJava\\CyclePro\\src\\GUI\\Images\\LogoCyclePro.png"));
        } catch (IOException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.add(p4);
        document.add(p5);
        document.add(p6);
        document.add(p7);
        document.add(p);
        document.add(p1);
        document.add(p3);
        document.add(p2);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        PdfPTable table = new PdfPTable(6);
        PdfPCell c1 = new PdfPCell(new Phrase("Produit"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Prix"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Etat"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Date"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Quantite"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Adresse"));
        table.addCell(c1);
        table.setHeaderRows(1);

        for (Panier panier : paniers) {
            try {
                table.addCell(Image.getInstance("E:\\3ème_année\\PiJava\\CycleProJava\\CyclePro\\src\\GUI\\Images\\" + panier.getImage()));
            } catch (IOException ex) {
                Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
            table.addCell(Integer.toString(panier.getPrix()));
            table.addCell(this.getCommande(idCommande).getEtat());
            table.addCell(this.getCommande(idCommande).getDate());
            table.addCell(Integer.toString(panier.getQuantite()));
            ServiceAdresse serviceAdresse = new ServiceAdresse();
            Adresse a = serviceAdresse.getAdresse(serviceAdresse.getLastAdresse());
            table.addCell(a.getAdresseLivraison());

        }
        System.out.println("Facture générée");
        document.add(table);
        document.close();

    }

}
