/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.CommentaireEvent;
import Entitie.Evenement.Event;
import Entitie.Evenement.Participants;
import Entitie.User.User;
import GUI.Frontend.FrontendController;
import Service.Evenement.CommentaireEventService;
import Service.Evenement.EventService;
import Service.Evenement.ParticipantsService;
import animatefx.animation.Bounce;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class EvenementSingleController implements Initializable {

    /**
     * Initializes the controller class.
     */
        
    @FXML
    private AnchorPane banner;

    @FXML
    private Label titre;

    @FXML
    private ImageView imageEvent;

    @FXML
    private Label adr;

    @FXML
    private Label description;

    @FXML
    private TextField comment;

    @FXML
    private JFXButton commenter;

    @FXML
    private VBox vbox;

    @FXML
    private Pane paneComment;

    @FXML
    private Label userName1;

    @FXML
    private Label date1;

    @FXML
    private Label content1;

    @FXML
    private Pane paneComment1;

    @FXML
    private Label userName2;

    @FXML
    private Label date2;

    @FXML
    private Label content2;

    @FXML
    private Pane paneComment11;

    @FXML
    private Label userName3;

    @FXML
    private Label date3;

    @FXML
    private Label content3;

    Event event1;
    User user;
    AnchorPane centerContent;
     @FXML
    private JFXButton part;
     @FXML
    private Label nullnbr;
     
     @FXML
    private TextField searchinput;

    @FXML
    private FontAwesomeIcon search;
    
    @FXML
            
         
    void commenter(ActionEvent event) {
        CommentaireEventService cs  = new CommentaireEventService();
        CommentaireEvent cm=new  CommentaireEvent(comment.getText(),event1.getId(),user.getId());
        ParticipantsService ps = new ParticipantsService();
         cs.ajouter(cm);
        
        userName3.setText(ps.getUserName(cm.getUser()));
        
        content3.setText(cm.getContenue());
    }
  @FXML
    void participerEvent(ActionEvent event) {
        
        
      EventService es = new EventService();
      ParticipantsService ps = new ParticipantsService();
      
        if(ps.participantExist(event1.getId(),user.getId())==0){
        part.setText("Participé ✓");
            Participants p = new Participants(user.getId(),event1.getId());
        ps.ajouter(p);
          
        
        }else{
         part.setText("Participer ");
          Participants p = new Participants(user.getId(),event1.getId());
         ps.ajouter(p);
        }
      if(event1.getNbrplace()==0){
      nullnbr.setText("le nombre de place est indisponible");
      
      }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();
    }   
    public void redirection(AnchorPane c, Event e,User u){
       centerContent=c; 
        System.out.println("l'identifiant de l'evenement est "+e.getId());
        //AFFICHAGE SINGLE
        System.out.println("l'identifiant de l'utilisatuer est "+u.getId());
        
        imageEvent.setImage(new Image(this.getClass().getResourceAsStream(e.getPhotoEvent())));
        titre.setText(e.getNom());
        description.setText(e.getDescription());
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");  
       Date dt =e.getDateDebut();
       
    SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy ");  
    String strDate = formatter.format(e.getDateDebut());  
        adr.setText(e.getAdresse()+"  "+strDate);
         this.event1 = e;
      this.user=u;
        ParticipantsService ps = new ParticipantsService();
         CommentaireEventService cs  = new CommentaireEventService();
         try{
        CommentaireEvent c1= cs.getComments(event1.getId()).get(0);
        userName1.setText(ps.getUserName(c1.getUser()));
        date1.setText(c1.getDateComment().toString());
        content1.setText(c1.getContenue());
        CommentaireEvent c2= cs.getComments(event1.getId()).get(1);
        userName2.setText(ps.getUserName(c2.getUser()));
        date2.setText(c2.getDateComment().toString());
        content2.setText(c2.getContenue());
        CommentaireEvent c3= cs.getComments(event1.getId()).get(2);
        userName3.setText(ps.getUserName(c3.getUser()));
        date3.setText(c3.getDateComment().toString());
        content3.setText(c3.getContenue());
        }catch(Exception ex){}
       if(ps.participantExist(event1.getId(),user.getId())!=0){
        part.setText("Participé ✓");
        
        
        }else{
         part.setText("Participer ");
          
        }

    }
    
}
