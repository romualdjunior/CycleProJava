/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Frontend;

import Entitie.User.User;
import GUI.Backoffice.BackofficeController;
import GUI.Blog.BlogController;
import GUI.Evenement.EvenementController;
import GUI.Stock.ShopController2;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class FrontendController implements Initializable {

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
    private VBox vbox;
    @FXML
    private Label nomUtilisateur;

    @FXML
    private Pane blackScreen;

    @FXML
    private Pane signIn2;

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

    String page;
    Parent fxml;
    boolean sidebarVisible;
    User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        vbox.setVisible(false);
        sidebarVisible = false;
        blackScreen.setVisible(false);
        signIn2.setVisible(false);
        notification.setVisible(false);

    }

    public void topButton(String page) {
        if (page.equals("Accueil")) {
            ajouter.setVisible(false);
            modifier.setVisible(false);
            supprimer.setVisible(false);
        } else if ("Blog".equals(page)) {
            ajouter.setVisible(true);
            modifier.setVisible(true);
            supprimer.setVisible(true);
            ajouter.setText("Chat");
            modifier.setText("Autre");
            supprimer.setText("Autre");

        } else if ("Shop".equals(page)) {
            ajouter.setVisible(true);
            modifier.setVisible(true);
            supprimer.setVisible(true);
            ajouter.setText("Article");
            modifier.setText("Autre");
            supprimer.setText("Autre");

        } else {
            ajouter.setVisible(false);
            modifier.setVisible(false);
            supprimer.setVisible(false);

        }
    }

    public void pageLoader(String pageName, User u) {
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource(pageName));
            fxml = Loader.load();
            if ("Evenement".equals(page) && pageName.equals("/GUI/Evenement/Evenement.fxml")) {
                EvenementController e = Loader.getController();
                System.out.println("utilisateur dans avant EventController");
                System.out.println(user);
                e.redirection(centerContent, page,u);
                System.out.println("le centerContent est envoyé depuis le FrontendController");
            } else if ("Blog".equals(page) && pageName.equals("/GUI/Blog/Blog.fxml")) {
                BlogController e = Loader.getController();
                e.redirection(centerContent, page,user);
            }
            else if ("Shop".equals(page) && pageName.equals("/GUI/Stock/Shop2.fxml")) {
                System.out.println("la redirection est bonne");
                ShopController2 e = Loader.getController();
                e.redirection(centerContent,user);
            }
            centerContent.getChildren().removeAll();
            new FadeInDown(fxml).play();
            centerContent.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(FrontendController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void accueil(ActionEvent event) {
        page = "Accueil";
        this.topButton(page);
        this.pageLoader("Accueil.fxml",user);

    }

    @FXML
    void blog(ActionEvent event) {
        page = "Blog";
        this.topButton(page);

        this.pageLoader("/GUI/Blog/Blog.fxml",user);

    }

    @FXML
    void boutique(ActionEvent event) {
        page = "Shop";
        this.topButton(page);

        this.pageLoader("/GUI/Stock/Shop.fxml",user);
    }
    
     @FXML
    void boutique2(ActionEvent event) {
        page = "Shop";
        this.topButton(page);

        this.pageLoader("/GUI/Stock/Shop2.fxml",user);
    }

    @FXML
    void contact(ActionEvent event) {
        page = "Reclamation";
        this.topButton(page);
        this.pageLoader("/GUI/Reclamation/User.fxml",user);

    }

    @FXML
    void evenement(ActionEvent event) {
        page = "Evenement";
        this.topButton(page);
        this.pageLoader("/GUI/Evenement/Evenement.fxml",user);

    }

    @FXML
    void gallerie(ActionEvent event) {

    }

    @FXML
    void ajouter(ActionEvent event) {
        if (page.equals("Blog") || page.equals("BlogSingle")) {
            this.pageLoader("/GUI/Blog/Ajouter.fxml",user);
        } else if (page.equals("Shop")) {
            this.pageLoader("/GUI/Stock/Shop.fxml",user);
        } else if (page.equals("Contact")) {
            this.pageLoader("/GUI/Reclamation/Ajouter.fxml",user);
        } else if (page.equals("Evenement") || page.equals("EvenementSingle")) {
            this.pageLoader("/GUI/Evenement/Ajouter.fxml",user);
        }

    }

    @FXML
    void modifier(ActionEvent event) {
        if (page.equals("Blog") || page.equals("BlogSingle")) {
            this.pageLoader("/GUI/Blog/Modifier.fxml",user);
        } else if (page.equals("Shop")) {
            this.pageLoader("/GUI/Stock/ShopA.fxml",user);
        } else if (page.equals("Contact")) {
            this.pageLoader("/GUI/Reclamation/Modifier.fxml",user);
        } else if (page.equals("Evenement") || page.equals("EvenementSingle")) {
            this.pageLoader("/GUI/Evenement/Afficher.fxml",user);
        }
    }

    @FXML
    void supprimer(ActionEvent event) {
        if (page.equals("Blog") || page.equals("BlogSingle")) {
            this.pageLoader("/GUI/Blog/Supprimer.fxml",user);
        } else if (page.equals("Shop")) {
            this.pageLoader("/GUI/Stock/Supprimer.fxml",user);
        } else if (page.equals("Contact")) {
            this.pageLoader("/GUI/Reclamation/Supprimer.fxml",user);
        } else if (page.equals("Evenement") || page.equals("EvenementSingle")) {
            this.pageLoader("/GUI/Evenement/Supprimer.fxml",user);
        }
    }

    @FXML
    void administration(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Backoffice/Backoffice.fxml"));
        Parent fxml = Loader.load();
        BackofficeController e = Loader.getController();
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

    public void redirection(User u) {
        user = u;
        nomUtilisateur.setText(user.getUsername());
         page = "Accueil";
        this.pageLoader("Accueil.fxml",user);
        this.topButton(page);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), (ActionEvent e) -> {
                    this.notification("Succès", "Bienvenue  " + u.getUsername());
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
}
