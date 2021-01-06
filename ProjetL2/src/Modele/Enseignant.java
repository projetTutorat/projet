package Modele;

public class Enseignant extends Personne {


    /**
     * La méthode Enseignant est le constructeur de Enseignant
     *
     * @param nom
     *          Le nom
     * @param prenom
     *          Le prenom
     * @param date_de_naissance
     *          La date de naissance
     * @param numero_identification
     *          Le numéro d'identification
     * @param mot_de_passe
     *          Le mot de passe
     * @param email
     *          L'email
     * @param numero_telephone
     *          Le numéro de téléphone
     * @param matiere
     *          La matière
     */
    public Enseignant(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone, String matiere) {
        super(nom, prenom, date_de_naissance, numero_identification, mot_de_passe, email, numero_telephone);
    }

    /**
     *
     */
    public Enseignant() {

    }


    /**
     * Méthode toString
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
