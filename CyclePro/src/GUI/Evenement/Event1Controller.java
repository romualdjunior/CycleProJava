/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Event1Controller implements Initializable {

    @FXML
    private Pane banner;
    @FXML
    private JFXButton regarder;
    @FXML
    private FlowPane flowpane;
     @FXML
    private Pane hello;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
       
         for (int i = 0; i < 20; i++) {
		 
             flowpane.getChildren().add(new Pane(new ImageView(new Image(this.getClass().getResourceAsStream("event1.jpg"),20,20,false,false))));
	
         
         }
    }    

    @FXML
    private void regarder(ActionEvent event) {
    }
    
}
