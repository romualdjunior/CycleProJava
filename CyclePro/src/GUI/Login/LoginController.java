/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import animatefx.animation.*;
import animatefx.util.ParallelAnimationFX;
import animatefx.util.SequentialAnimationFX;
import com.jfoenix.controls.JFXButton;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class LoginController implements Initializable {

  private Label label;
    @FXML
    private VBox vbox;
    private Parent fxml;
        @FXML
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
        System.out.println("ici aussi"+ vbox.getLayoutX());
        t.setToX(632);
        t.play();
        System.out.println("ici"+vbox.getLayoutX());

        t.setOnFinished((e)->{
            try {
                fxml=FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                vbox.getChildren().removeAll();
                new FadeInDown(fxml).play();
                vbox.getChildren().setAll(fxml);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }  
    
    @FXML
    private void openSignUp(ActionEvent event) {
         TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
        t.setToX(19);
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml=FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vbox.getChildren().removeAll();
              new FadeIn(fxml).play();
                vbox.getChildren().setAll(fxml);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void openSignIn(ActionEvent event) {
         TranslateTransition t=new TranslateTransition(Duration.seconds(1),vbox);
        t.setToX(632);
        t.play();
        t.setOnFinished((e)->{
            try {
                fxml=FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                vbox.getChildren().removeAll();
               new FadeIn(fxml).play();
                vbox.getChildren().setAll(fxml);
                
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
