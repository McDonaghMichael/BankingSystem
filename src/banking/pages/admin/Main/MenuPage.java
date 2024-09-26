package banking.pages.admin.Main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import banking.pages.admin.Accounts.AccountsPage;
import banking.pages.admin.settings.AdminSettingsPage;
import banking.pages.authentication.AuthenticationPage;

public class MenuPage {

	public MenuPage() {
		
	}
	
	public static void call()
	{
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame();
		frame.setSize(dimension.width, dimension.height);
		frame.setTitle("Banking System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		JButton accountsBtn = new JButton("Accounts");
		accountsBtn.setPreferredSize(new Dimension(100,30));
		accountsBtn.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                AccountsPage.call();
                frame.dispose();
            }
		});
		
		JButton settingsBtn = new JButton("Settings");
		settingsBtn.setPreferredSize(new Dimension(100,30));
		
		settingsBtn.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                
                AdminSettingsPage.call();
                frame.dispose();
            }
		});
		
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setPreferredSize(new Dimension(100,30));
		logoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AuthenticationPage.call();
			}
			
		});
		
		frame.add(accountsBtn);
		frame.add(settingsBtn);
		frame.add(logoutBtn);
		
	}
}
