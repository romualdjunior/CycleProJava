package Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author toshiba
 */
public class Test {
    public static void test(){
  String password="lll";
String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);
        System.out.println("/n");
  }
    public static void test2() throws FileNotFoundException, DocumentException{
        Document document = new Document();
            String file_name = "E:\\3ème_année\\PiJava\\CycleProJava\\CyclePro\\src\\GUI\\Commande\\Facture.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            Paragraph p = new Paragraph("Ci-joint votre facture");
            document.add(p);
            document.close();

    }
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //Test:test(); 
          test2();


// Tester si un mot de passe est identique à un autre
//if (BCrypt.checkpw("lll", "$2a$10$/HMaE6NLvyxNOvqdrQBEUebRYKLMeuIlWaKGZbcBKHKQhvU5VsLd2"))
  //      System.out.println("It matched");
//else
//	System.out.println("It does not match");

   }
    
  
}
