package fr.digi.jdbc.dao;

import fr.digi.jdbc.connexion.ConnectionDB;
import fr.digi.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJdbc implements FournisseurDao {
    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES('%s')";
    private static final String FIND_ALL_QUERY = "SELECT * FROM FOURNISSEUR";
    private static final String FIND_BY_ID_QUERY = "SELECT * FOURNISSEUR WHERE ID = %s";
    private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = '%s' WHERE NOM = '%s'";
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = '%s'";

    @Override
    public List<Fournisseur> extraire() throws SQLException {
        Connection connection = ConnectionDB.getSingle().getConnection();
        try ( Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL_QUERY)) {
                List<Fournisseur> fournisseurs = new ArrayList<>();
                while (rs.next()) {
                    Long id = rs.getLong("ID");
                    String nom = rs.getString("NOM");
                    Fournisseur fournisseur = new Fournisseur(id, nom);
                    fournisseurs.add(fournisseur);
                }
                return fournisseurs;
            }
        }
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        Connection connection = ConnectionDB.getSingle().getConnection();
        try (Statement st = connection.createStatement()) {
            int nb = st.executeUpdate(String.format(INSERT_QUERY, fournisseur.getNom()));
            System.out.println(nb);
        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        Connection connection = ConnectionDB.getSingle().getConnection();
        try (Statement st = connection.createStatement()) {
            int nb = st.executeUpdate(String.format(UPDATE_QUERY, nouveauNom,ancienNom));
            System.out.println(nb);
            return nb;
        }
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws SQLException {
        Connection connection = ConnectionDB.getSingle().getConnection();
        try( Statement st = connection.createStatement()) {
            int nb = st.executeUpdate(String.format(DELETE_QUERY, fournisseur.getId()));
            System.out.println(nb);
            return nb >= 1;
        }
    }
}
