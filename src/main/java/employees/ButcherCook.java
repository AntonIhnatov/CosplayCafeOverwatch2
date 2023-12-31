package employees;

import menu.DishItem;
import menu.Item;

import java.util.List;

public class ButcherCook extends Employee implements Cook {
    public ButcherCook(String name, String abilities) {
        super(name, abilities);
    }

    @Override
    public void cookItem(List<Item> selectedItems) {
        for (Item item : selectedItems) {
            if (item instanceof DishItem) {
                DishItem dish = (DishItem) item;
                if (dish.getIngredients().contains("Мясо")) {
                    System.out.println(getName() +  " готовит мясо для блюда: "  + dish.getName());
//                    System.out.println("Повар "+ getName() + " закончил готовить часть блюда: " + dish.getName());
                }
            }
        }

    }
}
