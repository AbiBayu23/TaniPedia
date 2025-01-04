package dao;

import model.EnsiklopediaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnsiklopediaDAO {
    public int getIdTanaman(String namaTanaman, String jenisTanaman) throws SQLException {
    String query = "SELECT id_tanaman FROM tanaman WHERE nama_tanaman = ? AND jenis_tanaman = ?";
        try (Connection conn = BaseDAO.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, namaTanaman);
            stmt.setString(2, jenisTanaman);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_tanaman"); // Kembalikan ID tanaman
                } else {
                    throw new SQLException("Tanaman dengan nama dan jenis tersebut tidak ditemukan.");
                }
            }
        }
    }
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

    public void tambahEnsiklopedia(String namaTanaman, String jenisTanaman, String panduanBudidaya, String penangananPenyakit, byte[] fotoEnsiklopedia) throws SQLException {
    // Dapatkan ID tanaman berdasarkan nama dan jenis tanaman
    int idTanaman = getIdTanaman(namaTanaman, jenisTanaman);

    // Query untuk menyimpan ke tabel ensiklopedia
    String query = "INSERT INTO ensiklopedia (id_tanaman, panduan_budidaya, penanganan_hama, foto_ensiklopedia) VALUES (?, ?, ?, ?)";
        try (Connection conn = BaseDAO.getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idTanaman);
            stmt.setString(2, panduanBudidaya);
            stmt.setString(3, penangananPenyakit);
            stmt.setBytes(4, fotoEnsiklopedia); // Simpan gambar sebagai BLOB
            stmt.executeUpdate();
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
