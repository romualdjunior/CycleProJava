/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import Entitie.Blog.View;
import Service.Blog.ServiceArticle;
import Service.Blog.ServiceView;
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

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ViewBackController implements Initializable {

  @FXML private TableView<View> tabView;
    @FXML private TableColumn tabDate;
    @FXML private TableColumn tabUser;
    @FXML private TableColumn tabRate;
    @FXML private TableColumn tabCont;
    
        ObservableList<View> data;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ServiceView sv= new ServiceView();
                
         tabDate.setCellValueFactory(
            new PropertyValueFactory<View,Date>("dateView")
        );
          tabUser.setCellValueFactory(
            new PropertyValueFactory<View,Integer>("idUser")
        );
          tabRate.setCellValueFactory(
            new PropertyValueFactory<View,Integer>("rating")
        );

         tabCont.setCellValueFactory(
            new PropertyValueFactory<View,String>("contenueView")
        );
        
        data = FXCollections.observableArrayList();
        data.addAll(sv.readAllView());
        data.forEach(System.out::println);
        tabView.setItems(data);
        data.forEach(System.out::println);
        
    }    
    
}
