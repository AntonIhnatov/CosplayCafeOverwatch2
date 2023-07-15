package main.java.employees;

import main.java.menu.DishItem;
import main.java.menu.Item;

import java.util.List;

public class SauceCook extends Employee implements Cook{

    public SauceCook(String name, String abilities) {
        super(name, abilities);
    }

    @Override
    public void cookItem(List<Item> selectedItems) {
        for (Item item : selectedItems) {
            if (item instanceof DishItem) {
                DishItem dish = (DishItem) item;
                if (dish.getIngredients().contains("Соус")) {
                    System.out.println(getName() +  " готовит соус для блюда: "  + dish.getName());
                }
            }
        }
    }
}
