package banking.pages.global.settings;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import banking.pages.authentication.AuthenticationPage;
import banking.pages.global.GlobalMenuPage;

public class GlobalSettingsPage {
	
	public GlobalSettingsPage() {
		
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
				GlobalMenuPage globalMenuPage = new GlobalMenuPage();
				globalMenuPage.call();
			}
			
		});

		frame.add(returnBtn);
	}

}
