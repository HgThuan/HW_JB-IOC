package Bai3;

public abstract class Drink implements IPromotion {
    private String id;
    private String name;
    private double price;

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getter và Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Phương thức trừu tượng
    public abstract void prepare();

    // Triển khai Interface IPromotion
    @Override
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            this.price -= this.price * (percentage / 100);
        }
    }

    public void displayInfo() {
        System.out.printf("Mã: %s | Tên: %s | Giá: %,.0f VNĐ\n", id, name, price);
    }
}