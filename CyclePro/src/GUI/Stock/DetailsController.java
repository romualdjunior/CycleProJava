/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author skand
 */
public class DetailsController implements Initializable {

    @FXML
    private Label marque;
    @FXML
    private Label taille;
    @FXML
    private Label categorie;
    @FXML
    private Label description;
    @FXML
    private ImageView imagev;
    @FXML
    private JFXButton panier;
    @FXML
    private Label prix;
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.id.setVisible(false);
    }    

    public void setData(int id,double prix,Image image,String taille,String categorie,String marque,String description)
    {
        this.id.setText(String.valueOf(id));
        this.prix.setText(String.valueOf(prix)+" DT");
        this.imagev.setImage(image);
        this.categorie.setText(categorie);
        this.taille.setText(taille);
        this.description.setText(description);
        this.marque.setText(marque);
    }
    @FXML
    private void ajoutpanier(ActionEvent event) {
        // Todo
    }
    
}
