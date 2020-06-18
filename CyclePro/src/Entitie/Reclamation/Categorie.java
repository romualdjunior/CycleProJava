/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Reclamation;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

/**
 *
 * @author Wiem
 */
@Getter @Setter
@Builder
public class Categorie {
    private int id;
    private String label;
    private String description;

    public Categorie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
    
    
    public Categorie (int id , String l , String d ) 
    {
    this.id = id; 
    this.label = l ; 
    this.description = d; 
    
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", label=" + label + ", description=" + description + '}';
    }
    
    
   
    
    
    
    
    
    
}
