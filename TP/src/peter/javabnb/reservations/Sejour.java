package peter.javabnb.reservations;

import peter.javabnb.logements.Appartement;
import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;
import peter.javabnb.outils.Utile;

import java.util.Date;

public class Sejour implements Reservable {

    private Date dateArrivee;
    private int nbNuits;
    private Logement logement;
    private int nbVoyageurs;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
    }

    /**
     *
     * @return true si la date d'arrivée est plus grande que la date actuelle, false sinon
     */
    @Override
    public boolean aUneDateArriveeCorrecte() {
        Date dateActuelle = new Date();

        if (dateArrivee.after(dateActuelle)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return true si le nombre de nuits est compris entre 1 et 31, false sinon
     */
    @Override
    public boolean aUnNombreDeNuitsCorrecte() {
        if (nbNuits >= 1 && nbNuits <= 31) {
            return true;
        }

        return false;
    }

    /**
     *
     * @return true si le nombre de voyageurs ne dépace pas la capacité du logement
     */
    @Override
    public boolean aUnNombreDeVoyageursCorrecte() {
        return nbVoyageurs >= 1 && nbVoyageurs <= logement.getNbVoyageurMax();
    }

    @Override
    public void afficher() {

        logement.afficher();

        if (logement instanceof Maison) {
            Maison maMaison = (Maison) logement;
            System.out.println("Piscine d'intérieur : " + maMaison.aUnePiscineInterieur());
        }

        System.out.println("La date d'arrivée est le " + dateArrivee + " pour "
                + nbNuits + " nuit" + (nbNuits > 1 ? "s." : "."));


    }

}
