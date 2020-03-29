/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import animatefx.animation.Bounce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class BlogSingleController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
        private Pane banner;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();
    }    
    
}
