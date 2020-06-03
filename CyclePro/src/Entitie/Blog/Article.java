/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Blog;

import IService.Blog.IServiceComt;
import Service.Blog.ServiceComt;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Article {
    private int id;
    private String titre;
    private String contenue;
    private String auteur;
    private String photo;
    private String category;
    private int likes;
    private Date date_art;
    private ArrayList<CommentaireArticle> Commentaires;
    private IServiceComt _serviceComt;

    public Article() {
        _serviceComt = new ServiceComt();
    }
    
    

    public Article(int id, String contenue, String titre, String auteur, String photo,
             Date date_art,String category, int likes) {
        this.id = id;
        this.titre = titre;
        this.contenue = contenue;
        this.auteur = auteur;
        this.photo = photo;
        this.category = category;
        this.likes = likes;
        this.date_art = date_art;
        _serviceComt = new ServiceComt();
        Commentaires = _serviceComt.getCommentsByArticle(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getDate_art() {
        return date_art;
    }

    public void setDate_art(Date date_art) {
        this.date_art = date_art;
    }
    
        @Override
    public String toString() {
        //return "Article{" + "id=" + id + ", titre=" + titre + ", category=" + category +
         //       ", photo=" + photo +", likes=" + likes +", auteur=" + auteur +", date=" + date_art +'}';
         
         String result =  "L'article est crée le "+ date_art + " par l'auteur " + auteur + 
                 " apartient au category "
                 + category + 
                 " avec le titre " + titre + " photo " + photo + "et a "+ likes 
                 + " likes est son contenue est " +contenue + "\n "+ this.Commentaires.size() +
                 " Commentaires : ";
         for(int i=0; i<this.Commentaires.size();i++)
         {
             CommentaireArticle ca = this.Commentaires.get(i);
             result +=  ca.getOwner() + " : " + ca.getContenue() + "\n";
         }
         return result;
    }

    public void setDate_art(LocalDate datebirt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
