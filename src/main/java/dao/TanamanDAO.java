package dao;

import model.TanamanModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TanamanDAO {

    public List<TanamanModel> getAllTanaman() {
        List<TanamanModel> tanamanList = new ArrayList<>();
        try (Connection con = BaseDAO.getCon()) {
            String query = "SELECT * FROM tanaman";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TanamanModel tanaman = new TanamanModel();
                tanaman.setIdTanaman(rs.getInt("id_tanaman"));
                tanaman.setNamaTanaman(rs.getString("nama_tanaman"));
                tanaman.setJenisTanaman(rs.getString("jenis_tanaman"));
                tanamanList.add(tanaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tanamanList;
    }

    public boolean addTanaman(TanamanModel tanaman) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "INSERT INTO tanaman (nama_tanaman, jenis_tanaman) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, tanaman.getNamaTanaman());
            ps.setString(2, tanaman.getJenisTanaman());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTanaman(TanamanModel tanaman) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "UPDATE tanaman SET nama_tanaman = ?, jenis_tanaman = ? WHERE id_tanaman = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, tanaman.getNamaTanaman());
            ps.setString(2, tanaman.getJenisTanaman());
            ps.setInt(3, tanaman.getIdTanaman());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTanaman(int idTanaman) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "DELETE FROM tanaman WHERE id_tanaman = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idTanaman);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
