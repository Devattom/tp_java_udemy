package peter.javabnb.logements;

import peter.javabnb.utilisateurs.Hote;
import peter.javabnb.utilisateurs.Personne;

public abstract class Logement {

    private final Hote hote;
    private final String nom;
    private final int tarifParNuit;
    private final String adresse;
    private final int superifie;
    private final int nbVoyageurMax;

    public Logement(Hote hote, String nom, int tarifParNuit, String adresse, int superifie, int nbVoyageurMax) {
        this.hote = hote;
        this.nom = nom;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superifie = superifie;
        this.nbVoyageurMax = nbVoyageurMax;
    }

    public abstract void afficher();

    public Personne getHote() {
        return hote;
    }

    public String getNom() {
        return nom;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getSuperifie() {
        return superifie;
    }

    public int getNbVoyageurMax() {
        return nbVoyageurMax;
    }
}
