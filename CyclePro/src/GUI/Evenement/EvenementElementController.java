/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.Event;
import Entitie.User.User;
import animatefx.animation.Bounce;
import animatefx.animation.FadeInDown;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EvenementElementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView imageEvenement1;

    @FXML
    private Label EvenementTitre1;

    @FXML
    private Label EvenementTexte1;

    

    @FXML
    private ImageView imageEvenement2;

    @FXML
    private Label EvenementTitre2;

    @FXML
    private Label EvenementTexte2;

    @FXML
    private ImageView imageEvenement3;

    @FXML
    private Label EvenementTitre3;

    @FXML
    private Label EvenementTexte3;


    @FXML
    private ImageView imageEvenement4;

    @FXML
    private Label EvenementTitre4;

    @FXML
    private Label EvenementTexte4;

    @FXML
    private Label idEvenement4;
    @FXML
    private Label idEvenement3;
    @FXML
    private Label idEvenement2;
    @FXML
    private Label idEvenement1;

    @FXML
    private AnchorPane centerContent;
    @FXML
    private JFXButton regarder4;
    @FXML
    private JFXButton regarder3;
    @FXML
    private JFXButton regarder2;
    @FXML
    private JFXButton regarder1;
    User u;

    void init(Event e) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    void init(Event e1, Event e2, Event e3, Event e4, AnchorPane c,User u) {
        idEvenement1.setText(Integer.toString(e1.getId()));
        idEvenement2.setText(Integer.toString(e2.getId()));
        idEvenement3.setText(Integer.toString(e3.getId()));
        centerContent = c;
        System.out.println("centerContent:"+c);
        EvenementTitre1.setText(e1.getNom());
        EvenementTexte1.setText(e1.getDescription());
        imageEvenement1.setImage(new Image(this.getClass().getResourceAsStream(e1.getPhotoEvent())));
        regarder1.setOnAction((ActionEvent e)->{
           this.EvenementSingleLoader(e1.getId(),c,u);
        });
        regarder2.setOnAction((ActionEvent e)->{
           this.EvenementSingleLoader(e2.getId(),c,u);
        });
        regarder3.setOnAction((ActionEvent e)->{
           this.EvenementSingleLoader(e3.getId(),c,u);
        });
        regarder4.setOnAction((ActionEvent e)->{
           this.EvenementSingleLoader(e4.getId(),c,u);
        });
        EvenementTitre2.setText(e2.getNom());
        EvenementTexte2.setText(e2.getDescription());
        imageEvenement2.setImage(new Image(this.getClass().getResourceAsStream(e2.getPhotoEvent())));
        EvenementTitre3.setText(e3.getNom());
        EvenementTexte3.setText(e3.getDescription());
        imageEvenement3.setImage(new Image(this.getClass().getResourceAsStream(e3.getPhotoEvent())));
        EvenementTitre4.setText(e4.getNom());
        EvenementTexte4.setText(e4.getDescription());
        imageEvenement4.setImage(new Image(this.getClass().getResourceAsStream(e4.getPhotoEvent())));

    }

   
    public void EvenementSingleLoader(int id,AnchorPane c, User u){ 
              try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementSingle.fxml"));
            Parent fxml = Loader.load();
            EvenementSingleController es = Loader.getController();
            es.redirection(c, id,u);
            c.getChildren().removeAll();
            new FadeInDown(fxml).play();
            c.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(EvenementSingleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
