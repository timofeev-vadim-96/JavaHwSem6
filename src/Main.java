import java.util.*;

public class Main {
    public static Set<Laptop> laptops = new HashSet<>();

    public static void main(String[] args) {
        createSetOfLeptops();
        printAllLaptops();
        printLaptopsWithFilter(userMenu(), filter());
    }

    private static void createSetOfLeptops() {
        Laptop laptop1 = new Laptop(40123, 2000, 2_000_000, "Windows 10", "Asus", "Black");
        Laptop laptop2 = new Laptop(35321, 3000, 1_000_000, "Linux", "Dell", "Grey");
        Laptop laptop3 = new Laptop(37592, 2000, 1_000_000, "Windows 10", "HP", "White");
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
    }

    private static int userMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фильтр: \n" +
                "1. Цена\n" +
                "2. ОЗУ\n" +
                "3. Объем ЖД");
        int choice = scanner.nextInt();
        if (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Вы ввели не верный вариант фильтрации...");
            return choice;
        }
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
        if (userChoice == 1) {
            for (var item : laptops) {
                if (filter.get("min") <= item.price && item.price <= filter.get("max")) {
                    System.out.println(item);
                }
            }
        } else if (userChoice == 2) {
            for (var item : laptops) {
                if (filter.get("min") <= item.ram && item.ram <= filter.get("max")) {
                    System.out.println(item);
                }
            }
        } else if (userChoice == 3) {
            for (var item : laptops) {
                if (filter.get("min") <= item.hardDiscCapacity && item.hardDiscCapacity <= filter.get("max")) {
                    System.out.println(item);
                }
            }
        }
    }

    public static void printAllLaptops() {
        System.out.println("Все ноутбуки: \n");
        for (var item : laptops) {
            System.out.println(item);
        }
    }

}