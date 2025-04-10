package peter.javabnb.utilisateurs;

import java.util.Objects;

public class Hote extends Personne {

    private final int delaiDeReponse;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hote hote = (Hote) o;
        return delaiDeReponse == hote.delaiDeReponse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), delaiDeReponse);
    }
}
