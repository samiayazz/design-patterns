package main.creational.singleton.techniques.enumeration;

enum Foo {

	INSTANCE();

	private String name;

	private Foo() {

	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	Foo getInstance() {
		return INSTANCE;
	}
}
