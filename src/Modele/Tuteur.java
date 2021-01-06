package Modele;

public class Tuteur extends Etudiant{

    private int idTuteur;

    /**
     * La méthode Tuteur est le constructeur de Tuteur
     *
     * @param nom
     *          Le nom
     * @param prenom
     *          Le prenom
     * @param date_de_naissance
     *          La date de naissance
     * @param numero_identification
     *          Le numero d'identification
     * @param mot_de_passe
     *          Le mot de passe
     * @param email
     *          L'email
     * @param numero_telephone
     *          Le numéro de téléphone
     * @param idTuteur
     *          L'Id tuteur
     */
    public Tuteur(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone, int idTuteur) {
        super(nom, prenom, date_de_naissance, numero_identification, mot_de_passe, email, numero_telephone);
    this.idTuteur=idTuteur;
    }

    /**
     *
     */
    public Tuteur() {

    }

    /**
     * Getter de idTuteur
     *
     * @return
     */
    public int getIdTuteur() {
        return idTuteur;
    }

    /**
     * Setter de idTuteur
     *
     * @param idTuteur
     *          L'idTuteur
     */
    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }


    /**
     * Méthode toString
     * 
     * @return
     */
    @Override
    public String toString() {
        return  super.toString() +
                "idTuteur=" + idTuteur ;
    }
}
