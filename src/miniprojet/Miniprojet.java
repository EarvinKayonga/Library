/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author PapiMartial
 */
public class Miniprojet {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, ParseException {

        Bibliotheque example = new Bibliotheque();
        ArrayList<Adherent> adh = new ArrayList<Adherent>(); // Constitution d'une liste d'Adherents
        adh.add(new Adherent());
        adh.add(new Adherent("Fremy", "Christelle", "christelle.fremy@gmail.com", "Boulangère", "36 quai des orfèvres Paris", 23));
        adh.add(new Adherent("Lizzé", "Raffaele", "raffaele@gmail.com", " Artiste peintre", " 26 rue de la santé Paris", 49));
        adh.add(new Adherent("Guyan", "Mathieu", "guyan@gmail.com", " Photoshopper", " 26 rue de la paix Paris", 79));
        adh.add(new Adherent("Telier", "Fabien", "fabiche@gmail.com", "Cascadeur", " 26 quai de la rappée Paris", 74));
        adh.add(new Adherent("Nyamabo", "Randy", "randy@gmail.com", " Poulet Man", "15 Restaurant Crous de Villetaneuse", 19));
        adh.add(new Adherent("Francis", "Louis", "louis@gmail.com", "Developpeur Oscript", " 26 boulevard Magenta Villejuif", 49));

        ArrayList<Livre> liv = new ArrayList<Livre>();  // Constitution d'une liste de livres
        liv.add(new Livre());
        liv.add(new Livre("Rouge et Noir", "Stendhal", "ROM", 789, 8));
        liv.add(new Livre("L'éducation sentimentale", "Gustave Flaubert", "ROM", 740, 4));
        liv.add(new Livre("Sciences et Vie", "St", "MAG", 145, 8));
        liv.add(new Livre("Veronika veut mourrir", "Paul Coelho", "ROM", 945, 2));
        liv.add(new Livre("Les Georgiques", "Virgile", "POE", 130, 8));
        liv.add(new Livre("Le choix de Diane", "Kate Quinn", "ROM", 189, 8));

        example = new Bibliotheque(adh, liv, new ArrayList<Emprunt>()); // initiailisation de la bibliothèque

        // Christelle fremy emprunte le livre Le choix de Diane
        example.emprunt(example.getLivres().get(5), example.getAdherents().get(1));

        //Raffaele fremy emprunte le livre Le choix de Diane le 29 Mai
        String str = "Friday, 29th May";
        str = str.replaceAll("(\\d\\d)..", "$1") + " " + Calendar.getInstance().get(Calendar.YEAR);
        Date date = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.US).parse(str);
        example.emprunt(example.getLivres().get(5), example.getAdherents().get(2), date);

        example.save();

        //example = new Bibliotheque(true);
        example.afficheDate();
        example.ByName();
        example.ByTitre();
        example.ByAuteur();
        example.ByCode();
        example.afficheLecteursEnRetard();
        example.ajoutAdherent(new Adherent("Hawk", "Ethan", "ethan@gmail.com", "acteur", "35 rue Louis Valtics Paris", 53));
        example.ajoutLivre(new Livre("Les rivales", "Michel Peyramaure", "ROM", 225, 5));

        // Raffaele emprunte le livre L'Assomoir de Zola
        example.emprunt(example.getLivres().get(0), example.getAdherents().get(4));

        System.out.println(example);

    }

}
