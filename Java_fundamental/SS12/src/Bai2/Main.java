package Bai2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Asset> assetList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== QUẢN LÝ TÀI SẢN CÔNG TY ===");
            System.out.println("1. Nhập tài sản mới");
            System.out.println("2. Xuất báo cáo tài sản");
            System.out.println("3. Tìm kiếm theo Mã (Asset Code)");
            System.out.println("4. Tìm kiếm theo Giá mua tối thiểu");
            System.out.println("5. Sửa giá mua tài sản");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = getValidIntInput();

            switch (choice) {
                case 1: inputAsset(); break;
                case 2: generateReport(); break;
                case 3:
                    System.out.print("Nhập mã tài sản cần tìm: ");
                    searchAsset(scanner.nextLine()); // Overloading theo String
                    break;
                case 4:
                    System.out.print("Nhập mức giá mua thấp nhất: ");
                    searchAsset(getValidDoubleInput()); // Overloading theo double
                    break;
                case 5: updatePrice(); break;
                case 6:
                    System.out.println("Đã thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // Tính Đa hình (Polymorphism): Nhận vào mọi đối tượng thuộc họ Asset
    public static void showValue(Asset a) {
        System.out.println(a.toString());
        System.out.printf("=> Giá trị hiện tại (Sau khấu hao): %,.0f VNĐ\n", a.getMarketValue());
        System.out.println("-".repeat(50));
    }

    // Method Overloading 1: Tìm theo Mã (String)
    public static void searchAsset(String assetCode) {
        boolean found = false;
        System.out.println("\n--- KẾT QUẢ TÌM KIẾM THEO MÃ ---");
        for (Asset a : assetList) {
            if (a.getAssetCode().equalsIgnoreCase(assetCode)) {
                showValue(a);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Không tìm thấy tài sản mã: " + assetCode);
    }

    // Method Overloading 2: Tìm theo Giá (double)
    public static void searchAsset(double minPrice) {
        boolean found = false;
        System.out.printf("\n--- KẾT QUẢ TÌM KIẾM THEO GIÁ ( Lớn hơn %,.0f ) ---\n", minPrice);
        for (Asset a : assetList) {
            if (a.getPurchasePrice() > minPrice) {
                showValue(a);
                found = true;
            }
        }
        if (!found) System.out.println("Không có tài sản nào lớn hơn mức giá này.");
    }

    private static void inputAsset() {
        System.out.println("Chọn loại: 1. Máy Tính  |  2. Thiết Bị Mạng");
        int type = getValidIntInput();
        if (type != 1 && type != 2) {
            System.out.println("Lựa chọn sai!"); return;
        }

        System.out.print("Nhập Mã tài sản: "); String code = scanner.nextLine();
        System.out.print("Nhập Tên tài sản: "); String name = scanner.nextLine();
        System.out.print("Nhập Giá mua gốc (VNĐ): "); double price = getValidDoubleInput();
        System.out.print("Nhập Số năm đã sử dụng: "); int years = getValidIntInput();

        if (type == 1) {
            System.out.print("Dung lượng RAM (GB): "); int ram = getValidIntInput();
            System.out.print("Tên CPU: "); String cpu = scanner.nextLine();
            assetList.add(new Computer(code, name, price, years, ram, cpu));
        } else {
            System.out.print("Số cổng (Ports): "); int ports = getValidIntInput();
            assetList.add(new NetworkDevice(code, name, price, years, ports));
        }
        System.out.println("Thêm mới thành công!");
    }

    private static void generateReport() {
        if (assetList.isEmpty()) {
            System.out.println("Danh sách tài sản đang trống."); return;
        }
        System.out.println("\n--- BÁO CÁO TÀI SẢN ---");
        for (Asset a : assetList) {
            showValue(a); // Gọi hàm thể hiện tính đa hình
        }
    }

    private static void updatePrice() {
        System.out.print("Nhập mã tài sản cần sửa giá: ");
        String code = scanner.nextLine();
        for (Asset a : assetList) {
            if (a.getAssetCode().equalsIgnoreCase(code)) {
                System.out.printf("Giá cũ đang là: %,.0f VNĐ\n", a.getPurchasePrice());
                System.out.print("Nhập giá mới (VNĐ): ");
                a.setPurchasePrice(getValidDoubleInput());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy mã tài sản này.");
    }

    // --- Helpers xử lý lỗi ---
    private static int getValidIntInput() {
        while (true) {
            try { return Integer.parseInt(scanner.nextLine()); }
            catch (Exception e) { System.out.print("Nhập sai! Hãy nhập số nguyên: "); }
        }
    }

    private static double getValidDoubleInput() {
        while (true) {
            try { return Double.parseDouble(scanner.nextLine()); }
            catch (Exception e) { System.out.print("Nhập sai! Hãy nhập số: "); }
        }
    }
}