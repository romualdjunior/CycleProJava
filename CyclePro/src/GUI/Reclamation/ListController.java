/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Reclamation;

import Entitie.Reclamation.Reclamation;
import Entitie.User.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author mywindows
 */
public class ListController implements Initializable {

    IService.Reclamation.IService<Reclamation> sr = new Service.Reclamation.ServiceReclamation();    
    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Reclamation> table_reclamations;

    @FXML
    private TableColumn<Reclamation, Integer> id;

    @FXML
    private TableColumn<Reclamation, String> user;
    
    @FXML
    private TableColumn<Reclamation, String> categorie;

    @FXML
    private TableColumn<Reclamation, String> label;

    @FXML
    private TableColumn<Reclamation, String> desc;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        id.setCellValueFactory(new PropertyValueFactory<Reclamation, Integer>("id"));
        user.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("userName"));
        categorie.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("categorieName"));
        label.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("label"));
        desc.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("desc"));
        this.populate();
    }
    
    @FXML
    private void handleAdd(ActionEvent event) {
        
    }
    
    @FXML
    private void handleUpdate(ActionEvent event) {
        Reclamation reclamation = table_reclamations.getSelectionModel().getSelectedItem();
        try {
            sr.supprimer(reclamation);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }        
    }
    
    @FXML
    private void handleDelete(ActionEvent event) {
        Reclamation reclamation = table_reclamations.getSelectionModel().getSelectedItem();
        try {
            sr.supprimer(reclamation);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }
    
    private void populate(){
        try{
            table_reclamations.getItems().setAll(sr.getAll());
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }
    
}
