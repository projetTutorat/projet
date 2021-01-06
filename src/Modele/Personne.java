package Modele;

public class Personne {

    private String nom;
    private String prenom;
    private String date_de_naissance;
    private String numero_identification;
    private String mot_de_passe;
    private String email;
    private String numero_telephone;


    /**
     *
     */
    public Personne(){

    }

    /**
     * La méthode personne est le constructeur de Personne
     *
     * @param nom
     *          Le nom
     * @param prenom
     *          Le prénom
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
    public Personne(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.numero_identification = numero_identification;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.numero_telephone = numero_telephone;
    }


    /**
     * Getter de nom
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter de nom
     *
     * @param nom
     *          Le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter de prenom
     *
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter de prenom
     *
     * @param prenom
     *          Le prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter de date_de_naissance
     *
     * @return
     */
    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    /**
     * Setter de date_de_naissance
     *
     * @param date_de_naissance
     *          La date de naissance
     */
    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    /**
     * Getter de numero_identification
     *
     * @return
     */
    public String getNumero_identification() {
        return numero_identification;
    }

    /**
     * Setter de numéro_identification
     *
     * @param numero_identification
     *          Le numéro d'identification
     */
    public void setNumero_identification(String numero_identification) {
        this.numero_identification = numero_identification;
    }

    /**
     * Getter de mot_de_passe
     *
     * @return
     */
    public String getMot_de_passe() {
        return mot_de_passe;
    }

    /**
     * Setter de mot_de_passe
     *
     * @param mot_de_passe
     *          Le mot de passe
     */
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    /**
     * Getter de email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter de email
     *
     * @param email
     *          L'email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter de numero_telephone
     *
     * @return
     */
    public String getNumero_telephone() {
        return numero_telephone;
    }

    /**
     * Setter de numero_telephone
     *
     * @param numero_telephone
     *          Le numéro téléphone
     */
    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }


    /**
     * Méthode toString
     * @return
     */
    @Override
    public String toString() {
        return "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_de_naissance='" + date_de_naissance + '\'' +
                ", numero_identification='" + numero_identification + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", email='" + email + '\'' +
                ", numero_telephone='" + numero_telephone + '\'' ;
    }
}
