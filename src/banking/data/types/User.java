package banking.data.types;

public class User extends Account {
	
	private String IBAN, BIC;
	
	public User(int accountId, String firstName, String lastName, String username, String password, String IBAN, String BIC) {
		super(accountId, firstName, lastName, username, password);
		this.IBAN = IBAN;
		this.BIC = BIC;
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


}
