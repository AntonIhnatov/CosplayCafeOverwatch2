package menu;

public class DrinkItem extends Item {
    private final String description;
    public DrinkItem(int number, String name, double price, String description) {
        super(number, name, price);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}