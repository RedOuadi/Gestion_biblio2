package Dao;

import java.util.List;

import métier.Livre;


public interface ILivreDAO {
    public Livre save(Livre l);

    public List<Livre> LivreParMc(String mc);

    public Livre getLivre(int id);

    public Livre update(Livre l);

    public void deleteLivre(int id);
}