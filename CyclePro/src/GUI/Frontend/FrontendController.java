/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Frontend;

import GUI.Blog.BlogController;
import GUI.Evenement.EvenementController;
import animatefx.animation.FadeInDown;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    String page;
    Parent fxml;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        page = "Accueil";
        //this.pageLoader("Accueil.fxml");
        this.pageLoader("/GUI/Stock/Shop.fxml");
        this.topButton(page);

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
           
        }
        else if ("Shop".equals(page)) {
            ajouter.setVisible(true);
            modifier.setVisible(true);
            supprimer.setVisible(true);
            ajouter.setText("Velo");
            modifier.setText("Accessoire");
            supprimer.setText("Promotion");
           
        }
         else  {
            ajouter.setVisible(false);
            modifier.setVisible(false);
            supprimer.setVisible(false);
           
        }
    }

    public void pageLoader(String pageName) {
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource(pageName));
            fxml = Loader.load();
            if ("Evenement".equals(page) && pageName.equals("/GUI/Evenement/Evenement.fxml")) {
                EvenementController e = Loader.getController();
                e.redirection(centerContent, page);
            } else if ("Blog".equals(page) && pageName.equals("/GUI/Blog/Blog.fxml")) {
                BlogController e = Loader.getController();
                e.redirection(centerContent, page);
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
        this.pageLoader("Accueil.fxml");

    }

    @FXML
    void blog(ActionEvent event) {
        page = "Blog";
        this.topButton(page);

        this.pageLoader("/GUI/Blog/Blog.fxml");

    }

    @FXML
    void boutique(ActionEvent event) {
        page = "Shop";
        this.topButton(page);

        this.pageLoader("/GUI/Stock/Shop.fxml");
    }

    @FXML
    void contact(ActionEvent event) {
        page = "Contact";
        this.topButton(page);
        this.pageLoader("/GUI/Reclamation/Contact.fxml");

    }

    @FXML
    void evenement(ActionEvent event) {
        page = "Evenement";
        this.topButton(page);
        this.pageLoader("/GUI/Evenement/Evenement.fxml");

    }

    @FXML
    void gallerie(ActionEvent event) {

    }

    @FXML
    void ajouter(ActionEvent event) {
        if (page.equals("Blog") || page.equals("BlogSingle")) {
            this.pageLoader("/GUI/Blog/Ajouter.fxml");
        } else if (page.equals("Shop")) {
            this.pageLoader("/GUI/Stock/Shop.fxml");
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
            this.pageLoader("/GUI/Stock/ShopA.fxml");
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
    void administration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Backoffice/Backoffice.fxml"));
        Stage stage = (Stage) centerContent.getScene().getWindow();
        stage.close();
        Stage stage2 = new Stage();
        stage2.setTitle("CyclePro");
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage2.initStyle(StageStyle.DECORATED);
        stage2.show();
    }

}

