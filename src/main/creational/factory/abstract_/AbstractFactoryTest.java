package main.creational.factory.abstract_;

import main.creational.factory.abstract_.factories.GUIFactoryImpl;
import main.creational.factory.abstract_.models.*;

class AbstractFactoryTest {

	public static void main(String[] args) {

		GUIFactoryImpl guiFactory = new GUIFactoryImpl();

		Button button = (Button) guiFactory.createButton();
		List list = (List) guiFactory.createList();
		Table table = (Table) guiFactory.createTable();

		System.out.println(button.toString());
		System.out.println(list.toString());
		System.out.println(table.toString());
	}
}
