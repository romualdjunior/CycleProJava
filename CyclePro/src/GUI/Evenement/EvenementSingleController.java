/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.User.User;
import animatefx.animation.Bounce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class EvenementSingleController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
            private Pane banner;
        @FXML
            private AnchorPane centerContent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();
    }   
    public void redirection(AnchorPane c, int id,User u){
       centerContent=c; 
        System.out.println("l'identifiant de l'evenement est "+id);
        //AFFICHAGE SINGLE
        System.out.println("l'identifiant de l'utilisatuer est "+u.getId());
    }
    
}
