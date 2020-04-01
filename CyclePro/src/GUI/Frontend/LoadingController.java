/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Frontend;

import GUI.Login.LoginController;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDown;
import animatefx.animation.ZoomIn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class LoadingController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private ImageView logo;
             @FXML
    private ImageView logo1;
        @FXML
    private Pane pane;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new ZoomIn(logo).play();
        Timeline timeline = new Timeline(
    new KeyFrame(Duration.seconds(1.3), (ActionEvent e) -> {
        ImageView loader=new ImageView("/GUI/Images/loadBar.gif");
        loader.setX(105.5);
        loader.setY(530.5);
            pane.getChildren().add(loader);

        }));
     timeline.play();  
   Timeline timeline2 = new Timeline(
    new KeyFrame(Duration.seconds(3), (ActionEvent e) -> {
        Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/GUI/Frontend/Frontend.fxml"));
                   Stage stage=(Stage)logo.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        new FadeIn(root).play();
        stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoadingController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }));
   timeline.setOnFinished((e)->{
            timeline2.play();
        });     
      
       
    }
    
    
}
