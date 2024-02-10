package main.creational.singleton;

class SingletonTest {

	public static void main(String[] args) {

		Foo foo = Foo.getInstance();
		System.out.println("foo.name: " + foo.getName());

		Foo foo2 = Foo.getInstance();
		System.out.println("foo2.name: " + foo2.getName());

		System.out.println();

		System.out.println("are these equal? " + (foo == foo2));
	}
}
