package controller;

import dao.UserDAO;
import java.io.File;
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
import java.net.URL;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private TextField Username;

    @FXML
    private TextField Pass;

    private AnchorPane rootPane;
    
    @FXML
    private Label Register;

    private UserDAO userDAO;
    @FXML
    private Button Login;
    @FXML
    private TextField Pass1;

    public LoginController() {
        // Inisialisasi UserDAO
        this.userDAO = new UserDAO();
    }

    @FXML
    void klik(MouseEvent event) {
        // Ambil input dari TextField
        String username = Username.getText();
        String password = Pass.getText();

        // Validasi data login
        boolean isValidUser = userDAO.validateUser(username, password);

        if (isValidUser) {
            // Jika valid, buka Main.fxml
            try {
                URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Stage stage = (Stage) Login.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Unable to load the main page.");
            }
        } else {
            // Jika invalid, tampilkan pesan
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid Username/Email/Password");
        }
    }

    public void handleRegister(MouseEvent event) {
    try {
        URL url = new File("src/main/java/view/Register.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) Register.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    } catch (Exception e) {
        File file = new File("src/main/java/view/Register.fxml");
        System.out.println("File exists: " + file.exists());
        showAlert(Alert.AlertType.ERROR, "Error",  e.getMessage());
    }
}

    private void showAlert(AlertType ERROR, String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
