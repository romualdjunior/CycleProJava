/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.CommentaireEvent;
import Entitie.Evenement.Event;
import Entitie.User.User;
import Service.Evenement.ParticipantsService;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CommentElementController implements Initializable {

    @FXML
    private Pane paneComment;
    @FXML
    private Label userName;
    @FXML
    private Label dateComment;
    @FXML
    private Label content;
     @FXML
    private AnchorPane centerContent;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
  public void init(CommentaireEvent c1, AnchorPane c){
        centerContent = c;
        System.out.println("centerContent:"+c);
        content.setText(c1.getContenue());
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy ");  
        String strDate = formatter.format(c1.getDateComment());  
        ParticipantsService ps = new ParticipantsService();
        userName.setText(ps.getUserName(c1.getUser()));
        dateComment.setText(strDate);
  
  
  
  }
 
}
