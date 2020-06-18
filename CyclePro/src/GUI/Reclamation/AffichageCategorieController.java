/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import Entitie.Commande.CommandeAdresse;
import Entitie.Evenement.Event;
import Entitie.Reclamation.Categorie;
import Entitie.Reclamation.Reclamation;
import GUI.Backoffice.BackofficeController;
import GUI.Commande.AfficherCommandeAdresseController;
import GUI.Commande.ModifierCommandeAdresseController;
import GUI.Evenement.AfficherController;
import Service.Commande.ServiceCommande;
import Service.Evenement.EventService;
import Service.Evenement.ParticipantsService;
import Service.Reclamation.ServiceCategorie;
import Service.Reclamation.ServiceReclamation;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDown;
import com.email.durgesh.Email;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AffichageCategorieController implements Initializable {
        
    @FXML
    private TableView<Categorie> CategorieView;

    @FXML
    private TableColumn<Categorie, Integer> idCategorie;

    @FXML
    private TableColumn<Categorie, String> label;

    @FXML
    private TableColumn<Categorie, String> description;
    
    @FXML
    private TextField SearchField; 
    
    @FXML 
  AnchorPane centerContent;
    
    @FXML
    private Button ajouter;
   
  
  @FXML
  Pane pane ; 
  Parent fxml ; 
    
    
   ObservableList<Categorie> list = FXCollections.observableArrayList();
    
    String page= "categoriePage";
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idCategorie.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id"));
        label.setCellValueFactory(new PropertyValueFactory<Categorie, String>("label"));
        description.setCellValueFactory(new PropertyValueFactory<Categorie, String>("description"));
      
       ServiceCategorie sc = new ServiceCategorie();
        try{
        list.addAll(sc.getAll()) ; 
        CategorieView.setItems(list);
        
     
         CategorieView.setOnMousePressed(new EventHandler<MouseEvent> () {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("Row Selected");
              
                           }
        });        
        
    }   
       
       catch ( SQLException e )
       {}
        
      
        
        FilteredList<Categorie> filteredData = new FilteredList<>(list, p -> true);
        SearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(categorie -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Integer.toString(categorie.getId()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (categorie.getLabel().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (categorie.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } 
                return false; // Does not match.
            });
        });
        SortedList<Categorie> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(CategorieView.comparatorProperty());
        CategorieView.setItems(sortedData);
        
       
        
        
        
        
        
    }
  
     @FXML 
    private void deleteRow (ActionEvent Event) throws SQLException, MessagingException, UnsupportedEncodingException{ 
   
        if (CategorieView.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide, veuillez selectionner une catégorie")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning(); }    
    else{
     Categorie selected = CategorieView.getSelectionModel().getSelectedItem();
     Iterator<Categorie> it = list.iterator();
                while (it.hasNext()) {
                    Categorie c = it.next();
                    if (c.equals(selected)) {
                        it.remove();
                        ServiceCategorie sc = new ServiceCategorie();
                        try {
                            sc.supprimer(selected.getId());

                        } catch (SQLException ex) {
                            Logger.getLogger(AfficherCommandeAdresseController.class.getName()).log(Level.SEVERE, null, ex);}
                             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous voulez vraiment supprimer cette categorie");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                new ServiceCategorie().supprimer(selected.getId());
               Notifications notificationBuilder = Notifications.create()
                                                .title("Confrimation suppression Categorie")
                                                .text("Categorie supprimée avec succès")
                                                .graphic(null)
                                                .hideAfter(Duration.seconds(5))
                                                .position(Pos.BOTTOM_RIGHT);
                                        notificationBuilder.showConfirm();   
            
            }
                        }
                        CategorieView.refresh();

                    }
                }
            }
        
   
   
   @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Reclamation/AjoutCategorie.fxml"));
                            Parent fxml = Loader.load();
                            centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
        
    }
    
    
    @FXML
    private void modifier (ActionEvent event) 
    { if (CategorieView.getSelectionModel().isEmpty()) {
            Notifications n = Notifications.create()
                    .title("Erreur")
                    .text("Choix invalide, veuillez selectionner une catégorie ")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(5));
            n.showWarning(); }    
    else{
    Categorie selected = CategorieView.getSelectionModel().getSelectedItem();
     Iterator<Categorie> it = list.iterator();
                while (it.hasNext()) {
                    Categorie c = it.next();
                    if (c.equals(selected)) {
                        try {
                            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Reclamation/ModifierCategorie.fxml"));
                            Parent fxml = Loader.load();
                            ModifierCategorieController m = Loader.getController();
                            m.redirection(centerContent, page, selected.getId());
                            centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
                        } catch (IOException ex) {
                            Logger.getLogger(AfficherCommandeAdresseController.class.getName()).log(Level.SEVERE, null, ex);
    
    }
    
    
    
                    }}}    } 
    

    
    
  
     
    
      @FXML
    private void back (ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Reclamation/AffichageReclamation.fxml"));
                            Parent fxml = Loader.load();
                            //centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
        
    }
    
    
}