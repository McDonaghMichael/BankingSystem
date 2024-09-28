package banking.data.db;

import javax.xml.crypto.Data;
import java.io.File;
import java.sql.*;


public class Database {

    public final static String DATABASE_NAME = "banking.db";

    public Database() {
        createNewDatabase();
        createNewTable("CREATE TABLE IF NOT EXISTS accounts (\n"
                + " accountId INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " firstName TEXT NOT NULL,\n"
                + " lastName TEXT NOT NULL,\n"
                + " username TEXT NOT NULL UNIQUE,\n"
                + " password TEXT NOT NULL\n"
                + ");");

        createNewTable("CREATE TABLE IF NOT EXISTS users (\n"
                + " accountId INTEGER,\n"
                + " balance INT NOT NULL,\n"
                + " FOREIGN KEY (accountId) REFERENCES accounts(accountId) ON DELETE CASCADE\n"
                + ");");

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

    public static void createNewTable(String sqltxt) {
        String url = "jdbc:sqlite:" + DATABASE_NAME;

        String sql = sqltxt;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table has been created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertAccount(String firstName, String lastName, String username, String password) {
        String url = "jdbc:sqlite:" + DATABASE_NAME;
        String sql = "INSERT INTO accounts (firstName, lastName, username, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, username);
            pstmt.setString(4, password);

            pstmt.executeUpdate();
            System.out.println("Account inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
