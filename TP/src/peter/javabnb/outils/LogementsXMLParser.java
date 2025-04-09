package peter.javabnb.outils;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import peter.javabnb.logements.Appartement;
import peter.javabnb.logements.Logement;
import peter.javabnb.logements.Maison;
import peter.javabnb.utilisateurs.Hote;

public final class LogementsXMLParser {

    private LogementsXMLParser() {
        throw new UnsupportedOperationException();
    }

    public static void parse(String path, ArrayList<Hote> listHotes, ArrayList<Logement> listLogements) {

        try {
            File xmlFile = new File(path);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // Les Logements
            Node node = document.getChildNodes().item(0);

            for (int i = 0; i < node.getChildNodes().getLength(); i++) {

                // Le noeud fille à l'indice i
                Node nodeItem = node.getChildNodes().item(i);

                if (nodeItem.getNodeType() == Node.ELEMENT_NODE) {

                    // L'élément Appartement ou Maison
                    Element element = (Element) nodeItem;

                    // L'élément Hote
                    Element nodeHote = (Element) element.getElementsByTagName("hote").item(0);

                    // L'objet hote avec ses informations
                    Hote hote = getHote(nodeHote);

                    int index = listHotes.indexOf(hote);
                    if (index != -1) {
                        hote = listHotes.get(index);
                    } else {
                        listHotes.add(hote);
                    }

                    // Le logement composé de l'hote avec ses informations
                    Logement logement = getLogement(element, hote);

                    // On ajoute le logement à la liste
                    listLogements.add(logement);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Logement getLogement(Element element, Hote hote) {
        Logement logement = null;

        // On récupère les informations liées au logement
        int tarifParNuit = Integer.parseInt(element.getElementsByTagName("tarifParNuit").item(0).getTextContent());
        String adresse = element.getElementsByTagName("adresse").item(0).getTextContent();
        int superficie = Integer.parseInt(element.getElementsByTagName("superficie").item(0).getTextContent());
        int nbVoyageursMax = Integer.parseInt(element.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());

        String nomLogement = element.getAttribute("nom");

        // Si c'est un appartement
        if (element.getNodeName().equals("Appartement")) {
            // On récupère les informations liées à l'appartement
            int numeroEtage = Integer.parseInt(element.getElementsByTagName("numeroEtage").item(0).getTextContent());
            int superficieBalcon = Integer.parseInt(element.getElementsByTagName("superficieBalcon").item(0).getTextContent());

            // On créée cet appartement
            logement = new Appartement(hote, nomLogement, tarifParNuit, adresse, superficie, nbVoyageursMax, numeroEtage, superficieBalcon);
        }

        // Si c'est une maison
        if (element.getNodeName().equals("Maison")) {
            // On récupère les informations liées à la maison
            int superficieJardin = Integer.parseInt(element.getElementsByTagName("superficieJardin").item(0).getTextContent());
            int possedePiscine = Integer.parseInt(element.getElementsByTagName("possedePiscine").item(0).getTextContent());

            // On créée cette maison
            logement = new Maison(hote, nomLogement, tarifParNuit, adresse, superficie, nbVoyageursMax, superficieJardin, possedePiscine == 0 ? false : true);
        }

        return logement;
    }

    private static Hote getHote(Element nodeHote) {

        // On récupère les informations liées à l'hote
        String prenom = nodeHote.getElementsByTagName("prenom").item(0).getTextContent();
        String nom = nodeHote.getElementsByTagName("nom").item(0).getTextContent();
        int age = Integer.parseInt(nodeHote.getElementsByTagName("age").item(0).getTextContent());
        int delaiReponse = Integer.parseInt(nodeHote.getElementsByTagName("delaiReponse").item(0).getTextContent());

        // On créée cet hote
        Hote hote = new Hote(prenom, nom, age, delaiReponse);

        return hote;
    }
}
