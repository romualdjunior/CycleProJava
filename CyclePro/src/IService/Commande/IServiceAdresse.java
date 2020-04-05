/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Commande;

import Entitie.Commande.Adresse;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface IServiceAdresse<T> {
     void ajouter(Adresse a) throws SQLException;
    boolean delete(Adresse a) throws SQLException;
    boolean update(Adresse a) throws SQLException;
    int getLastAdresse() throws SQLException;
    List<T> readAll() throws SQLException;
}
