package métier;

import java.util.Date;

public class Emprunt {
    private int id_emprunt;
    private Date date_emprunt;
    private Date date_retour;
    private int id_livre;
    private int id_membre;

    public Emprunt() {
    }

    public Emprunt(int id_emprunt, Date date_emprunt, Date date_retour, int id_livre, int id_membre) {
        this.id_emprunt = id_emprunt;
        this.date_emprunt = date_emprunt;
        this.date_retour = date_retour;
        this.id_livre = id_livre;
        this.id_membre = id_membre;
    }

    // Getters and setters
    public int getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(int id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public Date getDate_emprunt() {
        return date_emprunt;
    }

    public void setDate_emprunt(Date date_emprunt) {
        this.date_emprunt = date_emprunt;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }
}

