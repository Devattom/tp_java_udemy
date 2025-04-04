package peter.javabnb.outils;

import java.util.Date;

public class MaDate extends Date {

    public MaDate() {
        super();
    }

    /**
     * Constructeur de MaDate avec trois paramètres
     *
     * @param jour  valeur entre 1 et 31
     * @param mois  valeur entre 1 et 12
     * @param annee valeur de l'année, 2024 par exemple
     */
    public MaDate(int jour, int mois, int annee) {
        super(annee - 1900, mois - 1, jour);
    }

    /**
     * Méthode permettant de formater une date
     *
     * @return une String au format jour/mois/année ie. 06/12/2024 pour le 6 décembre 2024
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (getDate() < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(getDate());
        stringBuilder.append("/");

        if (getMonth() + 1 < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(getMonth() + 1);
        stringBuilder.append("/");
        stringBuilder.append(getYear() + 1900);

        return stringBuilder.toString();
    }
}
