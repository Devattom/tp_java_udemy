package peter.javabnb.utilisateurs;

public class Hote extends Personne {

    private int delaiDeReponse;

    public Hote(String pPrenom, String pNom, int pAge, int delaiDeReponse) {
        super(pPrenom, pNom, pAge);
        this.delaiDeReponse = delaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        if (delaiDeReponse == 1) {
            System.out.println(" qui s'engage à répondre dans l'heure.");
        } else {
            System.out.println(" qui s'engage à répondre dans les " + delaiDeReponse + " heures.");
        }

    }
}
