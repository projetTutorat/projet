package Modele;

public class Etudiant extends Personne {


    private Integer nombre_absence;


    public Etudiant(String nom, String prenom, String date_de_naissance, String numero_identification, String mot_de_passe, String email, String numero_telephone) {
        super(nom, prenom, date_de_naissance, numero_identification, mot_de_passe, email, numero_telephone);

        this.nombre_absence=0;
    }

    public Etudiant() {

    }


    public Integer getNombre_absence() {
        return nombre_absence;
    }

    public void setNombre_absence(Integer nombre_absence) {
        this.nombre_absence = nombre_absence;
    }

    public void ajouterEtudiant(){

    }

    public void modifierEtudiant(){

    }

    public void supprimerEtudiant(){

    }




    public void connexionEtudiant(){

    }

    @Override
    public String toString() {
        return super.toString() +
                "nombre_absence=" + nombre_absence ;
    }
}
