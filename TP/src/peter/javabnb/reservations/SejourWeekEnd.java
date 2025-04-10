package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SejourWeekEnd extends Sejour {
    SejourWeekEnd(LocalDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }

    @Override
    public boolean aUnNombreDeNuitsCorrecte() {
        return nbNuits == 2;
    }

    @Override
    public boolean aUneDateArriveeCorrecte() {
        return super.aUneDateArriveeCorrecte() && dateArrivee.getDayOfWeek() == DayOfWeek.FRIDAY;
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
