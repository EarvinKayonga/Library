/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author PapiMartial
 */
public class Miniprojet {

    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
         
        
        Bibliotheque example  = new Bibliotheque();
        reset(example);       
        
        /* example = new Bibliotheque(true);
        example.afficheDate();
        example.ByName();
        example.ByTitre();
        example.ByAuteur();
        example.ByCode();
        example.afficheLecteursEnRetard();
        example.ajoutAdherent(new Adherent("Hawk","Ethan","ethan@gmail.com","acteur","35 rue Louis Valtics Paris", 53));
        example.ajoutLivre(new Livre("Les rivales", "Michel Peyramaure", "ROM", 225, 5));
        
        // Fabien emprunte le livre L'Assomoir de Zola
        example.emprunt(example.getLivres().get(0), example.getAdherents().get(4));*/
        
        //System.out.print(example);
                
                
        
    }
    
    public static void reset(Bibliotheque example) throws IOException{
              
        ArrayList<Adherent> adh = new ArrayList<Adherent>(); // Constitution d'une liste d'Adherents
        adh.add(new Adherent()); 
        adh.add(new Adherent("Fremy","Christelle","christelle.fremy@gmail.com","Boulangère","36 quai des orfèvres Paris", 23)); 
        adh.add(new Adherent("Lizzé", "Raffaele","raffaele@gmail.com"," Artiste peintre"," 26 rue de la santé Paris", 49));
        adh.add(new Adherent("Guyan", "Mathieu","guyan@gmail.com"," Photoshopper"," 26 rue de la paix Paris", 79));
        adh.add(new Adherent("Telier", "Fabien","fabiche@gmail.com","Cascadeur"," 26 quai de la rappée Paris", 74));
        adh.add(new Adherent("Nyamabo", "Randy","randy@gmail.com"," Poulet Man","15 Restaurant Crous de Villetaneuse", 19));
        adh.add(new Adherent("Francis", "Louis","louis@gmail.com","Developpeur Oscript"," 26 boulevard Magenta Villejuif", 49));
 
        ArrayList<Livre> liv = new ArrayList<Livre>();  // Constitution d'une liste de livres
        liv.add(new Livre());
        liv.add(new Livre("Rouge et Noir", "Stendhal", "ROM", 789, 8));
        liv.add(new Livre("L'éducation sentimentale", "Gustave Flaubert", "ROM", 740, 4));
        liv.add(new Livre("Sciences et Vie", "St", "MAG", 145, 8));
        liv.add(new Livre("Veronika veut mourrir", "Paul Coelho", "ROM", 945, 2));
        liv.add(new Livre("Les Georgiques", "Virgile", "POE", 130, 8));
        liv.add(new Livre("Le choix de Diane", "Kate Quinn", "ROM", 189, 8));
        
        example = new Bibliotheque(adh,liv,new ArrayList<Emprunt>()); // initiailisation de la bibliothèque
        
        // Christelle fremy emprunte le livre Le choix de Diane
        example.emprunt(example.getLivres().get(5), example.getAdherents().get(1));
        
        example.save();        
       // System.out.print(example);
    }
    
}
