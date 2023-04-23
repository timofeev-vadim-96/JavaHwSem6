import java.util.HashSet;
import java.util.Set;

public class Main {
    public static Set<Object> laptops = new HashSet<>();
    public static void main(String[] args) {
        createSetOfLeptops();
        System.out.println(laptops);
        System.out.println(laptops.size());
    }

    public static void createSetOfLeptops() {
        Laptop laptop1 = new Laptop(40123, 2000, 2_000_000, "Windows 10", "Asus", "Black");
        Laptop laptop2 = new Laptop(40123, 2000, 2_000_000, "Windows 10", "Asus", "Black");
        laptops.add(laptop1);
        laptops.add(laptop2);
        System.out.println(laptop1.equals(laptop2));
    }

}