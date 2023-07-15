package main.java.employees;

import main.java.menu.DrinkItem;
import main.java.menu.Item;

import java.util.List;

public class Barman extends Employee implements Cook{

    public Barman(String name, String abilities) {
        super(name, abilities);
    }

    @Override
    public void cookItem(List<Item> selectedItems) {
        selectedItems.stream()
                .filter(item -> item instanceof DrinkItem)
                .map(item -> (DrinkItem) item)
                .forEach(drink -> System.out.println("Бармен приготовил напиток с названием " + drink.getName()));
    }
}
