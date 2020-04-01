/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Commande;

/**
 *
 * @author toshiba
 */
public class Adresse {
    private int id;
    private String nom;
    private String prenom;
    private int phone;
    private String email;
    private String pays;
    private String ville;
    private String etat;
    private int pincode;
    private String adresseLivraison;

    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", phone=" + phone + ", email=" + email + ", pays=" + pays + ", ville=" + ville + ", etat=" + etat + ", pincode=" + pincode + ", adresseLivraison=" + adresseLivraison + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Adresse other = (Adresse) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getPhone() {
        return phone;
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

    public String getEtat() {
        return etat;
    }

    public int getPincode() {
        return pincode;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }
    
}
