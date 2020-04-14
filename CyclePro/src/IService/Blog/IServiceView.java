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
 * @param <V>
 */
public interface IServiceView <V> {
    public void createView(V v);
    public List<V> readAllView();

    
}