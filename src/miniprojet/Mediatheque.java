
package miniprojet;

import java.util.ArrayList;


/**
 *
 * @author PapiMartial
 */
public interface Mediatheque { 
    public void afficherAdherents();
    public void afficheLivres();
    public void afficheLecteursEnRetard();
    public void recherche();
    public void afficheDate();
    public void ajoutAdherent( Adherent b);
    public void ajoutLivre( Livre b);
    public void supprAdherent(Adherent b);
    public void supprLivre( Livre b);
    public void emprunt(Livre a, Adherent b);
    public void rendre(Livre a, Adherent b);
    public void updateLivre(Livre a);
    public void updateAdherent(Adherent a);
    
    
}
