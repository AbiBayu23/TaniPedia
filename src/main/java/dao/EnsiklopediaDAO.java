package dao;

import model.EnsiklopediaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnsiklopediaDAO {
    public List<EnsiklopediaModel> getAllEnsiklopedia() {
        List<EnsiklopediaModel> ensiklopediaList = new ArrayList<>();
        try {
            Connection con = BaseDAO.getCon();
            String query = "SELECT * FROM ensiklopedia";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EnsiklopediaModel ensiklopedia = new EnsiklopediaModel();
                ensiklopedia.setIdEnsiklopedia(rs.getInt("id_ensiklopedia"));
                ensiklopedia.setNamaEnsiklopedia(rs.getString("nama_ensiklopedia"));
                ensiklopedia.setIdTanaman(rs.getInt("id_tanaman"));
                ensiklopedia.setJenisEnsiklopedia(rs.getString("jenis_ensiklopedia"));
                ensiklopedia.setKonten(rs.getString("konten"));
                ensiklopediaList.add(ensiklopedia);
            }
            BaseDAO.closeCon(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ensiklopediaList;
    }

    public boolean addEnsiklopedia(EnsiklopediaModel ensiklopedia) {
        try {
            Connection con = BaseDAO.getCon();
            String query = "INSERT INTO ensiklopedia (nama_ensiklopedia, id_tanaman, jenis_ensiklopedia, konten) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ensiklopedia.getNamaEnsiklopedia());
            ps.setInt(2, ensiklopedia.getIdTanaman());
            ps.setString(3, ensiklopedia.getJenisEnsiklopedia());
            ps.setString(4, ensiklopedia.getKonten());
            int result = ps.executeUpdate();
            BaseDAO.closeCon(con);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEnsiklopedia(EnsiklopediaModel ensiklopedia) {
        try {
            Connection con = BaseDAO.getCon();
            String query = "UPDATE ensiklopedia SET nama_ensiklopedia = ?, id_tanaman = ?, jenis_ensiklopedia = ?, konten = ? WHERE id_ensiklopedia = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ensiklopedia.getNamaEnsiklopedia());
            ps.setInt(2, ensiklopedia.getIdTanaman());
            ps.setString(3, ensiklopedia.getJenisEnsiklopedia());
            ps.setString(4, ensiklopedia.getKonten());
            ps.setInt(5, ensiklopedia.getIdEnsiklopedia());
            int result = ps.executeUpdate();
            BaseDAO.closeCon(con);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEnsiklopedia(int idEnsiklopedia) {
        try {
            Connection con = BaseDAO.getCon();
            String query = "DELETE FROM ensiklopedia WHERE id_ensiklopedia = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idEnsiklopedia);
            int result = ps.executeUpdate();
            BaseDAO.closeCon(con);
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
