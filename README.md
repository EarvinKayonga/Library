# Projet Library
Java project for School

I Mise en route

git clone [https://github.com/EarvinKayonga/Library.git](https://github.com/EarvinKayonga/Library.git) ou  allez  à [https://codeload.github.com/EarvinKayonga/Library/zip/master](https://codeload.github.com/EarvinKayonga/Library/zip/master)  pour telecharger les sources Ensuite ouvrir avec netbeans ou eclipse

II - Implementation

Cette implementation d'une bibliothèque comporte 4 classes et 1 interfaces :


      - reset


Cette fonction permet d'effacer le fichier et de le remplir à nouveau avec des valeurs.

Une instance de la classe Adherent peut emprunter et rendre des instances de Livres via la classe Emprunt. Voici un petit descriptif du diagramme de classe

Une classe Adherent ( Nom, Prenom, Mail, adresse, ...) :


    Methodes:
    - getters, setters,toString,


Une classe Livre ( Titre, Auteur, Theme, Numero, Nombre d'exemplaires, Nombre d'exemplaire disponibles) :


    Methodes:
    - getters, setters,toString,
    - Code : theme + Numero,


Une classe Emprunt ( Emprunteur, Livre, Date ) :


    Methodes:
    - getters, setters, toString,


Une classe Bibliotheque ( Liste des Adherents, Liste des emprunts, Liste des Livres) :     Cette classe est Serializable, et implemente l'interface Mediatheque


    Methodes:
    - getters, setters, toString, les fonctions de l'interface Mediatheque,
    - save ( methodes que ecrit l'instance en cours dans un fichier "bibliotheqe.txt" dans le dossier racine),
    - Constructeur particulier qui permet de charger une instance de la classe Bibliotheque à partir d'un fichier : Bibliotheque(boolean r)

    - afficheDate(), Affiche la date Courant
    - ByName(), Affiche la liste des Adherents par ordre alphabétique
    - ByTitre(), Affiche la liste des livres par titre par ordre alphabétique
    - ByAuteur(),  Affiche la liste des livres par auteur par ordre alphabétique
    - ByCode(),   Affiche la liste des livres par code par ordre alphabétique
    - afficheLecteursEnRetard()  Affiche la liste des adherents en retard


Une interface publique Mediatheque :


    Méthodes:
    - afficherAdherents(),
    - afficheLivres(),
    - afficheLecteursEnRetard(),
    - recherche(),
    - afficheDate(),
    - ajoutAdherent( Adherent b),
    - ajoutLivre( Livre b),
    - supprAdherent(Adherent b),
    - supprLivre( Livre b),
    - emprunt(Livre a, Adherent b),
    - emprunt(Livre a, Adherent b,Date c), Avec une date différée
    - rendre(Livre a, Adherent b),
    - updateLivre(Livre new, Livre old),
    - updateAdherent(Adherent new,Livre old),

III - Insuffisances et Améliorations possibles

1) Défauts

L'implementation de cette application rend le reverse engineering  possible et même facile. Cela vient de la faible complexité dans son architecture

De plus, le stockage est effectué avec io.ObjectOutputStream, dans le fichier "bibliotheque.txt" dans le dossier racine. Les informations sont bien sûr serialisées. Ce système de stockage est très discutable:
- Le fichiers de stockage sont facilement corruptibles,
- Les accès disque ne sont pas optimisés,
- Les fichiers de stockage sont sur la machine locale et non une machine distante,
- Les enjeux qui relèvent du transactionnel, de persistance et de la concurrence d'accès ne sont pas abordés.
- Enfin, si l'objet de la classe Bibliotheque devient trop gros, le heap space risque d'être débordé.

2) Améliorations

Une application Web est mieux adapté pour ce projet. Les fichiers de stockage devraient être en sécurité sur un serveur avec de la persistance via JPA. Le multiposte et le multithreading (coté serveur pour palier aux problèmes d'accès concurrents ) seront donc possibles.
