package main.creational.factory.method.models;

public class Employee {

	private int id;
	private String name;
	private String surname;
	private byte age;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id) {
		setId(id);
	}

	public Employee(int id, String name, String surname, byte age) {
		this(id);
		setName(name);
		setSurname(surname);
		setAge(age);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}
}
