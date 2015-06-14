/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PapiMartial
 */
public class Emprunt implements Serializable{

    private Adherent emprunteur;
    private Livre livre;
    private Date date;

    public Emprunt(Adherent emprunteur, Livre livre) {
        if (livre.isEmpruntable()) {
            this.emprunteur = emprunteur;
            livre.setNbexemplairedispo(livre.getNbexemplairedispo() - 1);
            this.livre = livre;
            this.emprunteur.getLivres().add(livre);
            this.date = new Date();
        }else{
            
        }
    }

    public Emprunt(Adherent emprunteur, Livre livre, Date date) {
        this.date = date;
        this.emprunteur = emprunteur;
        this.livre = livre;
        this.emprunteur.getLivres().add(livre);
    }

    @Override
    public String toString() {
        return " { Emprunt : " + this.emprunteur.toString() + " a emprunté " + this.livre.toString() + " le " + this.getDate() + " }";
    }

    /**
     * @return the emprunteur
     */
    public Adherent getEmprunteur() {
        return emprunteur;
    }

    /**
     * @param emprunteur the emprunteur to set
     */
    public void setEmprunteur(Adherent emprunteur) {
        this.emprunteur = emprunteur;
    }

    /**
     * @return the livre
     */
    public Livre getLivre() {
        return livre;
    }

    /**
     * @param livre the livre to set
     */
    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

}
