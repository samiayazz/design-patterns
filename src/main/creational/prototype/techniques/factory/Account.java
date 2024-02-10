package main.creational.prototype.techniques.factory;

class Account implements Cloneable {

	protected String iban;
	protected double balance;
	protected double credit;
	protected Customer owner;

	private boolean openToWithdraw;
	private boolean openToPayment;
	private boolean openToTransfer;

	Account(String iban, double balance, double credit, Customer owner, boolean openToWithdraw, boolean openToPayment,
			boolean openToTransfer) {
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
}
