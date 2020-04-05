/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Commande;

import Entitie.Commande.Commande;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface IServicePayment<Payment> {
     void ajouter(Payment p) throws SQLException;
    boolean delete(Payment p) throws SQLException;
    boolean update(Payment p) throws SQLException;
    List<Payment> readAll() throws SQLException;
}
