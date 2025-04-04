package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour {

    private static final int PROMOTION_EN_POURCENTAGE = 20;

    private int promotion;

    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        int prixInitial = nbNuits * logement.getTarifParNuit();
        promotion = prixInitial * PROMOTION_EN_POURCENTAGE / 100;
        prix = prixInitial - promotion;
    }

    @Override
    public void afficher() {
        afficherSejour();

        System.out.println("Le prix de ce séjour long est de " + prix + "€ (avec une promotion de " + promotion + "€)");
    }

    /**
     *
     * @return true si le nombre de nuits est compris entre 1 et 31, false sinon
     */
    @Override
    public boolean aUnNombreDeNuitsCorrecte() {
        return nbNuits >= 6 && nbNuits <= 31;
    }
}
