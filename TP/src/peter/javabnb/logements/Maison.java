package peter.javabnb.logements;

import peter.javabnb.utilisateurs.Hote;

public class Maison extends Logement {

    private final int superficieDuJardin;
    private final boolean possedePiscine;

    public Maison(Hote hote, String nom, int tarifParNuit, String adresse, int superifie, int nbVoyageurMax, int superficieDuJardin, boolean possedePiscine) {
        super(hote, nom, tarifParNuit, adresse, superifie, nbVoyageurMax);
        this.superficieDuJardin = superficieDuJardin;
        this.possedePiscine = possedePiscine;
    }

    public boolean aUnePiscineInterieur() {
        return superficieDuJardin == 0 && possedePiscine;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("La maison (" + getNom() + ") est située " + getAdresse());
        System.out.println("Superficie : " + getSuperifie() + "m2");
        System.out.println("Superficie du jardin : " + superficieDuJardin + "m2");
        System.out.println("Piscine : " + ((possedePiscine) ? "oui" : "non"));
    }
}
