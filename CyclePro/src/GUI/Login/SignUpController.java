package GUI.Login;

import Entitie.User.BCrypt;
import Entitie.User.User;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.JOptionPane;

public class SignUpController implements Initializable {

    @FXML
    private Label SignIn;

    @FXML
    private JFXTextField user;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    private boolean userbool;
    private boolean emailbool;
    private boolean passwordbool;

    @FXML
    private JFXButton connection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userbool = emailbool = passwordbool = false;
        RequiredFieldValidator requiredFieldValidator = new RequiredFieldValidator();
        requiredFieldValidator.setMessage("Champ obligatoire");
        ValidatorBase specialCharacter = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("Pas de caractères spéciaux ");
                if (user.getText().matches("^[a-zA-Z0-9éèà]+$")) {
                    userbool = true;
                    hasErrors.set(false);
                } else {
                    hasErrors.set(true);
                    userbool = false;
                }
            }
        };
        ValidatorBase emailValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("entrer une adresse mail valide");
                if (email.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    hasErrors.set(false);
                    emailbool = true;
                } else {
                    hasErrors.set(true);
                    emailbool = false;
                }
            }
        };
        ValidatorBase passWordValidator = new ValidatorBase() {
            @Override
            protected void eval() {
                setMessage("longueur supérieure ou égale à 10 ");
                if (password.getText().length() < 3) {
                    hasErrors.set(true);
                    passwordbool = false;
                } else {
                    hasErrors.set(false);
                    passwordbool = true;
                }
            }
        };
        user.getValidators().addAll(requiredFieldValidator, specialCharacter);
        password.getValidators().addAll(requiredFieldValidator, passWordValidator);
        email.getValidators().addAll(requiredFieldValidator, emailValidator);

        user.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                user.validate();
            }
        });
        email.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                email.validate();
            }
        });
        password.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (!newValue) {
                password.validate();
            }
        });

    }

    @FXML
    void typingUsername(ActionEvent event) {
        System.out.println("manger");
    }

    @FXML
    void connecting(ActionEvent event) throws SQLException {
        if (emailbool && userbool && passwordbool) {
            UserService userService = new UserService();
            String hashed = userService.passwordEncryption(password.getText());
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String last_login = dateFormat.format(date);
            System.out.println(last_login);
            User u = new User(user.getText(), user.getText(), email.getText(), email.getText(), 1, "", hashed, last_login, "", "", "");
            userService.ajouter(u);
        } else {
            JOptionPane.showMessageDialog(null, "Vous devez remplir correctement les champs");
        }

    }

}
