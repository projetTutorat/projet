package Modele;

public class Salle {


    private int idSalle;
    private String site;
    private String batiment;
    private int etage;
    private int numeroSalle;
    private int capaciteMax;
    private boolean salle_info;
    private boolean salle_TP_physique;
    private  boolean Salle_TP_biologie;


    public Salle(int idSalle, String site, String batiment, int etage, int numeroSalle, int capaciteMax, boolean salle_info, boolean salle_TP_physique, boolean Salle_TP_biologie) {
        this.idSalle = idSalle;
        this.site = site;
        this.batiment = batiment;
        this.etage = etage;
        this.numeroSalle = numeroSalle;
        this.capaciteMax = capaciteMax;
        this.salle_info = salle_info;
        this.salle_TP_physique = salle_TP_physique;
        this.Salle_TP_biologie = Salle_TP_biologie;
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

    public int getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(int numeroSalle) {
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

    public boolean isSalle_TP_physique() {
        return salle_TP_physique;
    }

    public void setSalle_TP_physique(boolean salle_TP_physique) {
        this.salle_TP_physique = salle_TP_physique;
    }

    public boolean Salle_TP_biologie() {
        return Salle_TP_biologie;
    }

    public void setSalle_TP_biologie(boolean salle_TP_biologie) {
        Salle_TP_biologie = salle_TP_biologie;
    }
}
