package main.java.employees;


import main.java.menu.DishItem;
import main.java.menu.Item;

import java.util.List;

public class PastryCook extends Employee implements Cook{
    public PastryCook(String name, String abilities) {
        super(name, abilities);
    }

    @Override
    public void cookItem(List<Item> selectedItems) {
        selectedItems.stream()
                .filter(item -> item instanceof DishItem)
                .map(item -> (DishItem) item)
                .filter(this::hasBreadOrCakeOrFruits)
                .forEachOrdered(this::cookDish);
    }

    private boolean hasBreadOrCakeOrFruits(DishItem dish) {
        return dish.getIngredients().contains("Хлеб") || dish.getIngredients().contains("Торт") || dish.getIngredients().contains("Фрукты");
    }

    private void cookDish(DishItem dish) {
        System.out.println(getName() + " готовит ингредиенты для блюда: " + dish.getName());
        if (dish.getIngredients().contains("Хлеб")) {
            System.out.println("- Хлеб");
        }
        if (dish.getIngredients().contains("Торт")) {
            System.out.println("- Торт");
        }
        if (dish.getIngredients().contains("Фрукты")) {
            System.out.println("- Фрукты");
        }
    }
}
