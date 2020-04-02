/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Evenement;


import Service.Evenement.ParticipantsService;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.NumberAxisBuilder;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class Stat extends Application{
    public StackedAreaChart createStackedChart() {
        NumberAxis xAxis = NumberAxisBuilder.create()
                .label("X Values")
                .lowerBound(1.0d)
                .upperBound(9.0d)
                .tickUnit(2.0d).build();

        NumberAxis yAxis = NumberAxisBuilder.create()
                .label("Y Values")
                .lowerBound(0.0d)
                .upperBound(30.0d)
                .tickUnit(2.0d).build();

        ObservableList<StackedAreaChart.Series> areaChartData = FXCollections.observableArrayList(
                new StackedAreaChart.Series("Series 1", FXCollections.observableArrayList(
                        new StackedAreaChart.Data(0, 4),
                        new StackedAreaChart.Data(2, 5),
                        new StackedAreaChart.Data(4, 4),
                        new StackedAreaChart.Data(6, 2),
                        new StackedAreaChart.Data(8, 6),
                        new StackedAreaChart.Data(10, 8)
                )),
                new StackedAreaChart.Series("Series 2", FXCollections.observableArrayList(
                        new StackedAreaChart.Data(0, 8),
                        new StackedAreaChart.Data(2, 2),
                        new StackedAreaChart.Data(4, 9),
                        new StackedAreaChart.Data(6, 7),
                        new StackedAreaChart.Data(8, 5),
                        new StackedAreaChart.Data(10, 7)
                )),
                new StackedAreaChart.Series("Series 3", FXCollections.observableArrayList(
                        new StackedAreaChart.Data(0, 2),
                        new StackedAreaChart.Data(2, 5),
                        new StackedAreaChart.Data(4, 8),
                        new StackedAreaChart.Data(6, 6),
                        new StackedAreaChart.Data(8, 9),
                        new StackedAreaChart.Data(10, 7)
                ))
        );
        return new StackedAreaChart(xAxis, yAxis, areaChartData);
    }
     public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       init(primaryStage);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("FX Chart Demo");
       StackPane root = new StackPane(this.createPieChart());
 
       Scene scene = new Scene(root, 600, 600);
 
       primaryStage.setScene(scene);
 
       primaryStage.show();
    
    }
    
      private void init(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root,500,530);
        primaryStage.setScene(scene);

        StackedAreaChart stackedAreaChart = createStackedChart();
        PieChart pieChart = createPieChart();
        
        root.getChildren().add(stackedAreaChart);
        root.getChildren().add(pieChart);
    }

       public PieChart createPieChart() {
          ParticipantsService ps = new ParticipantsService();
          int participant = ps.afficher().size();
           System.out.println(participant);
           
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
        return new PieChart(pieChartData);
    }

    
}
