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
public class Payment {
    private int id;
    private String cardHolderName;
    private int cardNumber;
    private int securityCode;
    private int moiExpiration;
     private int anneeExpiration;
    private int idCommande;

    public Payment(String cardHolderName, int cardNumber, int securityCode, int moiExpiration, int anneeExpiration, int idCommande) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.moiExpiration = moiExpiration;
        this.anneeExpiration = anneeExpiration;
        this.idCommande = idCommande;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", cardHolderName=" + cardHolderName + ", cardNumber=" + cardNumber + ", securityCode=" + securityCode + ", moiExpiration=" + moiExpiration + ", anneeExpiration=" + anneeExpiration + ", idCommande=" + idCommande + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public int getMoiExpiration() {
        return moiExpiration;
    }

    public int getAnneeExpiration() {
        return anneeExpiration;
    }

    public int getIdCommande() {
        return idCommande;
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
        final Payment other = (Payment) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    public int getId() {
        return id;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public void setMoiExpiration(int moiExpiration) {
        this.moiExpiration = moiExpiration;
    }

    public void setAnneeExpiration(int anneeExpiration) {
        this.anneeExpiration = anneeExpiration;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
}
