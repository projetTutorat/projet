package Test;

import Modele.Personne;
import Modele.Tuteur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuteurTest {

    @Test
    void getIdTuteur() {
        Tuteur tuteur = new Tuteur("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636",2);
        assertEquals(2,tuteur.getIdTuteur());
    }

    @Test
    void setIdTuteur() {
        Tuteur tuteur = new Tuteur();
        tuteur.setIdTuteur(2);
        assertEquals(2,tuteur.getIdTuteur());
    }
}