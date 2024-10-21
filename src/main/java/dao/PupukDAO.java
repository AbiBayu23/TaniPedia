PupukDAO.java
package dao;

import model.PupukModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PupukDAO {

    public List<PupukModel> getAllPupuk() {
        List<PupukModel> pupukList = new ArrayList<>();
        try (Connection con = BaseDAO.getCon()) {
            String query = "SELECT * FROM pupuk";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PupukModel pupuk = new PupukModel();
                pupuk.setIdPupuk(rs.getInt("id_pupuk"));
                pupuk.setNamaPupuk(rs.getString("nama_pupuk"));
                pupuk.setHargaPupuk(rs.getDouble("harga_pupuk"));
                pupukList.add(pupuk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pupukList;
    }

    public boolean addPupuk(PupukModel pupuk) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "INSERT INTO pupuk (nama_pupuk, harga_pupuk) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pupuk.getNamaPupuk());
            ps.setDouble(2, pupuk.getHargaPupuk());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePupuk(PupukModel pupuk) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "UPDATE pupuk SET nama_pupuk = ?, harga_pupuk = ? WHERE id_pupuk = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pupuk.getNamaPupuk());
            ps.setDouble(2, pupuk.getHargaPupuk());
            ps.setInt(3, pupuk.getIdPupuk());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePupuk(int idPupuk) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "DELETE FROM pupuk WHERE id_pupuk = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idPupuk);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
