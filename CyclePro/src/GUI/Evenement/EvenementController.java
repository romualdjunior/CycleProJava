/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.Event;
import Entitie.User.User;
import GUI.Frontend.FrontendController;
import Service.Evenement.EventService;
import animatefx.animation.Bounce;
import animatefx.animation.FadeInDown;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class EvenementController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Pane banner;

    @FXML
    private VBox vbox;
    String page;

    private AnchorPane centerContent;
    User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Bounce(banner).play();

    }

    @FXML
    void regarder(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementSingle.fxml"));
        Parent fxml = Loader.load();
        centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);

    }

    public void redirection(AnchorPane a, String page,User u) throws IOException {
        user=u;
        centerContent = a;
        page = "Evenement";
        EventService es = new EventService();
        List<Event> Events = new ArrayList<Event>();
        Event e1 = new Event();
        Event e2 = new Event();
        Event e3 = new Event();
        Event e4 = new Event();
        Events.addAll(es.afficher());
        List<Node> Events2 = new ArrayList<>();
        vbox.getChildren().clear();
        int count = 0;
        for (Event Event1 : Events) {
            try {
                FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/EvenementElement.fxml"));
                Parent fxml = (Parent) Loader.load();
                EvenementElementController e = Loader.getController();
                count++;
                if (count == 1) {
                    e1 = Event1;
                    System.out.println(e1);
                } else if (count == 2) {
                    e2 = Event1;
                } else if (count == 3) {
                    e3 = Event1;
                } else if (count == 4) {
                    e4 = Event1;
                    e.init(e1, e2, e3, e4, centerContent,u);
                    System.out.println("cela a marche");
                    count = 0;
                    vbox.getChildren().add(fxml);
                }
                System.out.println(count);

            } catch (IOException ex) {
                Logger.getLogger(FrontendController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
