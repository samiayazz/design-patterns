package main.creational.singleton.techniques.enumeration;

class SingletonWithEnumerationTest {

	public static void main(String[] args) {
		Foo foo = Foo.INSTANCE.getInstance();
		Foo foo2 = Foo.INSTANCE.getInstance();

		System.out.println("Are these equal? " + (foo == foo2));
	}
}
