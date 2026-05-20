package Bai6.ra.entity;
import java.util.Scanner;
public class Product {
    private String productId;
    private String productName;
    private double price;
    private ProductStatus status;

    public Product() {
    }

    public Product(String productId, String productName, double price, ProductStatus status) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }

    public void inputData(Scanner scanner, Product[] arrProd, int index) {
        // Nhập và Validate Mã sản phẩm
        while (true) {
            System.out.print("Nhập mã sản phẩm (Cxxx, Sxxx, Axxx): ");
            this.productId = scanner.nextLine();
            if (this.productId.matches("^[CSA]\\d{3}$")) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrProd[i].getProductId().equals(this.productId)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) break;
                else System.out.println("Mã sản phẩm đã tồn tại!");
            } else {
                System.out.println("Mã sản phẩm không đúng định dạng!");
            }
        }

        // Nhập và Validate Tên sản phẩm
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            this.productName = scanner.nextLine();
            if (this.productName.length() >= 10 && this.productName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrProd[i].getProductName().equalsIgnoreCase(this.productName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) break;
                else System.out.println("Tên sản phẩm đã tồn tại!");
            } else {
                System.out.println("Tên sản phẩm phải từ 10 đến 50 ký tự!");
            }
        }

        // Nhập và Validate Giá
        while (true) {
            System.out.print("Nhập giá sản phẩm (> 0): ");
            try {
                this.price = Double.parseDouble(scanner.nextLine());
                if (this.price > 0) break;
                else System.out.println("Giá sản phẩm phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        // Nhập trạng thái
        System.out.println("Chọn trạng thái (1: AVAILABLE, 2: OUT_OF_STOCK, 3: STOP_SELLING): ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 2: this.status = ProductStatus.OUT_OF_STOCK; break;
            case 3: this.status = ProductStatus.STOP_SELLING; break;
            default: this.status = ProductStatus.AVAILABLE; break;
        }
    }

    public void displayData() {
        System.out.printf("Mã SP: %s | Tên SP: %s | Giá: %.2f | Trạng thái: %s\n",
                this.productId, this.productName, this.price, this.status);
    }
}
