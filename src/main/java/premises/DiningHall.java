package main.java.premises;

import main.java.employees.Waiter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiningHall {

    private RestaurantTable selectedTable;

    Waiter tracer = new Waiter("Трейсер","Благодаря своей способности перемещаться во времени, Трейсер может быть идеальным официантом для тех, кто хочет быстрое обслуживание. Пользователи могут выбрать ее, чтобы заказы были доставлены очень быстро.");
    Waiter reinhardt = new Waiter("Рейнхардт", "Благодаря своей силе и защитному полю, Рейнхардт может нести несколько блюд одновременно без риска их повреждения. Он может быть идеальным официантом для больших групп, которым требуется одновременная доставка нескольких блюд.");
    Waiter widowmaker = new Waiter( "Роковая вдова", "Благодаря работе снайпера с превосходными навыками меткости, может быть прекрасным официантом для гостей, которым нужно максимальное внимание к деталям и точности");
    Waiter genji = new Waiter("Генджи", "Благодаря своей маневренности и уклонению, обеспечивает быстрое обслуживание и доставку заказов. С помощью своего меча, Генджи может элегантно и стильно подавать блюда, добавляя некую театральность к опыту обеда в кафе.");


    public enum RestaurantTable {
        KINGS_ROW(1, "King's Row"),
        DORADO(2, "Dorado"),
        NEPAL(3, "Nepal"),
        ROUTE_66(4, "Route 66");

        public final int tableNumber;
        public final String nameOfTable;

        RestaurantTable(int tableNumber, String nameOfTable) {
            this.tableNumber = tableNumber;
            this.nameOfTable = nameOfTable;
        }

        public int getTableNumber() {
            return tableNumber;
        }
    }


    public void selectTable() {
        Scanner scanner = new Scanner(System.in);
        printTableOptions();

        int tableNumber = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки после считывания числа

        RestaurantTable table = selectTableByNumber(tableNumber);
        if (table == null) {
            System.out.println("Неверный выбор столика");
            return;
        }

        selectedTable = table;
        printSelectedTableInfo();

        String waiterName = String.valueOf(getWaiter(table));
        if (waiterName == null) {
            System.out.println("Неверный выбор официанта");
            return;
        }

        Waiter selectedWaiter = getWaiter(selectedTable);
        printSelectedWaiterInfo(selectedWaiter);
    }


    private void printTableOptions() {
        System.out.println("Добро пожаловать в косплей-кафе по игре Overwatch 2!\n" + "Здесь вы сможете окунуться в удивительный мир Overwatch и насладиться атмосферой игры в реальной жизни\n");
        System.out.println("Выберите столик для посетителя:");
        System.out.println("1 - Столик Kings Row");
        System.out.println("2 - Столик Dorado");
        System.out.println("3 - Столик Nepal");
        System.out.println("4 - Столик Route 66");
    }

    private RestaurantTable selectTableByNumber(int tableNumber) {
        for (RestaurantTable table : RestaurantTable.values()) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null;
    }

    private void printSelectedTableInfo() {
        System.out.println("Номер столика: " + selectedTable.getTableNumber());
        System.out.println("Вы выбрали тематический столик " + selectedTable.nameOfTable + "\n");
    }

    private Waiter getWaiter(RestaurantTable table) {
        switch (table) {
            case KINGS_ROW:
                return tracer;
            case DORADO:
                return reinhardt;
            case NEPAL:
                return widowmaker;
            case ROUTE_66:
                return genji;
            default:
                return null;
        }
    }

    private void printSelectedWaiterInfo(Waiter waiter) {
        System.out.println("Назначенный официант: " + waiter.getName());
        System.out.println("Описание официанта: " + waiter.getAbilities() + "\n");
        System.out.println("Официант хочет принять у вас заказ. Заказы на напитки и блюда идут в разные чеки.");
    }

    public void deliverOrder() {
        System.out.println();
        System.out.println("Официант несет заказ за столик " + selectedTable.getTableNumber() + ". Ваш заказ готов.");
    }
}
