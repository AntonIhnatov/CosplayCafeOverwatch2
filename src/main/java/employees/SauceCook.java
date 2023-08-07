package employees;

import menu.DishItem;
import menu.Item;

import java.util.List;

public class SauceCook extends Employee implements Cook {

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
//                    System.out.println("Повар "+ getName() + " закончил готовить часть блюда: " + dish.getName());
                }
            }
        }
        try {
            Thread.sleep(2000); // Задержка в 2 секунды (можете настроить значение по вашему усмотрению)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
