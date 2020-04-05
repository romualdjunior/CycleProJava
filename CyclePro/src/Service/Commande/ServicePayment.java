/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Commande;

import Entitie.Commande.Payment;
import IService.Commande.IServicePayment;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class ServicePayment implements IServicePayment<Payment>{
 private Connection cnx;
    private Statement ste;

    public ServicePayment() {
        cnx = DataSource.getInstance().getCnx();
    }
    @Override
    public void ajouter(Payment p) throws SQLException {

        String req = "insert into Payment (cardHolderName,cardNumber,securityCode,moisExpiration,anneeExpiration,commande_id) values (?,?,?,?,?,?)";

        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, p.getCardHolderName());
            pst.setInt(2, p.getCardNumber());
            pst.setInt(3, p.getSecurityCode());
            pst.setInt(4, p.getMoiExpiration());
            pst.setInt(5, p.getAnneeExpiration());
            pst.setInt(6, p.getIdCommande());
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("Paiement effectuee avec succès");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public boolean delete(Payment p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Payment p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Payment> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
