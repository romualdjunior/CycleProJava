/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import Entitie.Reclamation.Categorie;
import Service.Commande.ServiceAdresse;
import Service.Reclamation.ServiceCategorie;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ModifierCategorieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML 
    private Text labelModif ; 
    @FXML 
    private Text descriptionModif ; 
    
     @FXML 
    private  TextArea  textAreaModif ; 
    @FXML
    private TextField labelM;
    @FXML
    AnchorPane centerContent;
    String page;
    int idCategorie ; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    void redirection(AnchorPane centerContent, String page, int idCategorie) {
        this.centerContent = centerContent;
        this.page = page;
        this.idCategorie = idCategorie;
    }
    
     @FXML
    private void back (ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Reclamation/AffichageCategorie.fxml"));
                            Parent fxml = Loader.load();
                            //centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
        
    }
    
    
     @FXML
    void ModifierAction(ActionEvent event) throws SQLException {
             if ( labelM.getText()==null || textAreaModif.getText()==null)
             { Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide, Merci de remplir tous les champs")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
                n.showWarning(); } 
             
             
            ServiceCategorie serviceCategorie = new ServiceCategorie();
            Categorie c = new Categorie(idCategorie, labelM.getText(), textAreaModif.getText());
            serviceCategorie.update(c);
            //JOptionPane.showMessageDialog(null, "Votre commande a été modifiée avec succès ");
            Notifications notificationBuilder = Notifications.create()
                    .title("Confrimation Modification Reclamation ")
                    .text("Votre reclamation a été modifiée avec succès")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificationBuilder.showConfirm();
        }

    }
    

