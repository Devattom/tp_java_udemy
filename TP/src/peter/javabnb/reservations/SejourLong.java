package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour {

    private static final int PROMOTION_EN_POURCENTAGE = 20;

    private int prix;
    private int promotion;

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);

        int prixInitial = nbNuits * logement.getTarifParNuit();
        promotion = prixInitial * PROMOTION_EN_POURCENTAGE / 100;
        prix = prixInitial - promotion;
    }

    @Override
    public void afficher() {
        super.afficher();

        System.out.println("Le prix de ce séjour long est de " + prix + "€ (avec une promotion de " + promotion + "€)");
    }
}
