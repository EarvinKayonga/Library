/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PapiMartial
 */
public class Bibliotheque implements Serializable, Mediatheque {

    private ArrayList<Adherent> adherents;
    private ArrayList<Livre> livres;
    private ArrayList<Emprunt> emprunts;

    public Bibliotheque() {
        this.adherents = new ArrayList<Adherent>();
        this.livres = new ArrayList<Livre>();
        this.emprunts = new ArrayList<Emprunt>();
    }

    public Bibliotheque(boolean val) throws FileNotFoundException, IOException, ClassNotFoundException  {
        //load from a file
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("bibliotheque.txt"));
        Object t = in.readObject();
        if (t instanceof Bibliotheque) {
             Bibliotheque b= (Bibliotheque) t;
             this.adherents = b.getAdherents();
             this.livres = b.getLivres();
             this.emprunts = b.getEmprunts();
        } else {
            System.out.println("Erreur");
        }
        in.close();
        
        
    }

    public Bibliotheque(ArrayList<Adherent> adherents, ArrayList<Livre> livres, ArrayList<Emprunt> emprunts) {
        this.adherents = adherents;
        this.livres = livres;
        this.emprunts = emprunts;
    }
    
    

    @Override
    public void recherche() {

    }

    public void updateLivre(Livre a,Livre old) {
        int index = this.livres.indexOf(old);
        this.livres.add(index, a);
    }

    public void updateAdherent(Adherent nouveau, Adherent old ) {
        int index = this.adherents.indexOf(old);
        this.adherents.add(index, nouveau);
    }

    @Override
    public void afficheLecteursEnRetard() {

    }

    @Override
    public void afficheLivres() {
        System.out.println( "La Liste des livres : "+this.livres);
    }

    @Override
    public void afficherAdherents() {
        System.out.println( "La Liste des adhérents : "+this.adherents);
    }

    @Override
    public void afficheDate() {
        System.out.println("La date courante :" +new Date());
    }

    @Override
    public void ajoutAdherent(Adherent b) {
        if (!this.adherents.contains(b)) {
            this.getAdherents().add(b);
            try {
                this.save();
            } catch (IOException ex) {
                Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    @Override
    public void ajoutLivre(Livre b) {
        if (!this.livres.contains(b)) {
            this.getLivres().add(b);
            try {
                this.save();
            } catch (IOException ex) {
                Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    @Override
    public void supprAdherent(Adherent a) {
        if (this.getAdherents().contains(a)) {
            this.getAdherents().remove(a);
            try {
                this.save();
            } catch (IOException ex) {
                Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    @Override
    public void supprLivre(Livre a) {
        if (this.getLivres().contains(a)) {
            this.getLivres().remove(a);
            try {
                this.save();
            } catch (IOException ex) {
                Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }

    @Override
    public void emprunt(Livre a, Adherent b) {
        if (!this.adherents.contains(b)) {
            this.ajoutAdherent(b);
        } else if (!a.isEmpruntable()) {
            return;
        }
        b = this.adherents.get(this.adherents.indexOf(b));
        b.addLivre(a);
        this.getEmprunts().add(new Emprunt(b, a));
        
        try {
            this.save();
        } catch (IOException ex) {
            Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rendre(Livre a, Adherent b) {
        Emprunt t = null;
        for (Emprunt cmp : this.getEmprunts()) {
            if ((cmp.getLivre() == a) && (cmp.getEmprunteur() == b)) {
                t = cmp;
            }
        }
        if (t == null) {
            return;
        } else {
            t.getLivre().setNbexemplairedispo(t.getLivre().getNbexemplairedispo() + 1);
            this.getEmprunts().remove(t);
        }
        try {
            this.save();
        } catch (IOException ex) {
            Logger.getLogger(Bibliotheque.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void save() throws FileNotFoundException, IOException {
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("bibliotheque.txt"));
        output.writeObject(this);

        output.close();
    }
    
    public void send(){
        
    }

    /**
     * @return the adherents
     */
    public ArrayList<Adherent> getAdherents() {
        return adherents;
    }

    /**
     * @return the livres
     */
    public ArrayList<Livre> getLivres() {
        return livres;
    }

    /**
     * @return the emprunts
     */
    public ArrayList<Emprunt> getEmprunts() {
        return emprunts;
    }

    @Override
    public String toString() {
        String tmp = "Bibliotheque {  " + "\n";
        tmp += "Livres [ " + "\n";
        for(Livre a : this.livres){
            tmp += a.toString()+ "\n";
        }
        tmp += " ]"+ "\n";
        tmp += "Adherents [" + "\n";
        for(Adherent a : this.adherents){
            tmp += a.toString()+ "\n";
        }
        tmp += "] "+"\n";
        tmp += "Emprunts [" + "\n";
        for(Emprunt a : this.emprunts){
            tmp += a.toString()+ "\n";
        }
        tmp += "] "+"\n";
        tmp += " } " ;
        return tmp; 
    }
    
    

}
