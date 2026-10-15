package com.vetgrooming.ui;

import com.vetgrooming.dao.UserDao;
import com.vetgrooming.model.User;

import java.util.Optional;
import java.util.Scanner;

/**
 * The first screen: Register, Login, or Exit.
 */
public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final UserDao userDao = new UserDao();

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("=============================================");
            System.out.println(" VETERINARY AND GROOMING APPOINTMENT SYSTEM");
            System.out.println("=============================================");
            System.out.println("[1] Register Account");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> register();
                case "2" -> login();
                case "3" -> {
                    System.out.println("Thank you! Goodbye.");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }
    }

    private void register() {
        System.out.println("\n--- REGISTER ACCOUNT ---");

        String username = prompt("Username: ");
        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }
        if (userDao.usernameExists(username)) {
            System.out.println("That username is already taken.");
            return;
        }

        String password = prompt("Password: ");
        if (password.length() < 4) {
            System.out.println("Password must be at least 4 characters.");
            return;
        }

        System.out.println("Select role:");
        System.out.println("[1] TEACHER");
        System.out.println("[2] STUDENT");
        String role;
        switch (prompt("Choose role: ")) {
            case "1" -> role = "TEACHER";
            case "2" -> role = "STUDENT";
            default -> {
                System.out.println("Invalid role. Registration cancelled.");
                return;
            }
        }

        if (userDao.register(username, password, role)) {
            System.out.println("Account created! Status: PENDING (waiting for approval).");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    private void login() {
        System.out.println("\n--- LOGIN ---");
        String username = prompt("Username: ");
        String password = prompt("Password: ");

        Optional<User> result = userDao.login(username, password);
        if (result.isPresent()) {
            new UserMenu(result.get(), scanner).show();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
