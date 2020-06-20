/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Stock;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Yasmine
 */
public class Velo {
    private int id ;
    private String marque;
    private String couleur;
     private int nbrDePlace ;
    private String etat;
    private String taille;
    private int qtStockSecurite ;
    private int qtEnStock ;
    private String type;
    private String categorie;
    private int Fournisseur;
    private String description;
    private String Caracteristiques;
    private double prixLocH ;
    private double prixAchat;
    private int soldee ;
    private String photoV;
    private String photoV1;
    private String photoV2;
    private String photoV3;
    private ImageView image;

    public Velo(int id, double prixAchat, String photoV, ImageView image) {
        this.id = id;
        this.prixAchat = prixAchat;
        this.photoV = photoV;
        this.image = image;
    }

    public Velo(int id, String marque, double prixAchat,String photoV, ImageView image) {
        this.id = id;
        this.marque = marque;
        this.prixAchat = prixAchat;
        this.photoV = photoV;
        this.image = image;
    }

    public Velo() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getNbrDePlace() {
        return nbrDePlace;
    }

    public void setNbrDePlace(int nbrDePlace) {
        this.nbrDePlace = nbrDePlace;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public int getQtStockSecurite() {
        return qtStockSecurite;
    }

    public void setQtStockSecurite(int qtStockSecurite) {
        this.qtStockSecurite = qtStockSecurite;
    }

    public int getQtEnStock() {
        return qtEnStock;
    }

    public void setQtEnStock(int qtEnStock) {
        this.qtEnStock = qtEnStock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getFournisseur() {
        return Fournisseur;
    }

    public void setFournisseur(int Fournisseur) {
        this.Fournisseur = Fournisseur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaracteristiques() {
        return Caracteristiques;
    }

    public void setCaracteristiques(String Caracteristiques) {
        this.Caracteristiques = Caracteristiques;
    }

    public double getPrixLocH() {
        return prixLocH;
    }

    public void setPrixLocH(double prixLocH) {
        this.prixLocH = prixLocH;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getSoldee() {
        return soldee;
    }

    public void setSoldee(int soldee) {
        this.soldee = soldee;
    }

    public String getPhotoV() {
        return photoV;
    }

    public void setPhotoV(String photoV) {
        this.photoV = photoV;
    }

    public String getPhotoV1() {
        return photoV1;
    }

    public void setPhotoV1(String photoV1) {
        this.photoV1 = photoV1;
    }

    public String getPhotoV2() {
        return photoV2;
    }

    public void setPhotoV2(String photoV2) {
        this.photoV2 = photoV2;
    }

    public String getPhotoV3() {
        return photoV3;
    }

    public void setPhotoV3(String photoV3) {
        this.photoV3 = photoV3;
    }

    public Velo(int id, String marque, String couleur, int nbrDePlace, String taille,int qtEnStock,int qtStockSecurite,double prixAchat,double prixLocH, String photoV, int Fournisseur,String categorie, String description,String etat, int soldee,  String type,    String photoV1, String photoV2, String photoV3,   String Caracteristiques) {
        this.id = id;
        this.marque = marque;
        this.couleur = couleur;
        this.nbrDePlace = nbrDePlace;
        this.etat = etat;
        this.taille = taille;
        this.qtStockSecurite = qtStockSecurite;
        this.qtEnStock = qtEnStock;
        this.type = type;
        this.categorie = categorie;
        this.Fournisseur = Fournisseur;
        this.description = description;
        this.Caracteristiques = Caracteristiques;
        this.prixLocH = prixLocH;
        this.prixAchat = prixAchat;
        this.soldee = soldee;
        this.photoV = photoV;
        this.photoV1 = photoV1;
        this.photoV2 = photoV2;
        this.photoV3 = photoV3;
    }

    public Velo(String marque, String couleur, int nbrDePlace, String taille,int qtEnStock,int qtStockSecurite,double prixAchat,double prixLocH, String photoV, int Fournisseur,String categorie, String description,String etat, int soldee,  String type,    String photoV1, String photoV2, String photoV3,   String Caracteristiques) {
        this.marque = marque;
        this.couleur = couleur;
        this.nbrDePlace = nbrDePlace;
        this.etat = etat;
        this.taille = taille;
        this.qtStockSecurite = qtStockSecurite;
        this.qtEnStock = qtEnStock;
        this.type = type;
        this.categorie = categorie;
        this.Fournisseur = Fournisseur;
        this.description = description;
        this.Caracteristiques = Caracteristiques;
        this.prixLocH = prixLocH;
        this.prixAchat = prixAchat;
        this.soldee = soldee;
        this.photoV = photoV;
        this.photoV1 = photoV1;
        this.photoV2 = photoV2;
        this.photoV3 = photoV3;
    }

    public Velo(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Velo{" + "id=" + id + ", marque=" + marque + ", couleur=" + couleur + ", nbrDePlace=" + nbrDePlace + ", taille=" + taille + ", qtEnStock=" + qtEnStock + ", qtStockSecurite=" + qtStockSecurite + ", prixAchat=" + prixAchat + ", prixLocH=" + prixLocH + ", photoV=" + photoV + ", Fournisseur=" + Fournisseur +   ", categorie=" + categorie +  ", description=" + description + ", etat=" + etat +    ", soldee=" + soldee +  ", type=" + type + ", photoV1=" + photoV1 + ", photoV2=" + photoV2 + ", photoV3=" + photoV3 + ", Caracteristiques=" + Caracteristiques +  '}';
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Velo(int id, String marque, String couleur, int nbrDePlace, String etat, String taille, int qtStockSecurite, int qtEnStock, String type, String categorie, int Fournisseur, String description, String Caracteristiques, double prixLocH, double prixAchat, int soldee, String photoV, String photoV1, String photoV2, String photoV3, ImageView image) {
        this.id = id;
        this.marque = marque;
        this.couleur = couleur;
        this.nbrDePlace = nbrDePlace;
        this.etat = etat;
        this.taille = taille;
        this.qtStockSecurite = qtStockSecurite;
        this.qtEnStock = qtEnStock;
        this.type = type;
        this.categorie = categorie;
        this.Fournisseur = Fournisseur;
        this.description = description;
        this.Caracteristiques = Caracteristiques;
        this.prixLocH = prixLocH;
        this.prixAchat = prixAchat;
        this.soldee = soldee;
        this.photoV = photoV;
        this.photoV1 = photoV1;
        this.photoV2 = photoV2;
        this.photoV3 = photoV3;
        this.image = image;
    }
    
    public Velo(int id, String marque, String couleur, int nbrDePlace, String taille,int qtEnStock,int qtStockSecurite,double prixAchat,double prixLocH, String photoV, int Fournisseur,String categorie, String description,String etat, int soldee,  String type,    String photoV1, String photoV2, String photoV3,   String Caracteristiques,ImageView image) {
        this.id = id;
        this.marque = marque;
        this.couleur = couleur;
        this.nbrDePlace = nbrDePlace;
        this.etat = etat;
        this.taille = taille;
        this.qtStockSecurite = qtStockSecurite;
        this.qtEnStock = qtEnStock;
        this.type = type;
        this.categorie = categorie;
        this.Fournisseur = Fournisseur;
        this.description = description;
        this.Caracteristiques = Caracteristiques;
        this.prixLocH = prixLocH;
        this.prixAchat = prixAchat;
        this.soldee = soldee;
        this.photoV = photoV;
        this.photoV1 = photoV1;
        this.photoV2 = photoV2;
        this.photoV3 = photoV3;
        this.image=image;
    }

 
    
    
    
}
