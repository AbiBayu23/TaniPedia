package dao;

import model.PestisidaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PestisidaDAO extends BaseDAO {

    public List<PestisidaModel> getAllPestisida() {
        List<PestisidaModel> pestisidaList = new ArrayList<>();
        String query = "SELECT * FROM pestisida";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PestisidaModel pestisida = new PestisidaModel();
                pestisida.setIdPestisida(rs.getInt("id_pestisida"));
                pestisida.setNamaPestisida(rs.getString("nama_pestisida"));
                pestisida.setHargaPestisida(rs.getDouble("harga_pestisida"));
                pestisidaList.add(pestisida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pestisidaList;
    }

    public boolean addPestisida(PestisidaModel pestisida) {
        String query = "INSERT INTO pestisida (nama_pestisida, harga_pestisida) VALUES (?, ?)";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, pestisida.getNamaPestisida());
            stmt.setDouble(2, pestisida.getHargaPestisida());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePestisida(PestisidaModel pestisida) {
        String query = "UPDATE pestisida SET nama_pestisida = ?, harga_pestisida = ? WHERE id_pestisida = ?";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, pestisida.getNamaPestisida());
            stmt.setDouble(2, pestisida.getHargaPestisida());
            stmt.setInt(3, pestisida.getIdPestisida());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePestisida(int idPestisida) {
        String query = "DELETE FROM pestisida WHERE id_pestisida = ?";
        
        try (Connection con = getCon(); PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idPestisida);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
