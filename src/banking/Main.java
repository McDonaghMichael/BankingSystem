package banking;

import banking.pages.Main.MenuPage;  

public class Main {
	
	private static Main instance;

	public static void main(String[] args) {

		MenuPage mP = new MenuPage();
		mP.call();
		
	}
	
	
	public static Main getInstance() {
		return instance;
	}

}
