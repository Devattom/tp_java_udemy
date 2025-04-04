package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {

    private int prix;

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        prix = nbNuits * logement.getTarifParNuit();
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour court est de " + prix + "€");
    }
}
