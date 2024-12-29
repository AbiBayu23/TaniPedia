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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.UserModel;

/**
 * FXML Controller class
 *
 * @author abiba
 */
public class HomeController implements Initializable {

    private ImageView Logout;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnSignout;
    @FXML
    private VBox pnItems;
    @FXML
    private Pane Belanja;
    @FXML
    private Pane Ensiklopedia;
    @FXML
    private Pane Home;
    @FXML
    private Label username;
    @FXML
    private Pane Kamus;
    @FXML
    private Label hello;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set default pane to show
        showPane(Home);
    }

    @FXML
    public void Logout(MouseEvent event) {
        try {
            URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) btnSignout.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            File file = new File("src/main/java/view/Login.fxml");
            System.out.println("File exists: " + file.exists());
        }
    }

    @FXML
    private void showOverview(MouseEvent event) {
        showPane(Home);
    }

    @FXML
    private void showPackages(MouseEvent event) {
        showPane(Belanja);
    }

    @FXML
    private void showOrders(MouseEvent event) {
        showPane(Ensiklopedia);
    }
    
    @FXML
    private void showMenus(MouseEvent event) {
        showPane(Kamus);
    }


    private void showPane(Pane paneToShow) {
        Home.setVisible(false);
        Belanja.setVisible(false);
        Ensiklopedia.setVisible(false);
        Kamus.setVisible(false);

        paneToShow.setVisible(true);
    }

  

    void setUserModel(UserModel user) {
        username.setText(user.getUsername());
        hello.setText("Hello, " + user.getUsername()+"!");
    }
}
