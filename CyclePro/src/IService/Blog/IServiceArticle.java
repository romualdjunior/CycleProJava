/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Blog;

import Entitie.Blog.Article;
import java.util.List;
//import objects.Article;

/**
 *
 * @author asus
 * @param <A>
 */
public interface IServiceArticle <A> {
    public void createArticle(A a);
    public void updateArticle(A a);
    public void deleteArticle(A a);
    public List<A> readAllArticle();
    
    public List<A> searchByCat(String category);
    public List<A> searchByTitre(String titre);
    public List<A> searchByAuteur(String auteur);
    public List<A> searchRecent();
    public Article readOne(int id);
    public String readTitre(int id);
    
    


}
