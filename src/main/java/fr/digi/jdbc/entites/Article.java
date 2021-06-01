package fr.digi.jdbc.entites;

public class Article {
    private Long id;
    private String ref;
    private String designation;
    private Double prix;
    private Fournisseur fournisseur;

    public Article() {
    }

    public Article(String ref, String designation, Double prix) {
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
    }

    public Article(Long id, String ref, String designation, Double prix) {
        this.id = id;
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
