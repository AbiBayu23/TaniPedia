package controller;

import dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private TextField Username;

    @FXML
    private TextField Email;

    @FXML
    private TextField Pass;

    @FXML
    private AnchorPane rootPane;

    private UserDAO userDAO;

    public HomeController() {
        // Inisialisasi UserDAO
        this.userDAO = new UserDAO();
    }

    @FXML
    void klik(MouseEvent event) {
        // Ambil input dari TextField
        String username = Username.getText();
        String email = Email.getText();
        String password = Pass.getText();

        // Validasi data login
        boolean isValidUser = userDAO.validateUser(username, email, password);

        if (isValidUser) {
            // Jika valid, buka Main.fxml
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/Main.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) rootPane.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Unable to load the main page.");
            }
        } else {
            // Jika invalid, tampilkan pesan
            showAlert("Login Failed", "Invalid Username/Email/Password");
        }
    }

    @FXML
    void Register(MouseEvent event) {
        showAlert("Register", "Fitur pendaftaran belum diimplementasikan.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
