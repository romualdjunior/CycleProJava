/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService.Reclamation;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author wiem
 */
public interface IService<T>{
    public boolean ajouter(T entity) throws SQLException;
    public T getById(int id) throws SQLException;
    public List<T> getAll() throws SQLException;
    public boolean update(T entity) throws SQLException;
    public boolean supprimer(T entity) throws SQLException;
    public boolean supprimer(int id) throws SQLException;
}
