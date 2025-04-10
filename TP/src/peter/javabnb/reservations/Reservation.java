package peter.javabnb.reservations;

import peter.javabnb.utilisateurs.Voyageur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private Voyageur voyageur;

    private Reservable objetReservable;

    private LocalDate dateDeReservation;

    /**
     *
     *
     * @param voyageur
     * @param objetReservable
     * @throws Exception
     */
    public Reservation(Voyageur voyageur, Reservable objetReservable) throws Exception{
        if (!objetReservable.aUnNombreDeVoyageursCorrecte() ) {
            throw new Exception("Le nombre de voyageur est incorrect");
        } else if(!objetReservable.aUneDateArriveeCorrecte()) {
            throw new Exception("La date d'arrivée est incorrecte");
        } else if (!objetReservable.aUnNombreDeNuitsCorrecte()) {
            throw new Exception("Le nombre de nuits est incorrect");
        }

        this.voyageur = voyageur;
        this.objetReservable = objetReservable;
        this.dateDeReservation = LocalDate.now();
    }

    public void afficher() {
        System.out.print("Réservation faite le " + dateDeReservation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " par le voyageur ");
        voyageur.afficher();
        System.out.print(" chez ");
        objetReservable.afficher();
    }
}
