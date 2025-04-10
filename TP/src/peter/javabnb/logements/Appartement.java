package peter.javabnb.logements;

import peter.javabnb.utilisateurs.Hote;

public class Appartement extends Logement {

    private final int superficieDuBalcon;
    private final int numeroEtage;

    public Appartement(Hote hote, String nom, int tarifParNuit, String adresse, int superifie, int nbVoyageurMax, int superficieDuBalcon, int numeroEtage) {
        super(hote, nom, tarifParNuit, adresse, superifie, nbVoyageurMax);
        this.superficieDuBalcon = superficieDuBalcon;
        this.numeroEtage = numeroEtage;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("L'appartement (" + getNom() + ") est situé " + getAdresse());
        System.out.println("Superficie : " + getSuperifie() + "m2");
        System.out.println("Superficie du balcon : " + superficieDuBalcon + "m2");
        switch (numeroEtage) {
            case 0:
                System.out.println("Etage : rez-de-chaussée");
                break;
            case 1:
                System.out.println("Etage : premier étage");
                break;
            case 2:
                System.out.println("Etage : second étage");
                break;
            default:
                System.out.println("Etage : " + numeroEtage + "ème étage");
        }
    }
}
