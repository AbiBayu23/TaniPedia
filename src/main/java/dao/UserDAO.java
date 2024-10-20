package dao;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // Method untuk menambahkan user baru ke database
    public void addUser(User user) {
        Connection con = BaseDAO.getCon();
        String query = "INSERT INTO users (idUser, nama, noTelp, password, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user.getIdUser());
            ps.setString(2, user.getNama());
            ps.setString(3, user.getNoTelp());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
    }

    // Method untuk mendapatkan user berdasarkan noTelp
    public User getUserByNoTelp(String noTelp) {
        Connection con = BaseDAO.getCon();
        String query = "SELECT * FROM users WHERE noTelp = ?";
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, noTelp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(
                    rs.getInt("idUser"),
                    rs.getString("nama"),
                    rs.getString("noTelp"),
                    rs.getString("password"),
                    rs.getString("role")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeCon(con);
        }
        return user;
    }

    // Method untuk memvalidasi login user
    public boolean validateLogin(String noTelp, String password) {
        User user = getUserByNoTelp(noTelp);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
