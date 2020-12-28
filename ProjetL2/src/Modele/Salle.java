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

    public Salle() {

    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public String getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public boolean isSalle_info() {
        return salle_info;
    }

    public void setSalle_info(boolean salle_info) {
        this.salle_info = salle_info;
    }

    public boolean isSalle_TP() {
        return salle_TP;
    }

    public void setSalle_TP(boolean salle_TP) {
        this.salle_TP = salle_TP;
    }


}
