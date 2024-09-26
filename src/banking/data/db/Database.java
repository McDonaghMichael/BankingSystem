package banking.data.db;

import javax.xml.crypto.Data;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

    final static String DATABASE_NAME = "banking.db";

    public Database() {
        createNewDatabase();
        createNewTable();
    }

    public static void createNewDatabase() {

        String url = "jdbc:sqlite:" + DATABASE_NAME;

        File databaseFile = new File(DATABASE_NAME);
        if (databaseFile.exists()) {
            System.out.println("Database already exists.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTable() {
        String url = "jdbc:sqlite:" + DATABASE_NAME;

        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL,\n"
                + " email TEXT NOT NULL UNIQUE\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
