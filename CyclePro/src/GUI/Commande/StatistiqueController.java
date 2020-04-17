/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Commande;

import Service.Commande.ServiceCommande;
import animatefx.animation.BounceIn;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class StatistiqueController implements Initializable {

    @FXML
    private Pane banner;

    @FXML
    private BarChart<?, ?> statVentes;

    @FXML
    private CategoryAxis mois;

    @FXML
    private NumberAxis nbreVentes;
    AnchorPane centerContent;
    String page;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new BounceIn(banner).play();
        ServiceCommande serviceCommande = new ServiceCommande();
        int[] stats = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        try {
            stats = serviceCommande.statistiques();
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("Janvier", stats[0]));
        set1.getData().add(new XYChart.Data("Février", stats[1]));
        set1.getData().add(new XYChart.Data("Mars", stats[2]));
        set1.getData().add(new XYChart.Data("Avril", stats[3]));
        set1.getData().add(new XYChart.Data("Mai", stats[4]));
        set1.getData().add(new XYChart.Data("Juin", stats[5]));
        set1.getData().add(new XYChart.Data("Juillet", stats[6]));
        set1.getData().add(new XYChart.Data("Août", stats[7]));
        set1.getData().add(new XYChart.Data("Septembre", stats[8]));
        set1.getData().add(new XYChart.Data("Octobre", stats[9]));
        set1.getData().add(new XYChart.Data("Novembre", stats[10]));
        set1.getData().add(new XYChart.Data("Dècembre", stats[11]));
        statVentes.getData().addAll(set1);

    }

    void redirection(AnchorPane centerContent, String page) {
        this.centerContent = centerContent;
        this.page = page;
    }
}
