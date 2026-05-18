import java.util.ArrayList;
import java.util.Scanner;

class Product {
    public static int AUTO_ID = 1;

    public final String WAREHOUSE_CODE = "KHO-01";

    private int id;
    private String name;
    private double price;

    public Product() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public Product(String name, double price) {
        this.id = AUTO_ID;
        AUTO_ID++;
        this.name = name;
        this.price = price;
    }

    public void input(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        this.price = Double.parseDouble(scanner.nextLine());
    }

    public void print() {
        System.out.printf("[Kho: %s] ID: %d | Tên: %-15s | Giá: %,.2f\n",
                WAREHOUSE_CODE, this.id, this.name, this.price);
    }

    public double getPrice() {
        return this.price;
    }
}

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        int choice;

        do {
            // Hiển thị menu
            System.out.println("\n===== MENU SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. In danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm theo khoảng giá");
            System.out.println("4. Thống kê số sản phẩm đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÊM SẢN PHẨM ---");
                    Product p = new Product();
                    p.input(scanner);
                    productList.add(p);
                    System.out.println("=> Thêm sản phẩm thành công!");
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
                    if (productList.isEmpty()) {
                        System.out.println("Danh sách hiện đang trống.");
                    } else {
                        for (Product prod : productList) {
                            prod.print();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- TÌM KIẾM THEO KHOẢNG GIÁ ---");
                    System.out.print("Nhập mức giá TỐI THIỂU: ");
                    double minPrice = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập mức giá TỐI ĐA: ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());

                    boolean isFound = false;
                    System.out.println("Kết quả tìm kiếm:");
                    for (Product prod : productList) {
                        if (prod.getPrice() >= minPrice && prod.getPrice() <= maxPrice) {
                            prod.print();
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        System.out.println("Không tìm thấy sản phẩm nào phù hợp.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- THỐNG KÊ ---");
                    // Vì AUTO_ID khởi tạo từ 1 và tăng dần sau mỗi lần tạo object,
                    // số lượng sản phẩm thực tế đã khởi tạo là (AUTO_ID - 1)
                    int totalCreated = Product.AUTO_ID - 1;
                    System.out.println("Tổng số sản phẩm đã khởi tạo trên hệ thống: " + totalCreated);
                    break;

                case 0:
                    System.out.println("\nĐã thoát chương trình quản lý. Tạm biệt!");
                    break;

                default:
                    System.out.println("\nLựa chọn không hợp lệ! Vui lòng chọn từ 0-4.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}