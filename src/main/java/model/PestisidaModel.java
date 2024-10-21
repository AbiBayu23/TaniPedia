package model;

public class PestisidaModel {
    private int idPestisida;
    private String namaPestisida;
    private double hargaPestisida;

    public PestisidaModel() {
    }

    public PestisidaModel(int idPestisida, String namaPestisida, double hargaPestisida) {
        this.idPestisida = idPestisida;
        this.namaPestisida = namaPestisida;
        this.hargaPestisida = hargaPestisida;
    }

    public int getIdPestisida() {
        return idPestisida;
    }

    public void setIdPestisida(int idPestisida) {
        this.idPestisida = idPestisida;
    }

    public String getNamaPestisida() {
        return namaPestisida;
    }

    public void setNamaPestisida(String namaPestisida) {
        this.namaPestisida = namaPestisida;
    }

    public double getHargaPestisida() {
        return hargaPestisida;
    }

    public void setHargaPestisida(double hargaPestisida) {
        this.hargaPestisida = hargaPestisida;
    }
}
