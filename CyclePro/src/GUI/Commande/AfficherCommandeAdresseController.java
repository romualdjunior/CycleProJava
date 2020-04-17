/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Commande;

import Entitie.Commande.CommandeAdresse;
import Entitie.Commande.Panier;
import Service.Commande.ServiceCommande;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class AfficherCommandeAdresseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<CommandeAdresse> commandeAdresseView;

    @FXML
    private TableColumn<CommandeAdresse, Integer> total;

    @FXML
    private TableColumn<CommandeAdresse, String> etat;

    @FXML
    private TableColumn<CommandeAdresse, String> date;

    @FXML
    private TableColumn<CommandeAdresse, String> username;

    @FXML
    private TableColumn<CommandeAdresse, String> email;

    @FXML
    private TableColumn<CommandeAdresse, String> pays;

    @FXML
    private TableColumn<CommandeAdresse, String> ville;

    @FXML
    private TableColumn<CommandeAdresse, String> adresseLivraison;

    @FXML
    private TableColumn<CommandeAdresse, Integer> pincode;

    @FXML
    private TableColumn<CommandeAdresse, Button> modifier;

    @FXML
    private TableColumn<CommandeAdresse, Button> supprimer;
    @FXML
    private TextField filterField;
    ObservableList<CommandeAdresse> list = FXCollections.observableArrayList();
    AnchorPane centerContent;
    String page;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        total.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, Integer>("total"));
        etat.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, String>("etat"));
        date.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, String>("date"));
        username.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, String>("username"));
        email.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, String>("email"));
        pays.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, String>("pays"));
        ville.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, String>("ville"));
        adresseLivraison.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, String>("adresseLivraison"));
        pincode.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, Integer>("pincode"));
        modifier.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, Button>("modifier"));
        supprimer.setCellValueFactory(new PropertyValueFactory<CommandeAdresse, Button>("supprimer"));
        ServiceCommande serviceCommande = new ServiceCommande();
        try {
            list.addAll(serviceCommande.readAll2());
            System.out.println(list);
            System.out.println("manger");
        } catch (SQLException ex) {
            Logger.getLogger(AfficherCommandeAdresseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FilteredList<CommandeAdresse> filteredData = new FilteredList<>(list, p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(commandeAdresse -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (Integer.toString(commandeAdresse.getTotal()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (commandeAdresse.getEtat().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (commandeAdresse.getDate().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (commandeAdresse.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (commandeAdresse.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (commandeAdresse.getVille().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (commandeAdresse.getPays().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (commandeAdresse.getAdresseLivraison().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (Integer.toString(commandeAdresse.getPincode()).toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });
        SortedList<CommandeAdresse> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(commandeAdresseView.comparatorProperty());
        commandeAdresseView.setItems(sortedData);
    }

    @FXML
    void displaySelected(MouseEvent event) {
        CommandeAdresse selected = commandeAdresseView.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        selected.getSupprimer().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Iterator<CommandeAdresse> it = list.iterator();
                while (it.hasNext()) {
                    CommandeAdresse c = it.next();
                    if (c.equals(selected)) {
                        it.remove();
                        ServiceCommande serviceCommande = new ServiceCommande();
                        try {
                            serviceCommande.delete(selected.getIdCommande());

                        } catch (SQLException ex) {
                            Logger.getLogger(AfficherCommandeAdresseController.class.getName()).log(Level.SEVERE, null, ex);
                             Notifications notificationBuilder = Notifications.create()
                                                .title("Confrimation suppression commande")
                                                .text("Commande supprimée avec succès")
                                                .graphic(null)
                                                .hideAfter(Duration.seconds(5))
                                                .position(Pos.BOTTOM_RIGHT);
                                        notificationBuilder.showConfirm();
                            //JOptionPane.showMessageDialog(null, "CommandeAdresse supprimée avec succès ");

                        }
                        commandeAdresseView.refresh();

                    }
                }
            }
        });
        selected.getModifier().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Iterator<CommandeAdresse> it = list.iterator();
                while (it.hasNext()) {
                    CommandeAdresse c = it.next();
                    if (c.equals(selected)) {
                        try {
                            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Commande/ModifierCommandeAdresse.fxml"));
                            Parent fxml = Loader.load();
                            ModifierCommandeAdresseController m = Loader.getController();
                            m.redirection(centerContent, page, selected.getIdAdresse());
                            centerContent.getChildren().removeAll();
                            new FadeInDown(fxml).play();
                            centerContent.getChildren().setAll(fxml);
                        } catch (IOException ex) {
                            Logger.getLogger(AfficherCommandeAdresseController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }
        });

    }

    public void redirection(AnchorPane centerContent, String page) {
        this.centerContent = centerContent;
        this.page = page;
    }

    @FXML
    void StatistiquesAction(ActionEvent event) {
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Commande/Statistique.fxml"));
            Parent fxml = Loader.load();
            StatistiqueController m = Loader.getController();
            m.redirection(centerContent, page);
            centerContent.getChildren().removeAll();
            new FadeInDown(fxml).play();
            centerContent.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(AfficherCommandeAdresseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
