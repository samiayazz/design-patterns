package main.creational.prototype.techniques.factory.static_;

class PrototypeWithStaticFactoryMethodTest {

	public static void main(String[] args) {
		Account normalAccount = Account.createNormal("1", new Customer(), 1000, 1000);
		System.out.println("is normalAccount normal: " + (normalAccount.isOpenToWithdraw()
				&& normalAccount.isOpenToPayment() && normalAccount.isOpenToTransfer()));

		Account negativeAccount = Account.createNegative("2", new Customer(), -500, 1000);
		System.out.println("is negativeAccount negative: " + (negativeAccount.isOpenToWithdraw()
				&& negativeAccount.isOpenToPayment() && !negativeAccount.isOpenToTransfer()));

		Account frozenAccount = Account.createFrozen("3", new Customer(), -1000, 1000);
		System.out.println("is frozenAccount frozen: " + (!frozenAccount.isOpenToWithdraw()
				&& !frozenAccount.isOpenToPayment() && !negativeAccount.isOpenToTransfer()));
	}
}
