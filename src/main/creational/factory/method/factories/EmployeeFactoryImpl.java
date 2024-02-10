package main.creational.factory.method.factories;

import main.creational.factory.method.models.Employee;

public class EmployeeFactoryImpl implements EmployeeFactory {

	public Employee create(String name, String surname, byte age) {
		int id = 1;
		Employee employee = new Employee(id, name, surname, age);
		return employee;
	}
}
