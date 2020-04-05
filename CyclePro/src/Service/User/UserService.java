/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.User;

import Entitie.Produit.Velo;
import Entitie.User.BCrypt;
import Entitie.User.User;
import IService.User.IService;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Utils.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class UserService implements IService<User> {

    private Connection cnx;
    private Statement ste;

    public UserService() {
        cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void ajouter(User user) throws SQLException {
        String req = "insert into user (username,username_canonical,email,email_canonical,enabled,password,last_login,roles) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getUsername_canonical());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getEmail_canonical());
            pst.setInt(5, user.getEnabled());
            pst.setString(6, user.getPassword());
            pst.setString(7, user.getLast_login());
            pst.setString(8, user.getRoles());
            pst.executeUpdate();//uniqument avec l'ajout,la suppression et la modification dans la base de données
            System.out.println("utilisateur ajoutée");
            JOptionPane.showMessageDialog(null, "Utilisateur ajoutée");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    @Override
    public boolean delete(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String passwordEncryption(String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        hashed = hashed.replace("$2a", "$2y");
        return hashed;
    }

    @Override
    public String passwordDecryption(String password) {
        String hashed = password.replace("$2y", "$2a");
        return hashed;
    }

    @Override
    public int connexion(String usernameEmail, String password) throws SQLException {
        String req = "select * from user where username = ? or email = ?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, usernameEmail);
            pst.setString(2, usernameEmail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                if (BCrypt.checkpw(password, this.passwordDecryption(rs.getString(8)))) {
                    return rs.getInt(1);

                } else {
                    return -1;
                }
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return -1;
    }
 

}
