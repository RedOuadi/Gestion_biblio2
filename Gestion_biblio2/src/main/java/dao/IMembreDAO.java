package dao;

import java.util.List;

import metier.Membre;

public interface IMembreDAO {
    public Membre save(Membre M);
    public List<Membre> MembreParMc(String mv);
    public Membre getMembre(int id);
    public Membre update(Membre M);
    public void deleteMembre(int id);
    public Membre getMembreByUsername(String username);

}
