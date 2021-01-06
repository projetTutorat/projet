package Test;

import Modele.Etudiant;
import org.junit.jupiter.api.Test;


class EtudiantTest  {

    @Test
    void getNombre_absence() {
        Etudiant etudiant = new Etudiant("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
      //  assertEquals(0,etudiant.getNombre_absence());

    }

    @Test
    void setNombre_absence() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNombre_absence(2);
       // assertEquals(2,etudiant.getNombre_absence());
    }
}