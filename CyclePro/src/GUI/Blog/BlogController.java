/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import Service.Blog.ServiceArticle;
import animatefx.animation.*;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class BlogController implements Initializable {

    /**
     * Initializes the controller class.
     */
    AnchorPane centerContent;
    
        @FXML private Pane banner;
        String page;
        @FXML private Pane paneview;
        @FXML private Label auteur;
        @FXML private Label datte;
        @FXML private Label category;
        @FXML private Label contenue;
        @FXML private Label titre;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();

           ServiceArticle SS=new ServiceArticle();
           List<Article> list = new ArrayList<>();
           list.addAll(SS.readAllArticle());
           
           for (int i = 0; i < list.size (); i++){
                      auteur.setText(list.get(i).getAuteur());
                      category.setText(list.get(i).getCategory());
                      //titre.setText(list.get(i).getTitre());
                      contenue.setText(list.get(i).getContenue());
                      String date = new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getDate_art());
                      datte.setText(date);
                      
                      System.out.println(list.get(i).getPhoto());
                      
                      Image image=new Image("/images/"+list.get(i).getPhoto());
                        javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
                        imageview.setFitWidth(254);
                        imageview.setFitHeight(200);
                        paneview.getChildren().add(imageview);
                           
     
           }
           
           
     }
public void redirection(AnchorPane a,String page) throws IOException{
      centerContent=a;
      page="BlogSingle";
    }

   @FXML
    void regarder(ActionEvent event) throws IOException {
        ServiceArticle SS=new ServiceArticle();
        List<Article> list = new ArrayList<>();
        list.addAll(SS.readAllArticle());
        Article ar=list.get(0);
           
         FXMLLoader Loader=new FXMLLoader(getClass().getResource("/GUI/Blog/BlogSingle.fxml"));
         Parent fxml=Loader.load();
         
         //BlogSingleController e=Loader.getController();
         //e.redirection(centerContent,ar); 
         
         centerContent.getChildren().removeAll();
         new FadeInDown(fxml).play();
         centerContent.getChildren().setAll(fxml);
                    
    }  
}
