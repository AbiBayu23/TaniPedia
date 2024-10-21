package main;

import controller.HomeController;
import controller.MainController;
import model.UserModel;

public class Main {
    public static void main(String[] args) {
        while (true) {
            HomeController homeController = new HomeController();
            UserModel loggedInUser = homeController.start();
            
            // If the user logs in successfully, proceed to the main application
            if (loggedInUser != null) {
                MainController mainController = new MainController(loggedInUser);
                mainController.start();  // When the user logs out, it will return here
            } else {
                // If the user chose to exit the application from HomeController
                System.out.println("Thank you for using TaniPedia. Goodbye!");
                break;
            }
        }
    }
}
