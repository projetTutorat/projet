package Test;

import Modele.Seance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeanceTest  {

    @Test
    void getIdSeance() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals(1,seance.getIdSeance());
    }

    @Test
    void setIdSeance() {
        Seance seance = new Seance();
        seance.setIdSeance(1);
        assertEquals(1,seance.getIdSeance());
    }

    @Test
    void getNbPlaceMax() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals(10,seance.getNbPlaceMax());
    }

    @Test
    void setNbPlaceMax() {
        Seance seance= new Seance();
        seance.setNbPlaceMax(10);
        assertEquals(10,seance.getNbPlaceMax());
    }

    @Test
    void getNbPlaceRestante() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals(8,seance.getNbPlaceRestante());
    }

    @Test
    void setNbPlaceRestante() {
        Seance seance= new Seance();
        seance.setNbPlaceRestante(8);
        assertEquals(8, seance.getNbPlaceRestante());
    }

    @Test
    void getBesoin() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals("Pas de besoin particulier",seance.getBesoin());
    }

    @Test
    void setBesoin() {
        Seance seance= new Seance();
        seance.setBesoin("Pas de besoin");
        assertEquals("Pas de besoin", seance.getBesoin());
    }

    @Test
    void getDate() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals("2020-12-16",seance.getDate());
    }

    @Test
    void setDate() {
        Seance seance= new Seance();
        seance.setDate("2020-12-16");
        assertEquals("2020-12-16",seance.getDate());
    }

    @Test
    void getHoraire() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals("18:00:00",seance.getHoraire());
    }

    @Test
    void setHoraire() {
        Seance seance= new Seance();
        seance.setHoraire("18:00:00");
        assertEquals("18:00:00",seance.getHoraire());
    }

    @Test
    void getIdSalle() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals(2,seance.getIdSalle());
    }

    @Test
    void setIdSalle() {
        Seance seance= new Seance();
        seance.setIdSalle(2);
        assertEquals(2,seance.getIdSalle());
    }

    @Test
    void getIdMat() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals(1,seance.getIdMat());

    }

    @Test
    void setIdMat() {
        Seance seance= new Seance();
        seance.setIdMat(1);
        assertEquals(1,seance.getIdMat());
    }

    @Test
    void getNum_ens() {
        Seance seance= new Seance("2020-12-16","18:00:00",1,10,8,"Pas de besoin particulier",2,1,"21500001t");
        assertEquals("21500001t",seance.getNum_ens());
    }

    @Test
    void setNum_ens() {
        Seance seance = new Seance();
        seance.setNum_ens("21500001t");
        assertEquals("21500001t",seance.getNum_ens());
    }
}