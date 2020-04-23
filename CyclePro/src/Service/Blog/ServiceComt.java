/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Blog;

import Entitie.Blog.Article;
import Entitie.Blog.CommentaireArticle;
import IService.Blog.IServiceComt;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author asus
 */
public class ServiceComt implements IServiceComt <CommentaireArticle>{
    Connection cnx = DataSource.getInstance().getCnx();

    @Override
    public void createComt(CommentaireArticle c) {
        try {
            String requete = "INSERT INTO commentaire "
                    + "( id,article,user,contenue)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
             //Date CreatedDate= new Date(System.currentTimeMillis());
            pst.setInt(1, c.getId());
            pst.setInt(2, c.getArticle());
            pst.setInt(3, c.getUser());
            pst.setString(4, c.getContenue());
            //pst.setString(5,c.getDateTime()); ctt
            //psDatet.setDate(5, (java.sql.Date) CreatedDate);
            pst.executeUpdate();
            System.out.println("Commentaire Ajouté !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    
    @Override
    public void deleteComt(CommentaireArticle c){
        try{
            String requete="DELETE FROM commentaire where id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getId());
            pst.executeUpdate();
            System.out.println("Article Supprimé !");  
        
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    @Override
    public void updateComt(CommentaireArticle c){
        try{
            String requete="UPDATE commentaire SET contenue=? where id=?";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            pst.setString(1,"modiiiiiiiiiiiif");
            pst.setInt(2, c.getId());
            
            pst.executeUpdate();
            System.out.println("Commentaire modifié !");
            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
  /*  @Override
    public List<CommentaireArticle> readComt(){
        List<CommentaireArticle> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM commentaire order By date_comt DESC";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String titre=" SELECT titre from Article where id = ?";
                PreparedStatement p=cnx.prepareStatement(requete);
                p.setInt(0, rs.getInt("id"));
                ResultSet r = p.executeQuery();
                r.getString("titre");

                list.add(new CommentaireArticle(
                        rs.getInt("id"),
                        rs.getInt("article"),
                        rs.getInt("user"),
                        rs.getString("contenue"),
                        rs.getDate("date_comt")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;   
    }
    */
    @Override
    public List<CommentaireArticle> readComt(){
        List<CommentaireArticle> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM commentaire";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CommentaireArticle(
                        rs.getInt("id"),
                        rs.getInt("article"),
                        rs.getInt("user"),
                        rs.getString("contenue"),
                        rs.getDate("date_comt")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;   
    }
    @Override
    public List<CommentaireArticle> readComtByUser(int id){
        List<CommentaireArticle> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM commentaire where user='"+id+"'";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CommentaireArticle(rs.getInt("id"), rs.getInt("article"), rs.getInt("user"),
                        rs.getString("contenue"),rs.getDate("date_comt")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
        
    }

     @Override
    public ArrayList<CommentaireArticle> getCommentsByArticle(int idArt) {
                 ArrayList<CommentaireArticle> list = new ArrayList<>();
try{
            String requete="SELECT * FROM commentaire where article='"+idArt+"'";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CommentaireArticle(rs.getInt("id"), rs.getInt("article"), rs.getInt("user"),
                        rs.getString("contenue"),rs.getDate("date_comt")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
        
    }
    
   /* @Override
    public ArrayList<CommentaireArticle> getCommentsByArticle(int idArticle) {
         ArrayList<CommentaireArticle> list = new ArrayList<>();
        try{
            String requete="SELECT CA.id as commentId, CA.*, U.* "
                    + "FROM commentaire CA inner join user U on U.id = CA.user where CA.article = "
                    + idArticle;
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CommentaireArticle(rs.getInt("commentId"), rs.getInt("article"), rs.getInt("user"),
                        rs.getString("contenue"),rs.getDate("date_comt"), rs.getString("username")));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
        
    }
    

    
*/
    @Override
    public List<CommentaireArticle> readComtDeux(){
        List<CommentaireArticle> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM commentaire order by date_comt limit 2 ";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new CommentaireArticle(
                        rs.getInt("id"),
                        rs.getInt("article"),
                        rs.getInt("user"),
                        rs.getString("contenue"),
                        rs.getDate("date_comt")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;   
    }
}
