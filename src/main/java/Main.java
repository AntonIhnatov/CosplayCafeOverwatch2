package main.java;

import main.java.menu.CafeMenu;
import main.java.menu.DishItem;
import main.java.menu.DrinkItem;
import main.java.menu.Item;
import main.java.orders.Order;
import main.java.premises.Bar;
import main.java.premises.DiningHall;
import main.java.premises.Kitchen;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        DiningHall diningHall = new DiningHall();
        diningHall.selectTable();

        List<Item> dishMenu = new ArrayList<>();
        dishMenu.add(new DishItem(1, "Взрывной сэндвич", 10.99, List.of("Мясо", "Овощи", "Соус", "Хлеб")));
        dishMenu.add(new DishItem(2, "Взрывной салат", 9.99, List.of("Мясо", "Овощи", "Соус")));
        dishMenu.add(new DishItem(3, "Бомбовые картофельные палочки", 8.99, List.of("Овощи", "Соус")));
        dishMenu.add(new DishItem(4, "Медовый торт с фруктами", 12.99, List.of("Торт", "Фрукты")));
        dishMenu.add(new DishItem(5, "Большой бургер Турбосвина", 22.59, List.of("Мясо", "Сыр", "Хлеб", "Соус")));
        dishMenu.add(new DishItem(6, "Лечебный суп", 17.49, List.of("Овощи", "Мясо", "Бульойн")));

        List<Item> drinkMenu = new ArrayList<>();
        drinkMenu.add(new DrinkItem(1, "High Noon Old Fashioned", 4.99, "Традиционный коктейль Old Fashioned, но с добавлением уникального прикосновения Маккри. Бурбон смешивается с тростниковым сахаром, а затем украшается апельсиновой цедрой и ангостура биттером."));
        drinkMenu.add(new DrinkItem(2, "Peacekeeper Margarita", 3.50, "Освежающий и пряный коктейль, сочетающий текилу с лаймовым соком и агавовым сиропом. Край бокала украшен солью, создавая иллюзию пыльной дороги." ));
        drinkMenu.add(new DrinkItem(3, "Harmony Bliss", 8.00, "Экзотический коктейль, объединяющий белый ром, кокосовое молоко, ананасовый сок и лаймовый сок. Погрузитесь в гармонию и блаженство с каждым глотком."));
        drinkMenu.add(new DrinkItem(4, "Soundwave Mojito", 10.50, "Освежающий мохито с энергетическим настроем Лусио. Белый ром, свежая мята, тростниковый сахар и лаймовый сок смешиваются с содовой водой, создавая волнующий вкусовой опыт."));
        drinkMenu.add(new DrinkItem(5, "Beat Drop Punch", 6.30, "Энергичный коктейль, вдохновленный музыкой Лусио. Темный ром, малиновый ликер, ананасовый сок, гренадин и лаймовый сок создают взрывной вкус и ритм в каждом глотке."));
        drinkMenu.add(new DrinkItem(6, "Hacktini", 5.55, "Коктейль с киберпанк-ноткой, сочетающий в себе водку, лимонный сок, сироп имбиря и оливку в качестве гарнира. Сомбра была здесь."));



        CafeMenu cafeMenu = new CafeMenu(dishMenu, drinkMenu);
        cafeMenu.printDishMenu();

        Order dishOrder = new Order(dishMenu);
        dishOrder.selectItems("блюд");
        dishOrder.printOrder();

        cafeMenu.printContextDrinkMenu();

        Order drinkOrder = new Order(drinkMenu);
        drinkOrder.selectItems("напитков");
        drinkOrder.printOrder();

        Kitchen kitchen = new Kitchen();
        kitchen.processSelectedDishItems(dishOrder.getSelectedItems());

        Bar bar = new Bar();
        bar.processSelectedDrinkItems(drinkOrder.getSelectedItems());

        diningHall.deliverOrder();
        dishOrder.printOrderedItems();
        drinkOrder.printOrderedItems();

        dishOrder.askForAdditionalOrder("блюд");
        dishOrder.printOrderAfterPreparation();

        drinkOrder.askForAdditionalOrder("напитков");
        drinkOrder.printOrderAfterPreparation();

    }
}
