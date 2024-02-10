package main.creational.factory.method.factories;

import java.math.BigDecimal;
import main.creational.factory.method.models.Employee;

public interface ManagerFactory {

	Employee create(String name, String surname, byte age, BigDecimal salary);
}
