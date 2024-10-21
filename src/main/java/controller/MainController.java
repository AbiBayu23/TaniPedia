package controller;

import dao.TanamanDAO;
import dao.PupukDAO;
import dao.PestisidaDAO;
import model.TanamanModel;
import model.PupukModel;
import model.PestisidaModel;
import model.UserModel;
import view.MainView;
import java.util.List;

public class MainController {
    private MainView view;
    private TanamanDAO tanamanDAO;
    private PupukDAO pupukDAO;
    private PestisidaDAO pestisidaDAO; 
    private UserModel currentUser;

    public MainController(UserModel user) {
        this.view = new MainView();
        this.tanamanDAO = new TanamanDAO();
        this.pupukDAO = new PupukDAO();
        this.pestisidaDAO = new PestisidaDAO(); 
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
                    case 13 -> {
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
                    case 3 -> viewPestisida(); // Tambahkan view pestisida
                    case 4 -> {
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
        view.showPestisidaList(pestisidaList); // Panggil view untuk menampilkan pestisida
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

    private void deleteTanaman() {
        int idTanaman = view.getTanamanId();
        boolean success = tanamanDAO.deleteTanaman(idTanaman);
        if (success) {
            System.out.println("Tanaman berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus tanaman.");
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

    private void deletePupuk() {
        int idPupuk = view.getPupukId();
        boolean success = pupukDAO.deletePupuk(idPupuk);
        if (success) {
            System.out.println("Pupuk berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus pupuk.");
        }
    }

    private void addPestisida() {
        PestisidaModel newPestisida = view.getPestisidaDetails(); // Ambil detail pestisida dari view
        boolean success = pestisidaDAO.addPestisida(newPestisida);
        if (success) {
            System.out.println("Pestisida berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan pestisida.");
        }
    }

    private void editPestisida() {
        int idPestisida = view.getPestisidaId(); // Ambil ID pestisida dari view
        PestisidaModel updatedPestisida = view.getPestisidaDetails(); // Ambil detail pestisida dari view
        updatedPestisida.setIdPestisida(idPestisida);
        boolean success = pestisidaDAO.updatePestisida(updatedPestisida);
        if (success) {
            System.out.println("Pestisida berhasil diubah.");
        } else {
            System.out.println("Gagal mengubah pestisida.");
        }
    }

    private void deletePestisida() {
        int idPestisida = view.getPestisidaId(); // Ambil ID pestisida dari view
        boolean success = pestisidaDAO.deletePestisida(idPestisida);
        if (success) {
            System.out.println("Pestisida berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus pestisida.");
        }
    }
}
