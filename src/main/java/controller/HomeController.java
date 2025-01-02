package controller;

import dao.UserDAO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.UserModel;

/**
 * FXML Controller class
 *
 * @author abiba
 */
public class HomeController implements Initializable {
    private UserModel userModel;
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
    @FXML
    private UserDAO userDAO;
    @FXML
    private ImageView profil;
    @FXML
    private ImageView addEnsiklopedia;
    @FXML
    private Pane formEnsiklopedia;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set default pane to show
        showPane(Home);
    }
    public HomeController() {
        // Inisialisasi UserDAO
        this.userDAO = new UserDAO();
    }
    
    
   
    
    private byte[] readFileToByteArray(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return data;
        }
    } 
    

    @FXML
    private void getProfil(MouseEvent event) throws IOException, SQLException {
        int userId = userModel.getIdUser();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(username.getScene().getWindow());
                if (selectedFile != null) {
            // Optional: Display the selected image in the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            profil.setImage(image);
                UserDAO.insertEntry(userId, this.readFileToByteArray(selectedFile));
        }
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
    @FXML
    private void showPengisian(MouseEvent event) {
        showPane(formEnsiklopedia);
    }


    private void showPane(Pane paneToShow) {
        Home.setVisible(false);
        Belanja.setVisible(false);
        Ensiklopedia.setVisible(false);
        Kamus.setVisible(false);
        formEnsiklopedia.setVisible(false);

        paneToShow.setVisible(true);
    }
    
    void setUserModel(UserModel user) {
        if (user == null) {
        throw new IllegalArgumentException("UserModel cannot be null");
        }

        this.userModel = user;
        username.setText(user.getUsername());
        hello.setText("Hello, " + user.getUsername() + "!");
        if (user.getProfilePhoto() != null) {
            Image foto = new Image(new ByteArrayInputStream(user.getProfilePhoto()));
            profil.setImage(foto);
        }
    }

    

}
