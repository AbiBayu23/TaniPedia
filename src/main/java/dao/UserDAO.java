package dao;

import static dao.BaseDAO.closeCon;
import static dao.BaseDAO.getCon;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserModel;



public class UserDAO {
    
    public boolean validateUser(String username, String password) {
        try (Connection con = BaseDAO.getCon()) {
            String query = "SELECT COUNT(*) FROM user WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
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
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("nomor_hp"),
                rs.getString("password"),
                rs.getString("alamat_pengguna"),
                rs.getString("email_pengguna"),
                rs.getString("nama_usaha"),
                rs.getBytes("Image")
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
    
    public static void updateUser(int IdUser, String namaUsaha, String Username, String NomorHP, String Alamat, String Email) throws SQLException {
    String query = "UPDATE user SET nama_usaha = ?, username = ?, nomor_hp = ?, email_pengguna = ?, alamat_pengguna = ? WHERE id = ?";
    Connection con = null;
    
    try{
        con = BaseDAO.getCon();
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, namaUsaha);
        stmt.setString(2, Username);
        stmt.setString(3, NomorHP);
        stmt.setString(4, Alamat);
        stmt.setString(5, Email);
        stmt.setInt(6, IdUser);
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
                System.out.println("User image updated successfully.");
            }
    }
    catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } finally {
            BaseDAO.closeCon(con);
        }
    }
    

    public static void insertEntry(int IdUser, byte[] imageData) throws SQLException {
    String query = "UPDATE user SET Image = ? WHERE id = ?"; // Update query based on userId
    Connection con = null;
        try {
            con = BaseDAO.getCon();
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setBytes(1, imageData);
            stmt.setInt(2, IdUser);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User image updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
