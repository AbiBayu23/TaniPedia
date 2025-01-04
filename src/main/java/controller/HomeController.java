package controller;

import dao.TanamanDAO;
import dao.UserDAO;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.TanamanModel;
import model.UserModel;

public class HomeController implements Initializable {
    private UserModel userModel;
    private UserDAO userDAO;
    private TanamanDAO tanamanDAO;
    
    @FXML
    private Label username, hello, namaUsaha, namaPengguna, nomorHP, email, alamat;

    @FXML
    private ImageView Img, fotoProfil, addEnsiklopedia;

    @FXML
    private TextField formUsaha, formPengguna, formHP, formEmail;

    @FXML
    private TextArea formAlamat;

    @FXML
    private Button editProfil, insertImg, confirmEdit, backHome, btnOverview, btnPackages, btnOrders, btnMenus, btnSignout;

    @FXML
    private Pane Belanja, Ensiklopedia, Home, Kamus, profilPengguna, formEnsiklopedia, previousPane;

    @FXML
    private AnchorPane profilImg, infoPengguna, formEdit;

    @FXML
    private VBox pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPane(Home);
    }
    
    public HomeController() {
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
    private void insertImg(MouseEvent event) throws IOException, SQLException {
        int userId = userModel.getIdUser();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(username.getScene().getWindow());
            if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            Img.setImage(image);
            fotoProfil.setImage(image);
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
    @FXML
    private void showProfil(MouseEvent event) {
        showPane(profilPengguna);
    }
    
    @FXML
    private void editProfilAction(MouseEvent event) {
        infoPengguna.setVisible(false);
        formEdit.setVisible(true);
        editProfil.setVisible(false);
        confirmEdit.setVisible(true);
    }

    private void showPane(Pane paneToShow) {
        if (paneToShow != null && paneToShow.isVisible()) {
        return;
    }

    previousPane = getVisiblePane();

    Home.setVisible(false);
    Belanja.setVisible(false);
    Ensiklopedia.setVisible(false);
    Kamus.setVisible(false);
    formEnsiklopedia.setVisible(false);
    profilPengguna.setVisible(false);
    
    paneToShow.setVisible(true);
    }
    
    private Pane getVisiblePane() {
    if (Home.isVisible()) return Home;
    if (Belanja.isVisible()) return Belanja;
    if (Ensiklopedia.isVisible()) return Ensiklopedia;
    if (Kamus.isVisible()) return Kamus;
    if (formEnsiklopedia.isVisible()) return formEnsiklopedia;
    if (profilPengguna.isVisible()) return profilPengguna;
    return null;
    }

    
    void setUserModel(UserModel user) {
        if (user == null) {
        throw new IllegalArgumentException("UserModel cannot be null");
        }
        
        this.userModel = user;
        formUsaha.setText(user.getNamaUsaha());
        formPengguna.setText(user.getUsername());
        formHP.setText(user.getNomorHp());
        formEmail.setText(user.getEmail());
        formAlamat.setText(user.getAlamat());
        username.setText(user.getUsername());
        namaUsaha.setText(user.getNamaUsaha());
        namaPengguna.setText(user.getUsername());
        nomorHP.setText(user.getNomorHp());
        email.setText(user.getEmail());
        alamat.setText(user.getAlamat());
        hello.setText("Hello, " + user.getUsername() + "!");
        if (user.getProfilePhoto() != null) {
            Image foto = new Image(new ByteArrayInputStream(user.getProfilePhoto()));
            Img.setImage(foto);
        }
        if (user.getProfilePhoto() != null) {
            Image foto = new Image(new ByteArrayInputStream(user.getProfilePhoto()));
            fotoProfil.setImage(foto);
        }
    }

    @FXML
    private void kembali(MouseEvent event) {
        if (formEdit.isVisible()) {
            formEdit.setVisible(false);
            confirmEdit.setVisible(false);

            infoPengguna.setVisible(true);
            editProfil.setVisible(true);
        } else {
            if (previousPane != null) {
                showPane(previousPane);
                previousPane = null;
            } else {
                showPane(Home);
            }
        }
    }
}
