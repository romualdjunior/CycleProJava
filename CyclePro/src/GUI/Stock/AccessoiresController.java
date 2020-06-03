/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Accessoires;
import Entitie.Stock.Fournisseur;
import Service.Stock.ServiceAccessoires;
import Service.Stock.ServiceFournisseur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class AccessoiresController implements Initializable {
 ServiceAccessoires SA = new ServiceAccessoires();
     private TextField ID;
    private TextField IDM;
     private TextField txt1;
    @FXML
     private TextField txt2;
     @FXML
     private TextField txt3;
     private TextField txt4;
     @FXML
     private TextField txt5;
    @FXML
     private TextField txt6;
     private TextField txt7;
     private TextField txt8;
     private TextField txt9;
   @FXML
     private TextField txt10;
   @FXML
     private TextField txt11;
    @FXML
     private TextField txt12;
     @FXML
    private Button btn1;
   @FXML private TableView<Accessoires> table3;
   @FXML private TableColumn<Accessoires,Integer> II1;
  @FXML  private TableColumn<Accessoires,ImageView> TT2;
  @FXML  private TableColumn<Accessoires,String> TT3;
   @FXML private TableColumn<Accessoires,String> TT4;
   @FXML private TableColumn<Accessoires,String> TT5;
   @FXML private TableColumn<Accessoires,Double> DD6;
  @FXML  private TableColumn<Accessoires,String> TT7;
   @FXML private TableColumn<Accessoires,String> TT8;
  @FXML  private TableColumn<Accessoires,String> TT9;
  @FXML  private TableColumn<Accessoires,String> TT10;
  @FXML  private TableColumn<Accessoires,Integer> II11;
  @FXML  private TableColumn<Accessoires,String> TT12;
  @FXML  private TableColumn<Accessoires,Integer> II13;
    private TextField S;
    @FXML
    private Text photo1;
    @FXML
    private Text photo2;
    @FXML
    private Text photo3;
    @FXML
    private Button Ph;
    @FXML
    private Button Ph1;
    @FXML
    private Button Ph2;
    @FXML
    private Button Ph3;
    @FXML
    private Label l_ph;
    @FXML
    private Label l_ph1;
    @FXML
    private Label l_ph2;
    @FXML
    private Label l_ph3;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    ObservableList<Accessoires> cls = FXCollections.observableArrayList();
    @FXML
    private Label id_label;
    @FXML
    private TextField rechercher;
    @FXML
    private Label l_t;
    @FXML
    private Label l_t1;
    @FXML
    private Label lt2;
    @FXML
    private Label l_t3;
    @FXML
    private ComboBox<String> combobox_categorie;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String categorie[] = {"Remorques & Poussettes", "Eclairage","Compteurs","Béquilles","Sieges enfants","Sacoches & Paniers vélo","porte-Bagage","Montres cardio & sports","Equipement Cyclotourisme","Systeme de navigation GPS","Sonnettes","Entretient & Reparation","Casques & Chapeaux","Lunette & Masques","ac & Sac à do","Tenus","Nutrition sportive & Soins corporels","Rangement & Transport","Pieces Detachees","Bidons & Porte-bidons","Autres"};
       combobox_categorie.setItems(FXCollections.observableArrayList(categorie));
        showAccessoires();
       RechercheAV();
       id_label.setVisible(false);
       
       l_t.setVisible(false);
       l_t1.setVisible(false);
       lt2.setVisible(false);
       l_t3.setVisible(false);
    }    

        
    public void showAccessoires(){
        ServiceAccessoires rs = new ServiceAccessoires();
        List<Accessoires> liste = rs.affichier();
        for (Accessoires aux : liste)
        {
             
            File file;
            file = new File(aux.getPhotoA());
            //Image imagee = new Image(file.toURI().toString());
            ImageView imagee=ImageViewBuilder.create()
                .image(new Image(file.toURI().toString()))
                .build();
            cls.add(new Accessoires(aux.getId(), aux.getPhotoA(),aux.getNom(), aux.getMarque(),  aux.getCategorie(),aux.getPrix(),aux.getDescription(), aux.getPhotoA1(),  aux.getPhotoA2(),  aux.getPhotoA3(),aux.getSoldee(),aux.getCaracteristiques(), aux.getQtEnStock(),imagee));
            table3.setItems(cls);    
        }
        II1.setCellValueFactory(new PropertyValueFactory<Accessoires,Integer>("id"));
    	//TT2.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("photoA"));
        TT2.setCellValueFactory(new PropertyValueFactory<Accessoires,ImageView>("image"));
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
        table3.setItems(cls);
    }
    
    @FXML
    private void AjouterAccessoires(ActionEvent event) {
           ServiceAccessoires SA = new ServiceAccessoires();
SA.ajouter(new Accessoires(l_ph.getText(), txt2.getText(), txt3.getText(), combobox_categorie.getValue(), (double)Integer.parseInt(txt5.getText()), txt6.getText(), l_ph1.getText(), l_ph2.getText(), l_ph3.getText(), Integer.parseInt(txt10.getText()), txt11.getText(), Integer.parseInt(txt12.getText())));
        JOptionPane.showMessageDialog(null, "Accessoires ajoutée !");
        cls.clear();
        showAccessoires();
            RechercheAV();
    }

    private void Supprimer(ActionEvent event) {
          ServiceAccessoires SA = new ServiceAccessoires();
   
         SA.supprimer(new Accessoires (Integer.parseInt(ID.getText())));
     JOptionPane.showMessageDialog(null, "Accessoires SUPPRIME !");
        showAccessoires();
            RechercheAV();
    }

    private void Modifier(ActionEvent event)  throws IOException{
        ServiceAccessoires SA = new ServiceAccessoires();

         SA.modifier(new Accessoires (Integer.parseInt(IDM.getText()),txt1.getText(), txt2.getText(), txt3.getText(), combobox_categorie.getValue(), (double)Integer.parseInt(txt5.getText()), txt6.getText(), txt7.getText(), txt8.getText(), txt9.getText(), Integer.parseInt(txt10.getText()), txt11.getText(), Integer.parseInt(txt12.getText())));
     JOptionPane.showMessageDialog(null, "Accessoires Modifier !");
     showAccessoires();
         RechercheAV();
     
    }
    
    public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Accessoires> filteredData = new FilteredList<>(cls, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(F -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (F.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
                                else if (String.valueOf(F.getId()).indexOf(lowerCaseFilter)!=-1)
                                {
                                    return true;
                                }
				else if (F.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1 )
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
		SortedList<Accessoires> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table3.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table3.setItems(sortedData);
    }
    

    private void Seatch(ActionEvent event) {
        II1.setCellValueFactory(new PropertyValueFactory<Accessoires,Integer>("id"));
    	TT2.setCellValueFactory(new PropertyValueFactory<Accessoires,ImageView>("image"));
        //TT2.setCellValueFactory(new PropertyValueFactory<Accessoires,String>("photoA"));
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
        table3.setItems(SA.search(S.getText()));
    }

    @FXML
    private void uploadPhoto1(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Ph.getScene().getWindow()).getPath();
        l_ph.setText(path);
    }

    @FXML
    private void uploadPhoto2(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Ph1.getScene().getWindow()).getPath();
        l_ph1.setText(path);
    }

    @FXML
    private void uploadPhoto3(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Ph2.getScene().getWindow()).getPath();
        l_ph2.setText(path);
    }

    @FXML
    private void uploadPhoto4(ActionEvent event) {
        FileChooser fc = new FileChooser();
        String path = fc.showOpenDialog(Ph3.getScene().getWindow()).getPath();
        l_ph3.setText(path);
    }

    @FXML
    private void SupprimerAccessoires(ActionEvent event) {
        table3.setItems(cls);
        ObservableList<Accessoires> allAc,Ac ;
        allAc=table3.getItems();
        Ac=table3.getSelectionModel().getSelectedItems();
        Accessoires A= Ac.get(0);
        ServiceAccessoires STD = new ServiceAccessoires(); // STD = Service TAB DEMANDE
        STD.supprimer(A);
        Ac.forEach(allAc::remove);
        cls.clear();
        RechercheAV();
        showAccessoires();
        Accessoirclear();
    }

    @FXML
    private void modifierAccessoires(ActionEvent event) {
       
            ServiceAccessoires Ac = new ServiceAccessoires();
            Accessoires a=new Accessoires(Integer.parseInt(id_label.getText()),l_ph.getText(), txt2.getText(), txt3.getText(), combobox_categorie.getValue(), Double.parseDouble(txt5.getText()), txt6.getText(), l_ph1.getText(), l_ph2.getText(), l_ph3.getText(), Integer.parseInt(txt10.getText()), txt11.getText(), Integer.parseInt(txt12.getText()));
            if(l_ph.getText().length()==0)
            {
                a.setPhotoA(l_t.getText());
                a.setPhotoA1(l_t1.getText());
                a.setPhotoA2(lt2.getText());
                a.setPhotoA3(l_t3.getText());
            }
            Ac.modifier(a);
            Accessoirclear();
            cls.clear();
            showAccessoires();
       
        RechercheAV();
    }
    public void Accessoirclear()
    {
        id_label.setText("");
        txt2.setText(""); 
        txt3.setText("");
        combobox_categorie.getSelectionModel().select("");
        txt5.setText("");
        txt6.setText("");
        txt10.setText("");
        txt11.setText("");
        txt12.setText("");
        l_ph.setText("");
        l_ph1.setText("");
        l_ph2.setText("");
        l_ph3.setText("");
        l_t.setText("");
        l_t1.setText("");
        lt2.setText("");
        l_t3.setText("");
    }

    @FXML
    private void tableauclick(MouseEvent event) {
            table3.setItems(cls);
            ObservableList<Accessoires> allac,ac ;
            allac=table3.getItems();
            ac=table3.getSelectionModel().getSelectedItems();
            Accessoires a = ac.get(0);
            id_label.setText(String.valueOf(a.getId()));
            txt2.setText(a.getNom()); 
            txt3.setText(a.getMarque());
            combobox_categorie.getSelectionModel().select(a.getCategorie());
            txt5.setText(String.valueOf(a.getPrix()));
            txt6.setText(a.getDescription());
            txt10.setText(String.valueOf(a.getSoldee()));
            txt11.setText(a.getCaracteristiques());
            txt12.setText(String.valueOf(a.getQtEnStock()));
            
            l_t.setText(a.getPhotoA());
            l_t1.setText(a.getPhotoA1());
            lt2.setText(a.getPhotoA2());
            l_t3.setText(a.getPhotoA3());
            RechercheAV();
    }
    
    
    
}
