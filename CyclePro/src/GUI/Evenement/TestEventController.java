/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TestEventController implements Initializable {

    @FXML
    private FlowPane flowpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i = 0; i < 20; i++) {
		   	 	flowpane.getChildren().add(new Button("Button"));
		    }
        
        
        
        
    }

  
    
}
