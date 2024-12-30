package model;

public class UserModel {


    public UserModel(int aInt, String string, String string1, String string2) {
    }
    private int idUser;
    private String password;
    private String username;
    private String nomorHp;
    private String role;
    private byte[] profilePhoto;


    

    public UserModel(int idUser, String username, String nomorHp, String password, byte[] profilePhoto) {
        this.idUser = idUser;
        this.username = username;
        this.nomorHp = nomorHp;
        this.password = password;
        this.profilePhoto = profilePhoto;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }   
    
    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

}
    

   
