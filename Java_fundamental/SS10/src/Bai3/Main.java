package Bai3;

class Computer {

    // Phiên bản 1: Chỉ tính theo giá gốc
    public double calculatePrice(double basePrice) {
        System.out.println("[Using basePrice only]");
        return basePrice;
    }

    // Phiên bản 2: Tính theo giá gốc + thuế (VAT)
    public double calculatePrice(double basePrice, double tax) {
        System.out.println("[Using basePrice + tax]");
        return basePrice + tax;
    }

    // Phiên bản 3: Tính theo giá gốc + thuế + giảm giá (discount)
    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("[Using basePrice + tax + discount]");
        return basePrice + tax - discount;
    }
}

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Computer
        Computer computer = new Computer();

        // 1. Gọi phiên bản chỉ có giá gốc
        double finalPrice1 = computer.calculatePrice(1000.0);
        System.out.println("Final Price = " + finalPrice1);
        System.out.println(); // In dòng trống để giống với kết quả mong muốn

        // 2. Gọi phiên bản có giá gốc + thuế (Giả sử thuế là 100.0)
        double finalPrice2 = computer.calculatePrice(1000.0, 100.0);
        System.out.println("Final Price = " + finalPrice2);
        System.out.println();

        // 3. Gọi phiên bản có giá gốc + thuế + giảm giá (Giả sử giảm giá là 50.0)
        double finalPrice3 = computer.calculatePrice(1000.0, 100.0, 50.0);
        System.out.println("Final Price = " + finalPrice3);
        System.out.println();
    }
}