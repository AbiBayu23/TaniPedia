package view;

import model.TanamanModel;
import model.PupukModel;
import model.PestisidaModel;
import model.EnsiklopediaModel;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private Scanner scanner = new Scanner(System.in);

    // Menampilkan daftar tanaman
    public void showTanamanList(List<TanamanModel> tanamanList) {
        System.out.println("Daftar Tanaman:");
        for (TanamanModel tanaman : tanamanList) {
            System.out.println("ID: " + tanaman.getIdTanaman() +
                    ", Nama: " + tanaman.getNamaTanaman() +
                    ", Jenis: " + tanaman.getJenisTanaman());
        }
    }

    // Menampilkan daftar pupuk
    public void showPupukList(List<PupukModel> pupukList) {
        System.out.println("Daftar Pupuk:");
        for (PupukModel pupuk : pupukList) {
            System.out.println("ID: " + pupuk.getIdPupuk() +
                    ", Nama: " + pupuk.getNamaPupuk() +
                    ", Harga: " + pupuk.getHargaPupuk());
        }
    }

    // Menampilkan daftar pestisida
    public void showPestisidaList(List<PestisidaModel> pestisidaList) {
        System.out.println("Daftar Pestisida:");
        for (PestisidaModel pestisida : pestisidaList) {
            System.out.println("ID: " + pestisida.getIdPestisida() +
                    ", Nama: " + pestisida.getNamaPestisida() +
                    ", Harga: " + pestisida.getHargaPestisida());
        }
    }

    // Menampilkan daftar ensiklopedia
    public void showEnsiklopediaList(List<EnsiklopediaModel> ensiklopediaList) {
        System.out.println("Daftar Ensiklopedia:");
        for (EnsiklopediaModel ensiklopedia : ensiklopediaList) {
            System.out.println("ID: " + ensiklopedia.getIdEnsiklopedia() +
                    ", Nama: " + ensiklopedia.getNamaEnsiklopedia() +
                    ", ID Tanaman: " + ensiklopedia.getIdTanaman() +
                    ", Jenis: " + ensiklopedia.getJenisEnsiklopedia() +
                    ", Konten: " + ensiklopedia.getKonten());
        }
    }

    // Menu admin
    public int showAdminMenu() {
        System.out.println("=== Admin Menu ===");
        System.out.println("1. Lihat Tanaman");
        System.out.println("2. Tambah Tanaman");
        System.out.println("3. Edit Tanaman");
        System.out.println("4. Hapus Tanaman");
        System.out.println("5. Lihat Pupuk");
        System.out.println("6. Tambah Pupuk");
        System.out.println("7. Edit Pupuk");
        System.out.println("8. Hapus Pupuk");
        System.out.println("9. Lihat Pestisida");
        System.out.println("10. Tambah Pestisida");
        System.out.println("11. Edit Pestisida");
        System.out.println("12. Hapus Pestisida");
        System.out.println("13. Lihat Ensiklopedia");
        System.out.println("14. Tambah Ensiklopedia");
        System.out.println("15. Edit Ensiklopedia");
        System.out.println("16. Hapus Ensiklopedia");
        System.out.println("17. Keluar");
        System.out.print("Pilih opsi: ");
        return scanner.nextInt();
    }

    // Menu customer
    public int showCustomerMenu() {
        System.out.println("=== Customer Menu ===");
        System.out.println("1. Lihat Tanaman");
        System.out.println("2. Lihat Pupuk");
        System.out.println("3. Lihat Pestisida");
        System.out.println("4. Lihat Ensiklopedia");
        System.out.println("5. Keluar");
        System.out.print("Pilih opsi: ");
        return scanner.nextInt();
    }

    // Input detail tanaman
    public TanamanModel getTanamanDetails() {
        TanamanModel tanaman = new TanamanModel();
        System.out.print("Nama Tanaman: ");
        tanaman.setNamaTanaman(scanner.next());
        System.out.print("Jenis Tanaman: ");
        tanaman.setJenisTanaman(scanner.next());
        return tanaman;
    }

    // Input detail pupuk
    public PupukModel getPupukDetails() {
        PupukModel pupuk = new PupukModel();
        System.out.print("Nama Pupuk: ");
        pupuk.setNamaPupuk(scanner.next());
        System.out.print("Harga Pupuk: ");
        pupuk.setHargaPupuk(scanner.nextDouble());
        return pupuk;
    }

    // Input detail pestisida
    public PestisidaModel getPestisidaDetails() {
        PestisidaModel pestisida = new PestisidaModel();
        System.out.print("Nama Pestisida: ");
        pestisida.setNamaPestisida(scanner.next());
        System.out.print("Harga Pestisida: ");
        pestisida.setHargaPestisida(scanner.nextDouble());
        return pestisida;
    }

    // Input detail ensiklopedia
    public EnsiklopediaModel getEnsiklopediaDetails() {
        EnsiklopediaModel ensiklopedia = new EnsiklopediaModel();
        System.out.print("Nama Ensiklopedia: ");
        ensiklopedia.setNamaEnsiklopedia(scanner.next());
        System.out.print("ID Tanaman: ");
        ensiklopedia.setIdTanaman(scanner.nextInt());
        System.out.print("Jenis Ensiklopedia: ");
        ensiklopedia.setJenisEnsiklopedia(scanner.next());
        System.out.print("Konten: ");
        ensiklopedia.setKonten(scanner.next());
        return ensiklopedia;
    }

    // Mendapatkan ID tanaman
    public int getTanamanId() {
        System.out.print("Masukkan ID Tanaman: ");
        return scanner.nextInt();
    }

    // Mendapatkan ID pupuk
    public int getPupukId() {
        System.out.print("Masukkan ID Pupuk: ");
        return scanner.nextInt();
    }

    // Mendapatkan ID pestisida
    public int getPestisidaId() {
        System.out.print("Masukkan ID Pestisida: ");
        return scanner.nextInt();
    }

    // Mendapatkan ID ensiklopedia
    public int getEnsiklopediaId() {
        System.out.print("Masukkan ID Ensiklopedia: ");
        return scanner.nextInt();
    }
}
