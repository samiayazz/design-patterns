package main.creational.factory.method.factories;

import java.math.BigDecimal;
import main.creational.factory.method.models.Manager;

public class ManagerFactoryImpl implements ManagerFactory {

	public Manager create(String name, String surname, byte age, BigDecimal salary) {
		int id = 2;
		Manager manager = new Manager(id, name, surname, age, salary);
		return manager;
	}
}
