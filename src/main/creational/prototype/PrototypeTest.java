package main.creational.prototype;

class PrototypeTest {

	public static void main(String[] args) {
		Account normalAccountPrototype = new Account(null, 0, 0, null, true, true, true);
		Account normalAccount = normalAccountPrototype.clone();
		normalAccount.setIban("1");
		normalAccount.setBalance(1000);
		normalAccount.setCredit(1000);
		normalAccount.setOwner(new Customer());

		Account negativeAccountPrototype = new Account(null, 0, 0, null, true, true, false);
		Account negativeAccount = negativeAccountPrototype.clone();
		negativeAccount.setIban("2");
		negativeAccount.setBalance(-500);
		negativeAccount.setCredit(1000);
		negativeAccount.setOwner(new Customer());

		Account frozenAccountPrototype = new Account(null, 0, 0, null, false, false, false);
		Account frozenAccount = frozenAccountPrototype.clone();
		frozenAccount.setIban("3");
		frozenAccount.setBalance(-1000);
		frozenAccount.setCredit(1000);
		frozenAccount.setOwner(new Customer());
	}
}
