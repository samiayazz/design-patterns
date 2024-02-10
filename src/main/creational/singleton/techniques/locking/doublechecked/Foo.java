package main.creational.singleton.techniques.locking.doublechecked;

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

	private static volatile Foo instance;

	static Foo getInstance() {
		if (instance == null) {
			synchronized (Foo.class) {
				if (instance == null) {
					instance = new Foo();
				}
			}
		}

		return instance;
	}
}
