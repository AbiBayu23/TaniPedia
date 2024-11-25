package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean validateUser(String username, String email, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND email = ? AND password = ?";
        Connection con = null;

        try {
            // Mendapatkan koneksi dari BaseDAO
            con = BaseDAO.getCon();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);

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
