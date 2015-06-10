/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

/**
 *
 * @author PapiMartial
 */
public class Livre {

    private String titre;
    private String auteur;
    private String theme;
    private int numero;
        private int nbexemplaires;
    private int nbexemplairedispo;

    public Livre(String titre, String auteur, String theme, int numero, int nbexemplaires, int nbexemplairedispo) {
        this.titre = titre;
        this.auteur = auteur;
        this.theme = theme;
        this.numero = numero;
        this.nbexemplaires = nbexemplaires;
        this.nbexemplairedispo = nbexemplairedispo;
    }

    public Livre(String titre, String auteur, String theme, int numero, int nbexemplaires) {
        this.titre = titre;
        this.auteur = auteur;
        this.theme = theme;
        this.numero = numero;
        this.nbexemplaires = nbexemplaires;
        this.nbexemplairedispo = this.nbexemplaires;
    }

    public Livre() {
        this.titre = "L'assomoir";
        this.auteur = "Emile Zola";
        this.theme = "ROM";
        this.numero = 436;
        this.nbexemplaires = 4;
        this.nbexemplairedispo = 4;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme the theme to set
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the nbexemplaires
     */
    public int getNbexemplaires() {
        return nbexemplaires;
    }

    /**
     * @param nbexemplaires the nbexemplaires to set
     */
    public void setNbexemplaires(int nbexemplaires) {
        this.nbexemplaires = nbexemplaires;
    }

    /**
     * @return the nbexemplairedispo
     */
    public int getNbexemplairedispo() {
        return nbexemplairedispo;
    }

    /**
     * @param nbexemplairedispo the nbexemplairedispo to set
     */
    public void setNbexemplairedispo(int nbexemplairedispo) {
        this.nbexemplairedispo = nbexemplairedispo;
    }

    public String getCode() {
        return this.theme.toString() + this.numero;
    }
    
    public boolean isEmpruntable(){
        return this.nbexemplaires >= 0;
    }

    @Override
    public String toString() {
        if(this.isEmpruntable()){
               return "{ Livre : "  + " disponible " + "Titre : " + this.getTitre() + " Auteur : " + this.getAuteur() + " Code : " + this.getCode() + " }";
        }else{
               return "{ Livre : "  + " non disponible " + "Titre : " + this.getTitre() + " Auteur : " + this.getAuteur() + " Code : " + this.getCode() + " }";
        }
     }
    
    

}
