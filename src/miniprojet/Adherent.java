/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author PapiMartial
 */
public class Adherent implements Serializable, Comparable {

    private String Nom;
    private String Prenom;
    private String Mail;
    private String Profession;
    private String Adresse;
    private int Age;
    private int Empruntencours;
    private ArrayList<Livre> Livres;

    public Adherent(String Nom, String Prenom, String Mail, String Profession, int Age, String Adresse, int Empruntencours, ArrayList<Livre> Livres) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Mail = Mail;
        this.Profession = Profession;
        this.Adresse = Adresse;
        this.Age = Age;
        this.Livres = Livres;
        this.Empruntencours = this.Livres.size();

    }

    public Adherent(String Nom, String Prenom, String Mail, String Profession, String Adresse, int Age) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Mail = Mail;
        this.Adresse = Adresse;
        this.Profession = Profession;
        this.Age = Age;
        this.Livres = new ArrayList<Livre>();
        this.Empruntencours = this.Livres.size();
    }

    public Adherent() {
        this.Nom = "Kayonga";
        this.Prenom = "Earvin";
        this.Mail = "demoneartin@gmail.com";
        this.Adresse = "14 Rue de la Paix MonopolyVille ";
        this.Profession = "Développeur";
        this.Age = 23;
        this.Livres = new ArrayList<Livre>();
        this.Empruntencours = this.Livres.size();
    }

    public void addLivre(Livre a) {
        this.Livres.add(a);
        this.Empruntencours++;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the Prenom
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * @param Prenom the Prenom to set
     */
    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    /**
     * @return the Mail
     */
    public String getMail() {
        return Mail;
    }

    /**
     * @param Mail the Mail to set
     */
    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    /**
     * @return the Profession
     */
    public String getProfession() {
        return Profession;
    }

    /**
     * @param Profession the Profession to set
     */
    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    /**
     * @return the Age
     */
    public int getAge() {
        return Age;
    }

    /**
     * @param Age the Age to set
     */
    public void setAge(int Age) {
        this.Age = Age;
    }

    /**
     * @return the Empruntencours
     */
    public int getEmpruntencours() {
        return Empruntencours;
    }

    /**
     * @param Empruntencours the Empruntencours to set
     */
    public void setEmpruntencours(int Empruntencours) {
        this.Empruntencours = Empruntencours;
    }

    /**
     * @return the Livre
     */
    public ArrayList<Livre> getLivres() {
        return Livres;
    }

    /**
     * @param Livres
     */
    public void setLivre(ArrayList<Livre> Livres) {
        this.Livres = Livres;
    }

    @Override
    public String toString() {
        if (!(this.Empruntencours < 1)) {
            return "{ Adherent : " + "Nom : " + this.getNom() + ", Prenom : " + this.getPrenom() + ", " + this.getEmpruntencours() + " emprunts, " + " Mail : " + this.getMail() + ", Adresse : " + this.Adresse + "}";
        }
        return "{ Adherent : " + "Nom : " + this.getNom() + ", Prenom : " + this.getPrenom() + ", Pas d'emprunts, " + "Mail : " + this.getMail() + ", Adresse : " + this.Adresse + " }";
    }

    /**
     * @return the Adresse
     */
    public String getAdresse() {
        return Adresse;
    }

    /**
     * @param Adresse the Adresse to set
     */
    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

  
    public int compareTo(Object o) {
        return Comparators.NOM.compare(this, (Adherent) o);
    }

    

    public static class Comparators {

        public static Comparator<Adherent> NOM = new Comparator<Adherent>() {

            public int compare(Adherent o1, Adherent o2) {
                return o1.Nom.compareTo(o2.Nom);
            }
        };
    }

}
