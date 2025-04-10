package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public final class SejourFactory {

    private SejourFactory() {}

    public static Sejour creerSejour(LocalDate dateArrivee, Logement logement, int nbNuits, int nbVoyageurs) {
        Sejour sejour;
        if (nbNuits == 2 && dateArrivee.getDayOfWeek() == DayOfWeek.FRIDAY) {
            sejour = new SejourWeekEnd(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else if (nbNuits < 6) {
            sejour = new SejourCourt(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else {
            sejour = new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
        }

        return sejour;
    }
}
