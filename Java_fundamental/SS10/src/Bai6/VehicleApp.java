package Bai6;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        // Khởi tạo sẵn các đối tượng phương tiện
        vehicles.add(new Car("Toyota", 2020, "Gasoline"));
        vehicles.add(new Motorcycle("Honda", 2018, "Gasoline"));
        vehicles.add(new Truck("Volvo", 2022, "Diesel"));

        int choice;
        do {
            System.out.println("\n========= VEHICLE MANAGEMENT MENU =========");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra Overriding: startEngine()");
            System.out.println("3. Kiểm tra Overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime (Vehicle array/list)");
            System.out.println("5. Gọi hành vi đặc trưng của từng loại");
            System.out.println("6. Thêm phương tiện mới");
            System.out.println("0. Thoát");
            System.out.println("===========================================");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÔNG TIN PHƯƠNG TIỆN ---");
                    for (Vehicle v : vehicles) {
                        v.showInfo();
                        System.out.println("-------------------------");
                    }
                    break;

                case 2:
                    System.out.println("\n--- OVERRIDING: startEngine() ---");
                    for (Vehicle v : vehicles) {
                        v.startEngine(); // Gọi hàm đã được Override ở lớp con
                    }
                    break;

                case 3:
                    System.out.println("\n--- OVERLOADING: move() ---");
                    if (!vehicles.isEmpty()) {
                        Vehicle firstVehicle = vehicles.get(0);
                        firstVehicle.move();           // Gọi bản move() không tham số
                        firstVehicle.move(80);         // Gọi bản move() có tham số speed
                    }
                    break;

                case 4:
                    System.out.println("\n--- POLYMORPHISM RUNTIME ---");
                    for (Vehicle v : vehicles) {
                        v.startEngine(); // Tính đa hình: Tự động gọi đúng phương thức của đối tượng thực tế
                    }
                    break;

                case 5:
                    System.out.println("\n--- HÀNH VI ĐẶC TRƯNG CỦA TỪNG LOẠI ---");
                    for (Vehicle v : vehicles) {
                        // Sử dụng instanceof để ép kiểu (Downcasting) an toàn
                        if (v instanceof Car) {
                            ((Car) v).openTrunk();
                        } else if (v instanceof Motorcycle) {
                            ((Motorcycle) v).doWheelie();
                        } else if (v instanceof Truck) {
                            ((Truck) v).loadCargo();
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n--- THÊM PHƯƠNG TIỆN MỚI ---");
                    System.out.print("Loại (car/motorcycle/truck): ");
                    String type = scanner.nextLine().toLowerCase();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Fuel Type: ");
                    String fuel = scanner.nextLine();

                    switch (type) {
                        case "car":
                            vehicles.add(new Car(brand, year, fuel));
                            break;
                        case "motorcycle":
                            vehicles.add(new Motorcycle(brand, year, fuel));
                            break;
                        case "truck":
                            vehicles.add(new Truck(brand, year, fuel));
                            break;
                        default:
                            System.out.println("Loại phương tiện không hợp lệ!");
                    }
                    break;

                case 0:
                    System.out.println("\nThoát chương trình...");
                    break;

                default:
                    System.out.println("\nLựa chọn không hợp lệ, vui lòng thử lại!");
            }
        } while (choice != 0);

        scanner.close();
    }
}