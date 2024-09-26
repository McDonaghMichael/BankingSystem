package banking.pages.global;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import banking.pages.admin.Accounts.AccountsPage;
import banking.pages.authentication.AuthenticationPage;

public class GlobalMenuPage {
	
	public GlobalMenuPage() {
		
	}
	
	public static void call() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame();
		frame.setSize(dimension.width, dimension.height);
		frame.setTitle("Banking System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);

		
		JButton settingsBtn = new JButton("Settings");
		settingsBtn.setPreferredSize(new Dimension(100,30));
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setPreferredSize(new Dimension(100,30));
		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AuthenticationPage authPage = new AuthenticationPage();
				authPage.call();
			}
			
		});

		frame.add(settingsBtn);
		frame.add(logoutBtn);
	}

}
