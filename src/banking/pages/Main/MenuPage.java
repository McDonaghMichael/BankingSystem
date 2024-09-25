package banking.pages.Main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import banking.pages.Accounts.AccountsPage;

import java.awt.event.ActionListener;

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
		
		JButton accountsBtn = new JButton("Accounts");
		accountsBtn.setPreferredSize(new Dimension(100,100));
		accountsBtn.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                AccountsPage accountsPage = new AccountsPage();
                accountsPage.call();
                frame.dispose();
            }
		});
		
		frame.add(accountsBtn);
		
		frame.setVisible(true);
	}
}
