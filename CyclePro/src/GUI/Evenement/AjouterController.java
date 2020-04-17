/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Evenement;
import Entitie.Evenement.Classe;
import Service.Evenement.EventService;
import Entitie.Evenement.Event;
import Service.Evenement.ClasseService;
import Service.Evenement.ParticipantsService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
 * @author toshiba
 */
public class AjouterController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML private ComboBox <String> Type;
    @FXML private ComboBox <String> Niveau;
    @FXML private ComboBox <String> Membre;
    @FXML private TextField AtDep;
    @FXML private TextField AtAr;
    @FXML private TextField LongAr;
    @FXML private TextField LongDeb;
    @FXML private TextField Nom;
    @FXML private DatePicker dateDebut;
    @FXML private DatePicker dateFin;
    @FXML private TextArea Description;
    @FXML private TextField Adresse;
    @FXML private TextField Prix;
    @FXML private TextField Tel;
    @FXML private TextField emailt;
     @FXML private TextField NbrPlace;
     @FXML private TextField Photo;
    File pfile;
   int file;
    @FXML
    private ImageView Image;
    @FXML private AnchorPane ajt;   

   // @FXML private ImageView IV;
    EventService es = new EventService();
    
    
     private ObservableList <String>ListMembre = FXCollections.observableArrayList("Enfants","Adolescents","Adultes","Personne agées");
     private ObservableList <String>listType = FXCollections.observableArrayList("Formation","Compétition");
     private ObservableList <String>listNiveau = FXCollections.observableArrayList("Débutant","Intermédiaire","Professionnel","Tous les niveaux");
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Membre.setItems(ListMembre);
        Niveau.setItems(listNiveau);
        Type.setItems(listType);
        
    }
    
    
    //image 
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
    public  boolean isEmailAdress(String email){
     String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);}

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
    public void insertEvent(ActionEvent event) throws IOException{
        
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
        String prix=Prix.getText();
        
        Event evt=new Event();
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
        evt.setDateDebut(dated);
        evt.setDateFin(sqlDatef);
        if(!estUnEntier(tel)&& tel.length()!=8){
        System.out.println("Le numero de telephone est incorrecte! ");
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Le numero de telephone est incorrecte! ");
            alert.showAndWait();
        }else{
        evt.setTel(Integer.parseInt(tel));
         if(!estFloat(latitudeArv)||!estFloat(latitudeDep)||!estFloat(longiAr)||!estFloat(longiDeb)||!estFloat(prix)){
       
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("verifiez vos données ");
            alert.showAndWait();
        }else{
             evt.setPrix(Float.parseFloat(prix));
        evt.setLatitudeArrv(Float.parseFloat(latitudeArv));
        evt.setLatitudeDep(Float.parseFloat(latitudeDep));
        evt.setLongitudeArrv(Float.parseFloat(longiAr));
        evt.setLatitudeDep(Float.parseFloat(longiDeb));
        }if((nbrplace.isEmpty()) || !estUnEntier(nbrplace)){
        
        Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("verifiez vos données ");
            alert.showAndWait();
        
        }else{
        
        evt.setNbrplace(Integer.parseInt(nbrplace));
        if(!isEmailAdress(Email)){
        Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("verifiez vos données ");
            alert.showAndWait();
        
        
        }else{
         evt.setEmail(Email);
         evt.setAdresse(adresse);
        evt.setDescription(description);
        evt.setPhotoEvent(photo);
        evt.setMembre(membre);
        evt.setNiveau(niveau);
        evt.setType(type);
        evt.setNom(nom);
        es.ajouter(evt);
            ClasseService cs = new ClasseService();
            ParticipantsService ps = new ParticipantsService();
    Classe c= new  Classe(ps.Nbparticipants(), "Adulte",ps.NbAdult() );
    Classe c1= new  Classe(ps.Nbparticipants(), "adolescents",ps.NbAdo() );
    Classe c2= new  Classe(ps.Nbparticipants(), "Enfants",ps.NbEnfant() );
    Classe c3= new  Classe(ps.Nbparticipants(), "Personnes agées",ps.NbPersonneAgees() );
    cs.modifier(c);
    cs.modifier(c1);
    cs.modifier(c2);
    cs.modifier(c3);   
        
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Evenement est ajouté avec succes !");
            alert.showAndWait();
            alert.close();
        }
         
        
        }
          
           
       
      
        }
        }
        
       
        
        
        
           
            

            
        }}
    
    @FXML
    private void clearEvent(){
    Nom.clear();
    Description.clear();
    NbrPlace.clear();
    Prix.clear();
    Niveau.setValue(null);
    Type.setValue(null);
    }
    
           
    
}
