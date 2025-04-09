package peter.javabnb.outils;

import peter.javabnb.logements.Logement;
import peter.javabnb.utilisateurs.Hote;

import java.util.ArrayList;

public class JavaBnBData {

    private static JavaBnBData instance = new JavaBnBData();
    private ArrayList<Hote> hotes;
    private ArrayList<Logement> logements;

    private JavaBnBData() {
        this.hotes = new ArrayList<>();
        this.logements = new ArrayList<>();
        LogementsXMLParser.parse("res/logements.xml", hotes, logements);
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
