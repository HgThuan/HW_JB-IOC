package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Staff> staffList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n=== HỆ THỐNG QUẢN LÝ TRUNG TÂM GIÁO DỤC ===");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Cập nhật thông tin theo ID");
            System.out.println("4. Xóa nhân viên theo ID");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng (1-5): ");

            int choice = getValidIntInput();

            switch (choice) {
                case 1: addStaff(); break;
                case 2: displayStaff(); break;
                case 3: updateStaff(); break;
                case 4: deleteStaff(); break;
                case 5:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
    }

    // 1. Thêm nhân viên
    private static void addStaff() {
        System.out.println("Chọn loại nhân viên: 1. Giảng viên  |  2. Hành chính");
        System.out.print("Lựa chọn: ");
        int type = getValidIntInput();

        if (type != 1 && type != 2) {
            System.out.println("Lựa chọn sai!");
            return;
        }

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();

        // Kiểm tra trùng ID
        if (findStaffById(id) != null) {
            System.out.println("Lỗi: ID này đã tồn tại!");
            return;
        }

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập lương cơ bản (VNĐ): ");
        double baseSalary = getValidDoubleInput();

        if (type == 1) {
            System.out.print("Nhập số giờ dạy: ");
            int teachingHours = getValidIntInput();
            staffList.add(new Lecturer(id, name, baseSalary, teachingHours));
            System.out.println("Đã thêm Giảng viên thành công!");
        } else {
            System.out.print("Nhập tiền thưởng (VNĐ): ");
            double bonus = getValidDoubleInput();
            staffList.add(new AdminStaff(id, name, baseSalary, bonus));
            System.out.println("Đã thêm Nhân viên hành chính thành công!");
        }
    }

    // 2. Hiển thị (Áp dụng Polymorphism)
    private static void displayStaff() {
        if (staffList.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\n--- DANH SÁCH NHÂN VIÊN ---");
        for (Staff staff : staffList) {
            System.out.println(staff.toString());
            staff.checkPerformance(); // Đa hình thời gian thực (Runtime Polymorphism)
            System.out.println("---------------------------");
        }
    }

    // 3. Cập nhật
    private static void updateStaff() {
        System.out.print("Nhập ID nhân viên cần cập nhật: ");
        String id = scanner.nextLine();
        Staff staff = findStaffById(id);

        if (staff == null) {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
            return;
        }

        System.out.print("Nhập tên mới (Bỏ trống để giữ nguyên): ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) {
            staff.setName(name);
        }

        System.out.print("Nhập lương cơ bản mới (-1 để giữ nguyên): ");
        double baseSalary = getValidDoubleInput();
        if (baseSalary != -1) {
            staff.setBaseSalary(baseSalary);
        }

        // Kiểm tra kiểu nhân viên để cập nhật thuộc tính riêng (Sử dụng instanceof)
        if (staff instanceof Lecturer) {
            Lecturer lec = (Lecturer) staff;
            System.out.print("Nhập số giờ dạy mới (-1 để giữ nguyên): ");
            int hours = getValidIntInput();
            if (hours != -1) lec.setTeachingHours(hours);

        } else if (staff instanceof AdminStaff) {
            AdminStaff admin = (AdminStaff) staff;
            System.out.print("Nhập tiền thưởng mới (-1 để giữ nguyên): ");
            double bonus = getValidDoubleInput();
            if (bonus != -1) admin.setBonus(bonus);
        }
        System.out.println("Cập nhật thành công!");
    }

    // 4. Xóa
    private static void deleteStaff() {
        System.out.print("Nhập ID nhân viên cần xóa: ");
        String id = scanner.nextLine();
        Staff staff = findStaffById(id);

        if (staff != null) {
            staffList.remove(staff);
            System.out.println("Đã xóa nhân viên ID " + id + " thành công!");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID: " + id);
        }
    }

    // Helper: Tìm kiếm nhân viên theo ID
    private static Staff findStaffById(String id) {
        for (Staff s : staffList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // Helper: Bắt lỗi nhập số nguyên (Int)
    private static int getValidIntInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Định dạng sai! Vui lòng nhập một số nguyên: ");
            }
        }
    }

    // Helper: Bắt lỗi nhập số thực (Double)
    private static double getValidDoubleInput() {
        while (true) {
            try {
                double input = Double.parseDouble(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Định dạng sai! Vui lòng nhập một số hợp lệ: ");
            }
        }
    }
}