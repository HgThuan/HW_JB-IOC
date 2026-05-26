package Bai5;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n================ MENU ================");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("0. Thoát chương trình");
            System.out.println("======================================");
            System.out.print("Lựa chọn của bạn: ");

            // Bắt lỗi nếu người dùng nhập không phải là số (tùy chọn nâng cao, ở đây dùng cơ bản)
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm (dấu Enter thừa) sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên muốn thêm: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Xóa bộ đệm

                    for (int i = 0; i < n; i++) {
                        System.out.println("-> Nhập thông tin sinh viên thứ " + (i + 1) + ":");
                        System.out.print("Họ và tên: ");
                        String name = scanner.nextLine();
                        System.out.print("GPA: ");
                        double gpa = scanner.nextDouble();
                        scanner.nextLine(); // Xóa bộ đệm

                        studentList.add(new Student(name, gpa));
                    }
                    System.out.println("=> Đã nhập danh sách thành công!");
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
                    if (studentList.isEmpty()) {
                        System.out.println("Danh sách hiện đang trống!");
                    } else {
                        for (Student s : studentList) {
                            System.out.println(s.toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String searchName = scanner.nextLine().toLowerCase(); // Chuyển về chữ thường để dễ tìm
                    boolean isFound = false;

                    System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                    for (Student s : studentList) {
                        // So sánh chuỗi có chứa từ khóa (bỏ qua hoa/thường)
                        if (s.getName().toLowerCase().contains(searchName)) {
                            System.out.println(s.toString());
                            isFound = true;
                        }
                    }

                    if (!isFound) {
                        System.out.println("Không tìm thấy sinh viên nào phù hợp với tên: " + searchName);
                    }
                    break;

                case 4:
                    System.out.println("\n--- PHÂN LOẠI SINH VIÊN THEO GPA ---");
                    if (studentList.isEmpty()) {
                        System.out.println("Danh sách trống, không thể phân loại.");
                    } else {
                        for (Student s : studentList) {
                            String rank;
                            double gpa = s.getGpa();

                            // Phân loại theo quy tắc đề bài
                            if (gpa >= 8.5) {
                                rank = "Xuất sắc";
                            } else if (gpa >= 7.0) {
                                rank = "Giỏi";
                            } else if (gpa >= 5.5) {
                                rank = "Khá";
                            } else {
                                rank = "Trung bình / Yếu";
                            }

                            // In ra màn hình thông tin kèm theo xếp loại
                            System.out.println(s.toString() + " | Xếp loại: " + rank);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 0 đến 4.");
            }
        } while (choice != 0);

        scanner.close(); // Đóng luồng nhập
    }
}