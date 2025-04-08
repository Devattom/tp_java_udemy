package peter.javabnb.outils;

import peter.javabnb.logements.Appartement;
import peter.javabnb.logements.Chalet;
import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;
import peter.javabnb.utilisateurs.Hote;

import java.util.ArrayList;

public class JavaBnBData {

    private static JavaBnBData instance = new JavaBnBData();
    private ArrayList<Hote> hotes;
    private ArrayList<Logement> logements;

    private JavaBnBData() {
        this.hotes = new ArrayList<>();
        this.logements = new ArrayList<>();

        Hote monHote1 = new Hote("Tom", "Martin", 30, 12);
        Hote monHote2 = new Hote("Emma", "Wilson", 52, 1);

        this.hotes.add(monHote1);
        this.hotes.add(monHote2);

        Maison maMaison = new Maison(monHote1, "Petite Maison", 60, "12 rue des maisons", 70, 4, 1000, true);
        Appartement monAppartement = new Appartement(monHote2, "Grand appartement", 150, "4 rue des apparts", 120, 6, 10, 4);
        Chalet monChalet = new Chalet(monHote1, "Chalet de montagne", 130, "5 rue de la montagne", 50, 6, 1345);

        this.logements.add(maMaison);
        this.logements.add(monAppartement);
        this.logements.add(monChalet);
    }

    public ArrayList<Hote> getHotes() {
        return hotes;
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

    public static JavaBnBData getInstance() {
        return instance;
    }
}
