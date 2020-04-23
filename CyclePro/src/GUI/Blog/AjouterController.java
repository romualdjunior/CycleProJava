/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Utils.DataSource;
import Service.Blog.ServiceArticle;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Entitie.Blog.Article;
import animatefx.animation.FadeInDown;
import java.io.File;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouterController implements Initializable {
    @FXML private ComboBox <String> cbCat;
    @FXML private TextField txT;
    @FXML private TextField txA;
    @FXML private DatePicker dateD;
    @FXML private TextArea txC;
    @FXML private TextField txP;
    @FXML private AnchorPane centerContent;
    @FXML private Pane PanePhoto; 
    
    
             @FXML private AnchorPane ajt;   

   // @FXML private ImageView IV;
    
    private ObservableList <String>list = FXCollections.observableArrayList("Sport","Nutrition","Cyclisme","Bien etre");
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbCat.setItems(list);
    }

    @FXML 
    public void Choose(ActionEvent event){
       
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
   
        fileChooser.setTitle("Choisir une image: ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp")
        );
             if(selectedFile != null){
            txP.setText(selectedFile.getName());
            
            
            Image image=new Image("/images/"+selectedFile.getName());
                        javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
                        imageview.setFitWidth(135);
                        imageview.setFitHeight(158);
                        PanePhoto.getChildren().add(imageview);
                        
            //ImageIcon imgicon=new ImageIcon();
        }else{
            System.out.println("Fichier non valide! choisir une photo");
        }
        
    }
    
    @FXML
    public void insertArticle(ActionEvent event) throws IOException{
        LocalDate datebirt=dateD.getValue();
        String titre=txT.getText();
        String auteur=txA.getText();
        String contenue=txC.getText();
        String photo=txP.getText();
        String category=cbCat.getValue();
        //décroche mon appel messenger stp
        if(titre.isEmpty() || auteur.isEmpty()|| contenue.isEmpty()||
                photo.isEmpty()|| category.isEmpty()){
            Alert alert=new Alert(AlertType.ERROR);
            alert.setTitle("Ajout article");
            alert.setHeaderText("Information");
            alert.setContentText("Vérifiez vos données");
            alert.showAndWait();
        }
            else if (titre.matches("[a-zA-Z]")){
            Alert alert=new Alert(AlertType.ERROR);
            alert.setTitle("Ajout article");
            alert.setHeaderText("Information");
            alert.setContentText(" Le champ Titre contient des lettres ");
            alert.showAndWait();
        }    
            else if (auteur.matches("[a-zA-Z]")){
            Alert alert=new Alert(AlertType.ERROR);
            alert.setTitle("Ajout article");
            alert.setHeaderText("Information");
            alert.setContentText(" Le champ Auteur contient des lettres ");
            alert.showAndWait();
        }   
             else if ((titre.charAt(0) != (titre.toUpperCase().charAt(0))) || 
                     (auteur.charAt(0) != (auteur.toUpperCase().charAt(0))) ||
                     (contenue.charAt(0) != (contenue.toUpperCase().charAt(0)))){
            Alert alert=new Alert(AlertType.ERROR);
            alert.setTitle("Ajout article");
            alert.setHeaderText("Information");
            alert.setContentText(" Tous les champs commencent par MAJUSCULE ");
            alert.showAndWait();
        }      
            else if (contenue.matches("[a-zA-Z]")){
            Alert alert=new Alert(AlertType.ERROR);
            alert.setTitle("Ajout article");
            alert.setHeaderText("Information");
            alert.setContentText(" Le champ contenu contient des lettres ");
            alert.showAndWait();
        }
            
        else {
            
        Article A1=new Article();
        
        A1.setContenue(contenue);
        A1.setTitre(titre);
        A1.setAuteur(auteur);
        A1.setPhoto(photo);
        A1.setCategory(category);
        A1.setLikes(0);
        java.util.Date date = java.sql.Date.valueOf(datebirt);
        A1.setDate_art(date);
        
        ServiceArticle sa = new ServiceArticle();        
        sa.createArticle(A1);
        
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout article");
            alert.setHeaderText("Information");
            alert.setContentText("L'article est ajouté");
            alert.showAndWait();
                        
        }}
    
    @FXML
    private void clearArticle(){
    txA.clear();
    txT.clear();
    txC.clear();
    txP.clear();
    cbCat.setValue(null);
    dateD.setValue(null);
    }
    
        
    }

