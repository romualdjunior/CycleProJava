/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import Entitie.Reclamation.Categorie;
import Entitie.Reclamation.Reclamation;
import Entitie.User.User;
import GUI.Backoffice.BackofficeController;
import GUI.Commande.AfficherCommandeAdresseController;
import Service.Reclamation.ServiceCategorie;
import Service.Reclamation.ServiceReclamation;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDown;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AffichageReclamationController extends BackofficeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TableView<Reclamation> ReclamationView;

    @FXML
    private TableColumn<Reclamation, Integer> idReclamation;

    @FXML
    private TableColumn<Reclamation, Integer> idUser;

    @FXML
    private TableColumn<Reclamation, Integer> idCategorie;

    @FXML
    private TableColumn<Reclamation, String> sujet;

    @FXML
    private TableColumn<Reclamation, String> description;

    @FXML
    private TableColumn<Reclamation, String> photo;


   
    @FXML
    private TextField SearchField;
   
  @FXML 
  AnchorPane centerContent;
  
  @FXML
  Pane pane ; 
    
    
    ObservableList<Reclamation> list = FXCollections.observableArrayList();
    
    String page;
    FileInputStream fis = null ;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idReclamation.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
        idUser.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("user"));
        idCategorie.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("categorie"));
        sujet.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("sujet"));
        description.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
    
        photo.setPrefWidth(50);
        photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        ImageView img = new ImageView(new Image (this.getClass().getResourceAsStream("event1.jpg")));
        
        ServiceReclamation sr = new ServiceReclamation();
         try{
         list.addAll(sr.getAll()) ; 
         ReclamationView.setItems(list);
             System.out.println(list);
         
            
         
         
         ReclamationView.setOnMousePressed(new EventHandler<MouseEvent> () {

          @Override
            public void handle(MouseEvent event) {
                System.out.println("Row Selected");
              
                           }
        });        
        
    }   
       
       catch ( SQLException e )
       {}
       
       
       
       
       
       FilteredList<Reclamation> filteredData = new FilteredList<>(list, p -> true);
        SearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(reclamation -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Integer.toString(reclamation.getId()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if(Integer.toString(reclamation.getUserId()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if(Integer.toString(reclamation.getCategorieId()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (reclamation.getSujet().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (reclamation.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                 // Filter matches last name.
                } 
               return false; // Does not match.
            });
        });
        SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(ReclamationView.comparatorProperty());
        ReclamationView.setItems(sortedData);
 
    }
    
    
    
    
    
    
    public void redirection(AnchorPane c) {
        centerContent = c;
    }
    
     
      @FXML
    private void back (ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Backoffice/Accueil.fxml"));
                            Parent fxml = Loader.load();
                            //centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
        
    }
    
    
     
     @FXML 
    private void deleteRowRec (ActionEvent Event) throws SQLException, MessagingException, UnsupportedEncodingException{ 
   
        if (ReclamationView.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide, veuillez selectionner une reclamation")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning(); }    
    else{
     Reclamation selected = ReclamationView.getSelectionModel().getSelectedItem();
     Iterator<Reclamation> it = list.iterator();
                while (it.hasNext()) {
                    Reclamation c = it.next();
                    if (c.equals(selected)) {
                        it.remove();
                        ServiceReclamation sc = new ServiceReclamation();
                        try {
                            sc.supprimer(selected.getId());

                        } catch (SQLException ex) {
                            Logger.getLogger(AfficherCommandeAdresseController.class.getName()).log(Level.SEVERE, null, ex);}
                             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment supprimer cette reclamation ? ");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                new ServiceCategorie().supprimer(selected.getId());
               Notifications notificationBuilder = Notifications.create()
                                                .title("Confrimation suppression Reclamation")
                                                .text("Reclamation supprimée avec succès")
                                                .graphic(null)
                                                .hideAfter(Duration.seconds(5))
                                                .position(Pos.BOTTOM_RIGHT);
                                        notificationBuilder.showConfirm();   
            
            }
                        }
                        ReclamationView.refresh();

                    }
                }
            }
        
   
     
     
    
}