package main.creational.factory.method.models;

import java.math.BigDecimal;

public class Manager extends Employee {

	private BigDecimal salary;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String name, String surname, byte age) {
		super(id, name, surname, age);
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String name, String surname, byte age, BigDecimal salary) {
		this(id, name, surname, age);
		setSalary(salary);
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
}
