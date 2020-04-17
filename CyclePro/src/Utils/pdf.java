package Utils;



import Entitie.Stock.Fournisseur;
import Entitie.Stock.Velo;
import Service.Stock.ServiceFournisseur;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



public class pdf {
      
        //webcam.main(args);  
    public void GeneratePdf(String filename,Velo v,int qnt) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        document.open();
        document.add(new Paragraph("Marque du Vélo :"+v.getMarque()+"\n"));
        document.add(new Paragraph("Taille :"+v.getCouleur()+"\n"));
        document.add(new Paragraph("Prix unitaire :"+v.getPrixAchat()+"\n"));
        document.add(new Paragraph("Quantité :"+qnt+"\n"));
        double total=qnt*v.getPrixAchat();
        document.add(new Paragraph("Prix Total :"+total+"\n"));
        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        document.close();
        //Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
}

