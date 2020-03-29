/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import animatefx.animation.*;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    
        @FXML
    private Pane banner;
        String page;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();
     }
public void redirection(AnchorPane a,String page) throws IOException{
      centerContent=a;
      page="BlogSingle";
    }

   @FXML
    void regarder(ActionEvent event) throws IOException {
            FXMLLoader Loader=new FXMLLoader(getClass().getResource("/GUI/Blog/BlogSingle.fxml"));
       Parent fxml=Loader.load();
         centerContent.getChildren().removeAll();
                new FadeInDown(fxml).play();
                centerContent.getChildren().setAll(fxml);
               new FadeInDown(fxml).play();
                centerContent.getChildren().setAll(fxml);
    }  
}
