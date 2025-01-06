package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KamusModel;

public class KamusDAO extends BaseDAO {

    // Mengambil semua data Kamus
    public List<KamusModel> getAllKamus() throws SQLException {
        List<KamusModel> kamusList = new ArrayList<>();
        String query = "SELECT nama_istilah, penjelasan FROM kamus";
        try (Connection connection = BaseDAO.getCon();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String namaIstilah = resultSet.getString("nama_istilah");
                String penjelasan = resultSet.getString("penjelasan");
                kamusList.add(new KamusModel(namaIstilah, penjelasan));
            }
        }
        return kamusList;
    }

    // Menambahkan data Kamus baru
    public void addKamus(KamusModel kamus) throws SQLException {
        String query = "INSERT INTO kamus (nama_istilah, penjelasan) VALUES (?, ?)";
        try (Connection connection = BaseDAO.getCon();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, kamus.getNamaIstilah());
            statement.setString(2, kamus.getPenjelasan());
            statement.executeUpdate();
        }
    }

    // Memperbarui data Kamus berdasarkan nama istilah
    public void updateKamus(KamusModel kamus) throws SQLException {
        String query = "UPDATE kamus SET penjelasan = ? AND nama_istilah = ? WHERE Id = ?";
        try (Connection connection = BaseDAO.getCon();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, kamus.getPenjelasan());
            statement.setString(2, kamus.getNamaIstilah());
            statement.setInt(3, kamus.getId());
            statement.executeUpdate();
        }
    }

    // Menghapus data Kamus berdasarkan nama istilah
    public void deleteKamus(KamusModel kamus) throws SQLException {
        String query = "DELETE FROM kamus WHERE nama_istilah = ?";
        try (Connection connection = BaseDAO.getCon();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, kamus.getNamaIstilah());
            statement.executeUpdate();
        }
    }

    // Mengambil data Kamus berdasarkan nama istilah
    public KamusModel getKamusByNamaIstilah(String namaIstilah) throws SQLException {
        KamusModel kamus = null;
        String query = "SELECT nama_istilah, penjelasan FROM kamus WHERE nama_istilah = ?";
        try (Connection connection = BaseDAO.getCon();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, namaIstilah);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String penjelasan = resultSet.getString("penjelasan");
                    kamus = new KamusModel(namaIstilah, penjelasan);
                }
            }
        }
        return kamus;
    }
}
