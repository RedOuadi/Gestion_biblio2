package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import métier.Membre;

public class MembreDAOImpl implements IMembreDAO {

    private Connection connection;

    public MembreDAOImpl() {
        connection = SingletonConnection.getConnection();
    }

    @Override
    public Membre save(Membre m) {
        String sql = "INSERT INTO membre(username, password, nom_membre, adresse, tele) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, m.getUsername());
            ps.setString(2, m.getPassword());
            ps.setString(3, m.getNom_membre());
            ps.setString(4, m.getAdresse());
            ps.setString(5, m.getTele());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<Membre> MembreParMc(String mc) {
        List<Membre> membres = new ArrayList<>();
        String sql = "SELECT * FROM membre WHERE username LIKE ? OR nom_membre LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + mc + "%");
            ps.setString(2, "%" + mc + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Membre membre = new Membre();
                    membre.setId_membre(rs.getInt("id_membre"));
                    membre.setUsername(rs.getString("username"));
                    membre.setPassword(rs.getString("password"));
                    membre.setNom_membre(rs.getString("nom_membre"));
                    membre.setAdresse(rs.getString("adresse"));
                    membre.setTele(rs.getString("tele"));
                    membres.add(membre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membres;
    }

    @Override
    public Membre getMembre(int id) {
        Membre membre = null;
        String sql = "SELECT * FROM membre WHERE id_membre = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    membre = new Membre();
                    membre.setId_membre(rs.getInt("id_membre"));
                    membre.setUsername(rs.getString("username"));
                    membre.setPassword(rs.getString("password"));
                    membre.setNom_membre(rs.getString("nom_membre"));
                    membre.setAdresse(rs.getString("adresse"));
                    membre.setTele(rs.getString("tele"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membre;
    }

    @Override
    public Membre update(Membre m) {
        String sql = "UPDATE membre SET username=?, password=?, nom_membre=?, adresse=?, tele=? WHERE id_membre=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, m.getUsername());
            ps.setString(2, m.getPassword());
            ps.setString(3, m.getNom_membre());
            ps.setString(4, m.getAdresse());
            ps.setString(5, m.getTele());
            ps.setInt(6, m.getId_membre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void deleteMembre(int id) {
        String sql = "DELETE FROM membre WHERE id_membre = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Membre getMembreByUsername(String username) {
        Membre membre = null;
        String sql = "SELECT * FROM membre WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    membre = new Membre();
                    membre.setId_membre(rs.getInt("id_membre"));
                    membre.setUsername(rs.getString("username"));
                    membre.setPassword(rs.getString("password"));
                    membre.setNom_membre(rs.getString("nom_membre"));
                    membre.setAdresse(rs.getString("adresse"));
                    membre.setTele(rs.getString("tele"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return membre;
    }
}



