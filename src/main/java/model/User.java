package model;

public class User {
    private int idUser;
    private String nama;
    private String noTelp;
    private String password;
    private String role;

    // Constructor
    public User(int idUser, String nama, String noTelp, String password, String role) {
        this.idUser = idUser;
        this.nama = nama;
        this.noTelp = noTelp;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}