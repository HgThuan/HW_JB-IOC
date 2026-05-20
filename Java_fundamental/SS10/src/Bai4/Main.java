package Bai4;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Car
        Car myCar = new Car();

        // Gọi phiên bản overloading 1: Không truyền tham số
        myCar.accelerate();
        myCar.printStatus();

        // Gọi phiên bản overloading 2: Truyền vào 1 tham số (tốc độ)
        myCar.accelerate(20);
        myCar.printStatus();

        // Gọi phiên bản overloading 3: Truyền vào 2 tham số (tốc độ, thời gian)
        // Để tăng thêm 20 km/h như trong hình, ta có thể truyền (10, 2) hoặc (20, 1)
        myCar.accelerate(10, 2);
        myCar.printStatus();
    }
}