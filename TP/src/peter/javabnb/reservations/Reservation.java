package peter.javabnb.reservations;

import peter.javabnb.outils.MaDate;
import peter.javabnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {

    private Voyageur voyageur;

    private Reservable objetReservable;

    private Date dateDeReservation;

    public Reservation(Voyageur voyageur, Reservable objetReservable) {
        this.voyageur = voyageur;
        this.objetReservable = objetReservable;
        this.dateDeReservation = new MaDate();
    }

    public void afficher() {
        System.out.print("Réservation faite le " + dateDeReservation + " par le voyageur ");
        voyageur.afficher();
        System.out.print(" chez ");
        objetReservable.afficher();
    }
}
