/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import Service.Blog.ServiceArticle;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierArticleController implements Initializable {
        //modif
    @FXML private ComboBox <String> cbCat;
    @FXML private TextField txT;
    @FXML private TextField txA;
    @FXML private DatePicker dateD;
    @FXML private TextArea txC;
    @FXML private TextField txP;
    @FXML private Pane PanePhoto;
    private ObservableList <String>list = FXCollections.observableArrayList("Sport","Nutrition","Cyclisme","Bien etre");

        AnchorPane centerContent;
        Article article;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }   
    @FXML
    public void Save (ActionEvent event){
        //recuperation   
        LocalDate datebirt=dateD.getValue();
        String titre=txT.getText();
        String auteur=txA.getText();
        String contenue=txC.getText();
        String photo=txP.getText();
        String category=cbCat.getValue();
            if(titre.isEmpty() || auteur.isEmpty()|| contenue.isEmpty()||
            photo.isEmpty()|| category.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modification article");
            alert.setHeaderText("Information");
            alert.setContentText("Vérifiez vos données");
            alert.showAndWait();
        }else {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation du  modification");
            alert.setHeaderText("Confirmation de modification");
            alert.setContentText("étes-vous Sur ?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
        
        //setter
        article.setContenue(contenue);
        article.setTitre(titre);
        article.setAuteur(auteur);
        article.setPhoto(photo);
        article.setCategory(category);
        article.setLikes(0);
        java.util.Date date = java.sql.Date.valueOf(datebirt);
        article.setDate_art(date);
        
        ServiceArticle sa=new ServiceArticle();
        sa.updateArticle(article);}
            else {
            }

      }}
    
    @FXML 
    public void Choose(ActionEvent event){
       
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null){
            txP.setText(selectedFile.getName());
            
            Image image=new Image("/images/"+selectedFile.getName());
                        javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
                        imageview.setFitWidth(135);
                        imageview.setFitHeight(158);
                        PanePhoto.getChildren().add(imageview);
                        
        }else{
            System.out.println("Fichier non valide! choisir une photo");
        }
    }
    
        @FXML
    public void redirection(AnchorPane c,Article article ){
        centerContent=c;
        this.article=article;
        
         cbCat.setItems(list);
        
        Image image=new Image("/images/"+article.getPhoto());
        javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
        imageview.setFitWidth(135);
        imageview.setFitHeight(158);
        PanePhoto.getChildren().add(imageview);
         
        String auteur=article.getAuteur();
        String category=article.getCategory();
        String contenue=article.getContenue();
        Date datArt=(Date) article.getDate_art();
        String photo=article.getPhoto();
        String titre=article.getTitre();
        
        txC.setText(contenue);
        txA.setText(auteur);
        txT.setText(titre);
        txP.setText(photo);
        cbCat.setValue(category);
        dateD.setValue(datArt.toLocalDate());
        
        
        }
      
        
}

