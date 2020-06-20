/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Stock;

import Entitie.Stock.Fournisseur;
import Entitie.Stock.Velo;
import Service.Stock.ServiceFournisseur;
import Service.Stock.ServiceVelo;
import Utils.pdf;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import manage.Mail;


/**
 * FXML Controller class
 *
 * @author skand
 */
public class CommandeVController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextField quantité;
    @FXML
    private Label id_velo;
    @FXML
    private Label idUangKeluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setidvelo(int id)
    {
        id_velo.setText(String.valueOf(id));
    }

    @FXML
    private void ajoutcommande(ActionEvent event) throws DocumentException, BadElementException, IOException, FileNotFoundException, InterruptedException, SQLException, Exception {
        
        //Integer.parseInt(id_velo.getText())
        ServiceVelo SV = new ServiceVelo();
        Velo v=new Velo();
        v=SV.getVelo(Integer.parseInt(id_velo.getText()));
        ServiceFournisseur Fs = new ServiceFournisseur();
        Fournisseur f=new Fournisseur();
        System.out.println("velo id:");
        System.out.println(v.getId());
        f=Fs.getFournisseurVelo(v.getId());
       
        pdf p=new pdf();
        p.GeneratePdf("velo",v,Integer.parseInt( quantité.getText()));
        System.out.println("Nom:");
        System.out.println(f.getMail());
        Mail m = new Mail();
        m.sendMail(f.getMail());
       JOptionPane.showMessageDialog(null, "Commande envoyé !");
    }
    
}
