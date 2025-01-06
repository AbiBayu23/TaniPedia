// ShopDAO.java
package dao;

import model.ShopModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShopDAO extends BaseDAO {

    public List<ShopModel> getAllItems() {
        List<ShopModel> items = new ArrayList<>();
        String query = "SELECT * FROM shopitem";

        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ShopModel item = new ShopModel(
                    rs.getInt("item_id"),
                    rs.getString("nama_item"),
                    rs.getDouble("harga_item"),
                    rs.getString("jenis_item")
                );
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public void insertItem(ShopModel item) {
        String query = "INSERT INTO shopitem (nama_item, harga_item, jenis_item) VALUES (?, ?, ?)";

        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, item.getNamaItem());
            ps.setDouble(2, item.getHargaItem());
            ps.setString(3, item.getJenisItem());
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
            ps.setString(3, item.getJenisItem());
            ps.setInt(4, item.getItemId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(int itemId) {
        String query = "DELETE FROM shopitem WHERE item_id = ?";

        try (Connection con = getCon(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, itemId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}