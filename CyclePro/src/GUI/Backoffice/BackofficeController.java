/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Backoffice;

import Entitie.User.User;
import GUI.Frontend.*;
import GUI.Blog.BlogController;
import GUI.Evenement.EvenementController;
import Service.User.UserService;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDown;
import animatefx.animation.FadeOut;
import animatefx.animation.SlideInLeft;
import animatefx.animation.SlideOutLeft;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class BackofficeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane centerContent;

    @FXML
    private JFXButton ajouter;

    @FXML
    private JFXButton modifier;

    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXTextField emailUsername;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Pane notification;

    @FXML
    private Label notificationMessage;
    @FXML
    private ImageView notificationImage;
    @FXML
    private Label nomUtilisateur;
    @FXML
    private Pane blackScreen;
    @FXML
    private Pane signIn2;
    @FXML
    private VBox vbox;

    boolean sidebarVisible;
    User user;
    String page;
    Parent fxml;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        page = "Accueil";
        this.pageLoader("Accueil.fxml");
        this.topButton(page);
        vbox.setVisible(false);
        sidebarVisible = false;
        blackScreen.setVisible(false);
        signIn2.setVisible(false);
        notification.setVisible(false);

    }

    public void topButton(String page) {
        if (page == "Accueil") {
            ajouter.setVisible(false);
            modifier.setVisible(false);
            supprimer.setVisible(false);
        } else {
            ajouter.setVisible(true);
            modifier.setVisible(true);
            supprimer.setVisible(true);
        }
    }

    public void pageLoader(String pageName) {
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource(pageName));
            fxml = Loader.load();
            centerContent.getChildren().removeAll();
            new FadeIn(fxml).play();
            centerContent.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(BackofficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void accueil(ActionEvent event) {
        page = "Accueil";
        this.topButton(page);
        this.pageLoader("Accueil.fxml");

    }

    @FXML
    void blog(ActionEvent event) {
        page = "Blog";
        this.topButton(page);
        this.pageLoader("/GUI/Blog/Ajouter.fxml");

    }

    @FXML
    void boutique(ActionEvent event) {
        page = "Shop";
        this.topButton(page);
        this.pageLoader("/GUI/Stock/Ajouter.fxml");
    }

    @FXML
    void contact(ActionEvent event) {
        page = "Contact";
        this.topButton(page);
        this.pageLoader("/GUI/Reclamation/Ajouter.fxml");

    }

    @FXML
    void evenement(ActionEvent event) {
        page = "Evenement";
        this.topButton(page);
        this.pageLoader("/GUI/Evenement/Ajouter.fxml");

    }

    @FXML
    void gallerie(ActionEvent event) {

    }

    @FXML
    void ajouter(ActionEvent event) {
        if (page.equals("Blog") || page.equals("BlogSingle")) {
            this.pageLoader("/GUI/Blog/Ajouter.fxml");
        } else if (page.equals("Shop")) {
            this.pageLoader("/GUI/Stock/Ajouter.fxml");
        } else if (page.equals("Contact")) {
            this.pageLoader("/GUI/Reclamation/Ajouter.fxml");
        } else if (page.equals("Evenement") || page.equals("EvenementSingle")) {
            this.pageLoader("/GUI/Evenement/Ajouter.fxml");
        }

    }

    @FXML
    void modifier(ActionEvent event) {
        if (page.equals("Blog") || page.equals("BlogSingle")) {
            this.pageLoader("/GUI/Blog/Modifier.fxml");
        } else if (page.equals("Shop")) {
            this.pageLoader("/GUI/Stock/Modifier.fxml");
        } else if (page.equals("Contact")) {
            this.pageLoader("/GUI/Reclamation/Modifier.fxml");
        } else if (page.equals("Evenement") || page.equals("EvenementSingle")) {
            this.pageLoader("/GUI/Evenement/Modifier.fxml");
        }
    }

    @FXML
    void supprimer(ActionEvent event) {
        if (page.equals("Blog") || page.equals("BlogSingle")) {
            this.pageLoader("/GUI/Blog/Supprimer.fxml");
        } else if (page.equals("Shop")) {
            this.pageLoader("/GUI/Stock/Supprimer.fxml");
        } else if (page.equals("Contact")) {
            this.pageLoader("/GUI/Reclamation/Supprimer.fxml");
        } else if (page.equals("Evenement") || page.equals("EvenementSingle")) {
            this.pageLoader("/GUI/Evenement/Supprimer.fxml");
        }
    }

    @FXML
    void Frontend(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Frontend/Frontend.fxml"));
        Parent fxml = Loader.load();
        FrontendController e = Loader.getController();
        e.redirection(user);
        Stage stage = (Stage) centerContent.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        stage2.setTitle("CyclePro");
        Scene scene = new Scene(fxml);
        stage2.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage2.initStyle(StageStyle.DECORATED);
        stage2.show();
    }

    @FXML
    void connecting(ActionEvent event) throws SQLException {
        UserService userService = new UserService();
        int idUser = userService.connexion(emailUsername.getText(), password.getText());
        if (idUser != -1) {
            Stage stage = (Stage) emailUsername.getScene().getWindow();
            user = userService.utilisateur(idUser);
            this.notification("Succès", "Bienvenue " + user.getUsername());
            new FadeOut(blackScreen).play();
            new FadeOut(signIn2).play();
            blackScreen.setVisible(false);
            signIn2.setVisible(false);
            nomUtilisateur.setText(user.getUsername());

        } else {
            this.notification("Erreur", "Identifiants invalides");
        }
    }

    public void redirection(User u) {
        user = u;
        nomUtilisateur.setText(user.getUsername());
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), (ActionEvent e) -> {
                    this.notification("Succès", "Bienvenue  " + u.getUsername());
                }));
        timeline.play();
    }

    @FXML
    void sideBar(ActionEvent event) {
        vbox.setVisible(true);
        if (sidebarVisible == false) {
            new SlideInLeft(vbox).play();
            sidebarVisible = true;

        } else {
            new SlideOutLeft(vbox).play();
            sidebarVisible = false;

        }

    }

    public void notification(String Type, String message) {
        notificationMessage.setText(message);

        switch (Type) {
            case "Succès":
                notification.setStyle("-fx-background-color:#2E7252;-fx-background-radius:4px;-fx-effect: dropshadow(three-pass-box, rgb(2,0,252,0.7), 10, 0, 0, 0);");
                notificationImage.setImage(new Image("/GUI/Images/Succès.png"));

                break;
            case "Erreur":
                notification.setStyle("-fx-background-color:#702820;-fx-background-radius:4px;-fx-effect: dropshadow(three-pass-box, rgb(2,0,252,0.7), 10, 0, 0, 0);");
                notificationImage.setImage(new Image("/GUI/Images/Icon material-error-outline.png"));
                break;
            default:

        }
        new FadeIn(notification).play();
        notification.setVisible(true);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), (ActionEvent e) -> {
                    new FadeOut(notification).play();

                }));

        timeline.play();
    }

    @FXML
    void changeUser(ActionEvent event) {
        System.out.println("manger");
        new FadeIn(blackScreen).play();
        new FadeInDown(signIn2).play();
        blackScreen.setVisible(true);
        signIn2.setVisible(true);

    }

}
