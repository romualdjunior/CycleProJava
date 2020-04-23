/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Service.Blog.ServiceArticle;
import Utils.DataSource;
import animatefx.animation.FadeInDown;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierController implements Initializable {

    @FXML private TableView<Article> tabArt;
    @FXML private TableColumn tabCat;
    @FXML private TableColumn tabTitre;
    @FXML private TableColumn tabCont;
    @FXML private TableColumn tabDate;
    @FXML private TableColumn tabAut;
    @FXML private TableColumn tabLike;
    @FXML private TableColumn tabComt;
    @FXML private AnchorPane centerContent;
    @FXML private TextField textCat;
    @FXML private Pane PanePhoto;
    @FXML private TextField search;
    @FXML private Label nbrArt;


    ObservableList<Article> data;
    
    @FXML
    void view (ActionEvent event)throws IOException{
            //selectionner
        Article ar=tabArt.getSelectionModel().getSelectedItem();
        FXMLLoader Loader=new FXMLLoader(getClass().getResource("/GUI/Blog/AfficherComt.fxml"));
         Parent fxml=Loader.load();
         AfficherComtController e=Loader.getController();
         e.redirection(centerContent,ar);
         centerContent.getChildren().removeAll();
         new FadeInDown(fxml).play();
         centerContent.getChildren().setAll(fxml);
         
    }  
    
        @FXML
    void modif (ActionEvent event)throws IOException{
    
         Article article=tabArt.getSelectionModel().getSelectedItem();
         FXMLLoader Loader=new FXMLLoader(getClass().getResource("/GUI/Blog/ModifierArticle.fxml"));
         Parent fxml=Loader.load();
         ModifierArticleController p=Loader.getController();
         p.redirection(centerContent,article);
         centerContent.getChildren().removeAll();
         new FadeInDown(fxml).play();
         centerContent.getChildren().setAll(fxml);
                 
    } 
    
        @FXML
    void supprimer (ActionEvent event)throws IOException{
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation du  suppression");
            alert.setHeaderText("Confirmation de suppression");
            alert.setContentText("étes-vous Sur ?");

            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK){
            
            Article ar=tabArt.getSelectionModel().getSelectedItem();
            tabArt.getItems().removeAll(ar);
            ServiceArticle sa=new ServiceArticle();
            sa.deleteArticle(ar);}
            
            else{
            }
            
             
        try{String req="Select count(Likes)from Article ";
        Connection cnx = DataSource.getInstance().getCnx();
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                       String nbr=rs.getString("count(Likes)");
                       nbrArt.setText(nbr);
                    }
        
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       

    }   
    
    @FXML 
    private void search(KeyEvent Key){
	FilteredList<Article> filteredData = new FilteredList<>(data, p -> true);

	search.textProperty().addListener((observable, oldValue, newValue) -> {
		filteredData.setPredicate(item -> {
			if(newValue == null || newValue.isEmpty() )
				return true;
                        
			if( (item.getTitre().toLowerCase().contains(newValue.toLowerCase())) ||
                                ((item.getAuteur().toLowerCase().contains(newValue.toLowerCase()))) ||
                                (item.getContenue().toLowerCase().contains(newValue.toLowerCase())) ||
                                (item.getCategory().toLowerCase().contains(newValue.toLowerCase()))
                                )
                                {
				return true;
			} else {
				return false;
			}

		});
	});

	SortedList<Article> sortedData = new SortedList<>(filteredData);

	sortedData.comparatorProperty().bind(tabArt.comparatorProperty());

                tabArt.setItems(sortedData);


}
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceArticle as= new ServiceArticle();
                
         tabCat.setCellValueFactory(
            new PropertyValueFactory<Article,String>("category")
        );
          tabTitre.setCellValueFactory(
            new PropertyValueFactory<Article,String>("titre")
        );
          tabAut.setCellValueFactory(
            new PropertyValueFactory<Article,String>("auteur")
        );

         tabDate.setCellValueFactory(
            new PropertyValueFactory<Article,Date>("date_art")
        );
         tabCont.setCellValueFactory(
            new PropertyValueFactory<Article,String>("contenue")
        );
          tabLike.setCellValueFactory(
            new PropertyValueFactory<Article,Integer>("likes")
        );
          tabComt.setCellValueFactory(
            new PropertyValueFactory<Article,Integer>("this.Commentaires.size()")
        );
        
        data = FXCollections.observableArrayList();
        data.addAll(as.readAllArticle());
        data.forEach(System.out::println);
        tabArt.setItems(data);
        data.forEach(System.out::println);
        
        
        try{String req="Select count(Likes)from Article ";
        Connection cnx = DataSource.getInstance().getCnx();
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                       String nbr=rs.getString("count(Likes)");
                       nbrArt.setText(nbr);
                    }
        
            }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }  
    
   public void redirection(AnchorPane c){
       centerContent=c;
       
   }
    
}
