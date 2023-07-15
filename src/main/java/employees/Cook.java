package main.java.employees;

import main.java.menu.DishItem;
import main.java.menu.Item;

import java.util.List;

public interface Cook {
    void cookItem(List<Item> selectedItems);
}
