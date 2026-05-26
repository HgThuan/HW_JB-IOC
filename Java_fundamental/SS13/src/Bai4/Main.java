package Bai4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager manager = new OrderManager();
        int choice = 0;

        while (true) {
            System.out.println("\n**************** MENU QUẢN LÝ ĐƠN HÀNG ****************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn:");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }

            if (choice == 5) {
                break;
            }

            switch (choice) {
                case 1:
                    String orderId = "";
                    while (true) {
                        System.out.println("Nhập mã đơn hàng:");
                        orderId = scanner.nextLine().trim();
                        if (orderId.isEmpty()) {
                            System.out.println("\nVui lòng ko để trống !");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Nhập tên khách hàng:");
                    String customerName = scanner.nextLine().trim();

                    manager.add(new Order(orderId, customerName));
                    break;

                case 2:
                    manager.display();
                    System.out.println("Nhập mã đơn hàng cần sửa:");
                    String updateId = scanner.nextLine().trim();

                    int updateIndex = manager.findIndexById(updateId);
                    if (updateIndex != -1) {
                        System.out.println("Nhập tên khách hàng mới:");
                        String newName = scanner.nextLine().trim();

                        // Lấy lại mã đơn hàng cũ để giữ nguyên case (chữ hoa/chữ thường)
                        String oldId = manager.getOrder(updateIndex).getOrderId();
                        manager.update(updateIndex, new Order(oldId, newName));
                    } else {
                        System.out.println("Không tìm thấy đơn hàng có mã: " + updateId);
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.println("Nhập mã đơn hàng cần xóa:");
                    String deleteId = scanner.nextLine().trim();

                    int deleteIndex = manager.findIndexById(deleteId);
                    if (deleteIndex != -1) {
                        manager.delete(deleteIndex);
                    } else {
                        System.out.println("Không tìm thấy đơn hàng có mã: " + deleteId);
                    }
                    break;

                case 4:
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