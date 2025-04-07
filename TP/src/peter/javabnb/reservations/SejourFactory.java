package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.util.Date;

public final class SejourFactory {

    private SejourFactory() {}

    public static Sejour creerSejour(Date dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {
        Sejour sejour;
        if (nbNuits == 2 && dateArrivee.getDay() == 5) {
            sejour = new SejourWeekEnd(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else if (nbNuits < 6) {
            sejour = new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else {
            sejour = new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
        }

        return sejour;
    }
}
