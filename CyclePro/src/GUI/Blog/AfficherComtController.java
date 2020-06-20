/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import Entitie.Blog.CommentaireArticle;
import Service.Blog.ServiceArticle;
import Service.Blog.ServiceComt;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class AfficherComtController implements Initializable {

     @FXML private TableView<CommentaireArticle> tabComt;
    @FXML private TableColumn tabTitre;
    @FXML private TableColumn tabUser;
    @FXML private TableColumn tabCont;
    @FXML private TableColumn tabDate;
        AnchorPane centerContent;
        Article article;
    
    ObservableList<CommentaireArticle> data;
    
          @FXML
    void supprimer (ActionEvent event)throws IOException{
         //recuperer commentaire selectionné
        CommentaireArticle ca=tabComt.getSelectionModel().getSelectedItem();
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Confirmation de suppression");
                alert.setContentText("étes-vous Sur ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
              tabComt.getItems().removeAll(ca);
        ServiceComt sc=new ServiceComt();
        sc.deleteComt(ca);
            System.out.print("Confirmation de modification");

        } else {
            // ... user chose CANCEL or closed the dialog
        }
           
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     } 
    
    @FXML
    public void redirection(AnchorPane c,Article ar ){
        centerContent=c;
        article=ar;
       
        ServiceComt sc= new ServiceComt();
        
         tabTitre.setCellValueFactory(cm-> new SimpleStringProperty(ar.getTitre()));
        // tabUser.setCellValueFactory(cm-> new SimpleStringProperty()
        //);
         tabDate.setCellValueFactory(
            new PropertyValueFactory<CommentaireArticle,Date>("date_comt")
        );
         tabCont.setCellValueFactory(
            new PropertyValueFactory<CommentaireArticle,String>("contenue")
        );
       
        data = FXCollections.observableArrayList();
        
        data.addAll(sc.getCommentsByArticle(ar.getId()));
        data.forEach(System.out::println);
        tabComt.setItems(data);
        data.forEach(System.out::println);
       
         
    
}
}