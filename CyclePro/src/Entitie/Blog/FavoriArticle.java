/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Blog;

/**
 *
 * @author asus
 */
public class FavoriArticle {
    private int id;
    private int user;
    private int article;

    public FavoriArticle() {
    }

    
    
    public FavoriArticle(int id, int user, int article) {
        this.id = id;
        this.user = user;
        this.article = article;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }
    
    @Override
    public String toString(){
    return "Ce favori est choisit par "+ user + " contient article "+ article;
    }
}
