package Test;

import DAO.MatiereDAO;
import Modele.Matiere;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

class MatiereDAOTest {

    @SuppressWarnings("deprecation")
	@Test
    void getMatiereById() {
        Matiere matiere= MatiereDAO.getMatiereById(10);
        assertEquals(matiere.getIdMatiere(),10);
        assertEquals(matiere.getNomMatiere(),"mathematiques");
        assertEquals(matiere.getSousCategorie(),"EP 2.2 : Arithmétique");


    }

    @SuppressWarnings("deprecation")
	@Test
    void getMatiereByNomAndSousCategorie() {
        Matiere matiere= MatiereDAO.getMatiereByNomAndSousCategorie("sciences de la vie", "EP 3.1 : Physiologie végétale");
        assertEquals(matiere.getIdMatiere(),17);
        assertEquals(matiere.getNomMatiere(),"sciences de la vie");
        assertEquals(matiere.getSousCategorie(),"EP 3.1 : Physiologie végétale");


    }

    @SuppressWarnings("deprecation")
	@Test
    void getMatiereBySousCategorie() {
        Matiere matiere= MatiereDAO.getMatiereBySousCategorie("EP 3.1 : Physiologie végétale");
        assertEquals(matiere.getIdMatiere(),17);
        assertEquals(matiere.getNomMatiere(),"sciences de la vie");
        assertEquals(matiere.getSousCategorie(),"EP 3.1 : Physiologie végétale");


    }

    @SuppressWarnings("deprecation")
	@Test
    void getMatieresByNumEns() {

        List<Matiere> listeMatieres= MatiereDAO.getMatieresByNumEns("21500001t");
        Matiere matiere1= listeMatieres.get(0);
        assertEquals(matiere1.getIdMatiere(),1);
        assertEquals(matiere1.getNomMatiere(),"informatique");
        assertEquals(matiere1.getSousCategorie(),"EP 1.1 : Logique pour l’informatique");
        Matiere matiere= listeMatieres.get(1);
        assertEquals(matiere.getIdMatiere(),"2");
        assertEquals(matiere.getNomMatiere(),"informatique");
        assertEquals(matiere.getSousCategorie(),"EP 1.2 : Programmation fonctionnelle");




    }


}