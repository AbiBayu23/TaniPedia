package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserModel;

public class UserDAO {
    public boolean registerUser(String username, String nomorHp, String password ) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "INSERT INTO user (username, nomor_hp, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, nomorHp);
            ps.setString(3, password);
            

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public UserModel getUser(String username, String password) {
    String query = "SELECT * FROM user WHERE username = ? AND password = ?";
    Connection con = null;

    try {
        // Mendapatkan koneksi dari BaseDAO
        con = BaseDAO.getCon();
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);

        // Eksekusi query
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Jika user ditemukan, buat objek UserModel
            UserModel user = new UserModel(
                rs.getString("username"),
                rs.getString("nomor_hp"),
                rs.getString("password")
            );
            return user;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Tutup koneksi menggunakan BaseDAO
        BaseDAO.closeCon(con);
    }
    return null; // Return null jika user tidak ditemukan
}
}
