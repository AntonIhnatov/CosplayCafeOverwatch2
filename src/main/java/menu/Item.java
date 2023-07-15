package main.java.menu;

public class Item {
    private final int number;
    private final String name;
    private final double price;

    public Item(int number, String name, double price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}