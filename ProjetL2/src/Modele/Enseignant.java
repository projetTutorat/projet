package Modele;

public class Enseignant extends Personne {




    public Enseignant(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone, String matiere) {
        super(nom, prenom, date_de_naissance, numero_identification, mot_de_passe, email, numero_telephone);
    }

    public Enseignant() {

    }


    public void ajouterEnseignant(){

    }

    public void modifierEnseignant(){

    }

    public void supprimerEnseignant(){

    }


    public void connexionEnseignant(){

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
