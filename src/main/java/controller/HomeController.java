package controller;
import dao.EnsiklopediaDAO;
import dao.TanamanDAO;
import dao.UserDAO;
import dao.KamusDAO;
import dao.ShopDAO;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;
import java.net.URL;
import model.UserModel;
import model.KamusModel;
import model.TanamanModel;
import model.ShopModel;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class HomeController implements Initializable {
    private UserModel userModel;
    private UserDAO userDAO;
    private EnsiklopediaDAO ensiklopediaDAO;
    private TanamanDAO tanamanDAO;
    private TanamanModel tanaman;
    private KamusDAO kamusDAO;
    private KamusModel kamus;
    private ShopModel shopModel;
    private ShopDAO shopDAO;
    private Pane previousPane;
    private byte[] fotoEnsiklopediaData;
    private byte[] fotoItem;

    @FXML
    private Button btnOverview, btnPackages, btnOrders, btnMenus, btnSignout, editProfil, backHome, newPlant, tambahTumbuhan, sourceFoto, cancelEnsi, tambahKamus, batalTambahKamus, addEnsiklopedia, Batal;
    @FXML
    private Pane Belanja, Ensiklopedia, Home, Kamus, formEnsiklopedia, profilPengguna, Tumbuhan, formKamus;
    @FXML
    private AnchorPane profilPane;
    @FXML
    private VBox pane;
    @FXML
    private ImageView profil, fotoProfil, ButtonKamus, ButtonEnsiklopedia;
    @FXML
    private Label username, hello, namaPengguna, nomorHP, email, alamat, namaUsaha, isiJenisTanaman;
    @FXML
    private TextField formEmail, formHP, formPengguna, formUsaha, formNamaTanaman, isiFotoEnsiklopedia, formNamaIstilah;
    @FXML
    private TextArea formAlamat, formPanduanBudidaya, formPenangananPenyakit, fieldPenjelasan;
    @FXML
    private ComboBox<String> formJenisTanaman;
    @FXML
    private ComboBox<TanamanModel> listTanaman;
    @FXML
    private TableView<KamusModel> ListKamus;
    @FXML
    private TableColumn<KamusModel, String> namaIstilah, isiPenjelasan;
    @FXML
    private TableColumn<KamusModel, Void> aksi;
    private TableView<ShopModel> ListBarang;
    @FXML
    private TableColumn<ShopModel, String> itemName, priceTag;
    @FXML
    private ImageView ButtonEnsiklopedia1;
    @FXML
    private TableColumn<ShopModel, byte[]> shopImg;
    @FXML
    private TableColumn<ShopModel, Integer> stok;
    @FXML
    private TableColumn<ShopModel, Void> aksiBelanja;
    @FXML
    private ImageView ButtonAddShop;
    @FXML
    private Button ButtonCancelItem;
    @FXML
    private Button tambahItem;
    @FXML
    private TextField formNamaItem;
    @FXML
    private TextField formHarga;
    @FXML
    private TextField formStok;
    @FXML
    private TextField formImageItem;
    @FXML
    private TableView<ShopModel> listBarang;
    @FXML
    private Button SourceItem;
    @FXML
    private Pane formItem;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        shopDAO = new ShopDAO();
        loadShopData();
        showPane(Home);
        List<TanamanModel> tanamanList = tanamanDAO.getAllTanaman();
        loadTanamanToComboBox(tanamanList);
        listTanaman.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<String> jenisTanamanList = FXCollections.observableArrayList(
            "Tanaman Buah",
            "Tanaman Sayur",
            "Tanaman Hias",
            "Tanaman Pangan",
            "Tanaman Umbi"
            );
            namaIstilah.setCellValueFactory(cellData -> {
                System.out.println("Nama Istilah: " + cellData.getValue().getNamaIstilah());
                return new SimpleStringProperty(cellData.getValue().getNamaIstilah());
            });

            isiPenjelasan.setCellValueFactory(cellData -> {
                System.out.println("Penjelasan: " + cellData.getValue().getPenjelasan());
                return new SimpleStringProperty(cellData.getValue().getPenjelasan());
            });
            loadKamusData();

            formJenisTanaman.setItems(jenisTanamanList);
                if (newValue instanceof TanamanModel) {
                    TanamanModel tanaman = (TanamanModel) newValue;
                    isiJenisTanaman.setText(tanaman.getJenisTanaman());
                } else {
                    isiJenisTanaman.setText("Jenis tanaman tidak ditemukan");
                }
        });
        aksiBelanja.setCellFactory(param -> new TableCell<>() {
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    Button btnEdit = new Button("Edit");
                    Button btnDelete = new Button("Delete");

                    btnEdit.setOnAction(event -> {
                        ShopModel shop = getTableView().getItems().get(getIndex());
                        editShop(shop);
                    });

                    btnDelete.setOnAction(event -> {
                        ShopModel shop = getTableView().getItems().get(getIndex());
                        deleteShop(shop);
                    });

                    HBox actionButtons = new HBox(10, btnEdit, btnDelete);
                    setGraphic(actionButtons);
                    btnEdit.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 5 10;");
                    btnDelete.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 5 10;");
                    }
                }

            private void deleteShop(ShopModel shop) {
                    
                }

            private void editShop(ShopModel shop) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            
            });
        aksi.setCellFactory(param -> new TableCell<>() {
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    Button btnEdit = new Button("Edit");
                    Button btnDelete = new Button("Delete");

                    btnEdit.setOnAction(event -> {
                        KamusModel kamus = getTableView().getItems().get(getIndex());
                        editKamus(kamus);
                    });

                    btnDelete.setOnAction(event -> {
                        KamusModel kamus = getTableView().getItems().get(getIndex());
                        deleteKamus(kamus);
                    });

                    HBox actionButtons = new HBox(10, btnEdit, btnDelete);
                    setGraphic(actionButtons);
                    btnEdit.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 5 10;");
                    btnDelete.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 5 10;");
                    }
                }
            });
    }
    
    public HomeController() {
        this.userDAO = new UserDAO();
        this.tanamanDAO = new TanamanDAO();
        this.ensiklopediaDAO = new EnsiklopediaDAO();
        this.kamusDAO = new KamusDAO(); 
        this.shopDAO = new ShopDAO(); 
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
    private void showProfil(MouseEvent event) {
        showPane(profilPengguna);
    }
    @FXML
    private void showPengisian(MouseEvent event) {
        showPane(formEnsiklopedia);
    }
    @FXML
    private void showTumbuhan(MouseEvent event) {
        if (!formEnsiklopedia.isVisible()) {
        showPane(formEnsiklopedia);
    }
    Tumbuhan.setVisible(true);
    }
    @FXML
    private void showUpload(MouseEvent event) {
        if (!Belanja.isVisible()) {
        showPane(Belanja);
    }
    formItem.setVisible(true);
    }
    @FXML
    private void showFormKamus(MouseEvent event) {
        if (!Kamus.isVisible()) {
        showPane(Kamus);
    }
    formKamus.setVisible(true);
    }
    
    private void showPane(Pane paneToShow) {
        if (paneToShow != null && paneToShow.isVisible()) {
        return;
        }

        previousPane = getVisiblePane();
        Home.setVisible(false);
        Kamus.setVisible(false);
        Belanja.setVisible(false);
        Tumbuhan.setVisible(false);
        formItem.setVisible(false);
        formKamus.setVisible(false);
        Ensiklopedia.setVisible(false);
        profilPengguna.setVisible(false);
        formEnsiklopedia.setVisible(false);

        if (paneToShow == Tumbuhan) {
        Tumbuhan.setVisible(false); // Hide subpanel
        formEnsiklopedia.setVisible(true); // Parent panel should be visible
        }
        if (paneToShow == formKamus) {
        formKamus.setVisible(false); // Hide subpanel
        Kamus.setVisible(true); // Parent panel should be visible
        }
        if (paneToShow == formItem) {
        formItem.setVisible(false); // Hide subpanel
        Belanja.setVisible(true); // Parent panel should be visible
        }
        
        paneToShow.setVisible(true);
    }

    private Pane getVisiblePane() {
        if (Home.isVisible()) return Home;
        if (Kamus.isVisible()) return Kamus;
        if (Belanja.isVisible()) return Belanja;
        if (Ensiklopedia.isVisible()) return Ensiklopedia;
        if (profilPengguna.isVisible()) return profilPengguna;
        if (formEnsiklopedia.isVisible()) return formEnsiklopedia;
        return null;
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

    void setUserModel(UserModel user) {
        if (user == null) {
        throw new IllegalArgumentException("UserModel cannot be null");
        }
        
        this.userModel = user;
        nomorHP.setText(user.getNomorHp());
        username.setText(user.getUsername());
        namaPengguna.setText(user.getUsername());
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
            userModel.setNomorHp(formHP.getText());
            userModel.setEmail(formEmail.getText());
            userModel.setAlamat(formAlamat.getText());
            userModel.setNamaUsaha(formUsaha.getText());
            userModel.setUsername(formPengguna.getText());

            String NamaUsaha = userModel.getNamaUsaha();
            String Username = userModel.getUsername();
            String NomorHP = userModel.getNomorHp();
            String Alamat = userModel.getAlamat();
            String Email = userModel.getEmail();
            int userId = userModel.getIdUser();

            nomorHP.setText(formHP.getText());
            formHP.setVisible(false);
            nomorHP.setVisible(true);

            email.setText(formEmail.getText());
            formEmail.setVisible(false);
            email.setVisible(true);

            alamat.setText(formAlamat.getText());
            formAlamat.setVisible(false);
            alamat.setVisible(true);

            namaUsaha.setText(formUsaha.getText());
            formUsaha.setVisible(false);
            namaUsaha.setVisible(true);

            namaPengguna.setText(formPengguna.getText());
            formPengguna.setVisible(false);
            namaPengguna.setVisible(true);

            UserDAO.updateUser(userId, NamaUsaha, Username, NomorHP, Alamat, Email);

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
    @FXML
    private void editHP(MouseEvent event) {
        formHP.setText(nomorHP.getText());
        formHP.setVisible(true);
        nomorHP.setVisible(false);
    }
    @FXML
    private void klikBatal(MouseEvent event) {
        Tumbuhan.setVisible(false);
        formEnsiklopedia.setVisible(true);
    }
    
    

    @FXML
    private void tambahTumbuhan(MouseEvent event) {
        try {
            // Ambil data dari form
            String namaTanaman = formNamaTanaman.getText();
            String jenisTanaman = formJenisTanaman.getValue(); // Ambil nilai dari ComboBox

            // Validasi input
            if (namaTanaman.isEmpty() || jenisTanaman == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validasi Input");
                alert.setHeaderText(null);
                alert.setContentText("Semua field harus diisi!");
                alert.showAndWait();
                return;
            }
            TanamanModel tanaman = new TanamanModel();
            tanaman.setNamaTanaman(namaTanaman);
            tanaman.setJenisTanaman(jenisTanaman);

            // Simpan data ke database
            tanamanDAO.addTanaman(tanaman);

            // Tampilkan pesan sukses
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tambah Tumbuhan");
            alert.setHeaderText(null);
            alert.setContentText("Data tumbuhan berhasil disimpan!");
            alert.showAndWait();

            // Reset form
            formNamaTanaman.clear();
            formJenisTanaman.getSelectionModel().clearSelection();

            // Muat ulang data ke ComboBox
            List<TanamanModel> tanamanList = tanamanDAO.getAllTanaman();
            loadTanamanToComboBox(tanamanList);

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tambah Tumbuhan");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat menyimpan data!");
            alert.showAndWait();
        }
    }

    void loadTanamanToComboBox(List<TanamanModel> tanamanList) {
        try {
            listTanaman.getItems().clear();
            listTanaman.getItems().addAll(tanamanList);
        } catch (Exception e) {
        }
    }

    void loadShopData() {
    try {
        List<ShopModel> shopList = shopDAO.getAllItems();
        ObservableList<ShopModel> items = FXCollections.observableArrayList(shopList);
        shopImg.setCellFactory(param -> new TableCell<>() {
            @Override
            protected void updateItem(byte[] item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(item)));
                    imageView.setFitWidth(50);  // Sesuaikan ukuran gambar
                    imageView.setFitHeight(50);
                    setGraphic(imageView);
                }
            }
        });
        itemName.setCellValueFactory(new PropertyValueFactory<>("namaItem"));
        priceTag.setCellValueFactory(new PropertyValueFactory<>("hargaItem"));
        stok.setCellValueFactory(new PropertyValueFactory<>("stokItem"));
        listBarang.setItems(items);
    } catch (Exception e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Gagal memuat data shop!");
        alert.showAndWait();
        }
    }
    
    void loadKamusData() {
    try {
        List<KamusModel> kamusList = kamusDAO.getAllKamus(); // Ganti dengan DAO yang sesuai
        ObservableList<KamusModel> data = FXCollections.observableArrayList(kamusList);
        namaIstilah.setCellValueFactory(new PropertyValueFactory<>("namaIstilah"));
        isiPenjelasan.setCellValueFactory(new PropertyValueFactory<>("penjelasan"));
        aksi.setCellFactory(param -> new TableCell<>() {
        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else {
                // Buat tombol Edit dan Delete untuk setiap baris
                Button btnEdit = new Button("Edit");
                Button btnDelete = new Button("Delete");

                // Aksi tombol Edit
                btnEdit.setOnAction(event -> {
                    KamusModel kamus = getTableView().getItems().get(getIndex());
                    editKamus(kamus);
                });

                // Aksi tombol Delete
                btnDelete.setOnAction(event -> {
                    KamusModel kamus = getTableView().getItems().get(getIndex());
                    deleteKamus(kamus);
                });

                // Tambahkan tombol ke dalam HBox
                HBox actionButtons = new HBox(10, btnEdit, btnDelete);
                setGraphic(actionButtons);
                btnEdit.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 5 10;");
                btnDelete.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 5 10;");
                }
            }
        });
        ListKamus.setItems(data);
    } catch (Exception e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Gagal memuat data kamus!");
        alert.showAndWait();
        }
    }

    
    @FXML
    private void pilihFotoEnsiklopedia(MouseEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Foto Ensiklopedia");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );

            File selectedFile = fileChooser.showOpenDialog(sourceFoto.getScene().getWindow());
            if (selectedFile != null) {
                // Baca file gambar sebagai byte array
                fotoEnsiklopediaData = readFileToByteArray(selectedFile);
                // Menambahkan nama file ke dalam text field
                isiFotoEnsiklopedia.setText(selectedFile.getName()); // Isi dengan nama file
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Foto Ensiklopedia");
                alert.setHeaderText(null);
                alert.setContentText("Foto berhasil dipilih!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Foto Ensiklopedia");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat memilih foto!");
            alert.showAndWait();
        }
    }

    @FXML
    private void tambahEnsiklopedia(MouseEvent event) {
        try {
            // Ambil data dari form
            String namaTanaman = listTanaman.getValue().getNamaTanaman();
            String jenisTanaman = listTanaman.getValue().getJenisTanaman();
            String panduanBudidaya = formPanduanBudidaya.getText();
            String penangananPenyakit = formPenangananPenyakit.getText();

            // Validasi input
            if (namaTanaman.isEmpty() || jenisTanaman.isEmpty() || panduanBudidaya.isEmpty() || penangananPenyakit.isEmpty() || fotoEnsiklopediaData == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validasi Input");
                alert.setHeaderText(null);
                alert.setContentText("Semua field dan foto harus diisi!");
                alert.showAndWait();
                return;
            }

            // Simpan data ke database
            ensiklopediaDAO.tambahEnsiklopedia(
                namaTanaman,
                jenisTanaman,
                panduanBudidaya,
                penangananPenyakit,
                fotoEnsiklopediaData
            );

            // Tampilkan pesan sukses
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tambah Ensiklopedia");
            alert.setHeaderText(null);
            alert.setContentText("Data ensiklopedia berhasil disimpan!");
            alert.showAndWait();

            // Reset form
            formPanduanBudidaya.clear();
            formPenangananPenyakit.clear();
            isiFotoEnsiklopedia.clear();
            fotoEnsiklopediaData = null;

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tambah Ensiklopedia");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat menyimpan data!");
            alert.showAndWait();
        }
    }

    @FXML
    private void kembaliEnsi(MouseEvent event) {
        showPane(Ensiklopedia);
    }
    @FXML
    private void addKamus(MouseEvent event) {
        try {
            // Ambil data dari form
            String namaIstilah = formNamaIstilah.getText();
            String penjelasan = fieldPenjelasan.getText();

            // Validasi input
            if (namaIstilah.isEmpty() || penjelasan.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validasi Input");
                alert.setHeaderText(null);
                alert.setContentText("Semua field harus diisi!");
                alert.showAndWait();
                return;
            }

            // Simpan data ke database
            kamus = new KamusModel(namaIstilah, penjelasan);
            kamus.setNamaIstilah(namaIstilah);
            kamus.setPenjelasan(penjelasan);

            kamusDAO.addKamus(kamus);

            // Tampilkan pesan sukses
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tambah Kamus");
            alert.setHeaderText(null);
            alert.setContentText("Data istilah berhasil disimpan!");
            alert.showAndWait();

            // Reset form
            formNamaIstilah.clear();
            fieldPenjelasan.clear();

            // Muat ulang data ke TableView
            loadKamusData();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tambah Kamus");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat menyimpan data istilah!");
            alert.showAndWait();
        }
    }
    
private void editKamus(KamusModel kamus) {
    try {
        // Tampilkan form untuk mengedit Kamus
        formKamus.setVisible(true); // Tampilkan form edit Kamus
        showPane(Kamus);  // Menampilkan tampilan utama Kamus di belakang form

        // Isi form dengan data Kamus yang dipilih
        formNamaIstilah.setText(kamus.getNamaIstilah());
        fieldPenjelasan.setText(kamus.getPenjelasan());

        // Mengubah fungsi tombol 'Tambah' menjadi 'Simpan Perubahan'
        Button btnSimpanPerubahan = new Button("Simpan Perubahan");

        // Tambahkan event handler untuk tombol "Simpan Perubahan"
        btnSimpanPerubahan.setOnAction(event -> {
            try {
                String namaIstilah = formNamaIstilah.getText();
                String penjelasan = fieldPenjelasan.getText();

                // Validasi input
                if (namaIstilah.isEmpty() || penjelasan.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Validasi Input");
                    alert.setHeaderText(null);
                    alert.setContentText("Semua field harus diisi!");
                    alert.showAndWait();
                    return;
                }

                // Update data kamus
                kamus.setNamaIstilah(namaIstilah);
                kamus.setPenjelasan(penjelasan);
                kamusDAO.updateKamus(kamus); // Memperbarui data di database

                // Tampilkan pesan sukses
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Edit Kamus");
                alert.setHeaderText(null);
                alert.setContentText("Data istilah berhasil diperbarui!");
                alert.showAndWait();

                // Reset form dan sembunyikan form edit
                formNamaIstilah.clear();
                fieldPenjelasan.clear();
                formKamus.setVisible(false);

                // Muat ulang data ke TableView
                loadKamusData();

            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Edit Kamus");
                alert.setHeaderText(null);
                alert.setContentText("Terjadi kesalahan saat memperbarui data!");
                alert.showAndWait();
            }
        });

    } catch (Exception e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Edit Kamus");
        alert.setHeaderText(null);
        alert.setContentText("Terjadi kesalahan saat memuat data!");
        alert.showAndWait();
    }
}

@FXML
private void batalTambahKamus(MouseEvent event) {
    // Reset form Kamus
    formNamaIstilah.clear();
    fieldPenjelasan.clear();

    // Sembunyikan form tambah atau edit Kamus
    formKamus.setVisible(false);

    // Kembali ke tampilan utama Kamus
    showPane(Kamus);
}

        private void deleteKamus(KamusModel kamus) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Hapus Kamus");
                alert.setHeaderText(null);
                alert.setContentText("Apakah Anda yakin ingin menghapus data ini?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    kamusDAO.deleteKamus(kamus); // Metode untuk menghapus data dari database
                    loadKamusData();
                    Alert info = new Alert(Alert.AlertType.INFORMATION);
                    info.setTitle("Hapus Kamus");
                    info.setHeaderText(null);
                    info.setContentText("Data istilah berhasil dihapus!");
                    info.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hapus Kamus");
                alert.setHeaderText(null);
                alert.setContentText("Terjadi kesalahan saat menghapus data!");
                alert.showAndWait();
            }
        }
        @FXML
    private void addItem(MouseEvent event) {
        try {
            // Ambil data dari form
            String namaItem = formNamaItem.getText();
            Integer hargaItem = Integer.parseInt(formHarga.getText());
            Integer stokItem = Integer.parseInt(formStok.getText());

            // Validasi input
            if (namaItem.isEmpty() || formHarga.getText().isEmpty() || formStok.getText().isEmpty() || fotoItem == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Validasi Input");
                alert.setHeaderText(null);
                alert.setContentText("Semua field harus diisi!");
                alert.showAndWait();
                return;
            }

            // Simpan data ke database
            shopModel = new ShopModel(namaItem, hargaItem, stokItem, fotoItem);
            shopDAO.insertItem(shopModel);

            // Tampilkan pesan sukses
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tambah Kamus");
            alert.setHeaderText(null);
            alert.setContentText("Data istilah berhasil disimpan!");
            alert.showAndWait();

            // Reset form
            formNamaItem.clear();
            formHarga.clear();
            formStok.clear();

            // Muat ulang data ke TableView
            loadItemData();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Tambah Kamus");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat menyimpan data istilah!");
            alert.showAndWait();
        }
    }
    
private void loadItemData() {
    try {
        // Ambil semua data dari database melalui DAO
        List<ShopModel> itemList = shopDAO.getAllItems(); // Pastikan DAO memiliki metode getAllItems()
        ObservableList<ShopModel> data = FXCollections.observableArrayList(itemList);
        
        // Set kolom dengan properti yang sesuai dari model
        itemName.setCellValueFactory(new PropertyValueFactory<>("namaItem")); // Properti di ShopModel
        priceTag.setCellValueFactory(new PropertyValueFactory<>("hargaItem")); // Properti di ShopModel
        stok.setCellValueFactory(new PropertyValueFactory<>("stokItem")); // Properti di ShopModel

        // Kolom untuk aksi (Edit & Delete)
        aksiBelanja.setCellFactory(param -> new TableCell<>() {
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    // Tombol Edit
                    Button btnEdit = new Button("Edit");
                    btnEdit.setOnAction(event -> {
                        ShopModel shop = getTableView().getItems().get(getIndex());
                    });

                    // Tombol Delete
                    Button btnDelete = new Button("Delete");
                    btnDelete.setOnAction(event -> {
                        ShopModel shop = getTableView().getItems().get(getIndex());
                        deleteItem(shop);
                    });

                    // Tambahkan tombol ke dalam HBox
                    HBox actionButtons = new HBox(10, btnEdit, btnDelete);
                    setGraphic(actionButtons);

                    // Tambahkan styling ke tombol
                    btnEdit.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 5 10;");
                    btnDelete.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-padding: 5 10;");
                }
            }
        });

        // Set data ke TableView
        ListBarang.setItems(data);

    } catch (Exception e) {
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Gagal memuat data item!");
        alert.showAndWait();
    }
}
     private void deleteItem(ShopModel shopModel) {
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Hapus Kamus");
                alert.setHeaderText(null);
                alert.setContentText("Apakah Anda yakin ingin menghapus data ini?");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    shopDAO.deleteItem(shopModel); // Metode untuk menghapus data dari database
                    loadKamusData();
                    Alert info = new Alert(Alert.AlertType.INFORMATION);
                    info.setTitle("Hapus Kamus");
                    info.setHeaderText(null);
                    info.setContentText("Data istilah berhasil dihapus!");
                    info.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hapus Kamus");
                alert.setHeaderText(null);
                alert.setContentText("Terjadi kesalahan saat menghapus data!");
                alert.showAndWait();
            }
        }

    @FXML
    private void pilihFotoItem(MouseEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Foto Item");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );

            File selectedFile = fileChooser.showOpenDialog(SourceItem.getScene().getWindow());
            if (selectedFile != null) {
                // Baca file gambar sebagai byte array
                fotoItem = readFileToByteArray(selectedFile);
                // Menambahkan nama file ke dalam text field
                formImageItem.setText(selectedFile.getName()); // Isi dengan nama file
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Foto Ensiklopedia");
                alert.setHeaderText(null);
                alert.setContentText("Foto berhasil dipilih!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Foto Ensiklopedia");
            alert.setHeaderText(null);
            alert.setContentText("Terjadi kesalahan saat memilih foto!");
            alert.showAndWait();
        }
    }


    @FXML
    private void batalTambahItem(MouseEvent event) {

    // Sembunyikan form tambah atau edit Kamus
    formItem.setVisible(false);

    // Kembali ke tampilan utama Kamus
    showPane(Belanja);
    }
    }
