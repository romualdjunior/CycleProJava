/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			FlowPane flowPane = new FlowPane();
			// vertikaler Abstand
			flowPane.setVgap(6);
			// horizontaler Abstand
			flowPane.setHgap(3);
			// geqwünschte Einschiebungslänge
			flowPane.setPrefWrapLength(400);
		    for (int i = 0; i < 20; i++) {
		   	 	flowPane.getChildren().add(new Button("Button"));
		    }
		    scene.setRoot(flowPane);
			primaryStage.setScene(scene);
			primaryStage.show();
        
        
          }
  public static void main(String[] args) {
		launch(args);
	}
}
