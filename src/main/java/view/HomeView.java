package view;

import java.util.Scanner;

public class HomeView {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("Welcome to Tanipedia");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String getEmail() {
        System.out.print("Enter email: ");
        return scanner.next();
    }

    public String getPassword() {
        System.out.print("Enter password: ");
        return scanner.next();
    }

    public String getNama() {
        System.out.print("Enter your name: ");
        return scanner.next();
    }

    public String getNomorHp() {
        System.out.print("Enter your phone number: ");
        return scanner.next();
    }

    public String getAlamat() {
        System.out.print("Enter your address: ");
        return scanner.next();
    }

    public String getRole() {
        System.out.print("Enter role (admin/customer): ");
        return scanner.next();
    }

    public void showLoginSuccess() {
        System.out.println("Login successful!");
    }

    public void showLoginFailure() {
        System.out.println("Invalid email or password. Please try again.");
    }

    public void showRegistrationSuccess() {
        System.out.println("Registration successful!");
    }

    public void showRegistrationFailure() {
        System.out.println("Registration failed. Please try again.");
    }
}
