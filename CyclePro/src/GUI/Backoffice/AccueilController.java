/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Backoffice;

import Entitie.Commande.CommandeAdresse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class AccueilController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private TableView<CommandeAdresse> commandeAdresse;

    @FXML
    private TableColumn<CommandeAdresse, Integer> total;

    @FXML
    private TableColumn<CommandeAdresse, String> etat;

    @FXML
    private TableColumn<CommandeAdresse, String> date;

    @FXML
    private TableColumn<CommandeAdresse, Integer> idUser;

    @FXML
    private TableColumn<CommandeAdresse, String> adresseLivraison;

    @FXML
    private TableColumn<CommandeAdresse, Button> modifier;

    @FXML
    private TableColumn<CommandeAdresse, Button> supprimer;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
