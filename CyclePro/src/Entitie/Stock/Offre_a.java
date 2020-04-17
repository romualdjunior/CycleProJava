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
public class Offre_a {
     public int id;
        public double nvPrix ;
         public Date dateDebut ;
         public Date dateFin ;
     public int pourcentage ;
     public int Accessoires ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getAccessoires() {
        return Accessoires;
    }

    public void setAccessoires(int Accessoires) {
        this.Accessoires = Accessoires;
    }

    public Offre_a(int id, double nvPrix, Date dateDebut, Date dateFin, int pourcentage, int Accessoires) {
        this.id = id;
        this.nvPrix = nvPrix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pourcentage = pourcentage;
        this.Accessoires = Accessoires;
    }

    public Offre_a(double nvPrix, Date dateDebut, Date dateFin, int pourcentage, int Accessoires) {
        this.nvPrix = nvPrix;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pourcentage = pourcentage;
        this.Accessoires = Accessoires;
    }
  
    
     
}
