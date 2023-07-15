package main.java.premises;

import main.java.employees.*;
import main.java.menu.Item;


import java.util.List;

public class Kitchen {
    Chef chef = new Chef("Джункрат (шеф)","Благодаря своим взрывным способностям, Джункрат может создавать уникальные и экспериментальные блюда, полные взрывного вкуса.");
    PastryCook pastryCook = new PastryCook("Ана (кондитер)", "Ана, будучи снайпером и медиком, может использовать свои навыки точности и лечения в кулинарии. Она может быть ответственна за создание блюд, которые не только вкусны, но и полезны для здоровья гостей.");
    RegularCook regularCook = new RegularCook("Мойра (обычный повар)","Мойра обладает способностями к лечению и нанесению урона. В качестве повара, она может использовать свои лечебные способности, чтобы создавать блюда с особым вниманием к здоровому питанию и пользе для организма.");
    ButcherCook butcherCook = new ButcherCook("Турбосвин (мясник)","Турбосвин может использовать свою силу и выносливость для обработки крупных порций продуктов. Он может быть ответственным за приготовление мясных блюд и гриля, создавая сочные и аппетитные стейки.");
    SauceCook sauceCook = new SauceCook("Солдат 76 (соусье)","Бывший военный герой, применив свою тактическую экспертизу, воспламеняет вкусовые рецепторы своими уникальными соусами, доставляя необычный вкус в мир кулинарии");


    public void processSelectedDishItems(List<Item> selectedItems) {
        if (!selectedItems.isEmpty()) {
            System.out.print("Шеф повар " + chef.getName() + " говорит команде: ");
            System.out.println();
            chef.cookItem(selectedItems);
            pastryCook.cookItem(selectedItems);
            System.out.println();
            regularCook.cookItem(selectedItems);
            System.out.println();
            butcherCook.cookItem(selectedItems);
            System.out.println();
            sauceCook.cookItem(selectedItems);
            System.out.println();
            System.out.println("Шеф-повар, (не без помощи своей команды), приготовил все блюда из заказа посетителя.");
        }
    }

}
