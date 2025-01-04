package controller;

import dao.UserDAO;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import model.UserModel;

public class LoginController {

    @FXML
    private TextField Username;

    @FXML
    private TextField Pass;
    
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textField;
    
    @FXML
    private Label Register;

    private UserDAO userDAO;

    @FXML
    private Button Login;

    private boolean isPasswordVisible = false;

    public LoginController() {
        this.userDAO = new UserDAO();
    }
    
    @FXML
    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordField.setText(textField.getText());
            passwordField.setVisible(true);
            textField.setVisible(false);
            isPasswordVisible = false;
        } else {
            textField.setText(passwordField.getText());
            passwordField.setVisible(false);
            textField.setVisible(true);
            isPasswordVisible = true;
        }
    }

    @FXML
    void klik(MouseEvent event) {
        String username = Username.getText();
        String password = passwordField.isVisible() ? passwordField.getText() : textField.getText();
        UserModel user = userDAO.getUser(username, password);
        if (user != null) {
            try {
                 URL url = new File("src/main/java/view/Home.fxml").toURI().toURL();
                FXMLLoader loader = new FXMLLoader(url);
                Parent root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserModel(user);
                Stage stage = (Stage) Login.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Unable to load the main page.");
            }
        } else {
            Text wrongUserText = (Text) Login.getScene().lookup("#wrongUser");
            if (wrongUserText != null) {
                wrongUserText.setVisible(true); 
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid Username/Email/Password");
            }
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
