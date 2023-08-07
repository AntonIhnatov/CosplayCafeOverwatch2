package premises;

import employees.*;
import equipments.Stove;
import menu.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Kitchen {
    Chef chef = new Chef("Джункрат (шеф)","Благодаря своим взрывным способностям, Джункрат может создавать уникальные и экспериментальные блюда, полные взрывного вкуса.");
    PastryCook pastryCook = new PastryCook("Ана (кондитер)", "Ана, будучи снайпером и медиком, может использовать свои навыки точности и лечения в кулинарии. Она может быть ответственна за создание блюд, которые не только вкусны, но и полезны для здоровья гостей.");
    RegularCook regularCook = new RegularCook("Мойра (обычный повар)","Мойра обладает способностями к лечению и нанесению урона. В качестве повара, она может использовать свои лечебные способности, чтобы создавать блюда с особым вниманием к здоровому питанию и пользе для организма.");
    ButcherCook butcherCook = new ButcherCook("Турбосвин (мясник)","Турбосвин может использовать свою силу и выносливость для обработки крупных порций продуктов. Он может быть ответственным за приготовление мясных блюд и гриля, создавая сочные и аппетитные стейки.");
    SauceCook sauceCook = new SauceCook("Солдат 76 (соусье)","Бывший военный герой, применив свою тактическую экспертизу, воспламеняет вкусовые рецепторы своими уникальными соусами, доставляя необычный вкус в мир кулинарии");

    private Stove stove = new Stove(2);
    ExecutorService executorService = Executors.newFixedThreadPool(2); // 2 потока для двух поваров

    public void processSelectedDishItems(List<Item> selectedItems) {
        chef.cookItem(selectedItems);

        if (!selectedItems.isEmpty()) {
            List<Employee> cooks = Arrays.asList(pastryCook, regularCook, butcherCook, sauceCook);

            for (Employee cook : cooks) {
                executorService.submit(() -> {
                    try {
                        stove.acquireSlot();
                        List<Item> cookItems = new ArrayList<>(selectedItems); // Копия заказанных блюд для каждого повара
                        cook.cookItem(cookItems);
                        Thread.sleep(3000); // Задержка готовки
                        System.out.println("Повар "+ cook.getName() + " закончил готовить часть блюда" );
                        Thread.sleep(3000); // За работу принимается другой повар
                        stove.releaseSlot();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

            executorService.shutdown(); // Завершаем выполнение задач после окончания

            try {
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Ждем завершения всех задач
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Шеф-повар, (не без помощи своей команды), приготовил все блюда из заказа посетителя.");
        }
    }
}
