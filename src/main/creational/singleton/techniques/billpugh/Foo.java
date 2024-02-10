package main.creational.singleton.techniques.billpugh;

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

	private static class SingletonHelper {
		private static final Foo FOO_INSTANCE = new Foo();
	}

	static Foo getInstance() {
		return SingletonHelper.FOO_INSTANCE;
	}
}
