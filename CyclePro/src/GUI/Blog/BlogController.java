/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import Entitie.User.User;
import Service.Blog.ServiceArticle;
import animatefx.animation.*;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.VBox;
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
         @FXML
    private VBox vbox;

    User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();

           
           
     }


   @FXML
    void regarder(ActionEvent event) throws IOException {
          
         FXMLLoader Loader=new FXMLLoader(getClass().getResource("/GUI/Blog/BlogSingle.fxml"));
         Parent fxml=Loader.load();
         
         centerContent.getChildren().removeAll();
         new FadeInDown(fxml).play();
         centerContent.getChildren().setAll(fxml);
                    
    } 
    public void redirection(AnchorPane a, String page,User u) throws IOException {
        user=u;
        centerContent = a;
        page = "Blog";
        ServiceArticle es = new ServiceArticle();
        List<Article> Articles = new ArrayList<Article>();
        Article e1 = new   Article();
        Article e2 = new   Article();
        Article e3 = new   Article();
        Article e4 = new   Article();
        Articles.addAll(es.readAllArticle()
        );
        vbox.getChildren().clear();
        int count = 0;
        for (Article Event1 : Articles) {
            try {
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Blog/BlogElement.fxml"));
                Parent fxml = (Parent) Loader.load();
                BlogElementController e = Loader.getController();
                count++;
                if (count == 1) {
                    e1 = Event1;
                    System.out.println(e1);
                } else if (count == 2) {
                    e2 = Event1;
                } else if (count == 3) {
                    e3 = Event1;
                } else if (count == 4) {
                    e4 = Event1;
                    e.init(e1, e2, e3, e4, centerContent,u);
                    System.out.println("cela a marche");
                    count = 0;
                    vbox.getChildren().add(fxml);
                }
                System.out.println(count);

            } catch (IOException ex) {
                Logger.getLogger(BlogElementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
