package fr.digi.jdbc.dao;

import fr.digi.jdbc.entites.Article;
import fr.digi.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDao {
    List<Article> extraire() throws SQLException;
    void insert(Article article, Fournisseur fournisseur) throws SQLException;
    int update(Double oldPrix, Double newPrix) throws SQLException;
    boolean delete(Article article) throws SQLException;
}
