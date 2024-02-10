package main.creational.factory.method.factories;

import main.creational.factory.method.models.Employee;

public interface EmployeeFactory {

	Employee create(String name, String surname, byte age);
}
