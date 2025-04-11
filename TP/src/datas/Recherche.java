package datas;

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
