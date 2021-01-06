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

    /**
     * La méthode Seance est le constructeur de Seance
     *
     * @param date
     *          La date
     * @param horaire
     *          L'horaire
     * @param idSeance
     *          L'Id de la séance
     * @param nbPlaceMax
     *          Le nombre de place max
     * @param nbPlaceRestante
     *          Le nombre de place restante
     * @param besoin
     *          Les besoins
     * @param idSalle
     *          L'Id de la salle
     * @param idMat
     *          L'Id de la matière
     * @param num_ens
     *          Le numéro enseignant
     */
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

    /**
     *
     */
    public Seance() {

    }

    /**
     * Getter de idSeance
     *
     * @return
     */
    public int getIdSeance() {
        return idSeance;
    }

    /**
     * Setter de idSeance
     *
     * @param idSeance
     *          L'Id de la seance
     */
    public void setIdSeance(int idSeance) {
        this.idSeance = idSeance;
    }

    /**
     * Getter de nbPlaceMax
     *
     * @return
     */
    public int getNbPlaceMax() {
        return nbPlaceMax;
    }

    /**
     * Setter de nbPlaceMax
     *
     * @param nbPlaceMax
     *          Le nombre de place max
     */
    public void setNbPlaceMax(int nbPlaceMax) {
        this.nbPlaceMax = nbPlaceMax;
    }

    /**
     * Getter de nbPlaceRestante
     *
     * @return
     */
    public int getNbPlaceRestante() {
        return nbPlaceRestante;
    }

    /**
     * Setter de nbPlaceRestante
     *
     * @param nbPlaceRestante
     *          Le nombre de place restante
     */
    public void setNbPlaceRestante(int nbPlaceRestante) {
        this.nbPlaceRestante = nbPlaceRestante;
    }

    /**
     * Getter de besoin
     *
     * @return
     */
    public String getBesoin() {
        return besoin;
    }

    /**
     * Setter de besoin
     *
     * @param besoin
     *          Les besoins
     */
    public void setBesoin(String besoin) {
        this.besoin = besoin;
    }


    /**
     * Getter de date
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Setter de date
     *
     * @param date
     *          La date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Getter de horaire
     *
     * @return
     */
    public String getHoraire() {
        return horaire;
    }

    /**
     * Setter de horaire
     *
     * @param horaire
     *          L'horaire
     */
    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    /**
     * Getter de idSalle
     *
     * @return
     */
    public int getIdSalle() {
        return idSalle;
    }

    /**
     * Setter de idSalle
     *
     * @param idSalle
     *          L'Id de la salle
     */
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * Getter de idMat
     *
     * @return
     */
    public int getIdMat() {
        return idMat;
    }

    /**
     * Setter de idMat
     *
     * @param idMat
     *          L'Id de la matière
     */
    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    /**
     * Getter de num_ens
     *
     * @return
     */
    public String getNum_ens() {
        return num_ens;
    }

    /**
     * Setter de num_ens
     *
     * @param num_ens
     *          Le numéro enseignant
     */
    public void setNum_ens(String num_ens) {
        this.num_ens = num_ens;
    }

    /**
     * Méthode toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "date='" + date + '\'' +
                ", horaire='" + horaire + '\'' +
                ", idSeance=" + idSeance +
                ", nbPlaceMax=" + nbPlaceMax +
                ", nbPlaceRestante=" + nbPlaceRestante +
                ", besoin='" + besoin + '\'' +
                ", idSalle=" + idSalle +
                ", idMat=" + idMat +
                ", num_ens='" + num_ens ;
    }
}
