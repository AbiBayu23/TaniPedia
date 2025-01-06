package model;

public class KamusModel {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;
    private String namaIstilah;
    private String penjelasan;

    // Konstruktor
    public KamusModel(String namaIstilah, String penjelasan) {
        this.namaIstilah = namaIstilah;
        this.penjelasan = penjelasan;
    }

    // Getter untuk namaIstilah
    public String getNamaIstilah() {
        return namaIstilah;
    }
    
    private KamusModel selectedKamus;

    private KamusModel getSelectedKamus() {
        return selectedKamus;
    }


    // Setter untuk namaIstilah
    public void setNamaIstilah(String namaIstilah) {
        this.namaIstilah = namaIstilah;
    }

    // Getter untuk penjelasan
    public String getPenjelasan() {
        return penjelasan;
    }

    // Setter untuk penjelasan
    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }
}
