package GUI.Login;

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
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class SignInController implements Initializable{

    @FXML
    private Label SignIn;

    @FXML
    private JFXTextField User;
        @FXML
    private JFXButton connection;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }   

    @FXML
    void typingUsername(ActionEvent event) {
          System.out.println("manger");
    }
      @FXML
    void connecting(ActionEvent event) {
           System.out.println("it is connecting");
    }

}
