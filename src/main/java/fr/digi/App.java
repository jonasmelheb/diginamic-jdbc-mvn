package fr.digi;

import fr.digi.jdbc.dao.FournisseurDaoJdbc;
import fr.digi.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class App {
    public static void main(String[] args) {
        FournisseurDaoJdbc fournisseurDaoJdbc = new FournisseurDaoJdbc();
        try {
            List<Fournisseur> fournisseurs = fournisseurDaoJdbc.extraire();
            for (Fournisseur item :
                    fournisseurs) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Fournisseur fournisseur = new Fournisseur("Younes");
        try {
            fournisseurDaoJdbc.insert(fournisseur);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

//        try {
//            fournisseurDaoJdbc.update("Younes", "Melheb");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            fournisseurDaoJdbc.delete(fournisseur));
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
