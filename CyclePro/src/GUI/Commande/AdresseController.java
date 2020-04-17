/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Commande;

import Entitie.Commande.Adresse;
import Entitie.Commande.Commande;
import Entitie.Commande.LignePanier;
import Entitie.Commande.Panier;
import Entitie.Commande.SendEmail;
import Entitie.User.User;
import GUI.Frontend.FrontendController;
import Service.Commande.ServiceAdresse;
import Service.Commande.ServiceCommande;
import Service.Commande.ServiceLignePanier;
import Service.User.UserService;
import animatefx.animation.Bounce;
import animatefx.animation.FadeInDown;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class AdresseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField prenom;
    @FXML
    private Pane banner;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField email;

    @FXML
    private ChoiceBox<String> etat;

    @FXML
    private ChoiceBox<String> pays;

    @FXML
    private ChoiceBox<String> ville;

    @FXML
    private JFXTextField pincode;

    @FXML
    private JFXTextField adresse;
    private boolean prenomBool, nomBool, phoneBool, emailBool, pincodeBool, adresseBool;
    private ObservableList<String> paysList = FXCollections.observableArrayList("UK", "India", "Australia", "Japan", "Africa");
    private ObservableList<String> etatList = FXCollections.observableArrayList("Victoria", "Hiroshima", "Pradesh");
    private ObservableList<String> villeList = FXCollections.observableArrayList("London", "Dehli", "Sydney", "Tokyo", "NewYork");
    private AnchorPane centerContent;
    ObservableList<Panier> panier = FXCollections.observableArrayList();
    User user;
    int Total;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        new Bounce(banner).play();

        etat.setValue("Hiroshima");
        pays.setValue("Japan");
        ville.setValue("Tokyo");
        etat.setItems(etatList);
        pays.setItems(paysList);
        ville.setItems(villeList);
        prenomBool = nomBool = phoneBool = emailBool = pincodeBool = adresseBool = false;
        RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();
        requiredFieldValidator.setMessage("Champ obligatoire");
        ValidatorBase nomValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Pas de caractères spéciaux ");
                if (nom.getText().matches("^^[a-zA-Z0-9éèà]+$")) {
                    nomBool = true;
                    hasErrors.set(false);
                } else {
                    hasErrors.set(true);
                    nomBool = false;
                }
            }
        };
        ValidatorBase prenomValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Pas de caractères spéciaux ");
                if (prenom.getText().matches("^^[a-zA-Z0-9éèà]+$")) {
                    prenomBool = true;
                    hasErrors.set(false);
                } else {
                    hasErrors.set(true);
                    prenomBool = false;
                }
            }
        };
        ValidatorBase phoneNumberValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Ne doit contenir que des chiffres ");
                if (phone.getText().matches("^[1-9]+$")) {
                    hasErrors.set(false);
                    phoneBool = true;
                } else {
                    hasErrors.set(true);
                    phoneBool = false;
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
        ValidatorBase emailValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("entrer une adresse mail valide");
                if (email.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    hasErrors.set(false);
                    emailBool = true;
                } else {
                    hasErrors.set(true);
                    emailBool = false;
                }
            }
        };

        nom.getValidators().addAll(requiredFieldValidator, nomValidator);
        prenom.getValidators().addAll(requiredFieldValidator, prenomValidator);
        phone.getValidators().addAll(requiredFieldValidator, phoneNumberValidator);
        pincode.getValidators().addAll(requiredFieldValidator, pinCodeValidator);
        email.getValidators().addAll(requiredFieldValidator, emailValidator);

        nom.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                nom.validate();
            }
        });

        prenom.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                prenom.validate();
            }
        });
        email.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                email.validate();
            }
        });
        phone.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                phone.validate();
            }
        });
        pincode.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                pincode.validate();
            }
        });

    }

    @FXML
    void commanderAction(ActionEvent event) throws SQLException, DocumentException, FileNotFoundException {
        FrontendController f = new FrontendController();

        if (nomBool && prenomBool && phoneBool && emailBool && pincodeBool) {
            ServiceAdresse serviceAdresse = new ServiceAdresse();
            Adresse a = new Adresse(nom.getText(), prenom.getText(), Integer.parseInt(phone.getText()), email.getText(), pays.getValue(), ville.getValue(), etat.getValue().toString(), Integer.parseInt(pincode.getText()), adresse.getText());
            serviceAdresse.ajouter(a);
            Notifications notificationBuilder = Notifications.create()
                    .title("Confrimation Ajout Adresse")
                    .text("Adresse ajoutée avec succès")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificationBuilder.showConfirm();

//            f.notification("Succès", "Adresse ajoutée avec succès");
            ServiceCommande serviceCommande = new ServiceCommande();
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateCommande = dateFormat.format(date);
            Commande commande = new Commande(Total, "non paye", dateCommande, user.getId(), serviceAdresse.getLastAdresse());
            serviceCommande.ajouter(commande);
            Notifications notificationBuilder2 = Notifications.create()
                    .title("Confrimation Commande")
                    .text("Commande ajoutée avec succès")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificationBuilder2.showConfirm();
            // f.notification("Succès", "Votre commande a été validée avec succès");
            SendEmail sm;
            sm = new SendEmail("romuald.motchehokamguia@esprit.tn", "validation de commande", "votre commande chez cyclepro a été validée avec "
                    + "success");
            Notifications notificationBuilder3 = Notifications.create()
                    .title("Confrimation Envoi Mail")
                    .text("Mail envoyée avec succès consulter votre boîte mail")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificationBuilder3.showConfirm();
            //f.notification("Succès", "Vérifiez votre boite mail ");

            ServiceLignePanier serviceLignePanier = new ServiceLignePanier();
            for (Panier p : panier) {
                serviceLignePanier.ajouter(new LignePanier(p.getQuantite(), serviceCommande.getLastCommande(), p.getIdProduit()));
            }
            Notifications notificationBuilder4 = Notifications.create()
                    .title("Confrimation Ajout des produits au panier")
                    .text("produits du panier ont été ajoutés dans la base de données")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificationBuilder4.showConfirm();
            //JOptionPane.showMessageDialog(null, "Produits ajoutés au panier");

            Alert dg = new Alert(Alert.AlertType.CONFIRMATION);
            dg.setTitle("ConfrimationDialogbox");
            dg.setContentText("Paiement Paypal");
            dg.setHeaderText("Effectuer le paiement");
            dg.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Commande/Payment.fxml"));
                    Parent fxml;
                    try {
                        fxml = Loader.load();
                        PaymentController e = Loader.getController();
                        e.redirection(centerContent, panier, user, Total, serviceCommande.getLastCommande());
                        centerContent.getChildren().removeAll();
                        new FadeInDown(fxml).play();
                        centerContent.getChildren().setAll(fxml);
                    } catch (IOException ex) {
                        Logger.getLogger(AdresseController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdresseController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
            );
            //serviceCommande.historique(user, Total);// génération de la facture 
            //JOptionPane.showMessageDialog(null, "Facture générée");

            try {

            } catch (Exception e) {
                System.err.println(e);
            }

        } else {
            //f.notification("Erreur", "problème dans les champs");
            JOptionPane.showMessageDialog(null, "Erreur dans les champs");
            

        }
    }

    void redirection(AnchorPane c, ObservableList<Panier> p, User u, int t) {

        centerContent = c;
        user = u;
        Total = t;
        if (panier.isEmpty()) {
            panier.addAll(p);
        } else {
            panier.clear();
            panier.addAll(p);
        }
    }

}
