package Modele;

public class Calendrier {

    private int idCalendrier;
    private String annee;
    private String mois;
    private String jour;
    private String heures;
    private String minutes;


    /**
     * La méthode Calendrier est le constructeur de Calendrier
     *
     * @param idCalendrier
     *          L'Id du calendrier
     * @param annee
     *          L'année
     * @param mois
     *          Le mois
     * @param jour
     *          Le jour
     * @param heures
     *          L'heure
     * @param minutes
     *          Les minutes
     */
    public Calendrier(int idCalendrier, String annee, String mois, String jour, String heures, String minutes) {
        this.idCalendrier = idCalendrier;
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heures = heures;
        this.minutes = minutes;
    }


    /**
     *
     */
    public Calendrier() {
    }


    /**
     * Getter de l'id calendrier
     *
     * @return int
     */
    public int getIdCalendrier() {
        return idCalendrier;
    }

    /**
     * Setter de l'id calendrier
     *
     * @param idCalendrier
     *          L'Id calendrier
     */
    public void setIdCalendrier(int idCalendrier) {
        this.idCalendrier = idCalendrier;
    }

    /**
     * Getter de annee
     * @return
     */
    public String getAnnee() {
        return annee;
    }

    /**
     * Setter de annee
     *
     * @param annee
     *          L'annee
     */
    public void setAnnee(String annee) {
        this.annee = annee;
    }

    /**
     * Getter de mois
     *
     * @return
     */
    public String getMois() {
        return mois;
    }

    /**
     * Setter de mois
     * @param mois
     *          Le mois
     */
    public void setMois(String mois) {
        this.mois = mois;
    }

    /**
     * Getter de jour
     * @return
     */
    public String getJour() {
        return jour;
    }

    /**
     * Setter de jour
     *
     * @param jour
     *          Le jour
     */
    public void setJour(String jour) {
        this.jour = jour;
    }

    /**
     * Getter de heures
     *
     * @return
     */
    public String getHeures() {
        return heures;
    }

    /**
     * Setteur heures
     *
     * @param heures
     *          L'heure
     */
    public void setHeures(String heures) {
        this.heures = heures;
    }

    /**
     * Getteur minutes
     *
     * @return
     */
    public String getMinutes() {
        return minutes;
    }

    /**
     * Setteur minutes
     *
     * @param minutes
     *          Les minutes
     */
    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }
}
