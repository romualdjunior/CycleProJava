/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Fournisseur;
import Service.Stock.ServiceFournisseur;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author skand
 */
public class FournisseurfController implements Initializable {

    @FXML
    private TextField txtM;
    @FXML
    private TextField txtA;
    @FXML
    private TextField txtT;
    @FXML
    private TextField txtR;
    @FXML
    private TextField txtMail;
    @FXML
    private Text RaisonSociale;
    @FXML
    private Text matricule;
    @FXML
    private Text adresse;
    @FXML
    private Text mailtitre;
    @FXML
    private Button ajout;
    @FXML
    private Text telephone;
    @FXML
    private Button supp;
    @FXML
    private TableView<Fournisseur>  table;
    @FXML
    private TableColumn<Fournisseur,Integer> id;
    @FXML
    private TableColumn<Fournisseur,String> r;
    @FXML
    private TableColumn<Fournisseur,String> m;
    @FXML
    private TableColumn<Fournisseur,String> a;
    @FXML
    private TableColumn<Fournisseur,String> mail;
    @FXML
    private TableColumn<Fournisseur,String> t;
    @FXML
    private Button mod;

    ObservableList<Fournisseur> cls = FXCollections.observableArrayList();
    @FXML
    private TextField recherche;
    @FXML
    private Label id_label;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showFournisseur();
        RechercheAV();
        id_label.setVisible(false);

    }

    public void showFournisseur(){
        ServiceFournisseur rs = new ServiceFournisseur ();
        List<Fournisseur> liste = rs.affichier();
        for (Fournisseur aux : liste)
        {
            cls.add(new Fournisseur(aux.getId(), aux.getRaisonSociale(), aux.getMatricule(),aux.getAddresse(), aux.getMail(),aux.getTelephone()));
            table.setItems(cls);
            
        }
        id.setCellValueFactory(new PropertyValueFactory<Fournisseur,Integer>("id"));
        r.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("raisonSociale"));
        m.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("matricule"));
        a.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("addresse"));
        mail.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("mail"));
        t.setCellValueFactory(new PropertyValueFactory<Fournisseur,String>("telephone"));
        table.setItems(cls);
    }

    @FXML
    private void ajouter(MouseEvent event) {
        ServiceFournisseur SF = new ServiceFournisseur();
        SF.ajouter(new Fournisseur(txtR.getText(), txtT.getText(), txtMail.getText(), txtM.getText(), txtA.getText()));
        
        JOptionPane.showMessageDialog(null, "Fournisseur ajoutée !");
        fournisseurclear();
        cls.clear();
        showFournisseur();
                RechercheAV();

    }
    
    public void fournisseurclear()
    {
        txtR.setText("");
        txtT.setText("");
        txtMail.setText("");
        txtM.setText("");
        txtA.setText("");
        RechercheAV();
    }
    
    @FXML
    private void Fournisseur(ActionEvent event) {
    }

    @FXML
    private void supprimer(MouseEvent event) throws SQLException {
        table.setItems(cls);
        ObservableList<Fournisseur> allFourn,fr ;
        allFourn=table.getItems();
        fr=table.getSelectionModel().getSelectedItems();
        Fournisseur f = fr.get(0);
        ServiceFournisseur STD = new ServiceFournisseur(); // STD = Service TAB DEMANDE
        STD.supprimer(f);
        fr.forEach(allFourn::remove);
        cls.clear();
                RechercheAV();

        showFournisseur();
        fournisseurclear();

    }

    @FXML
    private void modifier(MouseEvent event) {
       
            ServiceFournisseur SF = new ServiceFournisseur();
            
            SF.modifier(new Fournisseur(Integer.parseInt(id_label.getText()), txtR.getText(), txtM.getText(),txtA.getText(), txtMail.getText(), txtT.getText()));
            fournisseurclear();
            cls.clear();
            showFournisseur();
     
        RechercheAV();
    }
    
    public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Fournisseur> filteredData = new FilteredList<>(cls, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(F -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (F.getAddresse().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
                                else if (String.valueOf(F.getId()).indexOf(lowerCaseFilter)!=-1)
                                {
                                    return true;
                                }
				else if (F.getRaisonSociale().toLowerCase().indexOf(lowerCaseFilter) != -1 )
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
		SortedList<Fournisseur> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);
    }

    @FXML
    private void change_Rai(TableColumn.CellEditEvent txt) {
        ServiceFournisseur fs= new ServiceFournisseur();
        Fournisseur tab_Fournselected = table.getSelectionModel().getSelectedItem();
        tab_Fournselected.setRaisonSociale(txt.getNewValue().toString());
        fs.modifier(tab_Fournselected);
    }

    @FXML
    private void change_mat(TableColumn.CellEditEvent txt) {
        ServiceFournisseur fs= new ServiceFournisseur();
        Fournisseur tab_Fournselected = table.getSelectionModel().getSelectedItem();
        tab_Fournselected.setMatricule(txt.getNewValue().toString());
        fs.modifier(tab_Fournselected);
    }

    @FXML
    private void change_add(TableColumn.CellEditEvent  txt) {
        ServiceFournisseur fs= new ServiceFournisseur();
        Fournisseur tab_Fournselected = table.getSelectionModel().getSelectedItem();
        tab_Fournselected.setAddresse(txt.getNewValue().toString());
        fs.modifier(tab_Fournselected);
    }

    @FXML
    private void change_mail(TableColumn.CellEditEvent txt) {
        ServiceFournisseur fs= new ServiceFournisseur();
        Fournisseur tab_Fournselected = table.getSelectionModel().getSelectedItem();
        tab_Fournselected.setMail(txt.getNewValue().toString());
        fs.modifier(tab_Fournselected);
    }

    @FXML
    private void change_tel(TableColumn.CellEditEvent txt) {
        ServiceFournisseur fs= new ServiceFournisseur();
        Fournisseur tab_Fournselected = table.getSelectionModel().getSelectedItem();
        tab_Fournselected.setTelephone(txt.getNewValue().toString());
        fs.modifier(tab_Fournselected);
    }

    @FXML
    private void tableauclicked(MouseEvent event) {
            table.setItems(cls);
            ObservableList<Fournisseur> allFourn,fr ;
            allFourn=table.getItems();
            fr=table.getSelectionModel().getSelectedItems();
            Fournisseur f = fr.get(0);
            id_label.setText(String.valueOf(f.getId()));
            txtR.setText(f.getRaisonSociale());
            txtT.setText(f.getTelephone());
            txtMail.setText(f.getMail());
            txtM.setText(f.getMatricule());
            txtA.setText(f.getAddresse()); 
            RechercheAV();
    }
    
}
