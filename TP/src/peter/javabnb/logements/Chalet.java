package peter.javabnb.logements;

import peter.javabnb.utilisateurs.Hote;

public class Chalet extends Logement {

    private final int altitude;

    public Chalet(Hote hote, String nom, int tarifParNuit, String adresse, int superifie, int nbVoyageurMax, int altitude) {
        super(hote, nom, tarifParNuit, adresse, superifie, nbVoyageurMax);
        this.altitude = altitude;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("Le chalet (" + getNom() + ") est situé " + getAdresse());
        System.out.println("Superficie : " + getSuperifie() + "m2");
        System.out.println("Altitude : " + altitude + "m");
    }
}
