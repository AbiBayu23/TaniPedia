package controller;

import dao.UserDAO;
import model.User;
import view.UserView;

public class UserController {
    private UserView view;
    private UserDAO dao;

    public UserController(UserView view, UserDAO dao) {
        this.view = view;
        this.dao = dao;
    }

    // Method untuk registrasi user
    public void register() {
        String[] registerData = view.registerUser();
        User newUser = new User(0, registerData[0], registerData[1], registerData[2], registerData[3]); // ID otomatis di MySQL
        dao.addUser(newUser);
        view.showMessage("Registrasi berhasil!");
    }

    // Method untuk login user
    public void login() {
        String[] loginData = view.loginUser();
        boolean isLoginSuccessful = dao.validateLogin(loginData[0], loginData[1]);
        if (isLoginSuccessful) {
            view.showMessage("Login berhasil!");
        } else {
            view.showMessage("Login gagal, periksa kembali No. Telp dan Password!");
        }
    }
}
