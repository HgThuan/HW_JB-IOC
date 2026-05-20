package Bai6.ra.presentation;

import Bai6.ra.entity.Invoice;
import Bai6.ra.entity.Product;
import java.util.Scanner;

public class InvoiceManagement {
    static Product[] arrProd = new Product[100];
    static int prodIndex = 0;
    static Invoice[] arrInvoice = new Invoice[100];
    static int invoiceIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n================= QUẢN LÝ HÓA ĐƠN =================");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý hóa đơn");
            System.out.println("3. Báo cáo doanh thu");
            System.out.println("4. Thoát");
            System.out.println("===================================================");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: productMenu(scanner); break;
                case 2: invoiceMenu(scanner); break;
                case 3: reportMenu(scanner); break;
                case 4: System.exit(0);
                default: System.out.println("Vui lòng chọn từ 1-4.");
            }
        }
    }

    public static void productMenu(Scanner scanner) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n================ QUẢN LÝ SẢN PHẨM =================");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm (nếu chưa có trong hóa đơn nào)");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Thoát");
            System.out.println("===================================================");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Product p = new Product();
                    p.inputData(scanner, arrProd, prodIndex);
                    arrProd[prodIndex++] = p;
                    System.out.println("Thêm thành công!");
                    break;
                case 2:
                    for (int i = 0; i < prodIndex; i++) arrProd[i].displayData();
                    break;
                case 3:
                    // Logic cập nhật sản phẩm
                    System.out.println("Chức năng đang hoàn thiện...");
                    break;
                case 4:
                    // Logic xóa sản phẩm
                    System.out.println("Chức năng đang hoàn thiện...");
                    break;
                case 5:
                    // Logic tìm kiếm sản phẩm
                    System.out.println("Chức năng đang hoàn thiện...");
                    break;
                case 6:
                    isExit = true;
                    break;
                default: System.out.println("Vui lòng chọn từ 1-6.");
            }
        }
    }

    public static void invoiceMenu(Scanner scanner) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n================= QUẢN LÝ HÓA ĐƠN =================");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Cập nhật thông tin hóa đơn");
            System.out.println("4. Xóa hóa đơn");
            System.out.println("5. Tìm hóa đơn theo mã");
            System.out.println("6. Tìm hóa đơn theo tên khách hàng");
            System.out.println("7. Thoát");
            System.out.println("===================================================");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    if (prodIndex == 0) {
                        System.out.println("Chưa có sản phẩm nào. Vui lòng thêm sản phẩm trước!");
                        break;
                    }
                    Invoice inv = new Invoice();
                    inv.inputData(scanner, arrProd, prodIndex);
                    arrInvoice[invoiceIndex++] = inv;
                    System.out.println("Thêm hóa đơn thành công!");
                    break;
                case 2:
                    for (int i = 0; i < invoiceIndex; i++) arrInvoice[i].displayData();
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    System.out.println("Chức năng đang hoàn thiện...");
                    break;
                case 7:
                    isExit = true;
                    break;
                default: System.out.println("Vui lòng chọn từ 1-7.");
            }
        }
    }

    public static void reportMenu(Scanner scanner) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n================ QUẢN LÝ DOANH THU ================");
            System.out.println("1. Tính tổng doanh thu tất cả hóa đơn");
            System.out.println("2. Tìm hóa đơn có giá trị lớn nhất");
            System.out.println("3. Thống kê số hóa đơn theo khoảng ngày (nhập từ – đến)");
            System.out.println("4. Thống kê tổng doanh thu theo khoảng ngày");
            System.out.println("5. Thoát");
            System.out.println("===================================================");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    double totalRevenue = 0;
                    for (int i = 0; i < invoiceIndex; i++) {
                        totalRevenue += arrInvoice[i].getTotalAmount();
                    }
                    System.out.printf("Tổng doanh thu tất cả hóa đơn: %.2f\n", totalRevenue);
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("Chức năng đang hoàn thiện...");
                    break;
                case 5:
                    isExit = true;
                    break;
                default: System.out.println("Vui lòng chọn từ 1-5.");
            }
        }
    }
}