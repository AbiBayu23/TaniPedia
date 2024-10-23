package controller;

import dao.TanamanDAO;
import dao.PupukDAO;
import dao.PestisidaDAO;
import dao.EnsiklopediaDAO;
import model.TanamanModel;
import model.PupukModel;
import model.PestisidaModel;
import model.EnsiklopediaModel;
import model.UserModel;
import view.MainView;
import java.util.List;

public class MainController {
    private MainView view;
    private TanamanDAO tanamanDAO;
    private PupukDAO pupukDAO;
    private PestisidaDAO pestisidaDAO;
    private EnsiklopediaDAO ensiklopediaDAO; // Tambahkan DAO untuk ensiklopedia
    private UserModel currentUser;

    public MainController(UserModel user) {
        this.view = new MainView();
        this.tanamanDAO = new TanamanDAO();
        this.pupukDAO = new PupukDAO();
        this.pestisidaDAO = new PestisidaDAO();
        this.ensiklopediaDAO = new EnsiklopediaDAO(); // Inisialisasi EnsiklopediaDAO
        this.currentUser = user;
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            if (currentUser.getRole().equalsIgnoreCase("admin")) {
                int choice = view.showAdminMenu();
                switch (choice) {
                    case 1 -> viewTanaman();
                    case 2 -> addTanaman();
                    case 3 -> editTanaman();
                    case 4 -> deleteTanaman();
                    case 5 -> viewPupuk();
                    case 6 -> addPupuk();
                    case 7 -> editPupuk();
                    case 8 -> deletePupuk();
                    case 9 -> viewPestisida();
                    case 10 -> addPestisida();
                    case 11 -> editPestisida();
                    case 12 -> deletePestisida();
                    case 13 -> viewEnsiklopedia(); // Lihat Ensiklopedia
                    case 14 -> addEnsiklopedia(); // Tambah Ensiklopedia
                    case 15 -> editEnsiklopedia(); // Edit Ensiklopedia
                    case 16 -> deleteEnsiklopedia(); // Hapus Ensiklopedia
                    case 17 -> viewKamus(); 
                    case 18 -> addKamus(); 
                    case 19 -> editKamus(); 
                    case 20 -> deleteKamus(); 
                    case 21 -> {
                        System.out.println("Keluar dari aplikasi...");
                        isRunning = false; // End the loop to exit
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } else if (currentUser.getRole().equalsIgnoreCase("customer")) {
                int choice = view.showCustomerMenu();
                switch (choice) {
                    case 1 -> viewTanaman();
                    case 2 -> viewPupuk();
                    case 3 -> viewPestisida();
                    case 4 -> viewEnsiklopedia(); // Customer dapat melihat ensiklopedia
                    case 5 -> {
                        System.out.println("Keluar dari aplikasi...");
                        isRunning = false; // End the loop to exit
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
        }
    }

    private void viewTanaman() {
        List<TanamanModel> tanamanList = tanamanDAO.getAllTanaman();
        view.showTanamanList(tanamanList);
    }

    private void viewPupuk() {
        List<PupukModel> pupukList = pupukDAO.getAllPupuk();
        view.showPupukList(pupukList);
    }

    private void viewPestisida() {
        List<PestisidaModel> pestisidaList = pestisidaDAO.getAllPestisida();
        view.showPestisidaList(pestisidaList);
    }
    private void viewKamus() {
        List<KamusModel> kamusList = kamusDAO.getAllKamus();
        view.showKamusList(kamusList); // Panggil view untuk menampilkan pestisida
    }

    private void viewEnsiklopedia() {
        List<EnsiklopediaModel> ensiklopediaList = ensiklopediaDAO.getAllEnsiklopedia();
        view.showEnsiklopediaList(ensiklopediaList); // Panggil view untuk menampilkan ensiklopedia
    }

    private void addTanaman() {
        TanamanModel newTanaman = view.getTanamanDetails();
        boolean success = tanamanDAO.addTanaman(newTanaman);
        if (success) {
            System.out.println("Tanaman berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan tanaman.");
        }
    }

    private void addPupuk() {
        PupukModel newPupuk = view.getPupukDetails();
        boolean success = pupukDAO.addPupuk(newPupuk);
        if (success) {
            System.out.println("Pupuk berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan pupuk.");
        }
    }

    private void addPestisida() {
        PestisidaModel newPestisida = view.getPestisidaDetails();
        boolean success = pestisidaDAO.addPestisida(newPestisida);
        if (success) {
            System.out.println("Pestisida berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan pestisida.");
        }
    }

    private void addEnsiklopedia() {
        EnsiklopediaModel newEnsiklopedia = view.getEnsiklopediaDetails();
        boolean success = ensiklopediaDAO.addEnsiklopedia(newEnsiklopedia);
        if (success) {
            System.out.println("Ensiklopedia berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan ensiklopedia.");
        }
    }

    private void editTanaman() {
        int idTanaman = view.getTanamanId();
        TanamanModel updatedTanaman = view.getTanamanDetails();
        updatedTanaman.setIdTanaman(idTanaman);
        boolean success = tanamanDAO.updateTanaman(updatedTanaman);
        if (success) {
            System.out.println("Tanaman berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah tanaman.");
        }
    }

    private void editPupuk() {
        int idPupuk = view.getPupukId();
        PupukModel updatedPupuk = view.getPupukDetails();
        updatedPupuk.setIdPupuk(idPupuk);
        boolean success = pupukDAO.updatePupuk(updatedPupuk);
        if (success) {
            System.out.println("Pupuk berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah pupuk.");
        }
    }

    private void editPestisida() {
        int idPestisida = view.getPestisidaId();
        PestisidaModel updatedPestisida = view.getPestisidaDetails();
        updatedPestisida.setIdPestisida(idPestisida);
        boolean success = pestisidaDAO.updatePestisida(updatedPestisida);
        if (success) {
            System.out.println("Pestisida berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah pestisida.");
        }
    }

    private void editEnsiklopedia() {
        int idEnsiklopedia = view.getEnsiklopediaId();
        EnsiklopediaModel updatedEnsiklopedia = view.getEnsiklopediaDetails();
        updatedEnsiklopedia.setIdEnsiklopedia(idEnsiklopedia);
        boolean success = ensiklopediaDAO.updateEnsiklopedia(updatedEnsiklopedia);
        if (success) {
            System.out.println("Ensiklopedia berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah ensiklopedia.");
        }
    }

    private void deleteTanaman() {
        int idTanaman = view.getTanamanId();
        boolean success = tanamanDAO.deleteTanaman(idTanaman);
        if (success) {
            System.out.println("Tanaman berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus tanaman.");
        }
    }

    private void deletePupuk() {
        int idPupuk = view.getPupukId();
        boolean success = pupukDAO.deletePupuk(idPupuk);
        if (success) {
            System.out.println("Pupuk berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus pupuk.");
        }
    }

    private void deletePestisida() {
        int idPestisida = view.getPestisidaId();
        boolean success = pestisidaDAO.deletePestisida(idPestisida);
        if (success) {
            System.out.println("Pestisida berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus pestisida.");
        }
    }

    private void deleteEnsiklopedia() {
        int idEnsiklopedia = view.getEnsiklopediaId();
        boolean success = ensiklopediaDAO.deleteEnsiklopedia(idEnsiklopedia);
        if (success) {
            System.out.println("Ensiklopedia berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus ensiklopedia.");
        }
    }
    private void addKamus() {
        KamusModel newKamus = view.getKamusDetails(); // Ambil detail pestisida dari view
        boolean success = kamusDAO.addKamus(newKamus);
        if (success) {
            System.out.println("Istilah berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan istilah.");
        }
    }

    private void editKamus() {
        int idKamus = view.getKamusId();
        KamusModel updatedKamus = view.getKamusDetails();
        updatedKamus.setIdKamus(idKamus);
        boolean success = kamusDAO.updateKamus(updatedKamus);
        if (success) {
            System.out.println("Istilah berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah istilah.");
        }
    }

    private void deleteKamus() {
        int idKamus = view.getKamusId(); 
        boolean success = kamusDAO.deleteKamus(idKamus);
        if (success) {
            System.out.println("Istilah berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus istilah.");
        }
    }
}
