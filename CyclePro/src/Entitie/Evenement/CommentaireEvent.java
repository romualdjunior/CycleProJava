/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Evenement;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class CommentaireEvent {
    private int id;
    private float likes;
    private String contenue;
    private Date dateComment;
    private int event;
    private int user;

    public CommentaireEvent(float likes, Date dateComment, int event, int user) {
        this.likes = likes;
        this.dateComment = dateComment;
        this.event = event;
        this.user = user;
    }

    public CommentaireEvent(int id, String contenue, Date dateComment, int event, int user) {
        this.id = id;
        this.contenue = contenue;
        this.dateComment = dateComment;
        this.event = event;
        this.user = user;
    }

    public CommentaireEvent(float likes, String contenue, int event, int user) {
        this.likes = likes;
        this.contenue = contenue;
        this.dateComment = dateComment;
        this.event = event;
        this.user = user;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "CommentaireEvent{" + "id=" + id + ", likes=" + likes + ", contenue=" + contenue + ", dateComment=" + dateComment + '}';
    }

    public CommentaireEvent() {
    }

    public CommentaireEvent(float likes, String contenue, Date dateComment) {
        this.likes = likes;
        this.contenue = contenue;
        this.dateComment = dateComment;
    }

    public CommentaireEvent(int id) {
        this.id = id;
    }

    public CommentaireEvent(int id, float likes, String contenue, Date dateComment) {
        this.id = id;
        this.likes = likes;
        this.contenue = contenue;
        this.dateComment = dateComment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLikes() {
        return likes;
    }

    public void setLikes(float likes) {
        this.likes = likes;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }
   
    
    
}
