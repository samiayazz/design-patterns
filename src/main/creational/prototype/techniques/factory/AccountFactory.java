package main.creational.prototype.techniques.factory;

interface AccountFactory {

	Account createNormal(String iban, Customer owner, double balance, double credit);

	Account createNegative(String iban, Customer owner, double balance, double credit);

	Account createFrozen(String iban, Customer owner, double balance, double credit);
}
