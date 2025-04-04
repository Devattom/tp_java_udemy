package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour {

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        prix = nbNuits * logement.getTarifParNuit();
    }

    @Override
    public void afficher() {
        afficherSejour();
        System.out.println("Le prix de ce séjour court est de " + prix + "€");
    }

    /**
     *
     * @return true si le nombre de nuits est compris entre 1 et 31, false sinon
     */
    @Override
    public boolean aUnNombreDeNuitsCorrecte() {
        return nbNuits >= 1 && nbNuits <= 5;
    }
}
