/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Evenement;

/**
 *
 * @author ASUS
 */
public class Classe {
    private int id;
    private int NbModules;
    private String Nom;
    private int NbCategories;

    public Classe(int NbModules, String Nom, int NbCategories) {
        this.NbModules = NbModules;
        this.Nom = Nom;
        this.NbCategories = NbCategories;
    }
      public Classe(int NbModules, int NbCategories) {
        this.NbModules = NbModules;
        this.NbCategories = NbCategories;
    }

    public Classe() {
    }

    public Classe(int id, int NbModules, String Nom, int NbCategories) {
        this.id = id;
        this.NbModules = NbModules;
        this.Nom = Nom;
        this.NbCategories = NbCategories;
    }

    public Classe(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbModules() {
        return NbModules;
    }

    public void setNbModules(int NbModules) {
        this.NbModules = NbModules;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getNbCategories() {
        return NbCategories;
    }

    public void setNbCategories(int NbCategories) {
        this.NbCategories = NbCategories;
    }
    
    
    
}
