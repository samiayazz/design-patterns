package main.creational.factory.static_;

class Foo {

	private int id;
	private String name;

	private Foo() {

	}

	private Foo(int id) {
		setId(id);
	}

	private Foo(int id, String name) {
		this(id);
		setName(name);
	}

	int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	static Foo createFoo(int id) {
		return new Foo(id);
	}
}
