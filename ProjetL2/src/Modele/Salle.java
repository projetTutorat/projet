package Modele;

public class Salle {


    private int idSalle;
    private String site;
    private String batiment;
    private int etage;
    private String numeroSalle;
    private int capaciteMax;
    private boolean salle_info;
    private boolean salle_TP;


    /**
     * La méthode Salle est le constructeur de Salle
     *
     * @param idSalle
     *          L'Id de la salle
     * @param site
     *          Le site
     * @param batiment
     *          Le batiment
     * @param etage
     *          L'étage
     * @param numeroSalle
     *          Le numéro de la salle
     * @param capaciteMax
     *          La capacité max
     * @param salle_info
     *          L'option salle informatique
     * @param salle_TP
     *          L'option salle TP
     */
    public Salle(int idSalle, String site, String batiment, int etage, String numeroSalle, int capaciteMax, boolean salle_info, boolean salle_TP) {
        this.idSalle = idSalle;
        this.site = site;
        this.batiment = batiment;
        this.etage = etage;
        this.numeroSalle = numeroSalle;
        this.capaciteMax = capaciteMax;
        this.salle_info = salle_info;
        this.salle_TP = salle_TP;
    }

    /**
     *
     */
    public Salle() {

    }

    /**
     * Getter de idSalle
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
     * Getter de site
     *
     * @return
     */
    public String getSite() {
        return site;
    }

    /**
     * Setter de site
     *
     * @param site
     *          Le site
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * Getter de batiment
     *
     * @return
     */
    public String getBatiment() {
        return batiment;
    }

    /**
     * Setter de batiment
     *
     * @param batiment
     *          Le batiment
     */
    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    /**
     * Getter de etage
     *
     * @return
     */
    public int getEtage() {
        return etage;
    }

    /**
     * Setter de etage
     *
     * @param etage
     *          L'étage
     */
    public void setEtage(int etage) {
        this.etage = etage;
    }

    /**
     * Getter de numeroSalle
     *
     * @return
     */
    public String getNumeroSalle() {
        return numeroSalle;
    }

    /**
     * Setter de numeroSalle
     *
     * @param numeroSalle
     *          Le numéro de la salle
     */
    public void setNumeroSalle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    /**
     * Getter de capaciteMax
     *
     * @return
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }

    /**
     * Setter de capaciteMax
     *
     * @param capaciteMax
     *          La capacité max
     */
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    /**
     * Getter de salle_info
     * @return
     */
    public boolean isSalle_info() {
        return salle_info;
    }

    /**
     * Setter de salle_info
     *
     * @param salle_info
     *          L'option salle info
     */
    public void setSalle_info(boolean salle_info) {
        this.salle_info = salle_info;
    }

    /**
     * Getter de salleTP
     *
     * @return
     */
    public boolean isSalle_TP() {
        return salle_TP;
    }

    /**
     * Setter de salle_TP
     *
     * @param salle_TP
     *          L'option salleTp
     */
    public void setSalle_TP(boolean salle_TP) {
        this.salle_TP = salle_TP;
    }

    /**
     * La méthode toString
     * @return
     */
    @Override
    public String toString() {
        return "idSalle=" + idSalle +
                ", site='" + site + '\'' +
                ", batiment='" + batiment + '\'' +
                ", etage=" + etage +
                ", numeroSalle='" + numeroSalle + '\'' +
                ", capaciteMax=" + capaciteMax +
                ", salle_info=" + salle_info +
                ", salle_TP=" + salle_TP ;
    }
}
