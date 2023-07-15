package main.java.menu;

import java.util.List;


public class DishItem extends Item{
    private final List<String> ingredients;

    public DishItem(int number, String name, double price, List<String> ingredients) {
        super(number, name, price);
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}
