public class Laptop {
    public int id;
    public int price;
    public int ram;
    public int hardDiscCapacity;
    public String OS;
    public String company;
    public String color;

    public Laptop(int id, int price, int ram, int hardDiscCapacity, String OS, String company, String color) {
        this.id = id;
        this.price = price;
        this.ram = ram;
        this.hardDiscCapacity = hardDiscCapacity;
        this.OS = OS;
        this.company = company;
        this.color = color;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Laptop)
            return  ((Laptop)obj).price == (this.price) &&
                    ((Laptop)obj).ram == (this.ram) &&
                    ((Laptop)obj).hardDiscCapacity == (this.hardDiscCapacity) &&
                    ((Laptop)obj).OS.equals(this.OS) &&
                    ((Laptop)obj).company.equals(this.company) &&
                    ((Laptop)obj).color.equals(this.color);
        else return false;
    }
    public String toString() {
        return String.format("id: %s, price: %s, ram: %s, hardDiscCapacity: %s, OS: %s, " +
                "company: %s, color: %s. ",id, price, ram, hardDiscCapacity, OS, company, color);
    }

    @Override
    public int hashCode() {
        return id;
    }
}
