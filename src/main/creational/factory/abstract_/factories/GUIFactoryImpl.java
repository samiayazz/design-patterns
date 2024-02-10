package main.creational.factory.abstract_.factories;

import main.creational.factory.abstract_.models.Button;
import main.creational.factory.abstract_.models.Component;
import main.creational.factory.abstract_.models.List;
import main.creational.factory.abstract_.models.Table;

public class GUIFactoryImpl implements GUIFactory {

	@Override
	public Component createButton() {
		return new Button();
	}

	@Override
	public Component createList() {
		return new List();
	}

	@Override
	public Component createTable() {
		return new Table();
	}
}
