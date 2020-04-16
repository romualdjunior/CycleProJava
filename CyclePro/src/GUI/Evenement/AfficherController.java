/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.Event;
import Service.Evenement.EventService;
import animatefx.animation.FadeIn;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<Event> tabEvent;
    
    @FXML
    private TableColumn Nom;
    @FXML
    private TableColumn Type;
    @FXML
    private TableColumn NbrPlace;
    @FXML
    private TableColumn DateDebut;
    @FXML
    private TableColumn Prix;
    @FXML
    private TableColumn<Event, String> Participants;
    @FXML
    private TableColumn Commentaires;
    @FXML
    private Button searchb;
    @FXML
    private TextField search;
    ObservableList<Event> data;
    AnchorPane centerContent;
    @FXML
    private ImageView imageEvent;

    public Button del() {
        Button del = new Button();
        del.setText("X");
        del.setPrefWidth(30);
        del.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                EventService es = new EventService();
                Event e = tabEvent.getSelectionModel().getSelectedItem();
                es.supprimer(e);
                tabEvent.refresh();

            }
        });
        return del;
    } 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          EventService es = new EventService();
            Event eventSelec = tabEvent.getSelectionModel().getSelectedItem();
      data = FXCollections.observableArrayList();
        tabEvent.setOnMouseClicked(new EventHandler<MouseEvent>(){
              @Override
              public void handle(MouseEvent event) {
                  
                 Event eventSelec = tabEvent.getSelectionModel().getSelectedItem();
                imageEvent.setImage(new Image(this.getClass().getResourceAsStream(eventSelec.getPhotoEvent())));
                 }
          });
     
        Nom.setCellValueFactory(
                new PropertyValueFactory<Event, String>("nom")
        );
        Type.setCellValueFactory(
                new PropertyValueFactory<Event, String>("Type")
        );
        NbrPlace.setCellValueFactory(
                new PropertyValueFactory<Event, Integer>("nbrplace")
        );
        DateDebut.setCellValueFactory(
                new PropertyValueFactory<Event, Date>("dateDebut")
        );
        Prix.setCellValueFactory(
                new PropertyValueFactory<Event, Float>("prix")
        );
       
       
        Commentaires.setCellValueFactory(
                new PropertyValueFactory<Event, Integer>("id")
        );
        search.setOnKeyTyped(e -> {
            System.out.println("Clicked"+search.getText());
            String input =search.getText();
    data = FXCollections.observableArrayList();
        data.addAll(es.search(input));
        
        tabEvent.setItems(data);
        
        
        });
       
         
         
       
        data.addAll(es.afficher());
       
        tabEvent.setItems(data);
       

    }

    @FXML
    private void deleteAction(ActionEvent event) {
        
        try{
        EventService es = new EventService();

        Event eventSelec = tabEvent.getSelectionModel().getSelectedItem();
        es.supprimer(eventSelec);
        tabEvent.getItems().remove(eventSelec);
        tabEvent.refresh();}
         catch(Exception e){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection un evenement pour supprimer ");
            alert.showAndWait();
            alert.close();
       
       }
    }

    @FXML
    private void updateAction(ActionEvent event) throws IOException {
        EventService es = new EventService();
       try{
        Event eventSelec = tabEvent.getSelectionModel().getSelectedItem();
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/Modifier.fxml"));

        Parent fxml = Loader.load();
        
        ModifierController e = Loader.getController();
        e.redirection(centerContent, eventSelec);
       
        centerContent.getChildren().removeAll();

        new FadeIn(fxml).play();
        centerContent.getChildren().setAll(fxml);
        data = FXCollections.observableArrayList();
        data.addAll(es.search(search.getText()));
        data.forEach(System.out::println);
        tabEvent.setItems(data);
        data.forEach(System.out::println);
       
       }
       catch(Exception e){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection un evenement pour modifier ");
            alert.showAndWait();
            alert.close();
       
       }
       
    }
    
        @FXML
    private void commentaire(ActionEvent event) throws IOException {
        EventService es = new EventService();
       try{
        Event eventSelec = tabEvent.getSelectionModel().getSelectedItem();
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/ListComment.fxml"));

        Parent fxml = Loader.load();
        
        ListCommentaireController e = Loader.getController();
        e.redirection(centerContent, eventSelec);
       
        centerContent.getChildren().removeAll();

        new FadeIn(fxml).play();
        centerContent.getChildren().setAll(fxml);
       
       }
       catch(Exception e){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Selection un evenement pour afficher les commentaires ");
            alert.showAndWait();
            alert.close();
       
       }
       
    }
    @FXML
    private void participants(ActionEvent event) throws IOException {
        EventService es = new EventService();
       try{
        Event eventSelec = tabEvent.getSelectionModel().getSelectedItem();
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/ListParticipant.fxml"));

        Parent fxml = Loader.load();
        
        ListParticipantController e = Loader.getController();
        e.redirection(centerContent, eventSelec);
       
        centerContent.getChildren().removeAll();

        new FadeIn(fxml).play();
        centerContent.getChildren().setAll(fxml);
       }  
       catch(Exception e){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection un evenement pour Afficher les commentaires ");
            alert.showAndWait();
            alert.close();
       
       }
       
    }
 
   public Event returnEvent(){
    Event eventSelec = tabEvent.getSelectionModel().getSelectedItem();
    return eventSelec;
   
   
   }
    public void redirection(AnchorPane c) {
        centerContent = c;
    }
    
    public void search(){
    String input =search.getText();
    EventService es = new EventService();
    data = FXCollections.observableArrayList();
        data.addAll(es.search(input));
        data.forEach(System.out::println);
        tabEvent.setItems(data);
        data.forEach(System.out::println);
      
    
    }

}
