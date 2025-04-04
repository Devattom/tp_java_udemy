package peter.javabnb.utilisateurs;

/**
 * La définition de la classer peter.javabnb.utilisateurs.Personne qui me permet de créer une personne.
 * On représente une personne avec un nom, un prénom et un age.
 *
 * @author Peter Bardu
 */
public class Personne {

    /**
     * Attribut de type String qui représente le prénom
     */
    private String prenom;
    /**
     * Attribut de type String qui représente le nom
     */
    private String nom;
    /**
     * Attribut de type int qui représente l'âge
     */
    private int age;

    /**
     * Constructeur à trois paramètres permettant d'initialiser une personne
     * @param pPrenom le prénom de cette personne
     * @param pNom le nom de cette personne
     * @param pAge l'âge de cette personne
     */
    public Personne(String pPrenom, String pNom, int pAge) {
        prenom = pPrenom;
        nom = pNom;
        age = pAge;
    }

    /**
     * Méthode qui permet d'afficher dans <b>la console</b> cette personne
     */
    public void afficher() {
        System.out.print(prenom + " " + nom + " (" + age + " ans)");
    }

}
