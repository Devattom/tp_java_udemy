package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.util.Date;

public class SejourWeekEnd extends Sejour {
    public SejourWeekEnd(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public boolean aUnNombreDeNuitsCorrecte() {
        return nbNuits == 2;
    }

    @Override
    public boolean aUneDateArriveeCorrecte() {
        return super.aUneDateArriveeCorrecte() && dateArrivee.getDay() == 5;
    }

    @Override
    public void afficher() {
        afficherSejour();
        System.out.println("Ce séjour weekend est au prix de " + prix + " € (avec 50 euros de promotion)");
    }

    @Override
    public void miseAJourDuPrixDuSejour() {
        prix = nbNuits * logement.getTarifParNuit() - 50;
    }

}
