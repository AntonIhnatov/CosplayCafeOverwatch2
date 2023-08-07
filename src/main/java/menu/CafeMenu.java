package menu;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class CafeMenu {
    private final List<Item> dishMenu;
    private final List<Item> drinkMenu;

    public CafeMenu(List<Item> dishMenu, List<Item> drinkMenu) {
        this.dishMenu = dishMenu;
        this.drinkMenu = drinkMenu;
    }

    public void printDishMenu() {
        System.out.println("Меню блюд:");
        for (Item dish : dishMenu) {
            System.out.println(dish.getNumber() + " - " + dish.getName());
            System.out.println("Цена: " + dish.getPrice());
            System.out.println("Ингредиенты: " + ((DishItem) dish).getIngredients());
            System.out.println();
        }
    }

    public void printDrinkMenu() {
        System.out.println("Меню напитков:");
        for (Item drink : drinkMenu) {
            System.out.println(drink.getNumber() + " - " + drink.getName());
            System.out.println("Цена: " + drink.getPrice());
            System.out.println("Описание: " + ((DrinkItem) drink).getDescription());
            System.out.println();
        }
    }

    public void sortDrinkMenuByPrice() {
        Collections.sort(drinkMenu, Comparator.comparingDouble(Item::getPrice));
        System.out.println("Меню напитков отсортировано по ценам:");
        printDrinkMenu();
    }

    public void filterDrinkMenuByPriceRange(double minPrice, double maxPrice) {
        System.out.println("Напитки в заданном ценовом диапазоне [" + minPrice + " - " + maxPrice + "]:");
        boolean found = false;

        for (Item drink : drinkMenu) {
            if (drink instanceof DrinkItem && drink.getPrice() >= minPrice && drink.getPrice() <= maxPrice) {
                System.out.println(drink.getNumber() + " - " + drink.getName());
                System.out.println("Цена: " + drink.getPrice());
                System.out.println("Описание: " + ((DrinkItem) drink).getDescription());
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("В меню отсутствуют напитки в указанном ценовом диапазоне.");
        }
    }

    public void printContextDrinkMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double minPrice;
        double maxPrice;

        do {
            System.out.println("Пожалуйста, выберите одно из действий: ");
            System.out.println("1 - Отсортировать меню напитков по ценам");
            System.out.println("2 - Отфильтровать меню напитков по ценовому диапазону");
            System.out.println("0 - Выйти");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    sortDrinkMenuByPrice();
                    break;
                case 2:
                    System.out.println("Введите нижнюю границу ценового диапазона:");
                    minPrice = scanner.nextDouble();
                    System.out.println("Введите верхнюю границу ценового диапазона:");
                    maxPrice = scanner.nextDouble();
                    scanner.nextLine();
                    filterDrinkMenuByPriceRange(minPrice, maxPrice);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        } while (choice != 0);
    }
}