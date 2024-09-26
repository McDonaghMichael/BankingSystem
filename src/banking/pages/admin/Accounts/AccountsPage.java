package banking.pages.admin.Accounts;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountsPage {
	
	public AccountsPage() {
		
	}
	
	public static void call() {
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame();
		frame.setTitle("Accounts");
		frame.setSize(dimension.width, dimension.height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,6));
		
		panel.add(new JLabel("Account ID"));
		panel.add(new JLabel("First Name"));
		panel.add(new JLabel("Last Name"));
		panel.add(new JLabel("BIC"));
		panel.add(new JLabel("IBAN"));
		panel.add(new JLabel("Balance"));
		panel.add(new JLabel("343"));
		panel.add(new JLabel("Michael"));
		panel.add(new JLabel("McDonagh"));
		panel.add(new JLabel("IEXXXIE"));
		panel.add(new JLabel("IEHROEWFSD"));
		panel.add(new JLabel("2000"));
		frame.add(panel);
		
		frame.setVisible(true);
		
	}

}
