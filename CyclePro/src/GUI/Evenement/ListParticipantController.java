/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.Classe;
import Entitie.Evenement.CommentaireEvent;
import Entitie.Evenement.Event;
import Entitie.Evenement.Participants;
import Service.Evenement.ClasseService;
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
import static javafx.collections.FXCollections.observableList;
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
public class ListParticipantController implements Initializable {

    @FXML
    private Text title;
    @FXML
    private TableView<Participants> tabEvent;
    @FXML
    private TableColumn<Participants, String> Event;
    @FXML
    private TableColumn<Participants, String> User;
    @FXML
    private TableColumn<Participants, Date> DatePart;
    ObservableList<Participants> data;
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
        
        
         ParticipantsService ps = new ParticipantsService();
         ps.afficherParticipantEvent(event.getId());
                
        
 
         
         Event.setCellValueFactory(cm-> new SimpleStringProperty(ps.getEventP(event.getId())));
           User.setCellValueFactory(cm-> new SimpleStringProperty(ps.getEmailUser(cm.getValue().getUser())));
   
           DatePart.setCellValueFactory(
                new PropertyValueFactory<Participants, Date>("daePart")
        );
        
          Participants partSelec = tabEvent.getSelectionModel().getSelectedItem();
        data = FXCollections.observableArrayList();
        data.addAll( ps.afficherParticipantEvent(event.getId()));
        
        data.forEach(System.out::println);
        tabEvent.setItems(data);
        data.forEach(System.out::println);
        
        }
    
    
  
      @FXML
    private void deleteAction(ActionEvent event) {
        
        try{
        ParticipantsService es = new ParticipantsService();

        Participants eventSelec = tabEvent.getSelectionModel().getSelectedItem();
        es.supprimer(eventSelec);
        tabEvent.getItems().remove(eventSelec);
        tabEvent.refresh();
                 ClasseService cs = new ClasseService();
            ParticipantsService ps = new ParticipantsService();
    Classe c= new  Classe(ps.Nbparticipants(), "Adulte",ps.NbAdult() );
    Classe c1= new  Classe(ps.Nbparticipants(), "adolescents",ps.NbAdo() );
    Classe c2= new  Classe(ps.Nbparticipants(), "Enfants",ps.NbEnfant() );
    Classe c3= new  Classe(ps.Nbparticipants(), "Personnes agées",ps.NbPersonneAgees() );
    cs.modifier(c);
    cs.modifier(c1);
    cs.modifier(c2);
    cs.modifier(c3); 
        
        }
         catch(Exception e){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection un evenement pour supprimer ");
            alert.showAndWait();
            alert.close();
       
       }
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

    
    
}
