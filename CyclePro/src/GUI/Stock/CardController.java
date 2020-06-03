/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Offre;
import Entitie.Stock.Velo;
import Service.Stock.ServiceOffre;
import Service.Stock.ServiceVelo;
import animation.FadeInRightTransition;
import animation.FadeOutLeftTransition;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author skand
 */
public class CardController implements Initializable {

    @FXML
    private Pane pane1;
    @FXML
    private Label id;
    @FXML
    private Label prix;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton detail;
    @FXML
    private StackPane trans;
    @FXML
    private Group groups;
    @FXML
    private AnchorPane loadPane;
    @FXML
    private Label marque;
    @FXML
    private Label soldee;
    @FXML
    private ImageView logo_solde;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setVisible(false);
        soldee.setVisible(false);
        logo_solde.setVisible(false);
    }    
    public void setData(int id,String marque,double prix,Image image)
    {
        this.id.setText(String.valueOf(id));
         this.marque.setText(marque);
        this.prix.setText(String.valueOf(prix)+" DT");
        this.image.setImage(image);
        ServiceOffre Os=new ServiceOffre();
        Os.checkVerifOffre();
        Offre o=new Offre();
        o=Os.getOffre(id);
        if(o!=null)
        {
            soldee.setVisible(true);
            logo_solde.setVisible(true);
            soldee.setText("-"+String.valueOf(o.getPourcentage())+"%");
            double prixx=prix- ((prix/100)*o.getPourcentage());
            this.prix.setText(String.valueOf(prixx)+" DT");
        }
    }

    @FXML
    private void voirdetail(ActionEvent event) throws IOException {
        ServiceVelo rs = new ServiceVelo ();
        Velo v=new Velo();
        v=rs.getVelo(Integer.parseInt(id.getText()));
        
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("Details.fxml"));
        //blr.setEffect(new GaussianBlur(10));
        new FadeInRightTransition(trans).play();
        AnchorPane pane = Loader.load();
        DetailsController c = Loader.getController();
        File file;
                file = new File(v.getPhotoV());
                Image imag = new Image(file.toURI().toString());
                ImageView imagee=ImageViewBuilder.create()
                .image(new Image(file.toURI().toString()))
                .build();
        c.setData(v.getId(),v.getPrixLocH(),imag,v.getTaille(),v.getCategorie(),v.getMarque(),v.getDescription());
        loadPane.getChildren().setAll(pane);
        
    }

    @FXML
    private void tombolClose(ActionEvent event) {
        new FadeOutLeftTransition(trans).play();
        
    }
    
}
