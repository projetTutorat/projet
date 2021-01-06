package Test;

import Modele.Salle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalleTest {

    @Test
    void getIdSalle() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals(2, salle.getIdSalle());
    }

    @Test
    void setIdSalle() {
        Salle salle = new Salle();
        salle.setIdSalle(2);
        assertEquals(2,salle.getIdSalle());
    }

    @Test
    void getSite() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals("Grandmont",salle.getSite());
    }

    @Test
    void setSite() {
        Salle salle= new Salle();
        salle.setSite("Grandmont");
        assertEquals("Grandmont",salle.getSite());
    }

    @Test
    void getBatiment() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals("E1",salle.getBatiment());
    }

    @Test
    void setBatiment() {
        Salle salle = new Salle();
        salle.setBatiment("E1");
        assertEquals("E1",salle.getBatiment());
    }

    @Test
    void getEtage() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals(0,salle.getEtage());
    }

    @Test
    void setEtage() {
        Salle salle = new Salle();
        salle.setEtage(0);
        assertEquals(0,salle.getEtage());
    }

    @Test
    void getNumeroSalle() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals("10",salle.getNumeroSalle());
    }


    @Test
    void setNumeroSalle() {
        Salle salle = new Salle();
        salle.setNumeroSalle("10");
        assertEquals("10",salle.getNumeroSalle());
    }

    @Test
    void getCapaciteMax() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals(20,salle.getCapaciteMax());
    }

    @Test
    void setCapaciteMax() {
        Salle salle = new Salle();
        salle.setCapaciteMax(20);
        assertEquals(20,salle.getCapaciteMax());
    }

    @Test
    void isSalle_info() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals(true,salle.isSalle_info());
    }

    @Test
    void setSalle_info() {
        Salle salle = new Salle();
        salle.setSalle_info(true);
        assertEquals(true,salle.isSalle_info());
    }

    @Test
    void isSalle_TP() {
        Salle salle = new Salle(2,"Grandmont","E1",0,"10",20,true,false);
        assertEquals(false,salle.isSalle_TP());
    }

    @Test
    void setSalle_TP() {
        Salle salle = new Salle();
        salle.setSalle_TP(false);
        assertEquals(false,salle.isSalle_TP());
    }
}