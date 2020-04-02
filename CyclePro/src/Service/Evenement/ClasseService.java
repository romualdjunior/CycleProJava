/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Evenement;

import Entitie.Evenement.Classe;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import IService.Evenement.IServices;

/**
 *
 * @author ASUS
 */
public class ClasseService implements IServices<Classe> {
     Connection cnx=DataSource.getInstance().getCnx();

    @Override
    public void ajouter(Classe t) { 
         String req="insert into classe (Nom,NbModules,NbCategories) values ('"+t.getNom()+"','"+t.getNbModules()+"','"+t.getNbCategories()+"')";
    try{
     Statement st =cnx.createStatement();
     st.executeUpdate(req);
             }catch(SQLException e){
                 System.out.println(e.getMessage());
             }
        }

    @Override
    public void supprimer(Classe t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Classe t) {
        
         try {
           String requete = "UPDATE classe SET NbModules=?,NbCategories=? WHERE Nom=?  ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(3, t.getNom());
            pst.setInt(1, t.getNbModules());
            pst.setInt(2, t.getNbCategories());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
         }

    @Override
    public List<Classe> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
