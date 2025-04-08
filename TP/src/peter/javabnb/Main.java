package peter.javabnb;

import peter.javabnb.logements.Appartement;
import peter.javabnb.logements.Chalet;
import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;
import peter.javabnb.outils.JavaBnBData;
import peter.javabnb.outils.MaDate;
import peter.javabnb.outils.Utile;
import peter.javabnb.reservations.*;
import peter.javabnb.utilisateurs.Hote;
import peter.javabnb.utilisateurs.Voyageur;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Déclaration & Initialisation
        Voyageur monVoyageur = new Voyageur("Peter", "Bardu", 32);

        // Les critères de mon séjour
        Date maDate = new MaDate(15, 4, 2025);


        int nbNuits = Utile.choix("le nombre de nuits", 1, 31);

        Logement logement = JavaBnBData.getInstance().getLogements().get(0);

        int nbVoyageurs = Utile.choix("le nombre de voyageurs", 1, 12);

        // Création d'un séjour (court ou long)
        Sejour monSejour;

        if (nbNuits == 2 && maDate.getDay() == 5) {
            monSejour = new SejourWeekEnd(maDate, nbNuits, logement, nbVoyageurs);
        } else if (nbNuits < 6) {
            monSejour = new SejourCourt(maDate, nbNuits, logement, nbVoyageurs);
        } else {
            monSejour = new SejourLong(maDate, nbNuits, logement, nbVoyageurs);
        }

        try {
            Reservation maReservation = new Reservation(monVoyageur, monSejour);
            maReservation.afficher();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}