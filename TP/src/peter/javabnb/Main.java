package peter.javabnb;

import peter.javabnb.logements.Appartement;
import peter.javabnb.logements.Chalet;
import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;
import peter.javabnb.outils.MaDate;
import peter.javabnb.reservations.*;
import peter.javabnb.utilisateurs.Hote;
import peter.javabnb.utilisateurs.Voyageur;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Déclaration & Initialisation
        Voyageur monVoyageur = new Voyageur("Peter", "Bardu", 32);
        Hote monHote1 = new Hote("Tom", "Martin", 30, 12);
        Hote monHote2 = new Hote("Emma", "Wilson", 52, 1);

        //Logement monLogement1 = new Logement(monHote1, "Maison au calme", 80, "3 rue des logements", 100, 4);

        Maison maMaison = new Maison(monHote1, "Petite Maison", 60, "12 rue des maisons", 70, 4, 1000, true);
        Appartement monAppartement = new Appartement(monHote2, "Grand appartement", 150, "4 rue des apparts", 120, 6, 10, 4);
        Chalet monChalet = new Chalet(monHote1, "Chalet de montagne", 130, "5 rue de la montagne", 50, 6, 1345);


        // Les critères de mon séjour
        Date maDate = new MaDate(3, 4, 2025);
        int nbNuits = 8;
        Logement logement = monChalet;
        int nbVoyageurs = 2;

        // Création d'un séjour (court ou long)
        Sejour monSejour;

        if (nbNuits == 2 && maDate.getDay() == 5) {
            monSejour = new SejourWeekEnd(maDate, nbNuits, logement, nbVoyageurs);
        } else if (nbNuits < 6) {
            monSejour = new SejourCourt(maDate, nbNuits, logement, nbVoyageurs);
        } else {
            monSejour = new SejourLong(maDate, nbNuits, logement, nbVoyageurs);
        }
        
        Reservation maReservation = new Reservation(monVoyageur, monSejour);

        // Utilisation
        maReservation.afficher();
    }
}