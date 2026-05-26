package Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvoiceManager manager = new InvoiceManager();
        int choice = 0;

        while (true) {
            System.out.println("\n**************** MENU QUẢN LÝ HÓA ĐƠN ****************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn:");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            if (choice == 5) {
                System.out.println("Chương trình kết thúc!");
                break;
            }

            switch (choice) {
                case 1: // Thêm hóa đơn
                    String invoiceId = "";
                    while (true) {
                        System.out.println("Nhập mã hóa đơn:");
                        invoiceId = scanner.nextLine().trim();
                        if (invoiceId.isEmpty()) {
                            System.out.println("Vui lòng không để trống mã hóa đơn!");
                        } else {
                            break;
                        }
                    }

                    double amount = 0;
                    System.out.println("Nhập số tiền:");
                    try {
                        amount = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Số tiền không hợp lệ, mặc định đặt là 0.");
                    }

                    manager.add(new Invoice(invoiceId, amount));
                    break;

                case 2: // Sửa hóa đơn
                    manager.display();
                    System.out.println("Nhập mã hóa đơn cần sửa:");
                    String updateId = scanner.nextLine().trim();

                    int updateIndex = manager.findIndexById(updateId);
                    if (updateIndex != -1) {
                        System.out.println("Nhập số tiền mới:");
                        double newAmount = 0;
                        try {
                            newAmount = Double.parseDouble(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Số tiền không hợp lệ, giữ nguyên số tiền cũ.");
                            newAmount = manager.getInvoice(updateIndex).getAmount();
                        }

                        // Cập nhật lại hóa đơn (giữ nguyên mã hóa đơn)
                        String oldId = manager.getInvoice(updateIndex).getInvoiceId();
                        manager.update(updateIndex, new Invoice(oldId, newAmount));
                    } else {
                        System.out.println("Không tìm thấy hóa đơn có mã: " + updateId);
                    }
                    break;

                case 3: // Xóa hóa đơn
                    manager.display();
                    System.out.println("Nhập mã hóa đơn cần xóa:");
                    String deleteId = scanner.nextLine().trim();

                    int deleteIndex = manager.findIndexById(deleteId);
                    if (deleteIndex != -1) {
                        manager.delete(deleteIndex);
                    } else {
                        System.out.println("Không tìm thấy hóa đơn có mã: " + deleteId);
                    }
                    break;

                case 4: // Hiển thị danh sách
                    manager.display();
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1-5.");
                    break;
            }
        }
        scanner.close();
    }
}
