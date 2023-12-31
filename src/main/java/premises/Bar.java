package premises;

import employees.Barman;
import menu.DrinkItem;
import menu.Item;

import java.util.List;

public class Bar {
    Barman barman = new Barman("Лусио","Лусио, будучи музыкантом и с вниманием к ритму, может создавать энергичные и освежающие коктейли, которые будут радовать клиентов.");

    public void processSelectedDrinkItems(List<Item> selectedItems) {
        if (selectedItems.stream().anyMatch(item -> item instanceof DrinkItem)) {
            System.out.println();
            System.out.println("Бармен " + barman.getName() + " приступает к готовке напитков");
            barman.cookItem(selectedItems);
        }
    }

}
