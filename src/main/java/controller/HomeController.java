/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abiba
 */
public class HomeController implements Initializable {

    @FXML
    private Button Home;
    @FXML
    private Button Ensiklopedia;
    @FXML
    private Button Kamus;
    @FXML
    private Button Belanja;
    @FXML
    private ImageView Logout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void Logout(MouseEvent event) {
    try {
        URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) Logout.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    } catch (Exception e) {
        File file = new File("src/main/java/view/Login.fxml");
        System.out.println("File exists: " + file.exists());
    }
}
}
