/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Velo;
import Service.Stock.ServiceVelo;
import animation.FadeInRightTransition;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skand
 */
public class ShopController implements Initializable {

    @FXML
    private Pane banner;
    ObservableList<Entitie.Stock.Velo> cls = FXCollections.observableArrayList();
    @FXML
    private TextField search;
    private AnchorPane cp;
    private StackPane cpp;
    @FXML
    private VBox vbox;
    @FXML
    private VBox vbox1;
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ServiceVelo vs = new ServiceVelo ();
            List<Velo> liste = vs.affichier();
            for (Velo aux : liste)
            {   
                File file;
                file = new File(aux.getPhotoV());
                Image imag = new Image(file.toURI().toString());
                ImageView imagee=ImageViewBuilder.create()
                .image(new Image(file.toURI().toString()))
                .build();   
                showVelo(aux.getId(),aux.getMarque(),aux.getPrixLocH(),imag);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
        
    public void showVelo(int id,String marque,double prix,Image image) throws IOException
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("Card.fxml"));
        Pane p=new Pane();
        new FadeInRightTransition(p).play();
        AnchorPane pane = Loader.load();
        CardController c = Loader.getController();
        c.setData(id,marque,prix,image);
        p.getChildren().setAll(pane);
        VBox v=new VBox(p);
        vbox.getChildren().add(v);
    }

    @FXML
    private void vendre(ActionEvent event) {
        try {
            // TODO
            vbox.getChildren().clear();
            ServiceVelo vs = new ServiceVelo ();
            String typ="vendre";
            List<Velo> liste = vs.afficherType(typ);
            for (Velo aux : liste)
            {   
                File file;
                file = new File(aux.getPhotoV());
                Image imag = new Image(file.toURI().toString());
                ImageView imagee=ImageViewBuilder.create()
                .image(new Image(file.toURI().toString()))
                .build();   
                showVelo(aux.getId(),aux.getMarque(),aux.getPrixLocH(),imag);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void location(ActionEvent event) {
        try {
            // TODO
            vbox.getChildren().clear();
            ServiceVelo vs = new ServiceVelo ();
            String typ="location";
            List<Velo> liste = vs.afficherType(typ);
            for (Velo aux : liste)
            {   
                File file;
                file = new File(aux.getPhotoV());
                Image imag = new Image(file.toURI().toString());
                ImageView imagee=ImageViewBuilder.create()
                .image(new Image(file.toURI().toString()))
                .build();   
                showVelo(aux.getId(),aux.getMarque(),aux.getPrixLocH(),imag);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
