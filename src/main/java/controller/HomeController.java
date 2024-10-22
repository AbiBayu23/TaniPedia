package controller;

import dao.UserDAO;
import model.UserModel;
import view.HomeView;

public class HomeController {
    private HomeView view;
    private UserDAO userDAO;

    public HomeController() {
        view = new HomeView();
        userDAO = new UserDAO();
    }

    public UserModel start() {
        while (true) {
            int choice = view.showMenu();
            switch (choice) {
                case 1 -> {
                    UserModel loggedInUser = login();
                    if (loggedInUser != null) {
                        return loggedInUser; 
                    }
                }
                case 2 -> register();
                case 3 -> {
                    System.out.println("Exiting...");
                    return null;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private UserModel login() {
        String email = view.getEmail();
        String password = view.getPassword();
        UserModel user = userDAO.loginUser(email, password);
        if (user != null) {
            view.showLoginSuccess();
            return user; 
        } else {
            view.showLoginFailure();
            return null; 
        }
    }

    private void register() {
        UserModel newUser = new UserModel();
        newUser.setNamaUser(view.getNama());
        newUser.setEmailUser(view.getEmail());
        newUser.setPasswordUser(view.getPassword());
        newUser.setNomorHp(view.getNomorHp());
        newUser.setRole(view.getRole());

        boolean success = userDAO.registerUser(newUser);
        if (success) {
            view.showRegistrationSuccess();
        } else {
            view.showRegistrationFailure();
        }
    }
}
