/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Blog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author asus
 */
public class CommentaireArticle {
    private int id;
    private int article;
    private int user;
    private String contenue;
    private Date date_comt;
    private String userName;

    public CommentaireArticle() {
    }

    public String getDateTime() {
    DateFormat date_comt = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    return date_comt.format(date);
}
    
    public CommentaireArticle(int id, int article, int user, String contenue, Date date_comt) {
        this.id = id;
        this.article = article;
        this.user = user;
        this.contenue = contenue;
        this.date_comt = date_comt;
    }
    
     public CommentaireArticle(int id, int article, int user, String contenue, Date date_comt, String userName) {
        this.id = id;
        this.article = article;
        this.user = user;
        this.contenue = contenue;
        this.date_comt = date_comt;
        this.userName = userName;
    }
    
     public CommentaireArticle(int id, int article, int user, String contenue) {
        this.id = id;
        this.article = article;
        this.user = user;
        this.contenue = contenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Date getDate_comt() {
        return date_comt;
    }

    public void setDate_comt(Date date_comt) {
        this.date_comt = date_comt;
    }
    
    public String getOwner() {
        return this.userName;
    }
    
    @Override
    public String toString(){
    return "Le contenue de ce commentaire est " + contenue + " est cré par l'utilisateur d'id " + user +""
            + "sur l'article d'id "+article+
            " le "+date_comt;
    }
    
    
}
