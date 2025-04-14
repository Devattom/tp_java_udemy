package datas;

import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;
import peter.javabnb.outils.JavaBnBData;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Recherche {
    public static final int NE_SE_PRONONCE_PAS = 0;
    public static final int OUI = 1;
    public static final int NON = 2;
    private final int nbVoyageurs;

    private final int tarifMinParNuit;
    private final int tarifMaxParNuit;
    private final int possedePiscine;

    public Recherche(Builder builder) {
        this.nbVoyageurs = builder.nbVoyageurs;
        this.tarifMinParNuit = builder.tarifMinParNuit;
        this.tarifMaxParNuit = builder.tarifMaxParNuit;
        this.possedePiscine = builder.possedePiscine;
    }

    public ArrayList<Logement> resultat() {
        ArrayList<Logement> logements = JavaBnBData.getInstance().getLogements();

        return logements.stream()
                        .filter(predicateNbVoyageurs()
                                .and(predicateTarif()
                                .and(predicatePiscine())))
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    public Predicate<Logement> predicateNbVoyageurs() {
        return logement -> nbVoyageurs <= logement.getNbVoyageurMax();
    }

    public Predicate<Logement> predicateTarif() {
        return logement -> tarifMinParNuit >= logement.getTarifParNuit() && tarifMaxParNuit <= logement.getTarifParNuit();
    }

    public Predicate<Logement> predicatePiscine() {
        if(possedePiscine == NE_SE_PRONONCE_PAS) {
            return logement -> true;
        } else if (possedePiscine == OUI) {
            return logement -> logement instanceof Maison && (((Maison) logement).aUnePiscine());
        } else {
            return logement -> !(logement instanceof Maison) || !(((Maison) logement).aUnePiscine());
        }
    }

    @Override
    public String toString() {
        return "Recherche {" +
                "nbVoyageurs : " + nbVoyageurs +
                ", tarifMinParNuit : " + tarifMinParNuit +
                ", tarifMaxParNuit : " + tarifMaxParNuit +
                ", possedePiscine : " + possedePiscine +
                "}";
    }

    public static class Builder {
        private final int nbVoyageurs;

        private int tarifMinParNuit;
        private int tarifMaxParNuit;
        private int possedePiscine;

        public Builder(int nbVoyageurs) {
            this.nbVoyageurs = nbVoyageurs;
            tarifMinParNuit = 0;
            this.tarifMaxParNuit = Integer.MAX_VALUE;
            possedePiscine = NE_SE_PRONONCE_PAS;
        }

        public Builder tarifMin(int tarifMin) {
            this.tarifMinParNuit = tarifMin;
            return this;
        }

        public Builder tarifMax(int tarifMax) {
            this.tarifMaxParNuit = tarifMax;
            return this;
        }

        public Builder possedePiscine(boolean possedePiscine) {
            this.possedePiscine = possedePiscine ? OUI : NON;
            return this;
        }

        public Recherche build() {
            return new Recherche(this);
        }
    }
}
