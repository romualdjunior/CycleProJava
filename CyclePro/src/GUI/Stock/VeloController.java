/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import animation.FadeInRightTransition;
import animation.FadeOutLeftTransition;
import Entitie.Stock.Fournisseur;
import Entitie.Stock.Offre;
import Entitie.Stock.Velo;
import Service.Stock.ServiceFournisseur;
import Service.Stock.ServiceOffre;
import Service.Stock.ServiceVelo;
import Utils.DataSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class VeloController implements Initializable {
      ServiceVelo SV = new ServiceVelo();
     private TextField ID;
 @FXML
     private TextField txt1;
     private TextField txt2;
     @FXML
     private TextField txt3;
     private TextField txt4;
     @FXML
     private TextField txt5;
    @FXML
     private TextField txt6;
     @FXML
     private TextField txt7;
    @FXML
     private TextField txt8;
     private TextField txt9;
     private TextField txt10;
     private TextField txt11;
    @FXML
     private TextField txt12;
     private TextField txt13;
    @FXML
     private TextField txt14;
    
     private TextField txt16;
     private TextField txt17;
     private TextField txt18;
     @FXML
     private TextField txt19;
    @FXML
    private Button btn;
      
    @FXML private TableView<Velo> table2;
    @FXML private TableColumn<Velo,Integer> I1;
    @FXML private TableColumn<Velo,String> T2;
    @FXML private TableColumn<Velo,String> T3;
    @FXML private TableColumn<Velo,Integer> I4;
    @FXML private TableColumn<Velo,String> T5;
   @FXML  private TableColumn<Velo,Integer> I6;
    @FXML private TableColumn<Velo,Integer> I7;
    @FXML private TableColumn<Velo,Double> D8;
    @FXML private TableColumn<Velo,Double> D9;
    @FXML private TableColumn<Velo,ImageView> T10;
   @FXML  private TableColumn<Velo,String> I11;
    @FXML private TableColumn<Velo,String> T12;
   @FXML  private TableColumn<Velo,String> T13;
    @FXML private TableColumn<Velo,String> T14;
    @FXML private TableColumn<Velo,Integer> I15;
    @FXML private TableColumn<Velo,String> T16;
    @FXML private TableColumn<Velo,String> T17;
    @FXML private TableColumn<Velo,String> T18;
    @FXML private TableColumn<Velo,String> T19;
    @FXML private TableColumn<Velo,String> T20;
    private TextField S;
    private Button Photo1btn;
    private  String img1="C:\\Users\\Yasmine\\Desktop\\Images";
    @FXML
    private ComboBox<String> combobox_fournisseur;
    @FXML
    private ComboBox<String> combobox_categorie;
     @FXML
    private ComboBox<String> combobox_type;
    @FXML
    private ComboBox<String> combobox_couleur;
    @FXML
    private ComboBox<String> combobox_taille;
    private Statement ste;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    
    ObservableList<Velo> cls = FXCollections.observableArrayList();
    @FXML
    private Label label_id;
    @FXML
    private Button Photo;
    @FXML
    private Button Photo1;
    @FXML
    private Button Photo2;
    @FXML
    private Button Photo3;
    @FXML
    private Label label_photo;
    @FXML
    private Label label_photo1;
    @FXML
    private Label label_photo11;
    @FXML
    private Label label_photo12;
    @FXML
    private StackPane trans;
    @FXML
    private Group groups;
    @FXML
    private AnchorPane loadPane;
    @FXML
    private AnchorPane blur;
    @FXML
    private AnchorPane blr;
   @FXML
    private ComboBox<String> combobox_etat;
     @FXML
    private TextField recherche;
    @FXML
    private Button offre;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        /*T10.setPrefWidth(20);
        T10.setCellValueFactory(new PropertyValueFactory<>("C:\\Users\\skand\\Desktop\\photo"));*/
      
        String couleurs[] = {"Noir", "Jaune", "Rouge","rose","marron","blanc"}; 
        String categories[] = {"Vélos de route", "Vélos de route Flat Bar", "Vélos de tourisme","Vélos hybrides","Vélos Cross","Vélos de transport","Autres"}; 
        String tailles[] = {"Grand", "Moyen", "Petit","Tres grand"};
         String type[] = {"location", "vendre"}; 
           String etat[] = {"Disponible", "Non Disponible"}; 
        combobox_fournisseur.setItems(FXCollections.observableArrayList(getData()));
        combobox_couleur.setItems(FXCollections.observableArrayList(couleurs));
        combobox_taille.setItems(FXCollections.observableArrayList(tailles));
         combobox_type.setItems(FXCollections.observableArrayList(type));
          combobox_etat.setItems(FXCollections.observableArrayList(etat));
        combobox_categorie.setItems(FXCollections.observableArrayList(categories));
        showVelo();
           RechercheAV();
        label_id.setVisible(false);
          /*try {
              passercommande();
          } catch (IOException ex) {
              Logger.getLogger(VeloController.class.getName()).log(Level.SEVERE, null, ex);
          }*/
        
    }    
    //fournisseur
    private List<String> getData() {
        Connection con = DataSource.getInstance().getCnx();
        List<String> strings = new ArrayList<>();
        try {
            ste=con.createStatement();
            String query="select * from fournisseur";
            ResultSet rs=ste.executeQuery(query);
            while(rs.next())
            {
                strings.add(rs.getString("raisonSociale"));
            }
           return strings;
        } catch (SQLException ex) {
            Logger.getLogger(FournisseurfController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   

    @FXML
    private void AjouterVelo(ActionEvent event) {
          ServiceVelo SV = new ServiceVelo();
SV.ajouter(new Velo(txt1.getText(),combobox_couleur.getValue(), Integer.parseInt(txt3.getText()), combobox_taille.getValue(), Integer.parseInt(txt5.getText()), Integer.parseInt(txt6.getText()), (double)Integer.parseInt(txt7.getText()), (double)Integer.parseInt(txt8.getText()),label_photo.getText(), combobox_fournisseur.getValue(), combobox_categorie.getValue(), txt12.getText(), combobox_etat.getValue(), Integer.parseInt(txt14.getText()), combobox_type.getValue(), label_photo1.getText(), label_photo11.getText(), label_photo12.getText(), txt19.getText()));
        JOptionPane.showMessageDialog(null, "velo ajoutée !");
        cls.clear();
        showVelo();
         RechercheAV();
    }
    
    private void Supprimer(ActionEvent event)  throws IOException{
         ServiceVelo SV = new ServiceVelo();
   
         SV.supprimer(new Velo (Integer.parseInt(ID.getText())));
     JOptionPane.showMessageDialog(null, "Velo SUPPRIME !");
     showVelo();
      RechercheAV();
     
    }
    
     public void showVelo() {        
        ServiceVelo rs = new ServiceVelo ();
        List<Velo> liste = rs.affichier();
        for (Velo aux : liste)
        {
            /*ImageView imagee;
            imagee=new ImageView(new Image(this.getClass().getResourceAsStream("photo.png")));*/
            
            File file;
            file = new File(aux.getPhotoV());
            //Image imagee = new Image(file.toURI().toString());
            ImageView imagee=ImageViewBuilder.create()
                .image(new Image(file.toURI().toString()))
                .build();

            cls.add(new Velo(aux.getId(), aux.getMarque(), aux.getCouleur(), aux.getNbrDePlace(), aux.getTaille(),aux.getQtEnStock(),aux.getQtStockSecurite(),aux.getPrixAchat(),aux.getPrixLocH(),aux.getPhotoV(), aux.getFournisseur(),aux.getCategorie(),aux.getDescription(),aux.getEtat(), aux.getSoldee(),  aux.getType(),    aux.getPhotoV1(), aux.getPhotoV2(),aux.getPhotoV3(),aux.getCaracteristiques(),imagee));
            table2.setItems(cls);    
        }
        
        I1.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("id"));
    	T2.setCellValueFactory(new PropertyValueFactory<Velo,String>("marque"));
        T3.setCellValueFactory(new PropertyValueFactory<Velo,String>("couleur"));
    	I4.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("nbrDePlace"));
        T5.setCellValueFactory(new PropertyValueFactory<Velo,String>("taille"));
    	I6.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("qtEnStock"));
        I7.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("qtStockSecurite"));
    	D8.setCellValueFactory(new PropertyValueFactory<Velo,Double>("prixAchat"));
        D9.setCellValueFactory(new PropertyValueFactory<Velo,Double>("prixLocH"));
    	T10.setCellValueFactory(new PropertyValueFactory<Velo,ImageView>("image"));
        //T10.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV"));
        I11.setCellValueFactory(new PropertyValueFactory<Velo,String>("Fournisseur"));
    	T12.setCellValueFactory(new PropertyValueFactory<Velo,String>("categorie"));
        T13.setCellValueFactory(new PropertyValueFactory<Velo,String>("description"));
    	T14.setCellValueFactory(new PropertyValueFactory<Velo,String>("etat"));
        I15.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("soldee"));
    	T16.setCellValueFactory(new PropertyValueFactory<Velo,String>("type"));
        T17.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV1"));
    	T18.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV2"));   
        T19.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV3"));
        T20.setCellValueFactory(new PropertyValueFactory<Velo,String>("Caracteristiques"));
        table2.setItems(cls);
        
     }

    private void Modifier(ActionEvent event) {
       ServiceVelo SV = new ServiceVelo();
         SV.modifier(new Velo(txt1.getText(),combobox_couleur.getValue(), Integer.parseInt(txt3.getText()), combobox_taille.getValue(), Integer.parseInt(txt5.getText()), Integer.parseInt(txt6.getText()), (double)Integer.parseInt(txt7.getText()), (double)Integer.parseInt(txt8.getText()),label_photo.getText(), combobox_fournisseur.getValue(), combobox_categorie.getValue(), txt12.getText(), combobox_etat.getValue(), Integer.parseInt(txt14.getText()), combobox_type.getValue(), label_photo1.getText(), label_photo11.getText(), label_photo12.getText(), txt19.getText()));
     JOptionPane.showMessageDialog(null, "Velo Modifier !");
     showVelo();
      RechercheAV();
    }

    private void Seatch(ActionEvent event) {
        I1.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("id"));
    	T2.setCellValueFactory(new PropertyValueFactory<Velo,String>("marque"));
        T3.setCellValueFactory(new PropertyValueFactory<Velo,String>("couleur"));
    	I4.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("nbrDePlace"));
        T5.setCellValueFactory(new PropertyValueFactory<Velo,String>("taille"));
    	I6.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("qtEnStock"));
        I7.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("qtStockSecurite"));
    	D8.setCellValueFactory(new PropertyValueFactory<Velo,Double>("prixAchat"));
        D9.setCellValueFactory(new PropertyValueFactory<Velo,Double>("prixLocH"));
    	T10.setCellValueFactory(new PropertyValueFactory<Velo,ImageView>("image"));
        //T10.setCellValueFactory(new PropertyValueFactory<Velo,Image>("photoV"));
        I11.setCellValueFactory(new PropertyValueFactory<Velo,String>("Fournisseur"));
    	T12.setCellValueFactory(new PropertyValueFactory<Velo,String>("categorie"));
        T13.setCellValueFactory(new PropertyValueFactory<Velo,String>("description"));
    	T14.setCellValueFactory(new PropertyValueFactory<Velo,String>("etat"));
        I15.setCellValueFactory(new PropertyValueFactory<Velo,Integer>("soldee"));
    	T16.setCellValueFactory(new PropertyValueFactory<Velo,String>("type"));
        T17.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV1"));
    	T18.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV2"));   
        T19.setCellValueFactory(new PropertyValueFactory<Velo,String>("photoV3"));
        T20.setCellValueFactory(new PropertyValueFactory<Velo,String>("Caracteristiques"));
    	table2.setItems(SV.search(S.getText()));}

    @FXML
    private void uploadPhoto1(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Photo.getScene().getWindow()).getPath();
        label_photo.setText(path);
    }

    @FXML
    private void supprimerVelo(ActionEvent event) {
        table2.setItems(cls);
        ObservableList<Velo> allVelo,vl;
        allVelo=table2.getItems();
        vl=table2.getSelectionModel().getSelectedItems();
        Velo v = vl.get(0);
        
        ServiceOffre Os=new ServiceOffre();
        Offre o=new Offre();
        o=Os.getOffre(v.getId());
        if(o!=null)
        {
            Os.supprimerV(v.getId());
        }
        
        ServiceVelo STD = new ServiceVelo(); // STD = Service TAB DEMANDE
        STD.supprimer(v);
        vl.forEach(allVelo::remove);
        cls.clear();
        showVelo();
        Veloclear();
         RechercheAV();
    }

    @FXML
    private void modifierVelo(ActionEvent event) {
        ServiceVelo vs = new ServiceVelo();
        vs.modifier(new Velo(Integer.parseInt(label_id.getText()),txt1.getText(),combobox_couleur.getValue(), Integer.parseInt(txt3.getText()), combobox_taille.getValue(), Integer.parseInt(txt5.getText()), Integer.parseInt(txt6.getText()), Double.parseDouble(txt7.getText()), Double.parseDouble(txt8.getText()),label_photo.getText(), combobox_fournisseur.getValue(), combobox_categorie.getValue(), txt12.getText(), combobox_etat.getValue(), Integer.parseInt(txt14.getText()), combobox_type.getValue(), label_photo1.getText(), label_photo11.getText(), label_photo12.getText(), txt19.getText()));
        Veloclear();
        cls.clear();
        showVelo();
         RechercheAV();
    }
    public void Veloclear()
    {
        txt1.setText("");
        label_id.setText("");
        label_photo.setText("");
        label_photo1.setText("");
        txt3.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        
        txt12.setText("");
          combobox_etat.getSelectionModel().select("");
        txt14.setText("");
          combobox_type.getSelectionModel().select("");
        txt19.setText("");
        combobox_categorie.getSelectionModel().select("");
        combobox_couleur.getSelectionModel().select("");
        combobox_fournisseur.getSelectionModel().select("");
        combobox_taille.getSelectionModel().select("");
        RechercheAV();
    }

    @FXML
    private void uploadPhoto2(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Photo1.getScene().getWindow()).getPath();
        label_photo1.setText(path);
    }

    @FXML
    private void uploadPhoto3(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Photo2.getScene().getWindow()).getPath();
        label_photo11.setText(path);
    }

    @FXML
    private void uploadPhoto4(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Photo3.getScene().getWindow()).getPath();
        label_photo12.setText(path);
    }

    public void passercommande(int id) throws IOException
    {   
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("CommandeV.fxml"));
        blr.setEffect(new GaussianBlur(10));
        new FadeInRightTransition(trans).play();
        AnchorPane pane = Loader.load();
        CommandeVController c = Loader.getController();
        //v.getId()
        c.setidvelo(id);
        loadPane.getChildren().setAll(pane);
     

    }

    @FXML
    private void tombolClose(ActionEvent event) {
        
        blr.setEffect(null);
        new FadeOutLeftTransition(trans).play();
        cls.clear();
      
        showVelo();
            RechercheAV();
    }

    @FXML
    private void commandeajout(MouseEvent event) throws IOException {
          
        if (event.getClickCount() == 2)
        {
            table2.setItems(cls);
            ObservableList<Velo> allVelo,vl ;
            allVelo=table2.getItems();
            vl=table2.getSelectionModel().getSelectedItems();
            Velo v = vl.get(0);
            if(v.getQtEnStock()<=v.getQtStockSecurite())
            {
                passercommande(v.getId());
            }
            
        }
        else if(event.getClickCount()==1)
        { 
            table2.setItems(cls);
            ObservableList<Velo> allVelo,vl ;
            allVelo=table2.getItems();
            vl=table2.getSelectionModel().getSelectedItems();
            Velo v = vl.get(0);
            
            label_id.setText(String.valueOf(v.getId()));
            txt1.setText(v.getMarque());
            txt3.setText(String.valueOf(v.getNbrDePlace()));
            txt5.setText(String.valueOf(v.getQtEnStock()));
            txt6.setText(String.valueOf(v.getQtStockSecurite()));
            txt7.setText(String.valueOf(v.getPrixAchat()));
            txt8.setText(String.valueOf(v.getPrixLocH()));
            txt12.setText(v.getDescription());
            combobox_etat.getSelectionModel().select(v.getEtat());
            txt14.setText(String.valueOf(v.getSoldee()));
             combobox_type.getSelectionModel().select(v.getType());
            txt19.setText(v.getCaracteristiques());
            label_photo.setText(v.getPhotoV());
            label_photo1.setText(v.getPhotoV1());
            label_photo11.setText(v.getPhotoV2());
            label_photo12.setText(v.getPhotoV3());
            combobox_categorie.getSelectionModel().select(v.getCategorie());
            combobox_couleur.getSelectionModel().select(v.getCouleur());
            combobox_fournisseur.getSelectionModel().select(String.valueOf(v.getFournisseur()));
            combobox_taille.getSelectionModel().select(v.getTaille());
              
        }
    }
    
      public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Velo> filteredData = new FilteredList<>(cls, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(V -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (V.getMarque().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
                                else if (String.valueOf(V.getId()).indexOf(lowerCaseFilter)!=-1)
                                {
                                    return true;
                                }
				else if (V.getType().toLowerCase().indexOf(lowerCaseFilter) != -1 )
                                {
                                    return true;
                                }    
				else
                                {
                                    return false; // Does not match.
                                }
				    	 
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Velo> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table2.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table2.setItems(sortedData);
                
    }

    @FXML
    private void offreclick(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("Offre.fxml"));
        blr.setEffect(new GaussianBlur(10));
        new FadeInRightTransition(trans).play();
        AnchorPane pane = Loader.load();
        loadPane.getChildren().setAll(pane);
    }
    
}


