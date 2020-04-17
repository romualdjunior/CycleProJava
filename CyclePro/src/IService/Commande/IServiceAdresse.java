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


    int getLastAdresse() throws SQLException;

    List<T> readAll() throws SQLException;

    public Adresse getAdresse(int idAdresse) throws SQLException;

    public boolean update(int idAdresse, String adresseLivraison, int pincode, String ville, String pays, String etat) throws SQLException;

}
