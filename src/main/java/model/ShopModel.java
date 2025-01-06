package model;

public class ShopModel {
    private int itemId;
    private String namaItem;
    private double hargaItem;
    private String jenisItem;

    public ShopModel(int itemId, String namaItem, double hargaItem, String jenisItem) {
        this.itemId = itemId;
        this.namaItem = namaItem;
        this.hargaItem = hargaItem;
        this.jenisItem = jenisItem;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public double getHargaItem() {
        return hargaItem;
    }

    public void setHargaItem(double hargaItem) {
        this.hargaItem = hargaItem;
    }

    public String getJenisItem() {
        return jenisItem;
    }

    public void setJenisItem(String jenisItem) {
        this.jenisItem = jenisItem;
    }
}