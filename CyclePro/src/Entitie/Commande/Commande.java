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
public class Commande {
    private int id;
    private int total;
    private String etat;
    private String date;
    private int idUser;
    private int idAdresse;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public String getEtat() {
        return etat;
    }

    public String getDate() {
        return date;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getAdresse() {
        return idAdresse;
    }

    public Commande(int total, String etat, String date, int idUser, int idAdresse) {
        this.total = total;
        this.etat = etat;
        this.date = date;
        this.idUser = idUser;
        this.idAdresse = idAdresse;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", total=" + total + ", etat=" + etat + ", date=" + date + ", idUser=" + idUser + ", idAdresse=" + idAdresse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
