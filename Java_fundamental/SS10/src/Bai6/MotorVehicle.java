package Bai6;

public class MotorVehicle extends Vehicle {
    protected String fuelType;

    public MotorVehicle(String brand, int year, String fuelType) {
        super(brand, year); // Gọi constructor của lớp cha
        this.fuelType = fuelType;
    }

    // Overriding: Ghi đè phương thức showInfo()
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Fuel Type: " + fuelType);
    }
}