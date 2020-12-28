package Modele;

public class Matiere {

    private int idMatiere;
    private String nomMatiere;
    private String sousCategorie;


    public Matiere(int idMatiere, String nomMatiere, String sousCategorie) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.sousCategorie = sousCategorie;
    }

    public Matiere() {

    }


    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }
}
