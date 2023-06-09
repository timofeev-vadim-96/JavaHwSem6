import java.util.*;

public class Main {
    public static Set<Laptop> laptops = new HashSet<>();

    public static void main(String[] args) {
        createSetOfLeptops();
        printAllLaptops();
        printLaptopsWithFilter(userMenu(), filter());
    }

    private static void createSetOfLeptops() {
        Laptop laptop1 = new Laptop(1, 40123, 2000, 2_000_000, "Windows 10", "Asus", "Black");
        Laptop laptop2 = new Laptop(2, 35321, 3000, 1_000_000, "Linux", "Dell", "Grey");
        Laptop laptop3 = new Laptop(3, 37592, 2000, 1_000_000, "Windows 10", "HP", "White");
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop1); // убеждаемся, что эквивалентные экземпляры класса не попадут в множество
    }

    private static int userMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фильтр: \n" +
                "1. Цена\n" +
                "2. ОЗУ\n" +
                "3. Объем ЖД");
        int choice = scanner.nextInt();
        return choice;
    }

    private static Map<String, Integer> filter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимальное значение: ");
        int min = scanner.nextInt();
        System.out.println("Введите максимальное значение: ");
        int max = scanner.nextInt();
        Map<String, Integer> filter = new HashMap<>();
        filter.put("min", min);
        filter.put("max", max);
        return filter;
    }

    public static void printLaptopsWithFilter(int userChoice, Map<String, Integer> filter) {
        int counter = 0;
        if (userChoice == 1) {
            for (var item : laptops) {
                if (filter.get("min") <= item.price && item.price <= filter.get("max")) {
                    System.out.println(item);
                    counter++;
                }
            }
        } else if (userChoice == 2) {
            for (var item : laptops) {
                if (filter.get("min") <= item.ram && item.ram <= filter.get("max")) {
                    System.out.println(item);
                    counter++;
                }
            }
        } else if (userChoice == 3) {
            for (var item : laptops) {
                if (filter.get("min") <= item.hardDiscCapacity && item.hardDiscCapacity <= filter.get("max")) {
                    System.out.println(item);
                    counter++;
                }
            }
        } else{
            System.out.println("Вы ввели неверный вариант фильтрации. ");
        }
        if (counter == 0){
            System.out.println("Ноутбуки, удовлетворяющие введенные параметры, отсутствуют. ");
        }
    }

    public static void printAllLaptops() {
        System.out.println("Все ноутбуки: \n");
        for (var item : laptops) {
            System.out.println(item);
        }
    }

}