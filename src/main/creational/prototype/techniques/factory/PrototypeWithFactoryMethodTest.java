package main.creational.prototype.techniques.factory;

class PrototypeWithFactoryMethodTest {

	public static void main(String[] args) {
		AccountFactory factory = new AccountFactoryImpl();

		Account normalAccount = factory.createNormal("1", new Customer(), 1000, 1000);
		System.out.println("is normalAccount normal: " + (normalAccount.isOpenToWithdraw()
				&& normalAccount.isOpenToPayment() && normalAccount.isOpenToTransfer()));

		Account negativeAccount = factory.createNegative("2", new Customer(), -500, 1000);
		System.out.println("is negativeAccount negative: " + (negativeAccount.isOpenToWithdraw()
				&& negativeAccount.isOpenToPayment() && !negativeAccount.isOpenToTransfer()));

		Account frozenAccount = factory.createFrozen("3", new Customer(), -1000, 1000);
		System.out.println("is frozenAccount frozen: " + (!frozenAccount.isOpenToWithdraw()
				&& !frozenAccount.isOpenToPayment() && !negativeAccount.isOpenToTransfer()));
	}
}
