package view;

import model.TanamanModel;
import model.PupukModel;
import model.PestisidaModel;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private Scanner scanner = new Scanner(System.in);

    public void showTanamanList(List<TanamanModel> tanamanList) {
        System.out.println("Daftar Tanaman:");
        for (TanamanModel tanaman : tanamanList) {
            System.out.println("ID: " + tanaman.getIdTanaman() +
                    ", Nama: " + tanaman.getNamaTanaman() +
                    ", Jenis: " + tanaman.getJenisTanaman());
        }
    }

    public void showPupukList(List<PupukModel> pupukList) {
        System.out.println("Daftar Pupuk:");
        for (PupukModel pupuk : pupukList) {
            System.out.println("ID: " + pupuk.getIdPupuk() +
                    ", Nama: " + pupuk.getNamaPupuk() +
                    ", Harga: " + pupuk.getHargaPupuk());
        }
    }

    public void showPestisidaList(List<PestisidaModel> pestisidaList) {
        System.out.println("Daftar Pestisida:");
        for (PestisidaModel pestisida : pestisidaList) {
            System.out.println("ID: " + pestisida.getIdPestisida() +
                    ", Nama: " + pestisida.getNamaPestisida() +
                    ", Harga: " + pestisida.getHargaPestisida());
        }
    }

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
        System.out.println("13. Keluar");
        System.out.print("Pilih opsi: ");
        return scanner.nextInt();
    }

    public int showCustomerMenu() {
        System.out.println("=== Customer Menu ===");
        System.out.println("1. Lihat Tanaman");
        System.out.println("2. Lihat Pupuk");
        System.out.println("3. Lihat Pestisida");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
        return scanner.nextInt();
    }

    public TanamanModel getTanamanDetails() {
        TanamanModel tanaman = new TanamanModel();
        System.out.print("Nama Tanaman: ");
        tanaman.setNamaTanaman(scanner.next());
        System.out.print("Jenis Tanaman: ");
        tanaman.setJenisTanaman(scanner.next());
        return tanaman;
    }

    public PupukModel getPupukDetails() {
        PupukModel pupuk = new PupukModel();
        System.out.print("Nama Pupuk: ");
        pupuk.setNamaPupuk(scanner.next());
        System.out.print("Harga Pupuk: ");
        pupuk.setHargaPupuk(scanner.nextDouble());
        return pupuk;
    }

    public PestisidaModel getPestisidaDetails() {
        PestisidaModel pestisida = new PestisidaModel();
        System.out.print("Nama Pestisida: ");
        pestisida.setNamaPestisida(scanner.next());
        System.out.print("Harga Pestisida: ");
        pestisida.setHargaPestisida(scanner.nextDouble());
        return pestisida;
    }

    public int getTanamanId() {
        System.out.print("Masukkan ID Tanaman: ");
        return scanner.nextInt();
    }

    public int getPupukId() {
        System.out.print("Masukkan ID Pupuk: ");
        return scanner.nextInt();
    }

    public int getPestisidaId() {
        System.out.print("Masukkan ID Pestisida: ");
        return scanner.nextInt();
    }
}
