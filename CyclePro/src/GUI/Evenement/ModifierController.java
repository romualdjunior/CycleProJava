/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;

import Entitie.Evenement.Event;
import static GUI.Evenement.AjouterController.getDate;
import Service.Evenement.EventService;
import animatefx.animation.FadeIn;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierController implements Initializable {

    @FXML
    private DatePicker dateDebut;
    @FXML
    private Button add;
    @FXML
    private TextArea Description;
    @FXML
    private TextField Nom;
    @FXML
    private TextField emailt;
    @FXML
    private Button clear;
    @FXML
    private DatePicker dateFin;
    @FXML
    private ComboBox<String> Niveau;
    @FXML
    private ComboBox<String> Membre;
    @FXML
    private TextField Prix;
    @FXML
    private TextField Adresse;
    @FXML
    private TextField NbrPlace;
    @FXML
    private TextField AtDep;
    @FXML
    private TextField Tel;
    @FXML
    private ComboBox<String> Type;
    @FXML
    private TextField AtAr;
    @FXML
    private TextField LongAr;
    @FXML
    private TextField LongDep;
    @FXML
    private TextField Photo;
    AnchorPane centerContent;
   AfficherController aj = new AfficherController();
    File pfile;
   int file;
    @FXML
    private ImageView Image;
    Event event;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateEvent(ActionEvent event) {
        
        
    }
   @FXML
    private void Load(ActionEvent event) throws MalformedURLException {
        
          
                  FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image: ");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp")
        );
        Window stage = null;
        pfile = fileChooser.showOpenDialog(stage);

        /* - draw image */
        if (pfile != null) {
            file=1;
            Image image = new Image(pfile.toURI().toURL().toExternalForm());
            Image.setImage(image);
            Photo.setText( pfile.getName());
    }
    }
    @FXML
    private void clearEvent(ActionEvent event) {
    }
     public static boolean isEmailAdress(String email){
    Pattern p = Pattern.compile(" ^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$ ");
    Matcher m = p.matcher(email.toUpperCase());
return m.matches();
}
    public boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}
     public boolean estFloat(String chaine) {
		try {
			Float.parseFloat(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}
     public static java.util.Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
     
     
     
     @FXML
     
    public void modifier() throws IOException{
        
       String type =Type.getValue();
        String niveau=Niveau.getValue();
        String membre=Membre.getValue();
        String nbrplace=NbrPlace.getText();
        String nom=Nom.getText();
        String description=Description.getText();
        String latitudeDep=AtDep.getText();
        String latitudeArv=AtAr.getText();
        String photo=Photo.getText();
        String tel=Tel.getText();
        String adresse=Adresse.getText();
        String Email=emailt.getText();
        String longiAr = LongAr.getText();
        String longiDeb = LongAr.getText();
        
        EventService es = new EventService();    
        
       

        LocalDate DateDeb=dateDebut.getValue();
        LocalDate DateFin=dateFin.getValue();
        if(nbrplace.isEmpty() || nom.isEmpty()|| description.isEmpty()||
                photo.isEmpty()|| latitudeDep.isEmpty()|| latitudeArv.isEmpty()||
                tel.isEmpty()|| adresse.isEmpty() || Email.isEmpty()
                
                ){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ajout Evenement");
            alert.setHeaderText("Information");
            alert.setContentText("Vérifiez vos données");
            alert.showAndWait();
        }else {
         java.util.Date date = getDate(DateDeb.getYear(),DateDeb.getMonth().getValue(),DateDeb.getDayOfMonth());
         java.sql.Date dated = new java.sql.Date(date.getTime());
         java.util.Date datef = getDate(DateFin.getYear(),DateFin.getMonth().getValue(),DateFin.getDayOfMonth());
         java.sql.Date sqlDatef = new java.sql.Date(datef.getTime());
        if (dated.compareTo(datef) > 0) {
            System.out.println("Date debut est superieur à date fin !! ");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Date debut est superieur à date fin !! ");
            alert.showAndWait();
      
           }else{
        event.setDateDebut(dated);
        event.setDateFin(sqlDatef);
        if(!estUnEntier(tel)&& tel.length()!=8){
        System.out.println("Le numero de telephone est incorrecte! ");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Le numero de telephone est incorrecte! ");
            alert.showAndWait();
        }else{
        event.setTel(Integer.parseInt(tel));
         if(!estFloat(latitudeArv)||!estFloat(latitudeDep)||!estFloat(longiAr)||!estFloat(longiDeb)){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("verifiez vos données ");
            alert.showAndWait();
        }else{
        event.setLatitudeArrv(Float.parseFloat(latitudeArv));
        event.setLatitudeDep(Float.parseFloat(latitudeDep));
        event.setLongitudeArrv(Float.parseFloat(longiAr));
        event.setLatitudeDep(Float.parseFloat(longiDeb));
        }
          
            event.setEmail(Email);
       
        event.setAdresse(adresse);
        event.setDescription(description);
        event.setPhotoEvent(photo);
        event.setMembre(membre);
        event.setNiveau(niveau);
        event.setType(type);
        event.setNom(nom);
        es.modifier(event);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("evenement modifié avec succé");
            alert.showAndWait();
            alert.close();
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Evenement/Afficher.fxml"));

        Parent fxml = Loader.load();

        AfficherController e = Loader.getController();
        e.redirection(centerContent);
       
        centerContent.getChildren().removeAll();

        new FadeIn(fxml).play();
        centerContent.getChildren().setAll(fxml);
        
        
        }}} 
    
    }
     @FXML
    public void redirection(AnchorPane c,Event event ){
        centerContent=c;
        Description.setText(event.getDescription());
        Adresse.setText(event.getAdresse());
        Photo.setText(event.getPhotoEvent());
        Membre.setValue(event.getMembre());
        Niveau.setValue(event.getNiveau());
        Type.setValue(event.getType());
        Nom.setText(event.getNom());
        Tel.setText(Integer.toString(event.getNbrplace()));
        Prix.setText(Float.toString(event.getPrix()));
        NbrPlace.setText(Float.toString(event.getNbrplace()));
        AtDep.setText(Float.toString(event.getLatitudeDep()));
        AtAr.setText(Float.toString(event.getLatitudeArrv()));
        String nomT= event.getNom();
        LongDep.setText(Float.toString(event.getLogitudeDep()));
        LongAr.setText(Float.toString(event.getLongitudeArrv()));
        emailt.setText(event.getEmail());
        dateFin.setValue(event.getDateFin().toLocalDate());
        dateDebut.setValue(event.getDateDebut().toLocalDate());
        this.event=event;
        }
    
}
