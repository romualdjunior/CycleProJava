/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Commande;

import Entitie.Commande.Commande;
import Entitie.Commande.CommandeAdresse;
import Entitie.Commande.Panier;
import Entitie.User.User;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javafx.collections.ObservableList;

/**
 *
 * @author toshiba
 */
public interface IServiceCommande<Commande> {

    void ajouter(Commande c) throws SQLException;

    boolean delete(int idCommande) throws SQLException;

    boolean update(int idCommande) throws SQLException;

    void readAll() throws SQLException;

    int getLastCommande() throws SQLException;

    public void historique(User user, int idCommande, ObservableList<Panier> panier) throws SQLException, DocumentException, FileNotFoundException;

    public Commande getCommande(int idCommande) throws SQLException;
    public List<CommandeAdresse> readAll2() throws SQLException;
     public int[] statistiques() throws SQLException;
}
