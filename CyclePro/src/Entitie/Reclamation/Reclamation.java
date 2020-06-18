/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Reclamation;

import Entitie.User.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

/**
 *
 * @author Wiem
 */
@Getter @Setter
@Builder

public class Reclamation {
    private int id;
    private User user;
    private Categorie categorie;
    private String sujet;
    private String description;
    private String image ; 

    public Reclamation(int id, User user, Categorie categorie, String sujet, String description, String image) {
        this.id = id;
        this.user = user;
        this.categorie = categorie;
        this.sujet = sujet;
        this.description = description;
        this.image = image;
       
    }
    
    
      
    public Reclamation() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
  
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String photo) {
        this.image = photo;
    }
    

   /* 
    public String getUserName() {
        if (user == null) return "";
        return user.getUsername();
    }
    */
    
    public String getCategorieName() {
        if (categorie == null) return "";
        return categorie.getLabel();
    }

  public int getUserId() {
        if (user == null) return 0 ;
        return user.getId();
    }
    
    
   public int getCategorieId() {
        if (categorie == null) return 0;
        return categorie.getId();
    }
    
   
   
   @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", user=" + user + ", categorie=" + categorie + ", sujet=" + sujet + ", description=" + description + ", photo=" +image + '}';
    }

   
}
