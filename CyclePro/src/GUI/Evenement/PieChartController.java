/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Service.Evenement.ParticipantsService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PieChartController implements Initializable {

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button buttonclear;
    @FXML
    private PieChart piechart;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButton1Action(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList(
                    new PieChart.Data("January", 100),
                    new PieChart.Data("February", 200),
                    new PieChart.Data("March", 50),
                    new PieChart.Data("April", 75),
                    new PieChart.Data("May", 110),
                    new PieChart.Data("June", 300),
                    new PieChart.Data("July", 111),
                    new PieChart.Data("August", 30),
                    new PieChart.Data("September", 75),
                    new PieChart.Data("October", 55),
                    new PieChart.Data("November", 225),
                    new PieChart.Data("December", 99));
         
        piechart.setTitle("Monthly Record");
        piechart.setData(pieChartData);
    }
     
    @FXML
    private void handleButton2Action(ActionEvent event) {
        
        
        ParticipantsService ps = new ParticipantsService();
        String ch = "Enfants ("+Integer.toString(ps.NbEnfant()*100/ps.Nbparticipants())+" % )";
         String ch1 = "Adolescents ("+Integer.toString(ps.NbAdo()*100/ps.Nbparticipants())+" % )";
         String ch2 = "Adulte ("+Integer.toString(ps.NbAdult()*100/ps.Nbparticipants())+" % )";
         String ch3 = "Personnees agées ("+Integer.toString(ps.NbPersonneAgees()*100/ps.Nbparticipants())+" % )";
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
              
             new PieChart.Data(ch, ps.NbEnfant()*100/ps.Nbparticipants()),
             new PieChart.Data(ch1, ps.NbAdo()*100/ps.Nbparticipants()),
             new PieChart.Data(ch2,ps.NbAdult()*100/ps.Nbparticipants() ),
             new PieChart.Data(ch3, ps.NbPersonneAgees()*100/ps.Nbparticipants())
             
         );
         
        piechart.setTitle("Analyse des evenements ");
        piechart.setData(pieChartData);
    }
     
    @FXML
    private void handleButtonClearAction(ActionEvent event) {
        ObservableList<PieChart.Data> pieChartData = 
                FXCollections.observableArrayList();
        piechart.setTitle("");
        piechart.setData(pieChartData);
    }
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        ParticipantsService ps = new ParticipantsService();
        String ch = "Enfants ("+Integer.toString(ps.NbEnfant()*100/ps.Nbparticipants())+" % )";
         String ch1 = "Adolescents ("+Integer.toString(ps.NbAdo()*100/ps.Nbparticipants())+" % )";
         String ch2 = "Adulte ("+Integer.toString(ps.NbAdult()*100/ps.Nbparticipants())+" % )";
         String ch3 = "Personnees agées ("+Integer.toString(ps.NbPersonneAgees()*100/ps.Nbparticipants())+" % )";
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
              
             new PieChart.Data(ch, ps.NbEnfant()*100/ps.Nbparticipants()),
             new PieChart.Data(ch1, ps.NbAdo()*100/ps.Nbparticipants()),
             new PieChart.Data(ch2,ps.NbAdult()*100/ps.Nbparticipants() ),
             new PieChart.Data(ch3, ps.NbPersonneAgees()*100/ps.Nbparticipants())
             
         );
         
        piechart.setTitle("Analyse des evenements ");
        piechart.setData(pieChartData);
    }    
    
}
