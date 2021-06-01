package fr.digi;


import fr.digi.jdbc.dao.ArticleDaoJdbc;
import fr.digi.jdbc.dao.FournisseurDaoJdbc;
import fr.digi.jdbc.entites.Article;
import fr.digi.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public class TestJdbcArticles {
    public static void main(String[] args) {
        Fournisseur fournisseur = new Fournisseur("La Maison de la Peinture");
//
//        FournisseurDaoJdbc fournisseurDaoJdbc = new FournisseurDaoJdbc();
//        try {
//            fournisseurDaoJdbc.insert(fournisseur);
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//
//        Article article1 = new Article("A01", "Peinture blanche 1L", 12.5);
//        Article article2 = new Article("A01", "Peinture rouge mate 1L", 15.5);
//        Article article3 = new Article("A01", "Peinture noire laquée 1L", 17.8);
//        Article article4 = new Article("A01", "Peinture bleue mate 1L", 15.5);
//
        ArticleDaoJdbc articleDaoJdbc = new ArticleDaoJdbc();
//        try {
//            articleDaoJdbc.insert(article1,fournisseur);
//            articleDaoJdbc.insert(article2,fournisseur);
//            articleDaoJdbc.insert(article3,fournisseur);
//            articleDaoJdbc.insert(article4,fournisseur);
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }

        try {
            List<Article> articles = articleDaoJdbc.extraire();
            for (Article article:
                    articles) {
                System.out.println(article);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

}
