/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import Entitie.Reclamation.Categorie;
import GUI.Commande.ModifierCommandeAdresseController;
import Service.Reclamation.ServiceCategorie;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AjoutCategorieController implements Initializable {

    @FXML
    private ComboBox <String> comboBoxLabel ; 
    
    @FXML
    private  TextArea  TextAreaDesc ; 
    @FXML
    private Text label ; 
    @FXML 
    private Text description ; 
    @FXML
    AnchorPane centerContent;
    String page;
         
    private ObservableList <String>ListCategorie = FXCollections.observableArrayList("Prix","Produit","Service");
 
   
   
   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      comboBoxLabel.setItems(ListCategorie);
    }
    
    public void AjouterCategorie () {
   
    String Label = comboBoxLabel.getValue() ; 
    String Description =  TextAreaDesc.getText() ; 
    if (Label.isEmpty() || Description.isEmpty())
    {
     Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ajout Catégorie");
            alert.setHeaderText("Vérification");
            alert.setContentText("Vérifiez vos données , Merci de remplir tous les champs");
            alert.showAndWait();}
    
    else {
        try {
        Categorie categorie = new Categorie() ; 
        categorie.setLabel(Label);
        categorie.setDescription(Description); 
        ServiceCategorie sc = new ServiceCategorie() ; 
        sc.ajouter(categorie);
        FromController f = new FromController() ; 
        f.redirectionCat(centerContent, page,categorie);
        Notifications notificationBuilder = Notifications.create()
                                                .title("Confrimation Ajout Reclamation")
                                                .text("Reclamation ajoutéee avec succès")
                                                .graphic(null)
                                                .hideAfter(Duration.seconds(5))
                                                .position(Pos.BOTTOM_RIGHT);
                                        notificationBuilder.showConfirm();   
            } 
        catch (Exception ex) {}
        
    }       
    
    
    }
    
     public void redirection(AnchorPane centerContent, String page) {
        this.centerContent = centerContent;
        this.page = page;
    }
    
     
     
    
    public void back (ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Reclamation/AffichageCategorie.fxml"));
                            Parent fxml = Loader.load();
                            //centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
        
    }
    
    
    
    
    
     
     
     
     
    
}
