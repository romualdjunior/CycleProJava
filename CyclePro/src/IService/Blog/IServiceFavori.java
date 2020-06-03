/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Blog;

import java.util.List;

/**
 *
 * @author asus
 * @param <F>
 */
public interface IServiceFavori<F> {
    public void createFavori(F f);
    public void deleteFavori(F f);
    public List<F> readFavori();

    
}
