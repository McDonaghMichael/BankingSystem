package banking.pages.admin.Accounts;

import banking.data.db.Database;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountsPage {
	private static final String DATABASE_NAME = "banking.db";

	public static void call() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		JFrame frame = new JFrame();
		frame.setTitle("Accounts");
		frame.setSize(dimension.width, dimension.height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		frame.setLayout(new FlowLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 6));

		panel.add(new JLabel("Account ID"));
		panel.add(new JLabel("First Name"));
		panel.add(new JLabel("Last Name"));
		panel.add(new JLabel("Username"));
		panel.add(new JLabel("Password"));
		panel.add(new JLabel("Balance"));

		fetchAndDisplayAccounts(panel);

		frame.add(panel);
		frame.setVisible(true);
	}

	private static void fetchAndDisplayAccounts(JPanel panel) {
		String url = "jdbc:sqlite:" + Database.DATABASE_NAME;
		String sql = "SELECT accountId, firstName, lastName, username, password FROM accounts";

		try (Connection conn = DriverManager.getConnection(url);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			// Loop through the result set and create labels for each account
			while (rs.next()) {
				int accountId = rs.getInt("accountId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String username = rs.getString("username");
				String password = rs.getString("password");

				panel.add(new JLabel(String.valueOf(accountId)));
				panel.add(new JLabel(firstName));
				panel.add(new JLabel(lastName));
				panel.add(new JLabel(username));
				panel.add(new JLabel(password));
				panel.add(new JLabel("1000"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		call();
	}
}
