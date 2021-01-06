package Modele;

public class Etudiant extends Personne  {


    private Integer nombre_absence;


    /**
     * La méthode Etudiant est le constructeur de Etudiant
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
     */
    public Etudiant(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone) {
        super(nom, prenom, date_de_naissance, numero_identification, mot_de_passe, email, numero_telephone);

        this.nombre_absence=0;
    }

    /**
     *
     */
    public Etudiant() {

    }


    /**
     * Getter de nombre_absence
     *
     * @return
     */
    public Integer getNombre_absence() {
        return nombre_absence;
    }

    /**
     * Setter de nombre_absence
     *
     * @param nombre_absence
     *          Le nombre_absence
     */
    public void setNombre_absence(Integer nombre_absence) {
        this.nombre_absence = nombre_absence;
    }



    /**
     * Méthode toString
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString() +
                "nombre_absence=" + nombre_absence ;
    }
}
