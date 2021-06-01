package fr.digi.jdbc.dao;

import fr.digi.jdbc.connexion.ConnectionDB;
import fr.digi.jdbc.entites.Article;
import fr.digi.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoJdbc implements ArticleDao{
    private static final String INSERT_QUERY = "INSERT INTO ARTICLE (REF, DESIGNATION, PRIX, ID_FOU) VALUES('%s', '%s', '%s', '%s')";
    private static final String FIND_ALL_QUERY = "SELECT * FROM ARTICLE";
    private static final String FIND_BY_ID_QUERY = "SELECT * FOURNISSEUR WHERE ID = %s";
    private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = '%s' WHERE NOM = '%s'";
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = '%s'";

    @Override
    public List<Article> extraire() throws SQLException {
        Connection connection = ConnectionDB.getSingle().getConnection();
        try ( Statement statement = connection.createStatement()) {
            try (ResultSet rs = statement.executeQuery(FIND_ALL_QUERY)) {
                List<Article> articles = new ArrayList<>();
                while (rs.next()) {
                    Long id = rs.getLong("ID");
                    String ref = rs.getString("REF");
                    String designation = rs.getString("DESIGNATION");
                    Double prix = rs.getDouble("PRIX");
                    Article article = new Article(id, ref, designation, prix);
                    articles.add(article);
                }
                return articles;
            }
        }
    }

    @Override
    public void insert(Article article, Fournisseur fournisseur) throws SQLException {
        Connection connection = ConnectionDB.getSingle().getConnection();
        try (Statement st = connection.createStatement()) {
            int nb = st.executeUpdate(String.format(INSERT_QUERY, article.getRef(), article.getDesignation(), article.getPrix(), fournisseur.getId()));
            System.out.println(nb);
        }
    }

    @Override
    public int update(Double oldPrix, Double newPrix) throws SQLException {
        return 0;
    }

    @Override
    public boolean delete(Article article) throws SQLException {
        return false;
    }
}
