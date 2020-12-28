package Modele;

public class Tuteur extends Etudiant{

    private int idTuteur;

    public Tuteur(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone, int idTuteur) {
        super(nom, prenom, date_de_naissance, numero_identification, mot_de_passe, email, numero_telephone);
    this.idTuteur=idTuteur;
    }

    public Tuteur() {

    }

    public int getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }



    public void connexionTuteur() {

    }


    @Override
    public String toString() {
        return  super.toString() +
                "idTuteur=" + idTuteur ;
    }
}
