package dao;

import model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean registerUser(UserModel user) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "INSERT INTO user (password_user, nama_user, email_user, nomor_hp, alamat_user, role) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getPasswordUser());
            ps.setString(2, user.getNamaUser());
            ps.setString(3, user.getEmailUser());
            ps.setString(4, user.getNomorHp());
            ps.setString(5, user.getAlamatUser());
            ps.setString(6, user.getRole());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public UserModel loginUser(String email, String password) {
        UserModel user = null;
        try (Connection con = BaseDAO.getCon()) {
            String query = "SELECT * FROM user WHERE email_user = ? AND password_user = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setIdUser(rs.getInt("id_user"));
                user.setPasswordUser(rs.getString("password_user"));
                user.setNamaUser(rs.getString("nama_user"));
                user.setEmailUser(rs.getString("email_user"));
                user.setNomorHp(rs.getString("nomor_hp"));
                user.setAlamatUser(rs.getString("alamat_user"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
