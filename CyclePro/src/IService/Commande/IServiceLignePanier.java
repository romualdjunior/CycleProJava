/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Commande;

import Entitie.Commande.LignePanier;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author toshiba
 * @param <LignePanier>
 */
public interface IServiceLignePanier<LignePanier> {
     void ajouter(LignePanier p) throws SQLException;
    boolean delete(int idPanier) throws SQLException;
     boolean update(LignePanier l) throws SQLException;
    List<LignePanier> readAll() throws SQLException;
}
