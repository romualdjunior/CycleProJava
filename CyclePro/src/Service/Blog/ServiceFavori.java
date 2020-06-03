/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Blog;

import Entitie.Blog.FavoriArticle;
import IService.Blog.IServiceFavori;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ServiceFavori implements IServiceFavori<FavoriArticle>{

    Connection cnx = DataSource.getInstance().getCnx();    
     @Override
    public void createFavori(FavoriArticle F) {
    try {
            String requete = "INSERT INTO Favorie "
                    + "( id,article,user)"
                    + " VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, F.getId());
            pst.setInt(2, F.getArticle());
            pst.setInt(3, F.getUser());
            pst.executeUpdate();
            System.out.println("Article ajouté à votre favori !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    
    @Override
    public void deleteFavori(FavoriArticle F){
        try{
            String requete="DELETE FROM Favorie where id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, F.getId());
            pst.executeUpdate();
            System.out.println("Article Supprimé de votre liste favori !");  
        
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
   
    @Override
    public List<FavoriArticle> readFavori(){
        List<FavoriArticle> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM Favorie";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new FavoriArticle(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
        
    }
    
}
