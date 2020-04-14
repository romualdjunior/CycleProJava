/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Blog;

import Entitie.Blog.Article;
import Entitie.Blog.CommentaireArticle;
import Service.Blog.ServiceArticle;
import Service.Blog.ServiceComt;
import animatefx.animation.Bounce;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class BlogSingleController implements Initializable {

        @FXML private Pane banner;
        @FXML private TextField txtComt;
        @FXML private TextField DateComt;
        @FXML private TextField contenueComt;
        
        @FXML private Label PStitle1;
        @FXML private Label PStitle2;
        @FXML private Label PSDate1;
        @FXML private Label PSDate2;
        @FXML private Pane img1;
        @FXML private Pane img2;
        
        @FXML private Pane PanePhoto;
        @FXML private Label LTitre;
        @FXML private Label LCont;
        
        AnchorPane centerContent;
        Article article;

        
        @FXML void Commenter(ActionEvent event)throws IOException{
           /* CommentaireArticle C=new CommentaireArticle();
            C.setArticle(24);
            C.setUser(1);
            
            String contenue=txtComt.getText();
            C.setContenue(contenue);
            ServiceComt sc=new ServiceComt();
            sc.createComt(C);
            */
            
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           new Bounce(banner).play();
           
            ServiceArticle sa=new ServiceArticle();
            List<Article> list = new ArrayList<>();
        

        //List<Article> listOne=sa.readOne(0);  
        //LCont.setText(listOne.get(0).getContenue());
        //LTitre.setText(listOne.get(0).getTitre());
        javafx.scene.image.Image image1=new javafx.scene.image.Image("/images/blog1.jpg");
        javafx.scene.image.ImageView imageview1=new javafx.scene.image.ImageView(image1);
        imageview1.setFitWidth(562);
        imageview1.setFitHeight(435);
        PanePhoto.getChildren().add(imageview1); 
           
           //Recent posts
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
           
    }    
    
    @FXML void createPDF (ActionEvent event)throws IOException{
        
        String file_name="C:\\Users\\asus\\Desktop\\cours esprit 2019-2020\\javaPDF.pdf";
        Document document=new Document();
        try{
        PdfWriter.getInstance(document,new FileOutputStream(file_name));
        
        document.open();
        Paragraph para=new Paragraph("nada");
        document.add(para);
        
        document.add(Image.getInstance("C:\\Users\\asus\\Desktop\\cours esprit 2019-2020\\nada.JPG"));
        
            
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("PDF");
            alert.setHeaderText("Information");
            alert.setContentText("L'article est téléchargé comme PDF");
            alert.showAndWait();
        
        document.close();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }   
  
  /*@FXML
    public void redirection(AnchorPane c,Article ar ){
        centerContent=c;
        article=ar;
        
        LCont.setText(ar.getContenue());
        LTitre.setText(ar.getTitre());
        javafx.scene.image.Image image=new javafx.scene.image.Image("/images/"+ar.getPhoto());
        javafx.scene.image.ImageView imageview=new javafx.scene.image.ImageView(image);
        imageview.setFitWidth(562);
        imageview.setFitHeight(435);
        img1.getChildren().add(imageview);   
        
                 System.out.println(ar);

        
     */   
    
  
        
    }

