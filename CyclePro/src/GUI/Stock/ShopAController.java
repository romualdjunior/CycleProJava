/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Accessoires;
import Entitie.Stock.Velo;
import Service.Stock.ServiceAccessoires;
import Service.Stock.ServiceVelo;
import animation.FadeInRightTransition;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author skand
 */
public class ShopAController implements Initializable {

    @FXML
    private Pane banner;
    @FXML
    private TextField search;
    @FXML
    private VBox vbox;
    @FXML
    private VBox vbox1;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ServiceAccessoires rs = new ServiceAccessoires();
            List<Accessoires> liste = rs.affichier();
            for (Accessoires aux : liste)
            {   
                File file;
                file = new File(aux.getPhotoA());
                Image imag = new Image(file.toURI().toString());
                ImageView imagee=ImageViewBuilder.create()
                .image(new Image(file.toURI().toString()))
                .build();   
                showAccessoires(aux.getId(),aux.getMarque(),aux.getPrix(),imag);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
        
    public void showAccessoires(int id,String marque,double prix,Image image) throws IOException
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
    
}
