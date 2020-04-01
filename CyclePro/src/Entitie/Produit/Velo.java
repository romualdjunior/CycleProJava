/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Produit;

/**
 *
 * @author toshiba
 */
public class Velo {
    private int id;
    private String PhotoV;
    private String caracterisitques;
    private String marque;
    private String type;
    private String categorie;
    private String description;
    private String etat;
    private String couleur;
    private int nbDePlace;
    private String taille;
    private String soldee;
    private int qtEnStock;
    private int prixAchat;

    public Velo(int id,String PhotoV, String caracterisitques, String marque, String type, String categorie, String description, String etat, String couleur, int nbDePlace, String taille, String soldee, int qtEnStock, int prixAchat) {
        this.id = id;
        this.PhotoV = PhotoV;
        this.caracterisitques = caracterisitques;
        this.marque = marque;
        this.type = type;
        this.categorie = categorie;
        this.description = description;
        this.etat = etat;
        this.couleur = couleur;
        this.nbDePlace = nbDePlace;
        this.taille = taille;
        this.soldee = soldee;
        this.qtEnStock = qtEnStock;
        this.prixAchat = prixAchat;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Velo{id="+id+",PhotoV=" + PhotoV + ", caracterisitques=" + caracterisitques + ", marque=" + marque + ", type=" + type + ", categorie=" + categorie + ", description=" + description + ", etat=" + etat + ", couleur=" + couleur + ", nbDePlace=" + nbDePlace + ", taille=" + taille + ", soldee=" + soldee + ", qtEnStock=" + qtEnStock + ", prixAchat=" + prixAchat + '}';
    }

    public String getPhotoV() {
        return PhotoV;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Velo other = (Velo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String getCaracterisitques() {
        return caracterisitques;
    }

    public String getMarque() {
        return marque;
    }

    public String getType() {
        return type;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public String getEtat() {
        return etat;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getNbDePlace() {
        return nbDePlace;
    }

    public String getTaille() {
        return taille;
    }

    public String getSoldee() {
        return soldee;
    }

    public int getQtEnStock() {
        return qtEnStock;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public void setPhotoV(String PhotoV) {
        this.PhotoV = PhotoV;
    }

    public void setCaracterisitques(String caracterisitques) {
        this.caracterisitques = caracterisitques;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setNbDePlace(int nbDePlace) {
        this.nbDePlace = nbDePlace;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setSoldee(String soldee) {
        this.soldee = soldee;
    }

    public void setQtEnStock(int qtEnStock) {
        this.qtEnStock = qtEnStock;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }
    
}
