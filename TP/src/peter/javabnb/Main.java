package peter.javabnb;

import datas.Recherche;
import peter.javabnb.logements.Logement;
import peter.javabnb.outils.JavaBnBData;
import peter.javabnb.outils.Utile;
import peter.javabnb.reservations.*;
import peter.javabnb.utilisateurs.Voyageur;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Déclaration & Initialisation
        Voyageur monVoyageur = new Voyageur("Peter", "Bardu", 32);

        // Les critères de mon séjour
        LocalDate maDate = LocalDate.now().plusDays(1);
        int nbNuits = Utile.choix("le nombre de nuits", 1, 31);
        int nbVoyageurs = Utile.choix("le nombre de voyageurs", 1, 12);

        Recherche recherche1 = new Recherche.Builder(3).build();
        System.out.println(recherche1);

        Recherche recherche2 = new Recherche.Builder(3)
                .tarifMin(100)
                .tarifMax(220)
                .build();

        Logement logement = JavaBnBData.getInstance().getLogements().get(0);
        // Création d'un séjour (court ou long)
        Sejour monSejour = SejourFactory.creerSejour(maDate, logement, nbNuits, nbVoyageurs);
        try {
            Reservation maReservation = new Reservation(monVoyageur, monSejour);
            maReservation.afficher();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}