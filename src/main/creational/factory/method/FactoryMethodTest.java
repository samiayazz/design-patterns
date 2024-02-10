package main.creational.factory.method;

import java.math.BigDecimal;

import main.creational.factory.method.factories.EmployeeFactoryImpl;
import main.creational.factory.method.factories.ManagerFactoryImpl;
import main.creational.factory.method.models.Employee;
import main.creational.factory.method.models.Manager;

class FactoryMethodTest {

	public static void main(String[] args) {
		EmployeeFactoryImpl employeeFactory = new EmployeeFactoryImpl();
		ManagerFactoryImpl managerFactory = new ManagerFactoryImpl();

		Employee employee = employeeFactory.create("John", "Doe", (byte) 21);
		Manager manager = managerFactory.create("Jane", "Doe", (byte) 35, BigDecimal.valueOf(50_000));

		System.out.println("created " + employee.getName() + " employee with " + employee.getId() + " id.");
		System.out.println("created " + manager.getName() + " manager with " + manager.getId() + " id.");
	}
}
