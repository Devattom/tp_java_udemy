package peter.javabnb.reservations;

import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;

import java.util.Date;

public abstract class Sejour implements Reservable {

    protected Date dateArrivee;
    protected int nbNuits;
    protected Logement logement;
    private int nbVoyageurs;
    protected int prix;

    Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
        miseAJourDuPrixDuSejour();
    }

    public int getNbNuits() {
        return nbNuits;
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
     * @return true si le nombre de voyageurs ne dépace pas la capacité du logement
     */
    @Override
    public boolean aUnNombreDeVoyageursCorrecte() {
        return nbVoyageurs >= 1 && nbVoyageurs <= logement.getNbVoyageurMax();
    }

    public abstract void miseAJourDuPrixDuSejour();

    protected void afficherSejour() {
        logement.afficher();

        if (logement instanceof Maison) {
            Maison maMaison = (Maison) logement;
            System.out.println("Piscine d'intérieur : " + maMaison.aUnePiscineInterieur());
        }

        System.out.println("La date d'arrivée est le " + dateArrivee + " pour "
                + nbNuits + " nuit" + (nbNuits > 1 ? "s." : "."));
    }
}
