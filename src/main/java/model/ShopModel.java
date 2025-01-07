package model;

public class ShopModel {

    public int getStokItem() {
        return stokItem;
    }

    public void setStokItem(int stokItem) {
        this.stokItem = stokItem;
    }

    public byte[] getImageItem() {
        return imageItem;
    }

    public void setImageItem(byte[] imageItem) {
        this.imageItem = imageItem;
    }
    private int itemId;
    private String namaItem;
    private double hargaItem;
    private int stokItem;
    private byte[] imageItem;


    public ShopModel(String namaItem, Integer hargaItem1, Integer hargaItem, byte[] imageItem) {
        this.itemId = itemId;
        this.namaItem = namaItem;
        this.hargaItem = hargaItem;
        this.stokItem = stokItem;
        this.imageItem = imageItem;
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

}
