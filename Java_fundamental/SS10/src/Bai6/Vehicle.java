package Bai6;

public class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void showInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }

    public void startEngine() {
        System.out.println(brand + " engine is starting...");
    }

    // Overloading: Phương thức move()
    public void move() {
        System.out.println(brand + " is moving.");
    }

    public void move(int speed) {
        System.out.println(brand + " is moving at " + speed + " km/h.");
    }
}