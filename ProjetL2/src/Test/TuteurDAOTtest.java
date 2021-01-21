package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import DAO.TuteurDAO;
import Modele.Tuteur;

class TuteurDAOTtest {

	@Test
	void getTuteurById() {
        Tuteur tuteur = TuteurDAO.getTuteurById("21900001t");
        assertEquals(tuteur.getNumero_identification(),"21900001t");
        assertEquals(tuteur.getNom(),"Deslauriers");
        assertEquals(tuteur.getPrenom(),"Bruce");
        assertEquals(tuteur.getDate_de_naissance(),"2000-07-12");
        assertEquals(tuteur.getMot_de_passe(),"motdepasse");
        assertEquals(tuteur.getEmail(),"bruce.deslauriers@etu.univ-tours.fr");
        assertEquals(tuteur.getNumero_telephone(),"0678855601");
        assertEquals(tuteur.getIdTuteur(),5);

    }

	@Test
    void etudiantEstTuteur(){
        Tuteur tuteur = TuteurDAO.etudiantEstTuteur("21900001t");
        assertEquals(tuteur.getIdTuteur(),5);

    }

}
