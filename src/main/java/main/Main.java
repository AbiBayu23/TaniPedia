package main;

import controller.UserController;
import dao.UserDAO;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        UserView view = new UserView();
        UserDAO dao = new UserDAO();
        UserController controller = new UserController(view, dao);

        boolean running = true;

        while (running) {
            System.out.println("=== Menu ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Pilih: ");
            
            int choice = new java.util.Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    // Register user
                    controller.register();
                    break;

                case 2:
                    // Login user
                    controller.login();
                    break;

                case 3:
                    // Exit
                    running = false;
                    break;

                default:
                    view.showMessage("Pilihan tidak valid!");
                    break;
            }
        }
    }
}
