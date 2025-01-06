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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private PasswordField passwordField;
    @FXML
    private TextField textField;
    @FXML
    private Text fill;
    
    private UserDAO userDAO;
    
    private boolean isPasswordVisible = false; // Status visibilitas password

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.userDAO = new UserDAO();
        
        setMaxLengthAndPattern(Username, 16, "[a-zA-Z0-9]*");
        setMaxLengthAndPattern(passwordField, 16, "[a-zA-Z0-9]*");
        setMaxLengthAndPattern(textField, 16, "[a-zA-Z0-9]*");
        setMaxLengthAndPattern(HP, 13, "\\d*");
        
        fill.setVisible(false);
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
            textField.setVisible(true);
            passwordField.setVisible(false);
            isPasswordVisible = true;
        }
    }

    @FXML
    void handleRegister(MouseEvent event) {
        String username = Username.getText();
        String nomorHp = HP.getText();
        String password = passwordField.getText();

        if (username.length() < 8 || password.length() < 8 || nomorHp.length() < 12) {
            fill.setVisible(true);
            return;
        } else {
            fill.setVisible(false);
        }

        if (username.isEmpty() || nomorHp.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Registration Failed", "All fields must be filled!");
            return;
        }

        try {
            boolean isRegistered = userDAO.registerUser(username, nomorHp, password);

            if (isRegistered) {
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
                showAlert(Alert.AlertType.ERROR, "Registration Failed", "Nomor HP or username already exists!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while registering the user.");
        }
    }

    @FXML
    public void backLogin(MouseEvent event) {
        try {
            URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) Login.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            File file = new File("src/main/java/view/Register.fxml");
            System.out.println("File exists: " + file.exists());
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void setMaxLengthAndPattern(TextField textField, int maxLength, String pattern) {
        textField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().length() > maxLength) {
                return null;
            }
            if (!change.getControlNewText().matches(pattern)) {
                return null; 
            }
            return change;
        }));
    }
}

