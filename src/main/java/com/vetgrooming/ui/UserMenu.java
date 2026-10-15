package com.vetgrooming.ui;

import com.vetgrooming.model.User;

import java.util.Scanner;

/**
 * Screen shown after a successful login. Logging out ends the session
 * and returns to the main menu.
 */
public class UserMenu {

    private final User user;
    private final Scanner scanner;

    public UserMenu(User user, Scanner scanner) {
        this.user = user;
        this.scanner = scanner;
    }

    public void show() {
        System.out.println("\nWelcome, " + user.username() + "!");
        System.out.println("Role: " + user.roles() + " | Status: " + user.status());
        if ("PENDING".equals(user.status())) {
            System.out.println("Note: your account is still pending approval.");
        }

        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- USER MENU ---");
            System.out.println("[1] View my profile");
            System.out.println("[2] Logout");
            System.out.print("Choose an option: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> {
                    System.out.println("ID: " + user.id());
                    System.out.println("Username: " + user.username());
                    System.out.println("Role: " + user.roles());
                    System.out.println("Status: " + user.status());
                }
                case "2" -> {
                    System.out.println("You have been logged out.");
                    loggedIn = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
