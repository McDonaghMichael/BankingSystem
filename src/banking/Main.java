package banking;

import banking.data.db.Database;
import banking.pages.admin.Main.MenuPage;
import banking.pages.authentication.AuthenticationPage;  

public class Main {
	
	private static Main instance;

	public static void main(String[] args) {

		AuthenticationPage authPage = new AuthenticationPage();
		authPage.call();

		Database db = new Database();
		
	}
	
	
	public static Main getInstance() {
		return instance;
	}

}
