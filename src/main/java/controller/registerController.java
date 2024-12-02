/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abiba
 */
public class registerController implements Initializable {

    @FXML
    private Button Register;
    @FXML
    private TextField Username;
    @FXML
    private Label Login;
    @FXML
    private TextField HP;
    @FXML
    private TextField Pass;
    
    private UserDAO userDAO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.userDAO = new UserDAO();
    }    

    @FXML
    void Register(MouseEvent event) {
    // Ambil input dari TextField
    String username = Username.getText();
    String nomorHp = HP.getText();
    String password = Pass.getText();

    // Validasi input
    if (username.isEmpty() || nomorHp.isEmpty() || password.isEmpty()) {
        showAlert(Alert.AlertType.WARNING, "Registration Failed", "All fields must be filled!");
        return;
    }

    // Simpan data pengguna melalui DAO
    try {
        boolean isRegistered = userDAO.registerUser(username,  nomorHp, password);

        if (isRegistered) {
            // Jika berhasil, tampilkan pesan sukses dan buka halaman login
            showAlert(Alert.AlertType.INFORMATION, "Success", "Registration successful!");
            try {
            URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) Login.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Unable to load the login page.");
            }
        } else {
            // Jika gagal menyimpan data (misalnya, email sudah terdaftar)
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "nomor HP or username already exists!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while registering the user.");
    }
}


    public void backLogin(MouseEvent event) {
    try {
        URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) Login.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    } catch (Exception e) {
        File file = new File("src/main/java/view/Register.fxml");
        System.out.println("File exists: " + file.exists());
        showAlert(Alert.AlertType.ERROR, "Error",  e.getMessage());
    }
}

    private void showAlert(Alert.AlertType ERROR, String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

    
