/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Blog;

import Entitie.Blog.Article;
import IService.Blog.IServiceArticle;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ServiceArticle implements IServiceArticle<Article>{    
    Connection cnx = DataSource.getInstance().getCnx();

   
    @Override
    public void createArticle(Article a) {
        try {
            String requete = "INSERT INTO article ( id,contenue,titre,auteur,photo,date_art,category,likes)"
                    + " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.setString(2, a.getContenue());
            pst.setString(3, a.getTitre());
            pst.setString(4, a.getAuteur());
            pst.setString(5, a.getPhoto());  
            String date = new SimpleDateFormat("yyyy-MM-dd").format(a.getDate_art());
            pst.setString(6,date);
            pst.setString(7, a.getCategory());
            pst.setInt(8, a.getLikes());
           
            pst.executeUpdate();
            System.out.println("Article Ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    
    @Override
    public void deleteArticle(Article a){
        try{
            String requete="DELETE FROM Article where id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, a.getId());
            pst.executeUpdate();
            System.out.println("Article Supprimé !");  
        
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
        @Override
    public void updateArticle(Article a){
        try{
            String requete="UPDATE Article SET titre=?, auteur=?, contenue=?, photo=?, category=?, date_art=? "
                    + "where id=?";
            
            
            PreparedStatement pst=cnx.prepareStatement(requete);
            pst.setString(1,a.getTitre());
            pst.setString(2,a.getAuteur());
            pst.setString(3,a.getContenue());
            pst.setString(4,a.getPhoto());
            pst.setString(5,a.getCategory());
            String date = new SimpleDateFormat("yyyy-MM-dd").format(a.getDate_art());
            pst.setString(6,date);
            pst.setInt(7, a.getId());
            
            pst.executeUpdate();
            System.out.println("Article modifié !");
            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    @Override
    public List<Article> readAllArticle(){
        List<Article> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM Article ORDER BY likes DESC";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(rs.getInt("id"),
                        rs.getString("contenue"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("photo"),
                        rs.getDate("date_art"),                        
                        rs.getString("category"),
                        rs.getInt("likes")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
        
    }
    
    @Override
    public List<Article> searchByCat(String category){
        List<Article> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM Article where category = '"+category+"' ";
            PreparedStatement pst=cnx.prepareStatement(requete);                    
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(rs.getInt(1),
                        rs.getString("contenue"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("photo"),
                        rs.getDate("date_art"),                        
                        rs.getString("category"),
                        rs.getInt("likes")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

        }
        return list;
        
    }
    
    @Override
    public List<Article> searchByTitre(String titre){
        List<Article> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM Article where titre = '"+titre+"' ";
            PreparedStatement pst=cnx.prepareStatement(requete);                    
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(rs.getInt(1),
                        rs.getString("contenue"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("photo"),
                        rs.getDate("date_art"),                        
                        rs.getString("category"),
                        rs.getInt("likes")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

        }
        return list;
        
    }
    @Override
    public List<Article> searchByAuteur(String auteur){
        List<Article> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM Article where auteur = '"+auteur+"' ";
            PreparedStatement pst=cnx.prepareStatement(requete);                    
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(
                        rs.getInt(1),
                        
                        rs.getString("contenue"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("photo"),
                        rs.getDate("date_art"),                        
                        rs.getString("category"),
                        rs.getInt("likes")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

        }
        return list;
        
    }
 
    @Override
    public List<Article> searchRecent(){
        List<Article> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM Article order by date_art limit 2 ";
            PreparedStatement pst=cnx.prepareStatement(requete);                    
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Article(rs.getInt(1),
                        rs.getString("contenue"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("photo"),
                        rs.getDate("date_art"),                        
                        rs.getString("category"),
                        rs.getInt("likes")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

        }
        return list;
        
    }
    
    @Override
    public Article readOne(int id){
        Article ar=new Article();
        try{
            String requete="SELECT * FROM Article where id = '"+id+"' ";
            PreparedStatement pst=cnx.prepareStatement(requete);                    
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ar=new Article( rs.getInt(1),
                        rs.getString("contenue"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("photo"),
                        rs.getDate("date_art"),                        
                        rs.getString("category"),
                        rs.getInt("likes"));
                
                       
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());

        }
        return ar;
        
    }
    
    @Override 
    public String readTitre(int idArt){
        String titre="";
        try{
        String req="select titre from article where id ='"+idArt+"' ";
        PreparedStatement pst=cnx.prepareStatement(req);                    
        ResultSet rs = pst.executeQuery();
        titre=rs.getString(1);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return titre;
    }
}
