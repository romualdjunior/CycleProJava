/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Stock;

import java.sql.Date;

/**
 *
 * @author Yasmine
 */
public class Offre {
     public int id;
     public int pourcentage ;
     public String Velo ;
     public double nvPrix ;
     public java.sql.Date dateDebut ;
     public java.sql.Date dateFin ;

    public Offre(int pourcentage, String Velo, java.sql.Date dateDebut, java.sql.Date dateFin) {
        this.pourcentage = pourcentage;
        this.Velo = Velo;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getVelo() {
        return Velo;
    }

    public void setVelo(String Velo) {
        this.Velo = Velo;
    }

    public double getNvPrix() {
        return nvPrix;
    }

    public void setNvPrix(double nvPrix) {
        this.nvPrix = nvPrix;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Offre() {
    }

    public Offre(int id, int pourcentage, String Velo, double nvPrix, Date dateDebut, Date dateFin) {
        this.id = id;
        this.pourcentage = pourcentage;
        this.Velo = Velo;
        this.nvPrix = nvPrix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Offre(int pourcentage, String Velo, double nvPrix, Date dateDebut, Date dateFin) {
        this.pourcentage = pourcentage;
        this.Velo = Velo;
        this.nvPrix = nvPrix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
}
