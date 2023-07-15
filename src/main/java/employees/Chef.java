package main.java.employees;

import main.java.menu.DishItem;
import main.java.menu.Item;

import java.util.List;

public class Chef extends Employee implements Cook {
    public Chef(String name, String abilities) {
        super(name, abilities);
    }

    @Override
    public void cookItem(List<Item> selectedItems) {
        selectedItems.stream()
                .filter(item -> item instanceof DishItem)
                .map(item -> (DishItem) item)
                .forEach(dish -> System.out.println("\"Народ, готовим блюдо с названием " + dish.getName()+ "\""));
        System.out.println();
    }
}


