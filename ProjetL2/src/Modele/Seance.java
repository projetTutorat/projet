package Modele;

public class Seance {

    private int idSeance;
    private int nbPlaceMax;
    private int nbPlaceRestante;
    private String besoin;

    public Seance(int idSeance, int nbPlaceMax, int nbPlaceRestante, String besoin) {
        this.idSeance = idSeance;
        this.nbPlaceMax = nbPlaceMax;
        this.nbPlaceRestante = nbPlaceRestante;
        this.besoin = besoin;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    public int getNbPlaceMax() {
        return nbPlaceMax;
    }

    public void setNbPlaceMax(int nbPlaceMax) {
        this.nbPlaceMax = nbPlaceMax;
    }

    public int getNbPlaceRestante() {
        return nbPlaceRestante;
    }

    public void setNbPlaceRestante(int nbPlaceRestante) {
        this.nbPlaceRestante = nbPlaceRestante;
    }

    public String getBesoin() {
        return besoin;
    }

    public void setBesoin(String besoin) {
        this.besoin = besoin;
    }



    public void ajouterEtudiant(){

    }

    public void ajouterEtudiantTutorat(){

    }

    public void ajouterEtudiantListeAttente(){

    }


    public void suppressionEtudiant(){

    }

    public void ajouterTuteur(){

    }


    public void envoieMail(){

    }


    public void suppressionSeance(){

    }
}
