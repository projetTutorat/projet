package Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import DAO.EtudiantDAO;
import Modele.Etudiant;

class EtudiantDAOTest {


    @Test
    void getEtudiantById() {
        Etudiant etudiant= EtudiantDAO.getEtudiantById("21900001t");
        assertEquals(etudiant.getNumero_identification(),"21900001t");
        assertEquals(etudiant.getNom(),"Deslauriers");
        assertEquals(etudiant.getPrenom(),"Bruce");
        assertEquals(etudiant.getDate_de_naissance(),"2000-07-12");
        assertEquals(etudiant.getMot_de_passe(),"motdepasse");
        assertEquals(etudiant.getEmail(),"bruce.deslauriers@etu.univ-tours.fr");
        assertEquals(etudiant.getNumero_telephone(),"0678855601");
        //assertEquals(etudiant.getNombre_absence(),0);

    }

    @Test
    void getEtudiantsByIdSeance() {
        List<Etudiant> listeEtudiants= EtudiantDAO.getEtudiantsByIdSeance(1,"21500006t");

        Etudiant etudiant= listeEtudiants.get(0);
        assertEquals(etudiant.getNumero_identification(),"21900018t");
        assertEquals(etudiant.getNom(),"Caron");
        assertEquals(etudiant.getPrenom(),"Theo");
        assertEquals(etudiant.getDate_de_naissance(),"2000-07-30");
        assertEquals(etudiant.getMot_de_passe(),"motdepasse");
        assertEquals(etudiant.getEmail(),"theo.caron@etu.univ-tours.fr");
        assertEquals(etudiant.getNumero_telephone(),"0678855618");

        
        Etudiant etudiant1= listeEtudiants.get(1);
        assertEquals(etudiant1.getNumero_identification(),"21900019t");
        assertEquals(etudiant1.getNom(),"Paillaud");
        assertEquals(etudiant1.getPrenom(),"Karine");
        assertEquals(etudiant1.getDate_de_naissance(),"2000-07-31");
        assertEquals(etudiant1.getMot_de_passe(),"motdepasse");
        assertEquals(etudiant1.getEmail(),"karine.paillaud@etu.univ-tours.fr");
        assertEquals(etudiant1.getNumero_telephone(),"0678855619");
       // assertEquals(etudiant1.getNombre_absence(),0);

    }

    @Test
    void modifierAbsenceEtudiant() {
        Etudiant etudiant= EtudiantDAO.getEtudiantById("21900001t");
        assertEquals(etudiant.getNumero_identification(),"");
        assertEquals(etudiant.getNom(),"");
        assertEquals(etudiant.getPrenom(),"");
        assertEquals(etudiant.getDate_de_naissance(),0);
        assertEquals(etudiant.getMot_de_passe(),"motdepasse");
        assertEquals(etudiant.getEmail(),"");
        assertEquals(etudiant.getNumero_telephone(),"");
       // assertEquals(etudiant.getNombre_absence(),0);

        EtudiantDAO.modifierAbsenceEtudiant(etudiant);

        assertEquals(etudiant.getNumero_identification(),"");
        assertEquals(etudiant.getNom(),"");
        assertEquals(etudiant.getPrenom(),"");
        assertEquals(etudiant.getDate_de_naissance(),0);
        assertEquals(etudiant.getMot_de_passe(),"motdepasse");
        assertEquals(etudiant.getEmail(),"");
        assertEquals(etudiant.getNumero_telephone(),"");
        //assertEquals(etudiant.getNombre_absence(),0);

    }

    @Test
    void ajouterEtudiantSeance() {
    }

    @Test
    void demissionEtudiantSeance() {
    }

    @Test
    void associerEtudiantFiliere() {
    }

}
