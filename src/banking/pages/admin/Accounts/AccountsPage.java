package banking.pages.admin.Accounts;

import banking.data.db.Database;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

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


		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(0, 6));

		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] message = {
				"Username:", username,
				"Password:", password
		};

		JButton createAccountBtn = new JButton("Create Account");
		createAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					JFrame frame = new JFrame();
					frame.setTitle("Account Creation");
					frame.setSize(dimension.width / 4, dimension.height / 4);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setLayout(new FlowLayout());

					JPanel accountCreationPanel = new JPanel(new GridLayout(6,1));

					JLabel firstNameLabel = new JLabel("First Name");
					JLabel lastNameLabel = new JLabel("Last Name");
					JLabel usernameLabel = new JLabel("Username:");
					JLabel passwordLabel = new JLabel("Password:");
					JLabel confirmPasswordLabel = new JLabel("Confirm Password:");

					JTextField firstNameInput = new JTextField(10);
					JTextField lastnameInput = new JTextField(10);
					JTextField usernameInput = new JTextField(10);
					JTextField passwordInput = new JTextField(10);
					JTextField confirmPasswordInput = new JTextField(10);

					JButton createAccountBtn = new JButton("Create Account");

					accountCreationPanel.add(firstNameLabel);
					accountCreationPanel.add(firstNameInput);
					accountCreationPanel.add(lastNameLabel);
					accountCreationPanel.add(lastnameInput);
					accountCreationPanel.add(usernameLabel);
					accountCreationPanel.add(usernameInput);
					accountCreationPanel.add(passwordLabel);
					accountCreationPanel.add(passwordInput);
					accountCreationPanel.add(confirmPasswordLabel);
					accountCreationPanel.add(confirmPasswordInput);
					accountCreationPanel.add(createAccountBtn);

					createAccountBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!passwordInput.getText().equals(confirmPasswordInput.getText())) {


							}else{
								Database.insertAccount(firstNameInput.getText(), lastnameInput.getText(), usernameInput.getText(), passwordInput.getText());

							}
						}
					});
					frame.add(accountCreationPanel);
					frame.setVisible(true);


			}
		});

		btnPanel.add(createAccountBtn);
		frame.add(panel);
		frame.add(btnPanel);
		frame.setVisible(true);
	}

	private static void fetchAndDisplayAccounts(JPanel panel) {
		String url = "jdbc:sqlite:" + Database.DATABASE_NAME;
		String sql = "SELECT a.accountId, a.firstName, a.lastName, a.username, a.password, u.balance " +
				"FROM accounts a " +
				"LEFT JOIN users u ON a.accountId = u.accountId";

		try (Connection conn = DriverManager.getConnection(url);
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int accountId = rs.getInt("accountId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int balance = rs.getInt("balance");

				panel.add(new JLabel(String.valueOf(accountId)));
				panel.add(new JLabel(firstName));
				panel.add(new JLabel(lastName));
				panel.add(new JLabel(username));
				panel.add(new JLabel(password));
				panel.add(new JLabel(String.valueOf(balance)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public static void main(String[] args) {
		call();
	}
}
