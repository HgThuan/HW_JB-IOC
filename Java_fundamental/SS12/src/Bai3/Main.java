package Bai3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Drink> menu = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== PHẦN MỀM QUẢN LÝ QUÁN CÀ PHÊ ===");
            System.out.println("1. Thêm món vào Menu");
            System.out.println("2. Hiển thị Menu");
            System.out.println("3. Áp dụng mã giảm giá toàn Menu");
            System.out.println("4. Xóa món khỏi Menu");
            System.out.println("5. Thống kê giá trung bình");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = getValidIntInput();

            switch (choice) {
                case 1: addDrink(); break;
                case 2: displayMenu(); break;
                case 3: applyDiscountAll(); break;
                case 4: deleteDrink(); break;
                case 5: calculateAveragePrice(); break;
                case 6:
                    System.out.println("Đã thoát phần mềm. Chúc bạn một ngày tốt lành!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
    }

    // 1. Thêm món
    private static void addDrink() {
        System.out.println("Chọn loại đồ uống: 1. Cà phê  |  2. Trà trái cây");
        int type = getValidIntInput();
        if (type != 1 && type != 2) {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        // Kiểm tra trùng lặp ID
        for (Drink d : menu) {
            if (d.getId().equalsIgnoreCase(id)) {
                System.out.println("Lỗi: ID này đã tồn tại trong Menu.");
                return;
            }
        }

        System.out.print("Nhập Tên món: ");
        String name = scanner.nextLine();
        System.out.print("Nhập Giá (VNĐ): ");
        double price = getValidDoubleInput();

        if (type == 1) {
            menu.add(new Coffee(id, name, price));
        } else {
            menu.add(new FruitTea(id, name, price));
        }
        System.out.println("Thêm món thành công!");
    }

    // 2. Hiển thị Menu
    private static void displayMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu hiện đang trống.");
            return;
        }
        System.out.println("\n--- MENU ĐỒ UỐNG ---");
        for (Drink drink : menu) {
            drink.displayInfo(); // Thông tin đóng gói
            drink.prepare();     // Đa hình thời gian thực (In ra cách pha chế)
            System.out.println("-".repeat(30));
        }
    }

    // 3. Áp dụng giảm giá
    private static void applyDiscountAll() {
        if (menu.isEmpty()) {
            System.out.println("Menu trống, không thể áp dụng giảm giá.");
            return;
        }
        System.out.print("Nhập phần trăm giảm giá (Ví dụ: 10 cho 10%): ");
        double percentage = getValidDoubleInput();

        for (Drink drink : menu) {
            drink.applyDiscount(percentage);
        }
        System.out.println("Đã áp dụng giảm giá " + percentage + "% cho toàn bộ Menu!");
    }

    // 4. Xóa món
    private static void deleteDrink() {
        System.out.print("Nhập ID món cần xóa: ");
        String id = scanner.nextLine();

        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getId().equalsIgnoreCase(id)) {
                menu.remove(i); // ArrayList tự động dồn phần tử sau khi xóa
                System.out.println("Đã xóa món ăn thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy món nào có ID: " + id);
    }

    // 5. Thống kê
    private static void calculateAveragePrice() {
        if (menu.isEmpty()) {
            System.out.println("Menu trống, không thể tính thống kê.");
            return;
        }

        double totalPrice = 0;
        for (Drink drink : menu) {
            // Truy xuất giá bằng Getter do thuộc tính price là private
            totalPrice += drink.getPrice();
        }

        double avgPrice = totalPrice / menu.size();
        System.out.printf("Giá trị trung bình của các món trong Menu là: %,.0f VNĐ\n", avgPrice);
    }

    // Helper: Nhập số nguyên
    private static int getValidIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Lỗi định dạng. Vui lòng nhập số nguyên: ");
            }
        }
    }

    // Helper: Nhập số thực
    private static double getValidDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Lỗi định dạng. Vui lòng nhập số: ");
            }
        }
    }
}