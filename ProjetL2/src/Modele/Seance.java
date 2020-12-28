package Modele;

public class Seance {

    private String date;
    private String horaire;
    private int idSeance;
    private int nbPlaceMax;
    private int nbPlaceRestante;
    private String besoin;

    public Seance(String date,String horaire ,int idSeance, int nbPlaceMax, int nbPlaceRestante, String besoin) {
        this.date=date;
        this.horaire=horaire;
        this.idSeance = idSeance;
        this.nbPlaceMax = nbPlaceMax;
        this.nbPlaceRestante = nbPlaceRestante;
        this.besoin = besoin;
    }

    public Seance() {

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


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
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
