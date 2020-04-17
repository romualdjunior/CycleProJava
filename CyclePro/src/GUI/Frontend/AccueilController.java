/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Frontend;

import Entitie.Evenement.Event;
import Service.Evenement.EventService;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
  

public class AccueilController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
         private Pane banner;
      
      
         @FXML
    private ImageView img1;

    @FXML
    private Label adr1;

    @FXML
    private Label content1;

    @FXML
    private JFXButton regarder1;

    @FXML
    private ImageView img2;

    @FXML
    private Label adr2;

    @FXML
    private Label content2;

    @FXML
    private JFXButton regarder2;

    @FXML
    private ImageView img3;

    @FXML
    private Label adr3;

    @FXML
    private Label content3;

    @FXML
    private JFXButton regarder3;

    @FXML
    private ImageView img4;

    @FXML
    private Label adr4;

    @FXML
    private Label content4;

    @FXML
    private JFXButton regarder4;

     private AnchorPane centerContent;
    
    
    
    
    @FXML
    void regarder1(ActionEvent event) throws IOException {
        
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementSingle.fxml"));
        Parent fxml = Loader.load();
        centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);

    }

    @FXML
    void regarder2(ActionEvent event) throws IOException {
    
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementSingle.fxml"));
        Parent fxml = Loader.load();
        centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);

    


    }

    @FXML
    void regarder3(ActionEvent event) throws IOException {
        
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementSingle.fxml"));
        Parent fxml = Loader.load();
        centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);

    }

    @FXML
    void regarder4(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementSingle.fxml"));
        Parent fxml = Loader.load();
        centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EventService es = new EventService();
     es.afficherEventAcceuil().forEach(System.out::println);
          Event e1= es.afficherEventAcceuil().get(0);
       img1.setImage(new Image(this.getClass().getResourceAsStream("/GUI/Evenement/"+e1.getPhotoEvent())));
       String ch1 =e1.getAdresse()+ " "+e1.getDateDebut().toString();
       adr1.setText(ch1);
       content1.setText(e1.getDescription());
      Event e2=  es.afficherEventAcceuil().get(1);
       img2.setImage(new Image(this.getClass().getResourceAsStream("/GUI/Evenement/"+e2.getPhotoEvent())));
       String ch2 =e2.getAdresse()+ " "+e2.getDateDebut().toString();
       adr2.setText(ch2);
       content2.setText(e1.getDescription());
      Event e3=  es.afficherEventAcceuil().get(2);
       img3.setImage(new Image(this.getClass().getResourceAsStream("/GUI/Evenement/"+e3.getPhotoEvent())));
       String ch3 =e3.getAdresse()+ " "+e3.getDateDebut().toString();
       adr3.setText(ch3);
       content3.setText(e3.getDescription());
       Event e4= es.afficherEventAcceuil().get(3);
        img4.setImage(new Image(this.getClass().getResourceAsStream("/GUI/Evenement/"+e4.getPhotoEvent())));
       String ch4 =e4.getAdresse()+ " "+e4.getDateDebut().toString();
       adr4.setText(ch4);
       content4.setText(e4.getDescription());
                   new Bounce(banner).play();

    }    
    
}
