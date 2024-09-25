package banking.pages.Accounts;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;

public class AccountsPage {
	
	public AccountsPage() {
		
	}
	
	public static void call() {
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame();
		frame.setTitle("Accounts");
		frame.setSize(dimension.width, dimension.height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

}
