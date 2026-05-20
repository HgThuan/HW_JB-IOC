package Bai6.ra.entity;

import java.util.Scanner;

public class InvoiceDetail {
    private Product product;
    private int quantity;
    private double subTotal;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subTotal = product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getSubTotal() { return subTotal; }
    public void setSubTotal(double subTotal) { this.subTotal = subTotal; }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        System.out.println("Danh sách sản phẩm có sẵn:");
        for (int i = 0; i < prodIndex; i++) {
            System.out.printf("%d. %s (Giá: %.2f)\n", (i + 1), arrProd[i].getProductName(), arrProd[i].getPrice());
        }

        while (true) {
            System.out.print("Chọn số thứ tự sản phẩm để mua: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= prodIndex) {
                this.product = arrProd[choice - 1];
                break;
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }

        while (true) {
            System.out.print("Nhập số lượng mua (> 0): ");
            this.quantity = Integer.parseInt(scanner.nextLine());
            if (this.quantity > 0) {
                this.subTotal = this.product.getPrice() * this.quantity;
                break;
            } else {
                System.out.println("Số lượng phải lớn hơn 0!");
            }
        }
    }

    public void displayData() {
        System.out.printf("Sản phẩm: %s | Số lượng: %d | Thành tiền: %.2f\n",
                product.getProductName(), quantity, subTotal);
    }
}
