package view;

import java.util.Scanner;

public class UserView {
    private Scanner scanner = new Scanner(System.in);

    // Method for user registration
    public String[] registerUser() {
        System.out.println("=== Register User ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("No. Telp: ");
        String noTelp = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();

        return new String[] {nama, noTelp, password, role};
    }

    // Method for user login
    public String[] loginUser() {
        System.out.println("=== Login User ===");
        System.out.print("No. Telp: ");
        String noTelp = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        return new String[] {noTelp, password};
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}