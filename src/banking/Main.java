package banking;

import banking.pages.Main.MenuPage;
import banking.pages.authentication.AuthenticationPage;  

public class Main {
	
	private static Main instance;

	public static void main(String[] args) {

		AuthenticationPage authPage = new AuthenticationPage();
		authPage.call();
		
	}
	
	
	public static Main getInstance() {
		return instance;
	}

}
