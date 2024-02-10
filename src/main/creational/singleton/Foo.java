package main.creational.singleton;

class Foo {

	private String name;

	private static int instanceCount;

	private Foo() {
		instanceCount++;
		setName("instance" + instanceCount);
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	private static Foo instance;

	static Foo getInstance() {
		if (instance == null)
			instance = new Foo();

		return instance;
	}
}
