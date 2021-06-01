package fr.digi.jdbc.entites;

import java.io.Serializable;

public class Fournisseur implements Serializable {

    private Long id;
    private String nom;

    public Fournisseur() {
    }

    public Fournisseur( String nom ) {
        this.nom = nom;
    }

    public Fournisseur( Long id, String nom ) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Fournisseur{" );
        sb.append( "id=" ).append( id );
        sb.append( ", nom='" ).append( nom ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
