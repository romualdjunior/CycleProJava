/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Evenement;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Event {
   
    private int id;
    private String nom;
    private String description;
    private float prix;
    private String photoEvent;
    private String adresse;
    private float logitudeDep;
    private float longitudeArrv;
    private float latitudeDep;
    private float latitudeArrv;
    private Date dateDebut;
    private Date dateFin;
    private int nbrplace;
    private float evaluation;
    private String niveau;
    private String Type;
    private String membre;
    private int tel;
    private String email;
    //liste des commentaire 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getPhotoEvent() {
        return photoEvent;
    }

    public void setPhotoEvent(String photoEvent) {
        this.photoEvent = photoEvent;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getLogitudeDep() {
        return logitudeDep;
    }

    public void setLogitudeDep(float logitudeDep) {
        this.logitudeDep = logitudeDep;
    }

    public float getLongitudeArrv() {
        return longitudeArrv;
    }

    public void setLongitudeArrv(float longitudeArrv) {
        this.longitudeArrv = longitudeArrv;
    }

    public float getLatitudeDep() {
        return latitudeDep;
    }

    public void setLatitudeDep(float latitudeDep) {
        this.latitudeDep = latitudeDep;
    }

    public float getLatitudeArrv() {
        return latitudeArrv;
    }

    public void setLatitudeArrv(float latitudeArrv) {
        this.latitudeArrv = latitudeArrv;
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

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getMembre() {
        return membre;
    }

    public void setMembre(String membre) {
        this.membre = membre;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Event() {
    }

    public Event(int id, String nom, String description, float prix, String photoEvent, String adresse, float logitudeDep, float longitudeArrv, float latitudeDep, float latitudeArrv, Date dateDebut, Date dateFin, int nbrplace, float evaluation, String niveau, String Type, String membre, int tel, String email) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photoEvent = photoEvent;
        this.adresse = adresse;
        this.logitudeDep = logitudeDep;
        this.longitudeArrv = longitudeArrv;
        this.latitudeDep = latitudeDep;
        this.latitudeArrv = latitudeArrv;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrplace = nbrplace;
        this.evaluation = evaluation;
        this.niveau = niveau;
        this.Type = Type;
        this.membre = membre;
        this.tel = tel;
        this.email = email;
    }

    public Event(String nom, String description, float prix, String photoEvent, String adresse, float logitudeDep, float longitudeArrv, float latitudeDep, float latitudeArrv, Date dateDebut, Date dateFin, int nbrplace, String niveau, String Type, String membre, int tel, String email) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photoEvent = photoEvent;
        this.adresse = adresse;
        this.logitudeDep = logitudeDep;
        this.longitudeArrv = longitudeArrv;
        this.latitudeDep = latitudeDep;
        this.latitudeArrv = latitudeArrv;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrplace = nbrplace;
        this.niveau = niveau;
        this.Type = Type;
        this.membre = membre;
        this.tel = tel;
        this.email = email;
    }

    public Event(String nom, String description, float prix, String photoEvent, String adresse, float logitudeDep, float longitudeArrv, float latitudeDep, float latitudeArrv, Date dateDebut, Date dateFin, int nbrplace, float evaluation, String niveau, String Type, String membre, int tel, String email) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photoEvent = photoEvent;
        this.adresse = adresse;
        this.logitudeDep = logitudeDep;
        this.longitudeArrv = longitudeArrv;
        this.latitudeDep = latitudeDep;
        this.latitudeArrv = latitudeArrv;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrplace = nbrplace;
        this.evaluation = evaluation;
        this.niveau = niveau;
        this.Type = Type;
        this.membre = membre;
        this.tel = tel;
        this.email = email;
    }

    public Event(int id, String nom, String description, float prix, String photoEvent, String adresse) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.photoEvent = photoEvent;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", photoEvent=" + photoEvent + ", adresse=" + adresse + ", logitudeDep=" + logitudeDep + ", longitudeArrv=" + longitudeArrv + ", latitudeDep=" + latitudeDep + ", latitudeArrv=" + latitudeArrv + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nbrplace=" + nbrplace + ", evaluation=" + evaluation + ", niveau=" + niveau + ", Type=" + Type + ", membre=" + membre + ", tel=" + tel + ", email=" + email + '}';
    }
    
    
}
