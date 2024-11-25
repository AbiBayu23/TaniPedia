package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KamusModel;

public class KamusDAO extends BaseDAO {

    public List<KamusModel> getAllKamus() {
        List<KamusModel> kamusList = new ArrayList<>();
        String query = "SELECT * FROM kamus";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                KamusModel kamus = new KamusModel();
                kamus.setIdKamus(rs.getInt("id_kamus"));
                kamus.setIstilahKamus(rs.getString("istilah_kamus"));
                kamus.setKontenKamus(rs.getString("Konten"));
                kamusList.add(kamus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kamusList;
    }

    public boolean addKamus(KamusModel kamus) {
        String query = "INSERT INTO kamus (istilah_kamus, konten) VALUES (?, ?)";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, kamus.getIstilahKamus());
            stmt.setString(2, kamus.getKontenKamus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateKamus(KamusModel kamus) {
        String query = "UPDATE kamus SET istilah_kamus = ?, konten = ? WHERE id_kamus = ?";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, kamus.getIstilahKamus());
            stmt.setString(2, kamus.getKontenKamus());
            stmt.setInt(3, kamus.getIdKamus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteKamus(int idKamus) {
        String query = "DELETE FROM Kamus WHERE id_Kamus = ?";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idKamus);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
