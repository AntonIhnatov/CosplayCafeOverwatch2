package orders;
import menu.DishItem;
import menu.DrinkItem;
import menu.Item;

import java.util.*;

public class Order {
    private final List<Item> orderedItems;
    private final List<Item> selectedItems;

    public Order(List<Item> orderedItems) {
        this.orderedItems = orderedItems;
        this.selectedItems = new ArrayList<>();
    }

    public List<Item> getSelectedItems() {
        return selectedItems;
    }


    public void selectItems(String menuType) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Выберите позиции из меню " + menuType + " (введите номер позиции), для завершения заказа введите 0:");

        choice = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки после считывания числа

        if (choice == 0) {
            return;
        }

        Item selectedItem = findItemByNumber(choice);

        if (selectedItem != null) {
            selectedItems.add(selectedItem);
            System.out.println("Позиция " + selectedItem.getName() + " добавлена в заказ.");
        } else {
            System.out.println("Неверный номер позиции. Попробуйте еще раз.");
        }

        selectItems(menuType); // Рекурсивный вызов метода для выбора следующей позиции
    }

    private Item findItemByNumber(int itemId) {
        for (Item item : orderedItems) {
            if (item.getNumber() == itemId) {
                return item;
            }
        }
        return null;
    }

    public void printOrder() {
        if (!selectedItems.isEmpty()) {
            System.out.println("Ваш заказ:");
            double totalCost = 0;

            for (Item item : selectedItems) {
                System.out.println(item.getName() + " ");
                totalCost += item.getPrice();
            }
        }
    }

    public void printOrderAfterPreparation() {
        if (!selectedItems.isEmpty()) {
            Map<String, Double> itemMap = new HashMap<>();
            double totalCost = 0;

            for (Item item : selectedItems) {
                String itemName = item.getName();
                totalCost += item.getPrice();

                // Если элемент уже есть в Map, увеличиваем его количество
                if (itemMap.containsKey(itemName)) {
                    double currentQuantity = itemMap.get(itemName);
                    itemMap.put(itemName, currentQuantity + 1);
                } else {
                    // Если элемента еще нет в Map, добавляем его с количеством 1
                    itemMap.put(itemName, 1.0);
                }
            }

            // Вывод информации о блюдах и напитках с указанием количества
            if (!itemMap.isEmpty()) {

                // Разделяем блюда и напитки по типу элемента
                Map<String, Double> dishes = new HashMap<>();
                Map<String, Double> drinks = new HashMap<>();

                for (Map.Entry<String, Double> entry : itemMap.entrySet()) {
                    String itemName = entry.getKey();
                    double quantity = entry.getValue();

                    // Разделяем элементы по спискам блюд и напитков
                    if (orderedItems.stream().anyMatch(item -> item.getName().equals(itemName) && item instanceof DishItem)) {
                        dishes.put(itemName, quantity);
                    } else {
                        drinks.put(itemName, quantity);
                    }
                }

                // Вывод информации о блюдах с указанием количества
                if (!dishes.isEmpty()) {
                    System.out.println("Ваш заказ на блюда:");
                    for (Map.Entry<String, Double> entry : dishes.entrySet()) {
                        String itemName = entry.getKey();
                        double quantity = entry.getValue();
                        System.out.println(itemName + " - " + (int) quantity + "x");
                    }
                }

                // Вывод информации о напитках с указанием количества
                if (!drinks.isEmpty()) {
                    System.out.println("Ваш заказ на напитки:");
                    for (Map.Entry<String, Double> entry : drinks.entrySet()) {
                        String itemName = entry.getKey();
                        double quantity = entry.getValue();
                        System.out.println(itemName + " - " + (int) quantity + "x");
                    }
                }
            }

            // Вывод общей стоимости
            System.out.println();
            System.out.println("Итого к оплате: " + totalCost + " долларов");
            System.out.println();
        }
    }

    public void askForAdditionalOrder(String menuType) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("Хотите что-то дозаказать из меню " + menuType +  "? (да/нет)");
        choice = scanner.nextLine().toLowerCase();

        if (choice.equals("да")) {
            selectItems(menuType); // Вызываем метод selectItems() для выбора дополнительных позиций
        } else if (choice.equals("нет")) {
            return;
        } else {
            System.out.println("Неверный ответ. Пожалуйста, введите 'да' или 'нет'.");
            askForAdditionalOrder(menuType); // Рекурсивный вызов метода для повторного запроса
        }
    }

    public void printOrderedItems() {
        boolean dishesPrinted = false;
        boolean drinksPrinted = false;

        for (Item item : selectedItems) {
            if (item instanceof DishItem && !dishesPrinted) {
                System.out.println("Блюда в заказе:");
                dishesPrinted = true;
            } else if (item instanceof DrinkItem && !drinksPrinted) {
                System.out.println("Напитки в заказе:");
                drinksPrinted = true;
            }

            if (item instanceof DishItem) {
                System.out.println(item.getName());
            } else if (item instanceof DrinkItem) {
                System.out.println(item.getName());
            }
        }
    }
}