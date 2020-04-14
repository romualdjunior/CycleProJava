package GUI.Login;
import animatefx.animation.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//j'ai fini de travailler merci infiniment pour tout ce que vous faites pour moi 
public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/Backoffice/Backoffice.fxml"));
        primaryStage.setTitle("CyclePro");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
                primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
