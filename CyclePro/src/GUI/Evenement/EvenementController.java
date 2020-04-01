/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import GUI.Frontend.FrontendController;
import animatefx.animation.Bounce;
import animatefx.animation.FadeInDown;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */

public class EvenementController implements Initializable {
   

    /**
     * Initializes the controller class.
     */
        @FXML
            private Pane banner;
        String page;

    
    private AnchorPane centerContent;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();

    }    
    
    @FXML
    void regarder(ActionEvent event) throws IOException {
        FXMLLoader Loader=new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementSingle.fxml"));
       Parent fxml=Loader.load();
         centerContent.getChildren().removeAll();
                new FadeInDown(fxml).play();
                centerContent.getChildren().setAll(fxml);
              
                
    }
    public void redirection(AnchorPane a,String page) throws IOException{
      centerContent=a;
      page="EvenementSingle";
    }
}
