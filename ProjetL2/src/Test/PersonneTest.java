package Test;

import Modele.Personne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest  {


    @Test
    void getNom() {
        Personne personne = new Personne("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
        assertEquals( "Cherbonnier",personne.getNom());

    }

    @Test
    void setNom() {
        Personne personne = new Personne();
        personne.setNom("Cherbonnier");
        assertEquals("Cherbonnier",personne.getNom());
    }

    @Test
    void getPrenom() {
        Personne personne = new Personne("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
        assertEquals("Mathis",personne.getPrenom());
    }

    @Test
    void setPrenom() {
        Personne personne = new Personne();
        personne.setPrenom("Mathis");
        assertEquals("Mathis",personne.getPrenom());
    }

    @Test
    void getDate_de_naissance() {
        Personne personne = new Personne("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
        assertEquals("12-07-2001",personne.getDate_de_naissance());
    }

    @Test
    void setDate_de_naissance() {
        Personne personne = new Personne();
        personne.setDate_de_naissance("12-07-2001");
        assertEquals("12-07-2001",personne.getDate_de_naissance());
    }

    @Test
    void getNumero_identification() {
        Personne personne = new Personne("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
        assertEquals("21900298t",personne.getNumero_identification());
    }

    @Test
    void setNumero_identification() {
        Personne personne = new Personne();
        personne.setNumero_identification("21900298t");
        assertEquals("21900298t",personne.getNumero_identification());
    }

    @Test
    void getMot_de_passe() {
        Personne personne = new Personne("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
        assertEquals("motdepasse",personne.getMot_de_passe());
    }

    @Test
    void setMot_de_passe() {
        Personne personne = new Personne();
        personne.setMot_de_passe("motdepasse");
        assertEquals("motdepasse",personne.getMot_de_passe());
    }

    @Test
    void getEmail() {
        Personne personne = new Personne("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
        assertEquals("mathis.cherbonnier@etu.univ-tour.fr",personne.getEmail());
    }

    @Test
    void setEmail() {
        Personne personne = new Personne();
        personne.setEmail("mathis.cherbonnier@etu.univ-tour.fr");
        assertEquals("mathis.cherbonnier@etu.univ-tour.fr",personne.getEmail());
    }

    @Test
    void getNumero_telephone() {
        Personne personne = new Personne("Cherbonnier","Mathis","12-07-2001","21900298t","motdepasse","mathis.cherbonnier@etu.univ-tour.fr","0636363636");
        assertEquals("0636363636", personne.getNumero_telephone());
    }

    @Test
    void setNumero_telephone() {
        Personne personne = new Personne();
        personne.setNumero_telephone("0636363636");
        assertEquals("0636363636",personne.getNumero_telephone());
    }

}