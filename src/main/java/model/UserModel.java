package model;

public class UserModel {


    public UserModel(int aInt, String string, String string1, String string2) {
    }
    private int idUser;
    private String password;
    private String username;
    private String nomorHp;
    private String email;
    private String namaUsaha;
    private String alamat;
    private byte[] profilePhoto;
    
    
    public UserModel(int idUser, String username, String nomorHp, String password, String alamat, String email, String namaUsaha, byte[] profilePhoto) {
        this.idUser = idUser;
        this.username = username;
        this.nomorHp = nomorHp;
        this.password = password;
        this.alamat = alamat;
        this.email = email;
        this.namaUsaha = namaUsaha;
        this.profilePhoto = profilePhoto;
    }
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNamaUsaha() {
        return namaUsaha;
    }

    public void setNamaUsaha(String namaUsaha) {
        this.namaUsaha = namaUsaha;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    
    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

}
    

   
