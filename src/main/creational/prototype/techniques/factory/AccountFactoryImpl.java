package main.creational.prototype.techniques.factory;

class AccountFactoryImpl implements AccountFactory {

	/*
	 * private final Account normalPrototype; private final Account
	 * negativePrototype; private final Account frozenPrototype;
	 */

	AccountFactoryImpl() {
		/*
		 * normalPrototype = new Account(null, 0, 0, null, true, true, true);
		 * 
		 * negativePrototype = normalPrototype.clone();
		 * negativePrototype.setOpenToTransfer(false);
		 * 
		 * frozenPrototype = normalPrototype.clone();
		 * frozenPrototype.setOpenToWithdraw(false);
		 * frozenPrototype.setOpenToPayment(false);
		 * frozenPrototype.setOpenToTransfer(false);
		 */
	}

	@Override
	public Account createNormal(String iban, Customer owner, double balance, double credit) {
		Account account = AccountPrototypes.NORMAL.clone();
		account.setIban(iban);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setCredit(credit);
		return account;
	}

	@Override
	public Account createNegative(String iban, Customer owner, double balance, double credit) {
		Account account = AccountPrototypes.NEGATIVE.clone();
		account.setIban(iban);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setCredit(credit);
		return account;
	}

	@Override
	public Account createFrozen(String iban, Customer owner, double balance, double credit) {
		Account account = AccountPrototypes.FROZEN.clone();
		account.setIban(iban);
		account.setOwner(owner);
		account.setBalance(balance);
		account.setCredit(credit);
		return account;
	}

	private static class AccountPrototypes {
		static final Account NORMAL = new Account(null, 0, 0, null, true, true, true);
		static final Account NEGATIVE = new Account(null, 0, 0, null, true, true, false);
		static final Account FROZEN = new Account(null, 0, 0, null, false, false, false);
	}
}
