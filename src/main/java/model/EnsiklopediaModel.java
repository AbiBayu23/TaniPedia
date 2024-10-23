package model;

public class EnsiklopediaModel {
    private int idEnsiklopedia;
    private String namaEnsiklopedia;
    private int idTanaman;
    private String jenisEnsiklopedia;
    private String konten;

    // Getters dan Setters
    public int getIdEnsiklopedia() {
        return idEnsiklopedia;
    }

    public void setIdEnsiklopedia(int idEnsiklopedia) {
        this.idEnsiklopedia = idEnsiklopedia;
    }

    public String getNamaEnsiklopedia() {
        return namaEnsiklopedia;
    }

    public void setNamaEnsiklopedia(String namaEnsiklopedia) {
        this.namaEnsiklopedia = namaEnsiklopedia;
    }

    public int getIdTanaman() {
        return idTanaman;
    }

    public void setIdTanaman(int idTanaman) {
        this.idTanaman = idTanaman;
    }

    public String getJenisEnsiklopedia() {
        return jenisEnsiklopedia;
    }

    public void setJenisEnsiklopedia(String jenisEnsiklopedia) {
        this.jenisEnsiklopedia = jenisEnsiklopedia;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }
}
