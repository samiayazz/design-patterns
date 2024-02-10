package main.creational.factory.abstract_.factories;

import main.creational.factory.abstract_.models.Component;

public interface GUIFactory {

	Component createButton();

	Component createList();

	Component createTable();
}
