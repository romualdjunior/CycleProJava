/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Blog;

import Entitie.Blog.Article;
import Entitie.Blog.View;
import IService.Blog.IServiceArticle;
import IService.Blog.IServiceView;
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
public class ServiceView  implements IServiceView<View>{    
    Connection cnx = DataSource.getInstance().getCnx();

   
    @Override
    public void createView(View v) {
        try {
            String requete = "INSERT INTO view (idView,idUSer,contenueView,rating)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, v.getIdView());
            pst.setInt(2, v.getIdUSer());
            pst.setString(3, v.getContenueView());
            pst.setInt(4, v.getRating());
           
            pst.executeUpdate();
            System.out.println("Rating et votre avis sont ajoutés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    
    
    
    @Override
    public List<View> readAllView(){
        List<View> list = new ArrayList<>();
        try{
            String requete="SELECT * FROM View ORDER BY rating DESC";
            PreparedStatement pst=cnx.prepareStatement(requete);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new View(rs.getInt("idView"),
                        rs.getInt("idUser"),
                        rs.getString("contenueView"),
                        rs.getInt("rating"),
                        rs.getDate("dateView")
                        
                       ));
            }

            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
        
    }
}