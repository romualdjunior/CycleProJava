package GUI.Login;

import Service.User.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import animatefx.animation.*;
import animatefx.util.ParallelAnimationFX;
import animatefx.util.SequentialAnimationFX;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import java.sql.SQLException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
public class SignInController implements Initializable{

    @FXML
    private Label SignIn;
    @FXML
    private JFXTextField emailUsername;
    @FXML
    private JFXPasswordField password;    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }   

    @FXML
    void typingUsername(ActionEvent event) {
          System.out.println("manger");
    }
      @FXML
    void connecting(ActionEvent event) throws SQLException, IOException {
        UserService userService=new UserService();
          System.out.println(emailUsername.getText());
          System.out.println(password.getText());
          if (userService.connexion(emailUsername.getText(), password.getText())) {
          Parent root = FXMLLoader.load(getClass().getResource("/GUI/Frontend/Loading.fxml"));
          Stage stage=(Stage)emailUsername.getScene().getWindow();
          stage.close();
          Stage stage2=new Stage();
        stage2.setTitle("CyclePro");
        Scene scene = new Scene(root);
        stage2.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage2.initStyle(StageStyle.DECORATED);
        stage2.show();

          }
          else JOptionPane.showMessageDialog(null, "Identifianats invalides");

    }

}
