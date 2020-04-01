/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Commande;

/**
 *
 * @author toshiba
 */
public class Location {
    private int id;
    private int quantite;
    private String DateDebut;
    private String DateFin;
    private int idProduit;
    private int idUser;

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", quantite=" + quantite + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + ", idProduit=" + idProduit + ", idUser=" + idUser + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDateDebut(String DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(String DateFin) {
        this.DateFin = DateFin;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Location(int quantite, String DateDebut, String DateFin, int idProduit, int idUser) {
        this.quantite = quantite;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.idProduit = idProduit;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getDateDebut() {
        return DateDebut;
    }

    public String getDateFin() {
        return DateFin;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public int getIdUser() {
        return idUser;
    }
    
}
