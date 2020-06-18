/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import Service.Reclamation.SendEmail;
import Entitie.Reclamation.Categorie;
import Entitie.Reclamation.Reclamation;
import Entitie.Reclamation.user;
import Entitie.User.User;
import Service.Reclamation.ServiceCategorie;
import Service.Reclamation.ServiceReclamation;
import Utils.DataSource;
import animatefx.animation.FadeInDown;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import static jdk.nashorn.internal.objects.NativeString.search;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mywindows
 */
public class FromController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
   
   
    @FXML
    private ComboBox<String> comboBoxSujet ; 
    
    @FXML
    private Text sujet ; 
    
    @FXML
    private TextArea description ; 
   
    @FXML
    private TextField photo ;
   
    @FXML 
    private AnchorPane anchorpane ; 
    @FXML
    private ImageView Image;
    
    ObservableList<Categorie> data;

    private Pane banner;
    
   File pfile;
   int file;
   String page;
   User user ; 
  
   Categorie categorie ; 
   // private ObservableList <String>ListCategorie = FXCollections.observableArrayList("prix", "produit", "service");
    //private ObservableList <String>ListUser = FXCollections.observableArrayList("1", "3");
   private ObservableList <String> ListSujet = FXCollections.observableArrayList("prix", "Produit", "Service");

   
   
   
   
   @Override
    public void initialize(URL url, ResourceBundle rb)  {
   //categorie.setItems(ListCategorie);
   //user.setItems(ListUser); 
   comboBoxSujet.setItems(ListSujet);
   //comboBoxSujet.setConverter();
   
    }
  
    
    @FXML
     public void AjouterReclamation (ActionEvent event) {
       String  Sujet = comboBoxSujet.getValue() ; 
       String Description = description.getText() ; 
       String Photo = photo.getText() ; 
       if (Sujet.isEmpty() || Description.isEmpty()|| Photo.isEmpty())
    {
     Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ajout Reclamation");
            alert.setHeaderText("Vérification");
            alert.setContentText("Vérifiez vos données , Merci de remplir tous les champs");
            alert.showAndWait();}
       else {
       try {
         Reclamation r = new Reclamation(); 
         Categorie c = new Categorie(120, "service" , "defr") ;
         user = new User(1 , "wiem" , "wiem.saddem@esprit.tn") ;
         r.setUser(user);
         //Categorie catt = EvaluationCategorie(categorie);
         r.setCategorie(c);
         
         r.setSujet(Sujet);
         System.out.println("ok");
         r.setDescription(Description);
         r.setImage(Photo);
         ServiceReclamation sr = new ServiceReclamation();
         sr.ajouter(r); 
        System.out.println("ok");

        // System.out.println(r.getId()+"  " + r.getIdUser()+" " + r.getIdCategorie() + r.getSujet() + r.getDescription() + r.getPhoto());
           
                                                 SendEmail s;
        s = new SendEmail("wiem.saddem@esprit.tn", "validation de l'envoi reclamation", "votre Reclamation a été bien envoyée , Merci pour votre fidélité "
               );
        
         Notifications notificationBuilder = Notifications.create()
                                                .title("Confrimation Ajout Reclamation")
                                                .text("Reclamation ajoutéee avec succès")
                                                .graphic(null)
                                                .hideAfter(Duration.seconds(5))
                                                .position(Pos.BOTTOM_RIGHT);
                                                 notificationBuilder.showConfirm();
       }
       catch (Exception e)
       {}         
       
       
       
       
       
       }
          
    }
    
    
    @FXML
    private void Load(ActionEvent event) throws MalformedURLException {
        
          
                  FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image: ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp")
        );
        Window stage = null;
        pfile = fileChooser.showOpenDialog(stage);

        /* - draw image */
        if (pfile != null) {
            file=1;
            Image image = new Image(pfile.toURI().toURL().toExternalForm());
            Image.setImage(image);
            photo.setText( pfile.getName());
    }
    }
    
    
    
 public void redirection(AnchorPane centerContent, String page, User user) {
        this.anchorpane = centerContent;
        this.page = page;
        this.user = user;
    }
   
     public void redirectionCat(AnchorPane centerContent, String page , Categorie categorie) {
        this.anchorpane = centerContent;
        this.page = page;
        this.categorie = categorie; 
        
    }
    
   
   
    
    
     public void back (ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Reclamation/User.fxml"));
                            Parent fxml = Loader.load();
                            //centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            anchorpane.getChildren().setAll(fxml);
        
    }
    
         
    public static Categorie EvaluationCategorie (Categorie k )
    {
     
    if (k.getLabel() == "Service")
    {
      return  k;
    }
    else if (k.getLabel() == "Produit")
    { return k;
    }
   
    else 
        return k;
    
    
    
    }

    
    
    
    
}
        
        
    
    
    
    
     
    
    
    
    
    
    
    
    
    
    
    

