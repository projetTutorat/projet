package Test;

import DAO.SeanceDAO;
import Modele.Seance;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeanceDAOTest {

    @Test
    void getSeanceById() {
        Seance seance= SeanceDAO.getSeanceById(1);
        assertEquals(1,seance.getIdSeance());
        assertEquals("2020-12-16",seance.getDate());
        assertEquals("18:00:00",seance.getHoraire());
        assertEquals(10,seance.getNbPlaceMax());
        assertEquals(8,seance.getNbPlaceRestante());
        assertEquals("Pas de besoin particulier",seance.getBesoin());
        assertEquals(2,seance.getIdSalle());
        assertEquals(1,seance.getIdMat());
        assertEquals("21500001t",seance.getNum_ens());
    }

    @Test
    void getSeancesByNumEns() {
        List<Seance> listeSeance= SeanceDAO.getSeancesByNumEns("21500001t");
        Seance seance= listeSeance.get(0);
        assertEquals(1,seance.getIdSeance());
        assertEquals("2020-12-16",seance.getDate());
        assertEquals("18:00:00",seance.getHoraire());
        assertEquals(10,seance.getNbPlaceMax());
        assertEquals(8,seance.getNbPlaceRestante());
        assertEquals("Pas de besoin particulier",seance.getBesoin());
        assertEquals(2,seance.getIdSalle());
        assertEquals(1,seance.getIdMat());
        assertEquals("21500001t",seance.getNum_ens());
    }

    @Test
    void getSeancesByNumEtu() {
        List<Seance> listeSeance= SeanceDAO.getSeancesByNumEtu("21900001t");
        Seance seance= listeSeance.get(0);
        assertEquals(1,seance.getIdSeance());
        assertEquals("2020-12-16",seance.getDate());
        assertEquals("18:00:00",seance.getHoraire());
        assertEquals(10,seance.getNbPlaceMax());
        assertEquals(8,seance.getNbPlaceRestante());
        assertEquals("Pas de besoin particulier",seance.getBesoin());
        assertEquals(2,seance.getIdSalle());
        assertEquals(1,seance.getIdMat());
        assertEquals("21500001t",seance.getNum_ens());

    }

    @Test
    void getIdSeanceByNumEtu() {
        Seance seance= SeanceDAO.getIdSeanceByNumEtu("21900001t");
        assertEquals(1,seance.getIdSeance());

    }

    @Test
    void getSeancesByidTuteur() {
        List<Seance> listeSeance= SeanceDAO.getSeancesByidTuteur(5);
        Seance seance= listeSeance.get(0);
        assertEquals(1,seance.getIdSeance());
        assertEquals("2020-12-16",seance.getDate());
        assertEquals("18:00:00",seance.getHoraire());
        assertEquals(10,seance.getNbPlaceMax());
        assertEquals(8,seance.getNbPlaceRestante());
        assertEquals("Pas de besoin particulier",seance.getBesoin());
        assertEquals(2,seance.getIdSalle());
        assertEquals(1,seance.getIdMat());
        assertEquals("21500001t",seance.getNum_ens());

    }

    @Test
    void tuteurAppartientSeance() {
        boolean test = SeanceDAO.tuteurAppartientSeance(1,5);
    }

}