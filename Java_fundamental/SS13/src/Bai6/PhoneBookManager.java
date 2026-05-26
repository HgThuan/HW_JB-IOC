package Bai6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookManager {
    public static void main(String[] args) {
        // Cấu trúc lưu trữ Set
        Set<Contact> phoneBook = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ DANH BẠ =====");
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc theo số điện thoại");
            System.out.println("3. Tìm kiếm liên lạc theo số điện thoại");
            System.out.println("4. Hiển thị danh bạ");
            System.out.println("0. Thoát");
            System.out.print("Vui lòng chọn chức năng (0-4): ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Bỏ qua ký tự Enter thừa

            switch (choice) {
                case 1: // Thêm liên lạc
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();

                    Contact newContact = new Contact(name, phone);

                    // Hàm add() của Set trả về false nếu phần tử đã tồn tại
                    if (phoneBook.add(newContact)) {
                        System.out.println("=> Thêm thành công!");
                    } else {
                        System.out.println("=> Số điện thoại đã tồn tại trong danh bạ!");
                    }
                    break;

                case 2: // Xóa liên lạc
                    System.out.print("Nhập số điện thoại cần xóa: ");
                    String phoneToRemove = scanner.nextLine();

                    // Tạo đối tượng ảo chỉ chứa số điện thoại
                    Contact dummyToRemove = new Contact(phoneToRemove);

                    // Hàm remove() tự động dùng equals() để tìm và xóa
                    if (phoneBook.remove(dummyToRemove)) {
                        System.out.println("=> Đã xóa thành công!");
                    } else {
                        System.out.println("=> Không tìm thấy liên lạc!");
                    }
                    break;

                case 3: // Tìm kiếm liên lạc
                    System.out.print("Nhập số điện thoại cần tìm: ");
                    String phoneToSearch = scanner.nextLine();

                    Contact dummyToSearch = new Contact(phoneToSearch);

                    // Kiểm tra tồn tại bằng contains()
                    if (phoneBook.contains(dummyToSearch)) {
                        System.out.println("=> Đã tìm thấy liên lạc:");
                        // Vì Set không có hàm get() như List, ta phải duyệt để lấy ra thông tin đầy đủ
                        for (Contact c : phoneBook) {
                            if (c.equals(dummyToSearch)) {
                                System.out.println(c.toString());
                                break;
                            }
                        }
                    } else {
                        System.out.println("=> Không tồn tại liên lạc!");
                    }
                    break;

                case 4: // Hiển thị danh bạ
                    System.out.println("\n--- DANH SÁCH LIÊN LẠC ---");
                    if (phoneBook.isEmpty()) {
                        System.out.println("Danh bạ hiện đang trống.");
                    } else {
                        for (Contact c : phoneBook) {
                            System.out.println(c.toString());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Đang thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        } while (choice != 0);

        scanner.close();
    }
}
