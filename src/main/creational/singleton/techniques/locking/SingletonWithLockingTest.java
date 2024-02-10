package main.creational.singleton.techniques.locking;

class SingletonWithLockingTest extends Thread {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new SingletonWithLockingTest().start();
		}
	}

	@Override
	public void run() {
		Foo foo = Foo.getInstance();
		System.out.println(foo.getName());
	}
}
