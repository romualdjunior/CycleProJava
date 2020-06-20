/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Offre;
import Service.Stock.ServiceOffre;
import Utils.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yasmine
 */
public class OffreController implements Initializable {

    @FXML
    private TextField pourcentage;
    @FXML
    private ComboBox<String> combobox_velo;
    @FXML
    private DatePicker dateD;
    @FXML
    private DatePicker dateF;
    @FXML
    private TableColumn<Offre, Integer> id;
    @FXML
    private TableColumn<Offre, Integer> v;
    @FXML
    private TableColumn<Offre, Integer> p;
    @FXML
    private TableColumn<Offre, Double> np;
    @FXML
    private TableColumn<Offre, Date> dd;
    @FXML
    private TableColumn<Offre, Date> df;
    @FXML
    private Button ajouter;
     private Statement ste;
    ObservableList<Offre> cls = FXCollections.observableArrayList();
     @FXML
    private TableView<Offre>  table;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         combobox_velo.setItems(FXCollections.observableArrayList(getData()));
    }    
 private List<String> getData() {
        Connection con = DataSource.getInstance().getCnx();
        List<String> strings = new ArrayList<>();
        try {
            ste=con.createStatement();
            String query="select * from Velo";
            ResultSet rs=ste.executeQuery(query);
            while(rs.next())
            {
                strings.add(rs.getString("marque"));
            }
           return strings;
        } catch (SQLException ex) {
            Logger.getLogger(VeloController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    @FXML
    private void ajouterO(ActionEvent event) {
          ServiceOffre SO = new ServiceOffre();
//SO.ajouter(new Offre( Integer.parseInt(pourcentage.getText()),Integer.parseInt(combobox_velo.getValue()), (double)Integer.parseInt(nvprix.getText()),dateD.getText(),dateF.getText() ));
        JOptionPane.showMessageDialog(null, "offre ajoutée !");
        cls.clear();
       
    }
    public void showOffre(){
        ServiceOffre rs = new ServiceOffre ();
        List<Offre> liste = rs.affichier();
        for (Offre aux : liste)
        {
            cls.add(new Offre(aux.getId(), aux.pourcentage, aux.getVelo(),aux.nvPrix, aux.getDateDebut(),aux.getDateFin()));
            table.setItems(cls);
            
        }
        id.setCellValueFactory(new PropertyValueFactory<Offre,Integer>("id"));
        p.setCellValueFactory(new PropertyValueFactory<Offre,Integer>("pourcentage"));
        v.setCellValueFactory(new PropertyValueFactory<Offre,Integer>("velo"));
        np.setCellValueFactory(new PropertyValueFactory<Offre,Double>("nvPrix"));
        dd.setCellValueFactory(new PropertyValueFactory<Offre,Date>("dateDebut"));
        df.setCellValueFactory(new PropertyValueFactory<Offre,Date>("dateFin"));
        table.setItems(cls);
    }
    
}
