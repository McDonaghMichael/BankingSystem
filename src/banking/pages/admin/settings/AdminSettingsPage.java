package banking.pages.admin.settings;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import banking.pages.admin.Main.MenuPage;

public class AdminSettingsPage {
	
	public AdminSettingsPage() {
		
	}

	public static void call() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame();
		frame.setSize(dimension.width, dimension.height);
		frame.setTitle("Banking System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.setPreferredSize(new Dimension(100,30));
		returnBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MenuPage.call();
			}
			
		});

		frame.add(returnBtn);
	}

}
