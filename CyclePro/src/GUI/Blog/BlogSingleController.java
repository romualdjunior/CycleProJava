/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import Entitie.Blog.CommentaireArticle;
import Entitie.Blog.FavoriArticle;
//import Entitie.Blog.RatingArticle;
import Entitie.User.User;
import Service.Blog.ServiceArticle;
import Service.Blog.ServiceComt;
import Service.Blog.ServiceFavori;
//import Service.Blog.ServiceRatingArticle;
import Service.User.UserService;
import animatefx.animation.Bounce;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import org.fxmisc.richtext.InlineCssTextArea;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class BlogSingleController implements Initializable {

        @FXML private Pane banner;
        @FXML private Label DateComt;
        @FXML private Label nameUser;
        @FXML private Label affComt;
        @FXML private Label DateComt2;
        @FXML private Label nameUser2;
        @FXML private Label affComt2;
        
        @FXML private Label PStitle1;
        @FXML private Label PStitle2;
        @FXML private Label PSDate1;
        @FXML private Label PSDate2;
        @FXML private Pane img1;
        @FXML private Pane img2;
        
        @FXML private Pane PanePhoto;
        @FXML private Label LTitre;
        @FXML private Label LCont;
        @FXML private Rating rating;

        
        AnchorPane centerContent;
        User user;
        int  idArt;

        //Dictionnaire
        Dictionnaire dico =Dictionnaire.getOneDictionnaire("Français.txt");

        public static InlineCssTextArea area ;
        ContextMenu contexM=new ContextMenu();

        int taille=9;

        int positionCarret;
        int positionStartCurrentWord;
        int positionEndCurrentWord;

        static int positionStartWord;
        static int positionEndWord;
        static int positionStartWordAfter;
        static int positionEndWordAfter;
        static int positionStartWordBefore;
        static int positionEndWordBefore;

        String nomFichierCourant="";
        Boolean FichierEnregistrer=false;
        InlineCssTextArea AncienContenuDeFichier= new InlineCssTextArea(); 



         @FXML
         private VBox vbox;
         @FXML
         private Label nbMot;
         @FXML
         private Button btn;
         @FXML
         private ComboBox langCombo;
         @FXML
         private ImageView flag;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();

           //Recent posts
                      
           ServiceArticle sa=new ServiceArticle();
            List<Article> list = new ArrayList<>();
           list.addAll(sa.searchRecent());  

                      PStitle1.setText(list.get(0).getTitre());
                      String date = new SimpleDateFormat("yyyy-MM-dd").format(list.get(0).getDate_art());
                      PSDate1.setText(date);
                        javafx.scene.image.Image image=new javafx.scene.image.Image("/images/"+list.get(0).getPhoto());
                        javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
                        imageview.setFitWidth(95);
                        imageview.setFitHeight(79);
                        img1.getChildren().add(imageview);

                        
                        PStitle2.setText(list.get(1).getTitre());
                        String date2 = new SimpleDateFormat("yyyy-MM-dd").format(list.get(1).getDate_art());
                        PSDate2.setText(date2);
                        javafx.scene.image.Image image2=new javafx.scene.image.Image("/images/"+list.get(1).getPhoto());
                        javafx.scene.image.ImageView imageview2=new javafx.scene.image.ImageView(image2);
                        imageview2.setFitWidth(95);
                        imageview2.setFitHeight(79);
                        img2.getChildren().add(imageview2);

            //affichage par défaut des commentaires
            ServiceComt sc=new ServiceComt();
            List<CommentaireArticle> listC = new ArrayList<>();
            listC.addAll(sc.readComtDeux());
            
                //affichage Commentaire0                        
            affComt.setText(listC.get(0).getContenue());
            DateComt.setText(listC.get(0).getDateTime());
            nameUser.setText("Wiem"); //affichage nom user                    
        
            //affichage Commentaire1                        
            affComt2.setText(listC.get(1).getContenue());
            DateComt2.setText(listC.get(1).getDateTime());
            nameUser2.setText("Nada"); //affichage nom user  
        
            
            //Dictionnaire
                 
        //Mise à jour des itmes du langCombo        
        ListCell<Label> buttonCell = new ListCell<Label>() 
        {
           @Override protected void updateItem(Label item, boolean isEmpty) {
           super.updateItem(item, isEmpty);
           setText(item == null ? "" : item.getText());        
        }};     
        langCombo.setButtonCell(buttonCell);

        //Changement d'items du combo
        langCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Label>() {
         @Override public void changed(ObservableValue observableValue, Label oldLang, Label newLang) {
           if(oldLang!=null)
           {
               if(!newLang.getText().equals(oldLang.getText()))
               {
                   dico.ChangerDic(newLang.getText()+".txt");
                   flag.setImage(new javafx.scene.image.Image("test_fx/flags/"+newLang.getText()+".png"));
                   test(0,area.getLength());//Tester Tous
               }
           }
           else
           {
               if(!newLang.getText().equals("Français"))
               {
                   dico.ChangerDic(newLang.getText()+".txt");
                   flag.setImage(new javafx.scene.image.Image("test_fx/flags/"+newLang.getText()+".png"));
                   test(0,area.getLength());//Tester Tous
               }
           }
         }
    });
     

        area= new InlineCssTextArea() { 
            @Override
            public void paste() 
            {
                if(Clipboard.getSystemClipboard().hasString())
                {
                    int startIndex=area.getCaretPosition();
                    int endIndex=startIndex+Clipboard.getSystemClipboard().getString().length()-5;                    
                    area.replaceText(area.getCaretPosition(),area.getCaretPosition(), Clipboard.getSystemClipboard().getString());  
                    if(endIndex>=area.getText().length())endIndex=area.getText().length()-1;
                    test(startIndex, endIndex);
                }
            }   
            @Override
            public void cut()
            {
                final Clipboard clipboard = Clipboard.getSystemClipboard();
                final ClipboardContent content = new ClipboardContent();
                content.putString(area.getSelectedText());
                clipboard.setContent(content);  
                //pour supprimer le text selectionner
                area.replaceText(area.getSelection(), "");
                //compter les mots
                nbMot.setText("N° mot: "+new StringTokenizer(area.getText()).countTokens());
            } 
        };

        //le context menu des suggestions + copier coller couper
       contexM.setStyle("-fx-background-color: derive(#1d1d1d,20%);");
       
        MenuItem cut = new MenuItem();//====       
        Label lblCut = new Label("Couper");
        lblCut.setWrapText(true);
        lblCut.setPrefWidth(100);
        lblCut.setStyle("-fx-font-size: 13pt;");
        cut.setGraphic(lblCut);
        cut.setOnAction(event -> {
            area.cut();
        });//===        
        
         MenuItem copy = new MenuItem();//====   
        Label lblCopy = new Label("Copier");
        lblCopy.setWrapText(true);
        lblCopy.setPrefWidth(100);
        lblCopy.setStyle("-fx-font-size: 13pt;");
        copy.setGraphic(lblCopy);
        copy.setOnAction(event -> {
            area.copy();
        });//===
        
         MenuItem paste = new MenuItem();//====       
        Label lblPaste = new Label("Coller");
        lblPaste.setWrapText(true);
        lblPaste.setPrefWidth(100);
        lblPaste.setStyle("-fx-font-size: 13pt;");
        paste.setGraphic(lblPaste);
        paste.setOnAction(event -> { 
            area.paste();
        });//===
        
        //Application + Insersion du ContextMenu
        contexM.getItems().addAll(cut, copy, paste);
        area.setContextMenu(contexM);

        //eliminer le vertical scroll-bar
        area.setWrapText(true);

        //le richArea va prendre tous l'espace du VBox
        VBox.setVgrow(area, Priority.ALWAYS);

        //charger le fichier css
        area.getStylesheets().add(getClass().getResource("area.css").toExternalForm());

        //-----------
        area.styleProperty().set("-fx-background-color: transparent; -fx-font: 16 Helvetica;");
        area.setCursor(Cursor.TEXT);
        area.setStyle(0, "-fx-fill: black;"
                + "-fx-font: 16 Helvetica;");
        vbox.getChildren().add(area);
        area.requestFocus();

        btn.onActionProperty().set((EventHandler<ActionEvent>) (ActionEvent evt) -> {
            IndexRange range = area.getSelection();
            area.setStyle(range.getStart(), range.getEnd(), "-fx-fill: #FF6666;-fx-font: 16 Helvetica;");
            area.requestFocus();
        });
     
    //Evenement de clique gauche sur l'area
    area.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent e)
        {
           try // voir si la carret se trouve dans une position valide
           {
                if (e.getButton() == MouseButton.SECONDARY)
                {
                    String SelectedText=FiltreMot(GetTextSelect(area.getText(), area.getCaretPosition()));
                    //Cas du mot incorrect
                    if(!dico.CorrectOuPas(SelectedText))
                    {
                        //sauvgarde position caret

                        contexM.getItems().remove(0, contexM.getItems().size()-3);
                        List<MotCorrect> listMot = dico.Correction(SelectedText);
                        List<MenuItem> listMenu=new ArrayList<>();
                        int cpt=0;
                        for(MotCorrect mc: listMot)
                        {
                            cpt++;
                            if(cpt>=11)
                                    break;
                            else
                                listMenu.add(new MenuItem(mc.toString()));
                        }
                        for(MenuItem menu: listMenu)
                        {
                            menu.setOnAction(event -> {                        
                                changerMot(menu.getText());
                            });
                        }
                        MenuItem menuAjouterAuDico =new MenuItem();
                        Label lblAdd = new Label("Ajouter au Dictionnaire");
                        lblAdd.setWrapText(true);
                        lblAdd.setPrefWidth(150);
                        lblAdd.setStyle("-fx-font-size: 11pt;");
                        menuAjouterAuDico.setGraphic(lblAdd);
                        menuAjouterAuDico.setOnAction(event -> {                        
                                dico.AjouterMotAuDic(SelectedText);
                                area.setStyle(positionStartCurrentWord,positionEndCurrentWord,"-fx-fill: black;-fx-font: 16 Helvetica;");
                            });
                        listMenu.add(menuAjouterAuDico);
                        contexM.getItems().addAll(0,listMenu); 
                        
                        
                    }
                    else
                    {
                        contexM.getItems().remove(0, contexM.getItems().size()-3);
                    }
                }
           }catch(Exception ex){}//position de la carret invalide
           
            e.consume();
        }
    });
    
    //Evenement d'écriture dans l'area
    area.setOnKeyReleased(event -> {            
                    
                    //compter les mots
                    nbMot.setText("N° mot: "+new StringTokenizer(area.getText()).countTokens());
                    int xPoition=area.getCaretPosition();   
                    
                    if(event.getCode() == KeyCode.SPACE                                              
                       || event.getCode() == KeyCode.ENTER
                       || event.getCode() == KeyCode.TAB
                       || "'".equals(event.getText()) )
                    {
                        area.setStyle(area.getCaretPosition()-1, area.getCaretPosition(), "-fx-fill: black; -fx-font: 16 Helvetica;");
                        String premierMot=MyMethods.before(area.getText(),xPoition-2);
                        String deuxiemeMot=MyMethods.after(area.getText(), xPoition);
                        premierMot=FiltreMot(premierMot);
                        deuxiemeMot=FiltreMot(deuxiemeMot);
                        if(!"".equals(premierMot))
                            if(dico.CorrectOuPas(premierMot)==false)
                            {
                                marquerFaute(positionStartWordBefore, positionEndWordBefore);
                            }
                        else
                                marquerJuste(positionStartWordBefore, positionEndWordBefore);
                        if(!"".equals(deuxiemeMot))
                            if(dico.CorrectOuPas(deuxiemeMot)==false)
                            {
                                marquerFaute(positionStartWordAfter, positionEndWordAfter);
                            }
                        else
                                marquerJuste(positionStartWordAfter, positionEndWordAfter);
                    }
                    else if(event.getCode() != KeyCode.LEFT 
                            && event.getCode() != KeyCode.RIGHT)
                    {
                        //if(event.getCode() == KeyCode.BACK_SPACE  )
                            
                        String motCourrant=MyMethods.currentWord(area.getText(), xPoition-1);
                        motCourrant=FiltreMot(motCourrant);
                        if(!"".equals(motCourrant))
                            if(dico.CorrectOuPas(motCourrant)==false)
                            {
                                marquerFaute(positionStartWord, positionEndWord);
                            }
                        else
                            {
                                marquerJuste(positionStartWord, positionEndWord);
                            }
                      
                    }
        }); 

            
            
    }    
    @FXML void Commenter(ActionEvent event)throws IOException{
            String contenueComment=area.getText();
            int idUser= user.getId();
            System.out.println("contenue"+contenueComment);
            System.out.println("user"+idUser);
            
            //creation commentaire
            ServiceComt sc=new ServiceComt();
            CommentaireArticle c= new CommentaireArticle(); 
            c.setUser(idUser);
            c.setContenue(contenueComment);
            c.setArticle(idArt);
            sc.createComt(c);

            //date Systeme
            LocalDateTime local=LocalDateTime.now();
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YY/MM/dd h:mm a"); 
            System.out.println(dtf);
          
            System.out.println("nameUser"+user.getUsername());
            
            //affichage Commentaire                        
            affComt.setText(contenueComment);
            DateComt.setText(dtf.format(local));
            nameUser.setText(user.getUsername()); //affichage nom user
                        
            System.err.println("nbrRating"+rating.getRating());

            /*ServiceRatingArticle sr=new ServiceRatingArticle();
            RatingArticle r=new RatingArticle();
            r.setIdArt(idArt);
            r.setIdUser(idUser);
            r.setNbrRating((int) rating.getRating());
            sr.createRatingArticle(r);*/
            
          
        }
    
    
        @FXML void createFavorie(ActionEvent event){
            ServiceFavori sf=new ServiceFavori();
            FavoriArticle F=new FavoriArticle();
            F.setArticle(idArt);
            F.setUser(user.getId());
            sf.createFavori(F);
            
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout article");
            alert.setHeaderText("Information");
            alert.setContentText("L'article est ajouté à votre liste de favorit");
            alert.showAndWait();
        
        }

    //Dictionnaire
    public String confirmationEnregistrement()
   {
              Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez vous Enregistrer le texte courant?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
              alert.showAndWait();

              if (alert.getResult() == ButtonType.YES) {
                  enregistrerFichier();
                  return "yes";
              }
              else if (alert.getResult() == ButtonType.NO) {
                  return "no";
               
              }
              else
                  return "cancel";
    }      
   public void nouveauFichier()
   {
        
        if((FichierEnregistrer==false && !area.getText().equals("")) || !area.getText().equals(AncienContenuDeFichier.getText()))
        {
           String resultat = confirmationEnregistrement();
           if("yes".equals(resultat) || "no".equals(resultat) )
           {
                //====Nouveau Fichier======
                //compter les mots
                nbMot.setText("N° mot: 0");
                area.replaceText("");
                nomFichierCourant="";
                AncienContenuDeFichier.replaceText("");
           }

        }
        else
        {
                //====Nouveau Fichier======
                //compter les mots
                nbMot.setText("N° mot: 0");
                area.replaceText("");
                nomFichierCourant="";
                AncienContenuDeFichier.replaceText("");
        }
    }  
   public void ouvrirFichier()
   {
        if((FichierEnregistrer==false&& !area.getText().equals("")) || !area.getText().equals(AncienContenuDeFichier.getText()))
        {
           String resultat = confirmationEnregistrement();
           if("yes".equals(resultat) || "no".equals(resultat) )
           {
               FileChooser fileChooser = new FileChooser();
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier Text (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File selectedDirectory= fileChooser.showOpenDialog(new Stage());
           try 
           {
               BufferedReader br = new BufferedReader(
                       new InputStreamReader(
                               new FileInputStream(selectedDirectory.getPath()), "ISO-8859-1"));
               String text="";
               while(true)
                {
                    try 
                    {
                        String value=br.readLine();
                        if(value==null)break; //lecture de fichier fini
                        value+="\n";
                        text+=value;                    
                    } 
                    catch (EOFException ex) {break;} 
                    catch (IOException ex) {break;}
                }
               area.replaceText(text);
               //sauvgardement pour teste d'enregistrement
               AncienContenuDeFichier.replaceText(text);
               FichierEnregistrer=true;
               //compter les mots
               nbMot.setText("N° mot: "+new StringTokenizer(area.getText()).countTokens());
               test(0,area.getLength());//Tester Tous
           }//cas de probléme au niveau de fichier
           catch (UnsupportedEncodingException ex) {} catch (FileNotFoundException ex) {}
           }

        }
        else
        {
            FileChooser fileChooser = new FileChooser();
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier Text (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File selectedDirectory= fileChooser.showOpenDialog(new Stage());
           try 
           {
               BufferedReader br = new BufferedReader(
                       new InputStreamReader(
                               new FileInputStream(selectedDirectory.getPath()), "ISO-8859-1"));
               String text="";
               while(true)
                {
                    try 
                    {
                        String value=br.readLine();
                        if(value==null)break; //lecture de fichier fini
                        value+="\n";
                        text+=value;                    
                    } 
                    catch (EOFException ex) {break;} 
                    catch (IOException ex) {break;}
                }
               area.replaceText(text);
               //sauvgardement pour teste d'enregistrement
               AncienContenuDeFichier.replaceText(text);
               FichierEnregistrer=true;
               //compter les mots
               nbMot.setText("N° mot: "+new StringTokenizer(area.getText()).countTokens());
               test(0,area.getLength());//Tester Tous
           }//cas de probléme au niveau de fichier
           catch (UnsupportedEncodingException ex) {} catch (FileNotFoundException ex) {}
        }
        
        
        
            
               
    }
   
   public void enregistrerFichier()
   {
        if("".equals(nomFichierCourant))// Cas fichier n'éxiste pas
            {
               FileChooser fileChooser = new FileChooser();
               FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier Text (*.txt)", "*.txt");
               fileChooser.getExtensionFilters().add(extFilter);
               File selectedDirectory= fileChooser.showSaveDialog(new Stage());
               
               try
               {                   
                    BufferedWriter bw = new BufferedWriter(new FileWriter(selectedDirectory.getPath()));
                    bw.write(area.getText());
                    bw.flush();
                    bw.close();
               }
               catch(IOException ex){}
            
            }
            else // Cas fichier déja existe
            {
                 try
               {                   
                    BufferedWriter bw = new BufferedWriter(new FileWriter(nomFichierCourant));
                    bw.write(area.getText());
                    bw.flush();
                    bw.close();
               }
               catch(IOException ex){}
            }
               
    }    
   public void enregistrerSousFichier()
   {
                    
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier Text (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            File selectedDirectory= fileChooser.showSaveDialog(new Stage());

            try
            {                   
                 BufferedWriter bw = new BufferedWriter(new FileWriter(selectedDirectory.getPath()));
                 bw.write(area.getText());
                 bw.flush();
                 bw.close();
                 nomFichierCourant=selectedDirectory.getPath();
            }
            catch(IOException ex){}
    }
   
   //Pour recuperer le mot sélectionner par le curseur
   public  String GetTextSelect(String txt,int posCarret)
   {
       if(txt.charAt(posCarret-1)==' '&& posCarret==txt.length())
           return "";//si text est vide retourne
       if(txt.charAt(posCarret-1)==' ')// Carret aprés espace
        try
        {
            positionStartCurrentWord=posCarret;
            positionEndCurrentWord=txt.indexOf(' ',posCarret);
            return txt.substring(positionStartCurrentWord,positionEndCurrentWord);
        }
        catch(Exception ex)
        {
            positionStartCurrentWord=posCarret;
            positionEndCurrentWord=txt.length();
            return txt.substring(positionStartCurrentWord);
        }
       else // Carret dans le mot 
       {
           int posPremierSeparateur=-1;
           for(int i=posCarret-1;i>=0;i--)
           {
               if(txt.charAt(i)==' ' || txt.charAt(i)=='\t' || txt.charAt(i)=='\n' || txt.charAt(i)=='\'' || txt.charAt(i)=='’')
               {
                   posPremierSeparateur=i;
                   break;
               }
           }
        try//si le mot est à l'interieur du text
        {
          //retourne la position du separateur le plus proche
           positionEndCurrentWord=MyMethods.getIndexSeparateurSuivant(txt,posPremierSeparateur); 
           positionStartCurrentWord=posPremierSeparateur+1;
           //positionEndCurrentWord=txt.indexOf(' ',indexOfSpaceBefore+1);
           return txt.substring(positionStartCurrentWord,positionEndCurrentWord);
        }
        catch(Exception ex) //si le mot est à la fin du text
        {
            positionStartCurrentWord=posPremierSeparateur+1;
            positionEndCurrentWord=txt.length();           
            return txt.substring(positionStartCurrentWord);
        }
       }
   }   
   public void changerMot(String newMow)
   {
       area.replaceText(positionStartCurrentWord,positionEndCurrentWord, newMow);
       GetTextSelect(area.getText(),area.getCaretPosition());
       area.setStyle(positionStartCurrentWord,positionEndCurrentWord,"-fx-fill: black;-fx-font: 16 Helvetica;");
   }   
   public void marquerFaute(int start, int end)
   {
       area.setStyle(start, end, "-fx-fill: red;-fx-font: 16 Helvetica;");
   }
   public void marquerJuste(int start, int end)
   {
       area.setStyle(start, end, "-fx-fill: black;-fx-font: 16 Helvetica;");
   }
   public void supprimerMarquerFaute()
   {
       area.setStyle(positionStartCurrentWord, positionEndCurrentWord, "-fx-fill: black;-fx-font: 16 Helvetica;");
       area.setStyle(area.getCaretPosition()-1, area.getCaretPosition(), "-fx-fill: black;-fx-font: 16 Helvetica;");
       area.setStyle("-fx-fill: black;-fx-font: 16 Helvetica;");
   }
   //Filtre le mot des dernier caractère permi (exp "aller." => "aller")
   public String FiltreMot(String mot)
   {
        try
        {
            if(".".equals(mot.substring(mot.length()-1)) 
            || ",".equals(mot.substring(mot.length()-1))
            || ";".equals(mot.substring(mot.length()-1))
            || "!".equals(mot.substring(mot.length()-1))
            || "?".equals(mot.substring(mot.length()-1)))
            {
                mot=mot.substring(0,mot.length()-1);
                positionEndCurrentWord--;
                area.setStyle(positionEndCurrentWord, positionEndCurrentWord+1, "-fx-fill: black;-fx-font: 16 Helvetica;");
                
            }
        }
        catch(Exception ex)
        {}
        return mot;
    }
   //Test de correction de toutes les mot d'une interval
   public  void test(int indexStart, int indexEnd) 
   {           
        
           String txt=area.getText();
           Map<Integer,ArrayList<String>> listMot =new TreeMap<>(); 
           StringTokenizer t;         
      
           
           if(indexStart>0)//voir si la selection se trouve à l'interieur du text
           {    
                //voir si un caracatére(mot) est attaché au début avec la selection collé
                if( txt.charAt(indexStart-1)!=' '&& txt.charAt(indexStart-1)!='\t' && txt.charAt(indexStart-1)!='\n' && txt.charAt(indexStart-1)!='\'' && txt.charAt(indexStart-1)!='’')
                {
                     for(int i=indexStart;i>=0;i--)
                     {
                         if(txt.charAt(i)==' '||txt.charAt(i)=='\t'||txt.charAt(i)=='\n'  ||txt.charAt(i)=='\'' ||txt.charAt(i)=='’')
                         {
                             indexStart=i+1;
                             break;
                         }
                         else if(i==0)//cas premier mot
                         {
                            indexStart=0;
                            break;//sortir avec position 0
                         }
                     }
                }
           }
            System.out.println(indexStart+","+indexEnd+","+(txt.length()-1));
           //voir si un caracatére(mot) est attaché à la fin avec la selection collé
           if(indexEnd<txt.length())
           {
               try
               { 
                if( txt.charAt(indexEnd+1)!=' '&& txt.charAt(indexEnd+1)!='\t' && txt.charAt(indexEnd+1)!='\n' && txt.charAt(indexEnd+1)!='\'' && txt.charAt(indexEnd+1)!='’') 
                {
                    try
                   {            
                       //retourne la position du separateur le plus proche
                       indexEnd=MyMethods.getIndexSeparateurSuivant(txt,indexEnd); 
                   }
                   catch(Exception ex)//cas dernier mot
                   {
                       indexEnd=txt.length()-1;
                   }
                }
               }
               catch(Exception ex){}
           }
           
           //Nouveau Decoupage de la chaine à traiter
           System.out.println(indexStart+","+indexEnd+","+(txt.length()-1));
           String txtCouper=txt.substring(indexStart,indexEnd);           
           t= new StringTokenizer(txtCouper,"'’\n\t ");
           
                int startIndex =indexStart;
                
                while (t.hasMoreElements()) 
                {   
                    String nextT=t.nextToken();
                    //Recuperation d'index du prochaine mot
                    for(int i=startIndex ;i<=indexEnd;i++)
                    {
                        if(txt.charAt(i)!=' ' && txt.charAt(i)!='\t' && txt.charAt(i)!='\n' && txt.charAt(i)!='\'' && txt.charAt(i)!='’')
                        { 
                            startIndex=i;//index de début du prochaine mot
                            break;
                        }
                    }
                    //sotockage du mot avec son index de début et de fin "exemple: 10=[figure, 16]" 
                    //startIndex+=nextT.length() : le positionement sur la fin du mot stocké pour cherhcer le prochain 
                    listMot.put(startIndex,new ArrayList<>(Arrays.asList(nextT,String.valueOf(startIndex+=nextT.length()))));
                }
                        
                for(Integer indexS : listMot.keySet())
                {
                    ArrayList<String> motPlusIndexFin =listMot.get(indexS);
                    try
                    {
                        positionStartWord=indexS;
                        positionEndCurrentWord=Integer.parseInt(motPlusIndexFin.get(1));
                        String mot =FiltreMot(motPlusIndexFin.get(0));
                    if(dico.CorrectOuPas(mot)==false)//Voir si le mot est incorrect
                    {
                        marquerFaute(positionStartWord,positionEndCurrentWord);
                    }
                    else //Cas si le mot est correct
                        area.setStyle(positionStartWord, positionEndCurrentWord, "-fx-fill: black;-fx-font: 16 Helvetica;");
                    }
                    catch (Exception ex){}
                }          
       }

    @FXML void favorite(ActionEvent event){
    }
    
    @FXML void createPDF (ActionEvent event)throws IOException{
       
       ServiceArticle sa=new ServiceArticle();
       Article ar=sa.readOne(idArt);
       String titre=ar.getTitre();
       String contenue=ar.getContenue();
       String photo=ar.getPhoto();
       String tt="              Titre:   "      +       titre       +   "\n \n"+contenue;
        
        String file_name="E:\\3ème_année\\PiJava\\CycleProJava\\CyclePro\\"+titre+"javaArticle.pdf";
        Document document=new Document();
        try{
        PdfWriter.getInstance(document,new FileOutputStream(file_name));
        
        document.open();
        Paragraph para=new Paragraph(tt);
        document.add(para);
        
        //document.add(Image.getInstance("/images/"+photo));
            
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF");
            alert.setHeaderText("Information");
            alert.setContentText("L'article est téléchargé comme PDF dans votre dossier de projet");
            alert.showAndWait();
        
        document.close();
                try{
                    Runtime.getRuntime().exec("cmd/c start/max"+titre+"javaArticle.pdf");
                }catch(Exception e){}
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
  
    
    public void redirection(AnchorPane c, int id,User u){
       centerContent=c; 
       user = u;
       idArt = id;
       
        System.out.println("l'identifiant de l'evenement est "+id);
        //AFFICHAGE SINGLE
        System.out.println("l'identifiant de l'utilisatuer est "+u.getId());
        
       ServiceArticle sa=new ServiceArticle();
       Article ar=sa.readOne(id);
       
       LTitre.setText(ar.getTitre());
       LCont.setText(ar.getContenue());
       javafx.scene.image.Image image=new javafx.scene.image.Image("/images/"+ar.getPhoto());
       javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
       imageview.setFitWidth(559);
       imageview.setFitHeight(435);
       PanePhoto.getChildren().add(imageview);    
        
    }
    
  
        
    }

