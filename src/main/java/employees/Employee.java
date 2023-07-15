package main.java.employees;

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
}
