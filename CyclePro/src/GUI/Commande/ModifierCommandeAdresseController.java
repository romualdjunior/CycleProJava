/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Commande;

import Service.Commande.ServiceAdresse;
import animatefx.animation.Bounce;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author toshiba
 *
 */
public class ModifierCommandeAdresseController implements Initializable {

    @FXML
    private ChoiceBox<String> etat;

    @FXML
    private ChoiceBox<String> pays;

    @FXML
    private ChoiceBox<String> ville;

    @FXML
    private JFXTextField pincode;

    @FXML
    private JFXTextField adresseLivraision;
    private boolean pincodeBool, adresseLivraisonBool;
    private ObservableList<String> paysList = FXCollections.observableArrayList("UK", "India", "Australia", "Japan", "Africa");
    private ObservableList<String> etatList = FXCollections.observableArrayList("Victoria", "Hiroshima", "Pradesh");
    private ObservableList<String> villeList = FXCollections.observableArrayList("London", "Dehli", "Sydney", "Tokyo", "NewYork");
    AnchorPane centerContent;
    String page;
    @FXML
    private Pane banner;
    int idCommande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Bounce(banner).play();
        etat.setValue("Hiroshima");
        pays.setValue("Japan");
        ville.setValue("Tokyo");
        etat.setItems(etatList);
        pays.setItems(paysList);
        ville.setItems(villeList);
        pincodeBool = adresseLivraisonBool = false;
        RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();
        requiredFieldValidator.setMessage("Champ obligatoire");
        ValidatorBase adresseLivraisonValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Pas de caractères spéciaux ");
                if (adresseLivraision.getText().matches("^^[a-zA-Z0-9éèà]+$")) {
                    adresseLivraisonBool = true;
                    hasErrors.set(false);
                } else {
                    hasErrors.set(true);
                    adresseLivraisonBool = false;
                }
            }
        };

        ValidatorBase pinCodeValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Ecrivez un code postal conforme svp 6 chiffres uniquement ");
                if (pincode.getText().matches("[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$")) {
                    hasErrors.set(false);
                    pincodeBool = true;
                } else {
                    hasErrors.set(true);
                    pincodeBool = false;
                }
            }
        };
        adresseLivraision.getValidators().addAll(requiredFieldValidator, adresseLivraisonValidator);
        pincode.getValidators().addAll(requiredFieldValidator, pinCodeValidator);
        adresseLivraision.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                adresseLivraision.validate();
            }
        });

        pincode.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                pincode.validate();
            }
        });

    }

    void redirection(AnchorPane centerContent, String page, int idCommande) {
        this.centerContent = centerContent;
        this.page = page;
        this.idCommande = idCommande;
    }

    @FXML
    void ModifierAction(ActionEvent event) throws SQLException {
        if (adresseLivraisonBool && pincodeBool) {
            ServiceAdresse serviceAdresse = new ServiceAdresse();
            serviceAdresse.update(idCommande, adresseLivraision.getText(), Integer.parseInt(pincode.getText()), ville.getValue(), pays.getValue(), etat.getValue());
            //JOptionPane.showMessageDialog(null, "Votre commande a été modifiée avec succès ");
            Notifications notificationBuilder = Notifications.create()
                    .title("Confrimation Modification adresse ")
                    .text("Votre adresse a été modifiéeavec succès")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificationBuilder.showConfirm();
        }

    }

}
