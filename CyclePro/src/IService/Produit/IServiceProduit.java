/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Produit;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface IServiceProduit <T> {
        List<T> readAll() throws SQLException;
        boolean verifierQuantite(int idProduit,int quantite) throws SQLException;

}
