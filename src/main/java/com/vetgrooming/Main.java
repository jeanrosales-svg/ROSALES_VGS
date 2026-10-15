package com.vetgrooming;

import com.vetgrooming.dao.DatabaseConnection;
import com.vetgrooming.ui.MainMenu;

/**
 * Application entry point.
 */
public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();
        new MainMenu().show();
    }
}
