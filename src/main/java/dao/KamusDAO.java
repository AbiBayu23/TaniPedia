package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KamusModel;

public class KamusDAO extends BaseDAO {

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
    public void addKamus(KamusModel kamus) throws SQLException {
    String query = "INSERT INTO kamus (nama_istilah, penjelasan) VALUES (?, ?)";
    try (Connection connection = BaseDAO.getCon();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setString(1, kamus.getNamaIstilah());
        statement.setString(2, kamus.getPenjelasan());
        statement.executeUpdate();
    }
}

    public void updateKamus(String namaIstilah, String penjelasanBaru) throws SQLException {
    String query = "UPDATE kamus SET penjelasan = ? WHERE nama_istilah = ?";
    try (Connection connection = BaseDAO.getCon();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setString(1, penjelasanBaru);
        statement.setString(2, namaIstilah);
        statement.executeUpdate();
    }
}
    public void deleteKamus(String namaIstilah) throws SQLException {
    String query = "DELETE FROM kamus WHERE nama_istilah = ?";
    try (Connection connection = BaseDAO.getCon();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setString(1, namaIstilah);
        statement.executeUpdate();
    }
}
    public KamusModel getKamusByNamaIstilah(String namaIstilah) throws SQLException {
    KamusModel kamus = null;
    String query = "SELECT id_kamus, nama_istilah, penjelasan FROM kamus WHERE nama_istilah = ?";
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
