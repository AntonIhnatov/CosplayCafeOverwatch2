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

//    @Override
//    public void cookItem(List<Item> selectedItems) {
//        for (Item item : selectedItems) {
//            if (item instanceof DishItem) {
//                DishItem dish = (DishItem) item;
//                List<String> ingredients = dish.getIngredients();
//
//                // Перевірка інгредієнтів та готування страви відповідним кухарем
//                if (ingredients.contains("М'ясо")) {
//                    // Готуємо страву з м'ясом
//                    System.out.println("Готуємо страву з м'ясом: " + dish.getName());
//                } else if (ingredients.contains("Овочі")) {
//                    // Готуємо страву з овочами
//                    System.out.println("Готуємо страву з овочами: " + dish.getName());
//                } else {
//                    // Інші страви
//                    System.out.println("Готуємо іншу страву: " + dish.getName());
//                }
//            }
//        }
//    }

    //    @Override
//    public void cookItem(DishItem dishItem, List<DishItem> dishItems) {
//        for (DishItem item : dishItems) {
//            if (item.getName().equals(dishItem.getName())) {
//                System.out.println("Повар готовит блюдо: " + item.getName());
//                System.out.println("Ингредиенты: " + item.getIngredients());
//                break;
//            }
//        }
//    }

