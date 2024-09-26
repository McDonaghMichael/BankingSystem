package banking.pages.authentication;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banking.pages.Main.MenuPage;

public class AuthenticationPage {
	
	public AuthenticationPage() {
		
	}
	
	public static void call() {
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame();
		frame.setSize(dimension);
		frame.setTitle("Authentication");
		frame.setLayout(new FlowLayout());
		
		JLabel usernameLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		
		JTextField usernameField = new JTextField(null);
		usernameField.setToolTipText("Enter your username here");
		usernameField.requestFocusInWindow();
		usernameField.setPreferredSize(new Dimension(100,25));
		
		JTextField passwordField = new JTextField();
		passwordField.setToolTipText("Enter your password here");
		passwordField.setPreferredSize(new Dimension(100,25));
		
		JButton loginBtn = new JButton("Login");
		
		frame.add(usernameLabel);
		frame.add(usernameField);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(loginBtn);
		
		frame.setVisible(true);
		
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String username = usernameField.getText();
				String password = passwordField.getText();
				
				if(username.equals("admin") && password.equals("admin")) {
					MenuPage menuPage = new MenuPage();
					menuPage.call();
					frame.dispose();
				}
				
			}
		});
		
	}

}
