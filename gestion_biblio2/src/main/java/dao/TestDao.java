package dao;
import metier.Livre;

import java.util.List;

public class TestDao {
    public static void main(String[] args) {
     /*   IlivreDao livreDAO = new LivreDAOImpl();

        Livre livre1 = new Livre("Titre131", "Auteur1", "Editeur10", new java.util.Date());


        Livre livreSauvegarde = livreDAO.save(livre1);
        if (livreSauvegarde != null) {
            System.out.println("Livre ajouté avec succès : " + livreSauvegarde.getTitre_livre());
        } else {
            System.out.println("Erreur lors de l'ajout du livre");
        }*/
        IlivreDao Ilivre = new LivreDAOImpl() ;
        List<Livre> Livres = Ilivre.LivreParMc("");
        System.out.println(Livres.get(0));

    }
}
