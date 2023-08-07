package employees;

import menu.DishItem;
import menu.Item;

import java.util.List;

public class RegularCook extends Employee implements Cook {
    public RegularCook(String name, String abilities) {
        super(name, abilities);
    }

    @Override
    public void cookItem(List<Item> selectedItems) {
        selectedItems.stream()
                .filter(item -> item instanceof DishItem)
                .map(item -> (DishItem) item)
                .filter(this::hasVegetablesOrBouillon)
                .forEachOrdered(this::cookDish);
    }

    private boolean hasVegetablesOrBouillon(DishItem dish) {
        return dish.getIngredients().contains("Овощи") || dish.getIngredients().contains("Бульон") || dish.getIngredients().contains("Сыр");
    }

    private void cookDish(DishItem dish) {
        System.out.println(getName() + " готовит ингредиенты для блюда: " + dish.getName());
        if (dish.getIngredients().contains("Овощи")) {
            System.out.println("- Овощи");
        }
        if (dish.getIngredients().contains("Бульон")) {
            System.out.println("- Бульон");
        }
        if ((dish.getIngredients().contains("Сыр"))) {
            System.out.println("- Сыр");
        }
//        System.out.println("Повар "+ getName() + " закончил готовить часть блюда: " + dish.getName());
    }

}
