/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import GUI.Evenement.*;
import Entitie.Evenement.Event;
import Entitie.User.User;
import animatefx.animation.Bounce;
import animatefx.animation.FadeInDown;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class BlogElementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView imageBlog1;
        @FXML
    private Label C1;
        @FXML
    private Label C2;
        @FXML
    private Label C3;
        @FXML
    private Label C4;
        
    @FXML
    private Label titreBlog1;

    @FXML
    private Label contenuBlog1;

    @FXML
    private JFXButton regarder1;

    @FXML
    private Label idEvenement2;

    @FXML
    private ImageView imageBlog2;

    @FXML
    private Label titreBlog2;

    @FXML
    private Label contenuBlog2;

    @FXML
    private JFXButton regarder2;

    @FXML
    private Label idEvenement3;

    @FXML
    private ImageView imageBlog3;

    @FXML
    private Label titreBlog3;

    @FXML
    private Label contenuBlog4;
    
    @FXML
   private Label  contenuBlog3;

    @FXML
    private JFXButton regarder3;

    @FXML
    private Label idEvenement4;

    @FXML
    private ImageView imageBlog4;

    @FXML
    private Label titreBlog4;

    @FXML
    private JFXButton regarder4;
    User u;
    AnchorPane centerContent;

    void init(Event e) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    void init(Article e1, Article e2, Article e3, Article e4, AnchorPane c,User u) {
        
        centerContent = c;
        
        //a1
        titreBlog1.setText(e1.getTitre());
        contenuBlog1.setText(e1.getContenue());
        C1.setText(e1.getCategory());      
        imageBlog1.setImage(new Image("/GUI/Images/"+e1.getPhoto()));
        regarder1.setOnAction((ActionEvent e)->{
           this.BlogSingleLoader(e1.getId(),c,u);
        });

        titreBlog2.setText(e2.getTitre());
        contenuBlog2.setText(e2.getContenue());
        C2.setText(e2.getCategory());    
        imageBlog2.setImage(new Image("/GUI/Images/"+e2.getPhoto()));              
        regarder2.setOnAction((ActionEvent e)->{
           this.BlogSingleLoader(e2.getId(),c,u);
        });
        
        titreBlog3.setText(e3.getTitre());
        contenuBlog3.setText(e3.getContenue());
        C3.setText(e3.getCategory()); 
        imageBlog3.setImage(new Image("/GUI/Images/"+e3.getPhoto()));        
        regarder3.setOnAction((ActionEvent e)->{
           this.BlogSingleLoader(e3.getId(),c,u);
        });
        
        titreBlog4.setText(e4.getTitre());
        contenuBlog4.setText(e4.getContenue());
        C4.setText(e4.getCategory());  
        imageBlog4.setImage(new Image("/GUI/Images/"+e4.getPhoto()));        
        regarder4.setOnAction((ActionEvent e)->{
           this.BlogSingleLoader(e4.getId(),c,u);
        });




    }

   
    public void BlogSingleLoader(int id,AnchorPane c, User u){ 
              try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Blog/BlogSingle.fxml"));
            Parent fxml = Loader.load();
            BlogSingleController es = Loader.getController();
            es.redirection(c, id,u);
            c.getChildren().removeAll();
            new FadeInDown(fxml).play();
            c.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(BlogSingleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
