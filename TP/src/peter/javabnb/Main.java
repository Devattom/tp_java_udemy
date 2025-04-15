package peter.javabnb;

import datas.Recherche;
import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;
import peter.javabnb.outils.JavaBnBData;
import peter.javabnb.reservations.*;
import peter.javabnb.utilisateurs.Hote;
import peter.javabnb.utilisateurs.Voyageur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Déclaration & Initialisation
        Voyageur monVoyageur = new Voyageur("Peter", "Bardu", 32);

        // Les critères de mon séjour
        LocalDate maDate = LocalDate.now().plusDays(1);
        int nbNuits = 6; // Utile.choix("le nombre de nuits", 1, 31);
        int nbVoyageurs = 2; // Utile.choix("le nombre de voyageurs", 1, 12);

        Recherche recherche1 = new Recherche.Builder(nbVoyageurs).tarifMin(100).tarifMax(250).build();
        ArrayList<Logement> logements =  recherche1.resultat();

//         noms des logements
        logements.stream().map(Logement::getNom).toList().forEach(System.out::println);

//         tarifs moyens
        logements.stream().mapToInt(Logement::getTarifParNuit).average().ifPresent(tarifMoyen -> System.out.println("le tarif moyen est de " + tarifMoyen));

//         délai de réponses moyen
        logements.stream()
                .map(Logement::getHote).distinct()
                .mapToInt(Hote::getDelaiDeReponse).average()
                .ifPresent(delayMoyen -> System.out.println("Délai moyen :" + delayMoyen));

        // logement avec la plus grande capacité de voyageurs
        logements.stream()
                .max((logement1, logement2) -> logement1.getNbVoyageurMax() - logement2.getNbVoyageurMax())
                .ifPresent(Logement::afficher);

        // triez les logements par ordre croissant selon leur prix au m²
        logements.stream()
                .sorted(Comparator.comparingDouble(logement -> (double) logement.getTarifParNuit() / logement.getSuperifie()))
                .toList().forEach(Logement::afficher);

        // compter le nb maison avec jardin
        long nbMaison = logements.stream().filter(logement -> logement instanceof Maison && ((Maison) logement).getSuperficieDuJardin() > 0).count();
        System.out.println(nbMaison);

        // afficher le nb de maison par hôtes
        logements.stream().collect(Collectors.groupingBy(Logement::getHote)).forEach((Main::afficherLogementParHote));


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

    private static void afficherLogementParHote(Hote hote, List<Logement> logementHote) {
        hote.afficher();
        System.out.println(" possede " + logementHote.size() + " logements");
    }
}