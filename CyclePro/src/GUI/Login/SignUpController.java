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
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class SignUpController implements Initializable{

    @FXML
    private Label SignIn;

    @FXML
    private JFXTextField user;  
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;

    
        @FXML
    private JFXButton connection;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequiredFieldValidator requiredFieldValidator=new RequiredFieldValidator(); 
        requiredFieldValidator.setMessage("Champ obligatoire");
             ValidatorBase specialCharacter = new ValidatorBase() {
                @Override
                protected void eval() {
                    setMessage("Pas de caractères spéciaux ");
                    if (user.getText().matches("^[a-zA-Z0-9éèà]+$")) {
                        hasErrors.set(false);
                    } else hasErrors.set(true);
                }
            };
             ValidatorBase emailValidator = new ValidatorBase() {
                @Override
                protected void eval() {
                    setMessage("entrer une adresse mail valide");
                    if (email.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                        hasErrors.set(false);
                    } else hasErrors.set(true);
                }
            };
             ValidatorBase passWordValidator = new ValidatorBase() {
                @Override
                protected void eval() {
                    setMessage("longueur supérieure ou égale à 10 ");
                    if (password.getText().length()<10) {
                        hasErrors.set(true);
                    } else hasErrors.set(false);
                }
            };
             user.getValidators().addAll(requiredFieldValidator,specialCharacter); 
             password.getValidators().addAll(requiredFieldValidator,passWordValidator);
             email.getValidators().addAll(requiredFieldValidator,emailValidator);

        user.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(!newValue){
                user.validate();
            }
        });
        email.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(!newValue){
                email.validate();
            }
        });
        password.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if(!newValue){
                password.validate();
            }
        });
       
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
