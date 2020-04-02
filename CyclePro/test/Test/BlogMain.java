/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entitie.Blog.Article;
import Entitie.Blog.CommentaireArticle;
import Entitie.Blog.FavoriArticle;
import Service.Blog.ServiceArticle;
import Service.Blog.ServiceComt;
import Service.Blog.ServiceFavori;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author asus
 */
public class BlogMain {

    
    /**
     * @param args the command line arguments
     */
    
     public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    public static void main(String[] args) {
        
          ServiceArticle SS=new ServiceArticle();
        Date d1= getDate(2019,10,10);
        Article AA=new Article(252,"contenue","titre","auteur","photo",d1,"category",10);
         SS.createArticle(AA);
        System.out.println("********ALL articles ORDER BY LIKES************");
        SS.readAllArticle().forEach(System.out::println);
        
               System.out.println("**********Search by category****************");
        SS.searchByCat("sport").forEach(System.out::println);
        
        System.out.println("********************Search by title****************");
        SS.searchByTitre("Sport").forEach(System.out::println);
        
       System.out.println("*************Search by auteur****************");
        SS.searchByAuteur("nada").forEach(System.out::println);
        
        System.out.println("***********Search article les plus recent*************");
        SS.searchRecent().forEach(System.out::println);     
       
       ServiceComt sc = new ServiceComt();
        CommentaireArticle C1=new CommentaireArticle(50,5,1,"mohamed");
        //sc.createComt(C1);
        //sc.deleteComt(C1);
        sc.updateComt(C1);
                System.out.println("**********Search all comments***********");
        sc.readComt().forEach(System.out::println);
        
                System.out.println("**********Search comments by user***********");
        sc.readComtByUser(1).forEach(System.out::println);

        
        ServiceFavori sf = new ServiceFavori();
        FavoriArticle F1=new FavoriArticle(33,2,21);
        FavoriArticle F2=new FavoriArticle(22,1,27);
        sf.createFavori(F1);
        sf.deleteFavori(F2);
        sf.readFavori().forEach(System.out::println); 
        
        

    }
}
