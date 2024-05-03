package dao;

import java.util.List;

import metier.Livre;

public interface IlivreDao {
    public Livre save(Livre l);
    public List<Livre> LivreParMc(String mc);
    public Livre getLivre(int id);
    public Livre update(Livre l);
    public void deleteLivre(int id);
}
