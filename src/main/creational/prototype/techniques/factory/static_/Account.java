package main.creational.prototype.techniques.factory.static_;

class Account implements Cloneable {

	protected String iban;
	protected double balance;
	protected double credit;
	protected Customer owner;

	private boolean openToWithdraw;
	private boolean openToPayment;
	private boolean openToTransfer;

	private Account(String iban, double balance, double credit, Customer owner, boolean openToWithdraw,
			boolean openToPayment, boolean openToTransfer) {
		this.iban = iban;
		this.balance = balance;
		this.credit = credit;
		this.owner = owner;
		this.openToWithdraw = openToWithdraw;
		this.openToPayment = openToPayment;
		this.openToTransfer = openToTransfer;
	}

	String getIban() {
		return iban;
	}

	void setIban(String iban) {
		this.iban = iban;
	}

	double getBalance() {
		return balance;
	}

	void setBalance(double balance) {
		this.balance = balance;
	}

	double getCredit() {
		return credit;
	}

	void setCredit(double credit) {
		this.credit = credit;
	}

	Customer getOwner() {
		return owner;
	}

	void setOwner(Customer owner) {
		this.owner = owner;
	}

	boolean isOpenToWithdraw() {
		return openToWithdraw;
	}

	void setOpenToWithdraw(boolean openToWithdraw) {
		this.openToWithdraw = openToWithdraw;
	}

	boolean isOpenToPayment() {
		return openToPayment;
	}

	void setOpenToPayment(boolean openToPayment) {
		this.openToPayment = openToPayment;
	}

	boolean isOpenToTransfer() {
		return openToTransfer;
	}

	void setOpenToTransfer(boolean openToTransfer) {
		this.openToTransfer = openToTransfer;
	}

	@Override
	public Account clone() {
		Account account = null;
		try {
			account = (Account) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("CloneNotSupportedException");
			System.out.println(e);
		}
		return account;
	}

	static Account createNormal(String iban, Customer owner, double balance, double credit) {
		Account account = Prototypes.normal.clone();
		account.setIban(iban);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setCredit(credit);
		return account;
	}

	static Account createNegative(String iban, Customer owner, double balance, double credit) {
		Account account = Prototypes.negative.clone();
		account.setIban(iban);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setCredit(credit);
		return account;
	}

	static Account createFrozen(String iban, Customer owner, double balance, double credit) {
		Account account = Prototypes.frozen.clone();
		account.setIban(iban);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setCredit(credit);
		return account;
	}

	private static class Prototypes {
		static final Account normal = new Account(null, 0, 0, null, true, true, true);
		static final Account negative = new Account(null, 0, 0, null, true, true, false);
		static final Account frozen = new Account(null, 0, 0, null, false, false, false);
	}
}
