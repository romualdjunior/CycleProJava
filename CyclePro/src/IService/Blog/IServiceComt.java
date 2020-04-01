/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Blog;

import Entitie.Blog.CommentaireArticle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 * @param <C>
 */
public interface IServiceComt <C> {
    public void createComt(C c);
    public void updateComt(C c);
    public void deleteComt(C c);
    public List<C> readComt();
    public List<C> readComtByUser(int id);
    public ArrayList<CommentaireArticle> getCommentsByArticle(int idArticle);
   // public List<C> searchByName(C c);

}
