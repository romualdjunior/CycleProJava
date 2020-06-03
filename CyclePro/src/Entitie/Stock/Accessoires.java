/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Stock;

import javafx.scene.image.ImageView;

/**
 *
 * @author Yasmine
 */
public class Accessoires {
     public int id;
     
     public String photoA ;
     public String photoA1 ;
     public String photoA2 ;
     public String photoA3 ;
     public String nom ;
   public String marque ;
   public int qtEnStock ;
   public String Caracteristiques ;
   public double prix;
   public int soldee;
   public String categorie;
   public String description;
   private ImageView image;

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public Accessoires(int id, String photoA, double prix, ImageView image) {
        this.id = id;
        this.photoA = photoA;
        this.prix = prix;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoA() {
        return photoA;
    }

    public void setPhotoA(String photoA) {
        this.photoA = photoA;
    }

    public String getPhotoA1() {
        return photoA1;
    }

    public void setPhotoA1(String photoA1) {
        this.photoA1 = photoA1;
    }

    public String getPhotoA2() {
        return photoA2;
    }

    public void setPhotoA2(String photoA2) {
        this.photoA2 = photoA2;
    }

    public String getPhotoA3() {
        return photoA3;
    }

    public void setPhotoA3(String photoA3) {
        this.photoA3 = photoA3;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getQtEnStock() {
        return qtEnStock;
    }

    public void setQtEnStock(int qtEnStock) {
        this.qtEnStock = qtEnStock;
    }

    public String getCaracteristiques() {
        return Caracteristiques;
    }

    public void setCaracteristiques(String Caracteristiques) {
        this.Caracteristiques = Caracteristiques;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getSoldee() {
        return soldee;
    }

    public void setSoldee(int soldee) {
        this.soldee = soldee;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Accessoires(int id, String photoA,String nom, String marque,  String categorie,double prix,  String description, String photoA1, String photoA2, String photoA3,int soldee, String Caracteristiques, int qtEnStock ) {
        this.id = id;
        this.photoA = photoA;
        this.photoA1 = photoA1;
        this.photoA2 = photoA2;
        this.photoA3 = photoA3;
        this.nom = nom;
        this.marque = marque;
        this.qtEnStock = qtEnStock;
        this.Caracteristiques = Caracteristiques;
        this.prix = prix;
        this.soldee = soldee;
        this.categorie = categorie;
        this.description = description;
    }

    public Accessoires( String photoA,String nom, String marque,  String categorie,double prix,  String description, String photoA1, String photoA2, String photoA3,int soldee, String Caracteristiques, int qtEnStock ) {
        this.photoA = photoA;
        this.photoA1 = photoA1;
        this.photoA2 = photoA2;
        this.photoA3 = photoA3;
        this.nom = nom;
        this.marque = marque;
        this.qtEnStock = qtEnStock;
        this.Caracteristiques = Caracteristiques;
        this.prix = prix;
        this.soldee = soldee;
        this.categorie = categorie;
        this.description = description;
    }

    public Accessoires(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Accessoires{" + "id=" + id + ", photoA=" + photoA + ", nom=" + nom + ", marque=" + marque +  ", categorie=" + categorie +  ", prix=" + prix + ", description=" + description +  ", photoA1=" + photoA1 + ", photoA2=" + photoA2 + ", photoA3=" + photoA3 + ", soldee=" + soldee + ", Caracteristiques=" + Caracteristiques +  ", qtEnStock=" + qtEnStock +   '}';
    }

    public Accessoires(int id, String photoA,String nom, String marque,  String categorie,double prix,  String description, String photoA1, String photoA2, String photoA3,int soldee, String Caracteristiques, int qtEnStock, ImageView image) {
        this.id = id;
        this.photoA = photoA;
        this.photoA1 = photoA1;
        this.photoA2 = photoA2;
        this.photoA3 = photoA3;
        this.nom = nom;
        this.marque = marque;
        this.qtEnStock = qtEnStock;
        this.Caracteristiques = Caracteristiques;
        this.prix = prix;
        this.soldee = soldee;
        this.categorie = categorie;
        this.description = description;
        this.image = image;
    }

    
}
