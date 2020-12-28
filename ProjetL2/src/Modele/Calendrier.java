package Modele;

public class Calendrier {

    private int idCalendrier;
    private String annee;
    private String mois;
    private String jour;
    private String heures;
    private String minutes;


    public Calendrier(int idCalendrier, String annee, String mois, String jour, String heures, String minutes) {
        this.idCalendrier = idCalendrier;
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
        this.heures = heures;
        this.minutes = minutes;
    }


    public Calendrier() {
    }


    public int getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(int idCalendrier) {
        this.idCalendrier = idCalendrier;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeures() {
        return heures;
    }

    public void setHeures(String heures) {
        this.heures = heures;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }
}
