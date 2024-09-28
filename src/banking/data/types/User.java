package banking.data.types;

public class User extends Account {
	
	private String IBAN, BIC;

	private int balance;
	
	public User(int accountId, String firstName, String lastName, String username, String password, String IBAN, String BIC, int balance) {
		super(accountId, firstName, lastName, username, password);
		this.IBAN = IBAN;
		this.BIC = BIC;
		this.balance = balance;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String getBIC() {
		return BIC;
	}

	public void setBIC(String bIC) {
		BIC = bIC;
	}

	public int getBalance(){
		return this.balance;
	}


}
