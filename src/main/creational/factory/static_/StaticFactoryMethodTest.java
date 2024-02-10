package main.creational.factory.static_;

class StaticFactoryMethodTest {

	public static void main(String[] args) {
		Foo foo = Foo.createFoo(1);
		foo.setName("Bar");
		System.out.println(foo.getName());
	}
}
