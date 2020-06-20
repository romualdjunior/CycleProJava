/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Stock;

import java.util.List;

/**
 *
 * @author Yasmine
 */
public interface IServiceVelo<A> {
      public void ajouter (A a);
    public void supprimer (A a);
   // public void Modifier (T t);
    public List<A> afficher();
}
