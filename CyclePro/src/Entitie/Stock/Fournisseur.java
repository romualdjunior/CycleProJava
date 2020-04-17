/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Stock;

/**
 *
 * @author Yasmine
 */
public class Fournisseur {
      public int id;
   public String raisonSociale;
   public String telephone ;
   public String mail ;
   public String matricule ;
   public String addresse;

    public Fournisseur() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String RaisonSociale) {
        this.raisonSociale = RaisonSociale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String Mail) {
        this.mail = Mail;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String Matricule) {
        this.matricule = Matricule;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }


    public Fournisseur(int id, String raisonSociale, String matricule, String addresse, String mail, String telephone) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.telephone = telephone;
        this.mail = mail;
        this.matricule = matricule;
        this.addresse = addresse;
  
    }

    public Fournisseur(int id) {
        this.id = id;
    }

    public Fournisseur(String raisonSociale, String telephone, String mail, String matricule, String addresse) {
        this.raisonSociale = raisonSociale;
        this.telephone = telephone;
        this.mail = mail;
        this.matricule = matricule;
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Fournisseur{" + "id=" + id + ", RaisonSociale=" + raisonSociale +", Matricule=" + matricule + ", addresse=" + addresse + ", Mail=" + mail +  ", telephone=" + telephone +  '}';
    }

}
