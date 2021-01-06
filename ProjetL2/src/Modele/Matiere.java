package Modele;

public class Matiere  {

    private int idMatiere;
    private String nomMatiere;
    private String sousCategorie;


    /**
     * LA méthode Matiere est le constructeur de Matiere
     *
     * @param idMatiere
     *          L'Id matière
     * @param nomMatiere
     *          Le nom de la matière
     * @param sousCategorie
     *          La sous-catégorie
     */
    public Matiere(int idMatiere, String nomMatiere, String sousCategorie) {
        this.idMatiere = idMatiere;
        this.nomMatiere = nomMatiere;
        this.sousCategorie = sousCategorie;
    }

    /**
     *
     */
    public Matiere() {

    }


    /**
     * Getter de idMatiere
     *
     * @return
     */
    public int getIdMatiere() {
        return idMatiere;
    }

    /**
     * Setter de idMatiere
     *
     * @param idMatiere
     *          L'Id de la matière
     */
    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    /**
     * Getter de nomMatiere
     *
     * @return
     */
    public String getNomMatiere() {
        return nomMatiere;
    }

    /**
     * Setter de nomMatiere
     *
     * @param nomMatiere
     *          Le nom de la matiere
     */
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    /**
     * Getter de sousCategorie
     *
     * @return
     */
    public String getSousCategorie() {
        return sousCategorie;
    }

    /**
     * Setter de sousCategorie
     *
     * @param sousCategorie
     *          La sous-catégorie
     */
    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }


    /**
     * Méthode toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "idMatiere=" + idMatiere +
                ", nomMatiere='" + nomMatiere + '\'' +
                ", sousCategorie='" + sousCategorie ;
    }
}
