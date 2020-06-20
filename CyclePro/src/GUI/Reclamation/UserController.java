/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import Entitie.Reclamation.Categorie;
import Entitie.Reclamation.user;
import Entitie.User.User;
import Service.Reclamation.SendEmail;
import Service.Reclamation.ServiceCategorie;
import Service.Reclamation.ServiceUser;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
public class UserController implements Initializable {
    @FXML
    private AnchorPane centerContent;
    @FXML
    private Pane pane;
    @FXML
    private Pane banner;
    @FXML
    private Text nom;
    @FXML
    private Text prenom;
    @FXML
    private Text mail;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfmail;
    
   String page ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
     public void AjouterInformation () {
         String Nom = tfnom.getText() ; 
         String Prenom = tfprenom.getText() ; 
         
         String Mail = tfmail.getText() ; 
         
         
          if (Nom.isEmpty() || Prenom.isEmpty() ||  Mail.isEmpty())
    {
     Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ajout Information User");
            alert.setHeaderText("Vérification");
            alert.setContentText("Vérifiez vos données , Merci de remplir tous les champs");
            alert.showAndWait();}
    
    else {
        try {
        User user = new User() ; 
        user.setUsername(Nom);
        user.setUsername_canonical(Prenom);
        user.setEmail(Mail);
        ServiceUser su = new ServiceUser() ; 
        //System.out.println(su.getByNom(Nom).getId());
        su.ajouter(user);
        
        FromController f = new FromController() ; 
        f.redirection(centerContent, page,user);
                                                
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Reclamation/From.fxml"));
        Parent fxml = Loader.load();
                            //centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);
                                        
                                        
            } 
        catch (Exception ex) {}
        
    }}       
    
         
          
       public void back (ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Frontend/Frontend.fxml"));
                            Parent fxml = Loader.load();
                            //centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
        
    }
    
         
         
         
         
         
         
         
         
         
     }
    
    
    
    
    

