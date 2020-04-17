/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Commande;

import java.util.Objects;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author toshiba
 */
public class CommandeAdresse {

    private int id;
    private int total;
    private String etat;
    private String date;
    private String username;
    private String email;
    private String pays;
    private String ville;
    private String adresseLivraison;
    private int  pincode;
    private Button modifier;
    private Button supprimer;
    int idCommande;
    int idAdresse;

    public CommandeAdresse(int total, String etat, String date, String username, String email, String pays, String ville, String adresseLivraison, int pincode,int idCommande,int idAdresse) {
        this.total = total;
        this.etat = etat;
        this.date = date;
        this.username = username;
        this.email = email;
        this.pays = pays;
        this.ville = ville;
        this.adresseLivraison = adresseLivraison;
        this.pincode = pincode;
        this.modifier = new Button("");
        this.supprimer = new Button("");
        this.idCommande=idCommande;
        this.idAdresse=idAdresse;
         ImageView imageButton=new ImageView("/GUI/Images/Icon-awesome-trash-alt.png");
        imageButton.setFitHeight(20);
        imageButton.setFitWidth(20);
          ImageView imageButton2=new ImageView("/GUI/Images/Icon material-update.png");
        imageButton2.setFitHeight(20);
        imageButton2.setFitWidth(20);
        this.supprimer.setGraphic(imageButton);
        this.modifier.setGraphic(imageButton2);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CommandeAdresse other = (CommandeAdresse) obj;
        if (this.total != other.total) {
            return false;
        }
        if (this.pincode != other.pincode) {
            return false;
        }
        if (this.idCommande != other.idCommande) {
            return false;
        }
        if (this.idAdresse != other.idAdresse) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.pays, other.pays)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.adresseLivraison, other.adresseLivraison)) {
            return false;
        }
        return true;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public String getEtat() {
        return etat;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public int getPincode() {
        return pincode;
    }

    public Button getModifier() {
        return modifier;
    }

    public Button getSupprimer() {
        return supprimer;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setModifier(Button modifier) {
        this.modifier = modifier;
    }

    public void setSupprimer(Button supprimer) {
        this.supprimer = supprimer;
    }

}
