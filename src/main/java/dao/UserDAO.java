package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserModel;

public class UserDAO {
    public boolean registerUser(String username, String password, String nomorHp) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "INSERT INTO user (username, password,  nomor_hp) VALUES (?, ?, ?,)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nomorHp);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        Connection con = null;

        try {
            // Mendapatkan koneksi dari BaseDAO
            con = BaseDAO.getCon();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Eksekusi query
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Jika ada hasil, berarti valid
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Tutup koneksi menggunakan BaseDAO
            BaseDAO.closeCon(con);
        }
        return false;
    }
}
