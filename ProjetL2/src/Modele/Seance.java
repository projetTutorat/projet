package Modele;

public class Seance {

    private String date;
    private String horaire;
    private int idSeance;
    private int nbPlaceMax;
    private int nbPlaceRestante;
    private String besoin;
    private int idSalle;
    private int idMat;
    private String num_ens;

    public Seance(String date,String horaire ,int idSeance, int nbPlaceMax, int nbPlaceRestante, String besoin,int idSalle,int idMat,String num_ens) {
        this.date=date;
        this.horaire=horaire;
        this.idSeance = idSeance;
        this.nbPlaceMax = nbPlaceMax;
        this.nbPlaceRestante = nbPlaceRestante;
        this.besoin = besoin;
        this.idSalle = idSalle;
        this.idMat = idMat;
        this.num_ens= num_ens;

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

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public int getIdMat() {
        return idMat;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public String getNum_ens() {
        return num_ens;
    }

    public void setNum_ens(String num_ens) {
        this.num_ens = num_ens;
    }
}
