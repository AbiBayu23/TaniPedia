// ShopDAO.java
package dao;

import model.ShopModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KamusModel;

public class ShopDAO extends BaseDAO {

    public List<ShopModel> getAllItems() {
        List<ShopModel> items = new ArrayList<>();
        String query = "SELECT * FROM shopitem";

        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ShopModel item = new ShopModel(
                    rs.getString("nama_item"),
                    rs.getInt("harga_item"),
                    rs.getInt("stok_item"),
                    rs.getBytes("image_item")
                );
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public void insertItem(ShopModel item) {
        String query = "INSERT INTO shopitem (nama_item, harga_item, stok_item, image_item) VALUES (?, ?, ?, ?)";

        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, item.getNamaItem());
            ps.setDouble(2, item.getHargaItem());
            ps.setInt(3, item.getStokItem());
            ps.setBytes(4, item.getImageItem());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateItem(ShopModel item) {
        String query = "UPDATE shopitem SET nama_item = ?, harga_item = ?, jenis_item = ? WHERE item_id = ?";

        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, item.getNamaItem());
            ps.setDouble(2, item.getHargaItem());
            ps.setInt(3, item.getStokItem());
            ps.setInt(4, item.getItemId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void deleteItem(ShopModel shopModel) throws SQLException {
        String query = "DELETE FROM kamus WHERE nama_istilah = ?";
        try (Connection connection = BaseDAO.getCon();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, shopModel.getNamaItem());
            statement.executeUpdate();
        }
    }
}
