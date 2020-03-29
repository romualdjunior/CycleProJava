/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface IService<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    List<T> readAll() throws SQLException;
   String passwordEncryption(String password) ;
   boolean connexion(String usernameEmail,String password) throws SQLException;
   String passwordDecryption(String password);
}
