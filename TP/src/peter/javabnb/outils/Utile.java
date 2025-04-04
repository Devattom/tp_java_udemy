package peter.javabnb.outils;

import java.util.Date;

public class Utile {

    private Utile(){}

    /**
     * Méthode qui permet de créer une nouvelle date
     * @param jour valeur entre 1 et 31
     * @param mois valeur entre 1 et 12
     * @param annee valeur de l'année, 2024 par exemple
     * @return la nouvelle date initialisée par les paramètres
     */
    public static Date creerDate(int jour, int mois, int annee) {
        Date nouvelleDate = new Date(annee - 1900, mois - 1, jour);
        return nouvelleDate;
    }

    /**
     * Méthode permettant de formater une date
     * @param date la date à formater
     * @return une String au format jour/mois/année ie. 06/12/2024 pour le 6 décembre 2024
     */
    public static String formatDate(Date date) {
        StringBuilder stringBuilder = new StringBuilder();

        if (date.getDate() < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(date.getDate());
        stringBuilder.append("/");

        if (date.getMonth() + 1 < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(date.getMonth() + 1);
        stringBuilder.append("/");
        stringBuilder.append(date.getYear() + 1900);

        return stringBuilder.toString();
    }

}
