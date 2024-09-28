package banking.data.db;

import banking.data.types.User;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        String sqlAccount = "INSERT INTO accounts (firstName, lastName, username, password) VALUES (?, ?, ?, ?)";
        String sqlUser = "INSERT INTO users (accountId, balance) VALUES (?, 0)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmtAccount = conn.prepareStatement(sqlAccount, Statement.RETURN_GENERATED_KEYS)) {

            pstmtAccount.setString(1, firstName);
            pstmtAccount.setString(2, lastName);
            pstmtAccount.setString(3, username);
            pstmtAccount.setString(4, password);
            pstmtAccount.executeUpdate();

            try (ResultSet generatedKeys = pstmtAccount.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long accountId = generatedKeys.getLong(1);
                    try (PreparedStatement pstmtUser = conn.prepareStatement(sqlUser)) {
                        pstmtUser.setLong(1, accountId);
                        pstmtUser.executeUpdate();
                    }
                } else {
                    throw new SQLException("Creating account failed, no ID obtained.");
                }
            }

            System.out.println("Account and user inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static User getUserById(int id){
        String url = "jdbc:sqlite:" + Database.DATABASE_NAME;
        String sql = "SELECT a.accountId, a.firstName, a.lastName, a.username, a.password, u.balance " +
                "FROM accounts a " +
                "LEFT JOIN users u ON a.accountId = u.accountId";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int accountId = rs.getInt("accountId");
                if(accountId == id){
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    int balance = rs.getInt("balance");

                    return new User(accountId,firstName,lastName,username,password,"d","d", balance);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
