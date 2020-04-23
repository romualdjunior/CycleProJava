/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Blog;

import java.util.Date;

/**
 *
 * @author asus
 */
public class View {
    private int idView;
    private int idUSer;
    private String contenueView;
    private int rating;
    private Date dateView;
    private String nameUser;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    
    
    public int getIdView() {
        return idView;
    }

    public void setIdView(int idView) {
        this.idView = idView;
    }

    public int getIdUSer() {
        return idUSer;
    }

    public void setIdUSer(int idUSer) {
        this.idUSer = idUSer;
    }

    public String getContenueView() {
        return contenueView;
    }

    public void setContenueView(String contenueView) {
        this.contenueView = contenueView;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDateView() {
        return dateView;
    }

    public void setDateView(Date dateView) {
        this.dateView = dateView;
    }
    
    

    public View(int idView, int idUSer, String contenueView, int rating) {
        this.idView = idView;
        this.idUSer = idUSer;
        this.contenueView = contenueView;
        this.rating = rating;
    }
    
        public View(int idView, int idUSer, String contenueView, int rating, Date dateView) {
        this.idView = idView;
        this.idUSer = idUSer;
        this.contenueView = contenueView;
        this.rating = rating;
        this.dateView=dateView;
    }
        public View(int idView, int idUSer, String contenueView, int rating, Date dateView, String nameUser) {
        this.idView = idView;
        this.idUSer = idUSer;
        this.contenueView = contenueView;
        this.rating = rating;
        this.dateView=dateView;
        this.nameUser=nameUser;
    }
        public View(){
        }

    
}
