/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Accessoires;
import Entitie.Stock.Fournisseur;
import Entitie.Stock.Velo;
import Service.Stock.ServiceAccessoires;
import Service.Stock.ServiceFournisseur;
import Service.Stock.ServiceVelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class AffichierFournisseurController implements Initializable {
          ServiceFournisseur SF = new ServiceFournisseur();
 ServiceVelo SV = new ServiceVelo();
  ServiceAccessoires SA = new ServiceAccessoires();
     @FXML private TableView<Fournisseur> table ;
      @FXML private TableColumn<Fournisseur,Integer> id ;
      @FXML private TableColumn<Fournisseur,String> r ;
    @FXML private TableColumn<Fournisseur,String> t ;
     @FXML private TableColumn<Fournisseur,String> mail ;
      @FXML private TableColumn<Fournisseur,String> m ;
       @FXML private TableColumn<Fournisseur,String> a ;
    @FXML
    private TableView<Velo> table2;
    @FXML
    private TableColumn<Velo,Integer> I1;
    @FXML
    private TableColumn<Velo,String> T2;
    @FXML
    private TableColumn<Velo,String> T3;
    @FXML
    private TableColumn<Velo,Integer> I4;
    @FXML
    private TableColumn<Velo,String> T5;
      @FXML
    private TableColumn<Velo,Integer> I6;
    @FXML
    private TableColumn<Velo,Integer> I7;
    @FXML
    private TableColumn<Velo,Double> D8;
    @FXML
    private TableColumn<Velo,Double> D9;
    @FXML
    private TableColumn<Velo,String> T10;
    @FXML
    private TableColumn<Velo,Integer> I11;
    @FXML
    private TableColumn<Velo,String> T12;
    @FXML
    private TableColumn<Velo,String> T13;
    @FXML
    private TableColumn<Velo,String> T14;
    @FXML
    private TableColumn<Velo,Integer> I15;
    @FXML
    private TableColumn<Velo,String> T16;
    @FXML
    private TableColumn<Velo,String> T17;
    @FXML
    private TableColumn<Velo,String> T18;
    @FXML
    private TableColumn<Velo,String> T19;
    @FXML
    private TableColumn<Velo,String> T20;
    @FXML
    private TableView<Accessoires> table3;
    @FXML
    private TableColumn<Accessoires,Integer> II1;
    @FXML
    private TableColumn<Accessoires,String> TT2;
    @FXML
    private TableColumn<Accessoires,String> TT3;
    @FXML
    private TableColumn<Accessoires,String> TT4;
    @FXML
    private TableColumn<Accessoires,String> TT5;
    @FXML
    private TableColumn<Accessoires,Double> DD6;
    @FXML
    private TableColumn<Accessoires,String> TT7;
    @FXML
    private TableColumn<Accessoires,String> TT8;
    @FXML
    private TableColumn<Accessoires,String> TT9;
    @FXML
    private TableColumn<Accessoires,String> TT10;
    @FXML
    private TableColumn<Accessoires,Integer> II11;
    @FXML
    private TableColumn<Accessoires,String> TT12;
    @FXML
    private TableColumn<Accessoires,Integer> II13;
  
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       id.setCellValueFactory(new PropertyValueFactory<Fournisseur,Integer>("id"));
    	r.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("raisonSociale"));
        m.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("matricule"));
    	a.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("addresse"));
        mail.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("mail"));
    	t.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("telephone"));

    	table.setItems(SF.affichier());
        
          I1.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("id"));
    	T2.setCellValueFactory(new PropertyValueFactory<Velo,String>("marque"));
        T3.setCellValueFactory(new PropertyValueFactory<Velo,String>("couleur"));
    	I4.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("nbrDePlace"));
        T5.setCellValueFactory(new PropertyValueFactory<Velo,String>("taille"));
    	I6.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("qtEnStock"));
        I7.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("qtStockSecurite"));
    	D8.setCellValueFactory(new PropertyValueFactory<Velo,Double>("prixAchat"));
        D9.setCellValueFactory(new PropertyValueFactory<Velo,Double>("prixLocH"));
    	T10.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV"));
        I11.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("Fournisseur"));
    	T12.setCellValueFactory(new PropertyValueFactory<Velo,String>("categorie"));
        T13.setCellValueFactory(new PropertyValueFactory<Velo,String>("description"));
    	T14.setCellValueFactory(new PropertyValueFactory<Velo,String>("etat"));
        I15.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("soldee"));
    	T16.setCellValueFactory(new PropertyValueFactory<Velo,String>("type"));
        T17.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV1"));
    	T18.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV2"));   
        T19.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV3"));
        T20.setCellValueFactory(new PropertyValueFactory<Velo,String>("Caracteristiques"));
    	table2.setItems(SV.affichier());
        
        
         II1.setCellValueFactory(new PropertyValueFactory<Accessoires,Integer>("id"));
    	TT2.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("photoA"));
        TT3.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("nom"));
    	TT4.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("marque"));
        TT5.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("categorie"));
    	DD6.setCellValueFactory(new PropertyValueFactory<Accessoires,Double>("prix"));
        TT7.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("description"));
    	TT8.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("photoA1"));
        TT9.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("photoA2"));
    	TT10.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("photoA3"));
        II11.setCellValueFactory(new PropertyValueFactory<Accessoires,Integer>("soldee"));
    	TT12.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("Caracteristiques"));
        II13.setCellValueFactory(new PropertyValueFactory<Accessoires,Integer>("qtEnStock"));
        table3.setItems(SA.affichier());
    }    
 



    
}
