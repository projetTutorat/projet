package Test;

import Modele.Matiere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatiereTest {

    @Test
    void getIdMatiere() {
        Matiere matiere = new Matiere(1,"informatique","EP 1.1 : Logique pour l’informatique");
        assertEquals(1, matiere.getIdMatiere());
    }

    @Test
    void setIdMatiere() {
        Matiere matiere = new Matiere();
        matiere.setIdMatiere(1);
        assertEquals(1,matiere.getIdMatiere());
    }

    @Test
    void getNomMatiere() {
        Matiere matiere = new Matiere(1,"informatique","EP 1.1 : Logique pour l’informatique");
        assertEquals("informatique",matiere.getNomMatiere());
    }

    @Test
    void setNomMatiere() {
        Matiere matiere = new Matiere();
        matiere.setNomMatiere("informatique");
        assertEquals("informatique",matiere.getNomMatiere());
    }

    @Test
    void getSousCategorie() {
        Matiere matiere = new Matiere(1,"informatique","EP 1.1 : Logique pour l'informatique");
        assertEquals("EP 1.1 : Logique pour l'informatique",matiere.getSousCategorie());
    }

    @Test
    void setSousCategorie() {
        Matiere matiere= new Matiere();
        matiere.setSousCategorie("EP 1.1 : Logique pour l'informatique");
        assertEquals("EP 1.1 : Logique pour l'informatique",matiere.getSousCategorie());
    }
}