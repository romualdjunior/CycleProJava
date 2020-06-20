/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Reclamation;

import Entitie.Produit.Velo;
import Entitie.Reclamation.Categorie;
import IService.Reclamation.IService;
import Utils.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author wiem
 */
public class ServiceCategorie implements IService<Categorie>{

    @Override
    public boolean ajouter(Categorie entity) throws SQLException {
        if (entity == null) return false;
        String req = "insert into categories (label, description) values (?, ?)";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setString(1, entity.getLabel());
        pst.setString(2, entity.getDescription());

        return this.isUpdated(pst.executeUpdate(), "ajoutée");
    }

    @Override
    public Categorie getById(int id) throws SQLException {
        String req = "select id, label, description from categories where id = ?";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
             Categorie c = Categorie.builder().id(rs.getInt(1))
                     .label(rs.getString(2))
                     .description(rs.getString(3))
                     .build();
            return c;
        }
        return null;
    }

    @Override
    public List<Categorie> getAll() throws SQLException {
        String req = "select id, label, description from categories";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        ResultSet rs = pst.executeQuery();
        List<Categorie> categories = new LinkedList<Categorie>();
        while (rs.next()) {
             categories.add(Categorie.builder().id(rs.getInt(1))
                     .label(rs.getString(2))
                     .description(rs.getString(3))
                     .build());
        }
        return categories;
    }
    
   
    
    
    public List<Categorie> getAll2(int id) throws SQLException {
        String req = "select id, label, description from categories where id=?";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        List<Categorie> categories = new LinkedList<Categorie>();
        while (rs.next()) {
             categories.add(Categorie.builder().id(rs.getInt(1))
                     .label(rs.getString(2))
                     .description(rs.getString(3))
                     .build());
        }
        return categories;
    }
    
    
    
     public Categorie getByLabel(String sujet) throws SQLException {
        String req = "select id, label, description from categories where label = ?";
        
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setString(1, sujet);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            return this.getCategorie(rs);
        }
        
        return null;
    }
    
     
     
     
    private Categorie getCategorie(ResultSet rs) throws SQLException{
        
        return Categorie.builder().id(rs.getInt(1))
                    .label(rs.getString(2))
                    .description(rs.getString(3))
                    .build();
    }
    
    
    
    @Override
    public boolean update(Categorie entity) throws SQLException {
        if (entity == null) return false;
        String req = "UPDATE categories SET label=?, description=? WHERE id=?";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setString(1, entity.getLabel());
        pst.setString(2, entity.getDescription());
        pst.setInt(3, entity.getId());

        return this.isUpdated(pst.executeUpdate(), "modifié");
    }

    @Override
    public boolean supprimer(Categorie entity) throws SQLException {
        if (entity == null) return false;
        return this.supprimer(entity.getId());
    }

    @Override
    public boolean supprimer(int id) throws SQLException {
        String req = "DELETE FROM categories WHERE id=?";
        PreparedStatement pst = DataSource.getInstance().getCnx().prepareStatement(req);
        pst.setInt(1, id);
        pst.executeUpdate();
        return this.isUpdated(pst.executeUpdate(), "supprimé");
    }
    
    
    
    private boolean isUpdated(int rows, String action) {
            if (rows > 0){
                String message  = "Categorie " + action;
                System.out.printf(message);
                JOptionPane.showMessageDialog(null, message);
                return true;
            } else {
                return false;
            }
    }
}
