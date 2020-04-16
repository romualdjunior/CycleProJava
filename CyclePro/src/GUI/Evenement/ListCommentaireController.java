/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.CommentaireEvent;
import Entitie.Evenement.Event;
import Entitie.Evenement.Participants;
import Service.Evenement.CommentaireEventService;
import Service.Evenement.EventService;
import Service.Evenement.ParticipantsService;
import animatefx.animation.FadeIn;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ListCommentaireController implements Initializable {

    @FXML
    private Text title;
    @FXML
    private TableView<CommentaireEvent> tabEvent;
    @FXML
    private TableColumn<CommentaireEvent, String> Contenue;
    @FXML
    private TableColumn<CommentaireEvent, Date> DateComment;
    @FXML
    private TableColumn<CommentaireEvent, String> Event;
    @FXML
    private TableColumn<CommentaireEvent, String> User;
    ObservableList<CommentaireEvent> data;
    AnchorPane centerContent;
    Event event;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

     @FXML
    public void redirection(AnchorPane c,Event event ){
        centerContent=c;
        
        
         CommentaireEventService cs = new CommentaireEventService();
         cs.getCommentsByID(event.getId()).forEach(System.out::println);
         
        Contenue.setCellValueFactory(
                new PropertyValueFactory<CommentaireEvent, String>("contenue")
        );
          DateComment.setCellValueFactory(
                new PropertyValueFactory<CommentaireEvent, Date>("dateComment")
        );
         User.setCellValueFactory(cm-> new SimpleStringProperty(cs.getUserName(cm.getValue().getUser())));
         Event.setCellValueFactory(cm-> new SimpleStringProperty(cs.getEvent(event.getId())));
        
          
          CommentaireEvent commentSelec = tabEvent.getSelectionModel().getSelectedItem();
        data = FXCollections.observableArrayList();
        data.addAll( cs.getCommentsByID(event.getId()));
        
        data.forEach(System.out::println);
        tabEvent.setItems(data);
        data.forEach(System.out::println);
        
        }
    
    @FXML
     private void Retourner(ActionEvent event) throws IOException {
        EventService es = new EventService();
       
        
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/Afficher.fxml"));

        Parent fxml = Loader.load();
        
        AfficherController e = Loader.getController();
        e.redirection(centerContent);
       
        centerContent.getChildren().removeAll();

        new FadeIn(fxml).play();
        centerContent.getChildren().setAll(fxml);
       
       
    }
 
    
      @FXML
    private void deleteAction(ActionEvent event) {
        
        try{
        CommentaireEventService es = new CommentaireEventService();

        CommentaireEvent eventSelec = tabEvent.getSelectionModel().getSelectedItem();
        es.supprimer(eventSelec);
        tabEvent.getItems().remove(eventSelec);
        tabEvent.refresh();}
         catch(Exception e){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection un commentaire pour supprimer ");
            alert.showAndWait();
            alert.close();
       
       }
    }

}
