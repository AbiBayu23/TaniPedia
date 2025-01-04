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
    private UserDAO userDAO;
    private TanamanDAO tanamanDAO;
    
    @FXML
    private ImageView profil;
    @FXML
    private ImageView addEnsiklopedia;
    @FXML
    private Pane formEnsiklopedia;
    private ComboBox<TanamanModel> listTanaman;
    @FXML
    private Pane profilPengguna;
    @FXML
    private ImageView fotoProfil;
    @FXML
    private VBox pane;
    @FXML
    private AnchorPane profilPane;
    @FXML
    private Label namaPengguna;
    @FXML
    private Label nomorHP;
    @FXML
    private Label email;
    @FXML
    private Label alamat;
    @FXML
    private Label namaUsaha;
    @FXML
    private Button editProfil;
    @FXML
    private Button backHome;
    @FXML
    private TextField formEmail;
    @FXML
    private TextField formHP;
    @FXML
    private TextField formPengguna;
    @FXML
    private TextField formUsaha;
    @FXML
    private TextArea formAlamat;
    @FXML
    private Pane previousPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    


    private void showPane(Pane paneToShow) {
        if (paneToShow != null && paneToShow.isVisible()) {
        return; // Jika pane yang diminta sudah terlihat, tidak perlu berubah
    }

    // Simpan pane sebelumnya
    previousPane = getVisiblePane();

    Home.setVisible(false);
    Belanja.setVisible(false);
    Ensiklopedia.setVisible(false);
    Kamus.setVisible(false);
    formEnsiklopedia.setVisible(false);
    profilPengguna.setVisible(false);

    // Tampilkan pane baru
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
        namaPengguna.setText(user.getUsername());
        nomorHP.setText(user.getNomorHp());
        username.setText(user.getUsername());
        hello.setText("Hello, " + user.getUsername() + "!");
        if (user.getProfilePhoto() != null) {
            Image foto = new Image(new ByteArrayInputStream(user.getProfilePhoto()));
            profil.setImage(foto);
        }
        if (user.getProfilePhoto() != null) {
            Image foto = new Image(new ByteArrayInputStream(user.getProfilePhoto()));
            fotoProfil.setImage(foto);
        }
         if (user.getNamaUsaha() != null) {
        namaUsaha.setText(user.getNamaUsaha());
        }
        if (user.getEmail() != null) {
            email.setText(user.getEmail());
        }
        if (user.getAlamat() != null) {
            alamat.setText(user.getAlamat());
        }
    }

    @FXML
    private void editProfil(MouseEvent event) {
         try {
        userModel.setNamaUsaha(formUsaha.getText());
        userModel.setUsername(formPengguna.getText());
        userModel.setNomorHp(formHP.getText());
        userModel.setAlamat(formAlamat.getText());
        userModel.setEmail(formEmail.getText());

        // Update database
        int userId = userModel.getIdUser();
        String NamaUsaha = userModel.getNamaUsaha();
        String Username = userModel.getUsername();
        String NomorHP = userModel.getNomorHp();
        String Alamat = userModel.getAlamat();
        String Email = userModel.getEmail();
        

        // Tampilkan kembali label
        namaUsaha.setText(formUsaha.getText());
        formUsaha.setVisible(false);
        namaUsaha.setVisible(true);

        namaPengguna.setText(formPengguna.getText());
        formPengguna.setVisible(false);
        namaPengguna.setVisible(true);

        nomorHP.setText(formHP.getText());
        formHP.setVisible(false);
        nomorHP.setVisible(true);

        alamat.setText(formAlamat.getText());
        formAlamat.setVisible(false);
        alamat.setVisible(true);
        
        email.setText(formEmail.getText());
        formEmail.setVisible(false);
        email.setVisible(true);
        
        UserDAO.updateUser(userId, NamaUsaha, Username, NomorHP, Alamat, Email);

        // Notifikasi sukses
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Profil");
        alert.setHeaderText(null);
        alert.setContentText("Profil berhasil diperbarui!");
        alert.showAndWait();
    } catch (Exception e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Edit Profil");
        alert.setHeaderText(null);
        alert.setContentText("Terjadi kesalahan saat memperbarui profil!");
        alert.showAndWait();
    }
    }

    @FXML
    private void backHome(MouseEvent event) {
         if (previousPane != null) {
        showPane(previousPane);
        previousPane = null;
        } else {
            showPane(Home);
        }
    }

    @FXML
    private void editPengguna(MouseEvent event) {
        formPengguna.setText(namaPengguna.getText());
        formPengguna.setVisible(true);
        namaPengguna.setVisible(false);
    }

    @FXML
    private void editHP(MouseEvent event) {
        formHP.setText(nomorHP.getText());
        formHP.setVisible(true);
        nomorHP.setVisible(false);
    }

    @FXML
    private void editAlamat(MouseEvent event) {
        formAlamat.setText(alamat.getText());
        formAlamat.setVisible(true);
        alamat.setVisible(false);
    }

    @FXML
    private void editUsaha(MouseEvent event) {
        formUsaha.setText(namaUsaha.getText());
        formUsaha.setVisible(true);
        namaUsaha.setVisible(false);
    }

    @FXML
    private void editEmail(MouseEvent event) {
        formEmail.setText(email.getText());
        formEmail.setVisible(true);
        email.setVisible(false);
    }

    

}
