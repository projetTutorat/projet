package Modele;

public class Personne {

    private String nom;
    private String prenom;
    private String date_de_naissance;
    private String numero_identification;
    private String mot_de_passe;
    private String email;
    private String numero_telephone;


    public Personne(){

    }

    public Personne(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.numero_identification = numero_identification;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.numero_telephone = numero_telephone;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getNumero_identification() {
        return numero_identification;
    }

    public void setNumero_identification(String numero_identification) {
        this.numero_identification = numero_identification;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public void connexion(){

    }

    public void messageErreurConnexion(){

    }

    public void messageConnexionReussi(){

    }

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
