package employees;

import menu.Item;
import java.util.List;

public class Employee {
    private final String name;
    private final String abilities;

    public Employee(String name, String abilities) {
        this.name = name;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public String getAbilities() {
        return abilities;
    }

    public void cookItem(List<Item> selectedItems) {
    }

//    public void cookItem(List<Item> selectedItems) {
//    }
}
