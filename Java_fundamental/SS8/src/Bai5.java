import java.util.ArrayList;
import java.util.Scanner;

// Lớp Student quản lý thông tin sinh viên
class Student {
    // 1. Thuộc tính private (Đảm bảo tính đóng gói - Encapsulation)
    private int id;
    private String name;
    private double gpa;

    // 2. Thuộc tính static: Dùng chung cho tất cả đối tượng để đếm số lượng sinh viên
    private static int countStudent = 0;

    // 3. Thuộc tính final: Hằng số hệ số điểm
    public final double SCORE_FACTOR = 0.25;

    // 4. Constructor không tham số
    public Student() {
        countStudent++; // Tăng biến đếm mỗi khi khởi tạo đối tượng mới
    }

    // 5. Constructor có 3 tham số
    public Student(int id, String name, double gpa) {
        // Dùng this() để gọi constructor không tham số nhằm tăng countStudent
        this();

        // Dùng this.thuoc_tinh để phân biệt với tham số truyền vào
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Phương thức nhập thông tin
    public void input(Scanner scanner) {
        System.out.print("Nhập mã sinh viên (ID): ");
        this.id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập họ tên: ");
        this.name = scanner.nextLine();

        System.out.print("Nhập GPA: ");
        this.gpa = Double.parseDouble(scanner.nextLine());
    }

    // Phương thức in thông tin
    public void print() {
        System.out.printf("ID: %-5d | Tên: %-15s | GPA: %-4.2f | Hệ số: %.2f\n",
                this.id, this.name, this.gpa, this.SCORE_FACTOR);
    }

    // Getter cho GPA để so sánh
    public double getGpa() {
        return this.gpa;
    }

    // 6. Phương thức static để lấy tổng số sinh viên đã tạo
    public static int getTotalStudent() {
        return countStudent;
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== MENU SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm sinh viên GPA cao nhất");
            System.out.println("4. In tổng số sinh viên đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\n--- NHẬP DANH SÁCH SINH VIÊN ---");
                    System.out.print("Bạn muốn nhập bao nhiêu sinh viên? ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập sinh viên thứ " + (i + 1) + ":");
                        Student sv = new Student();
                        sv.input(scanner);
                        studentList.add(sv);
                    }
                    System.out.println("=> Đã nhập xong danh sách!");
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
                    if (studentList.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (Student sv : studentList) {
                            sv.print();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- SINH VIÊN CÓ GPA CAO NHẤT ---");
                    if (studentList.isEmpty()) {
                        System.out.println("Danh sách trống, không thể tìm kiếm!");
                    } else {
                        // Tìm mức GPA cao nhất
                        double maxGpa = studentList.get(0).getGpa();
                        for (Student sv : studentList) {
                            if (sv.getGpa() > maxGpa) {
                                maxGpa = sv.getGpa();
                            }
                        }
                        // In ra tất cả sinh viên có GPA bằng mức cao nhất vừa tìm được
                        for (Student sv : studentList) {
                            if (sv.getGpa() == maxGpa) {
                                sv.print();
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- THỐNG KÊ ---");
                    // Gọi phương thức static trực tiếp từ Tên Lớp (Student)
                    System.out.println("Tổng số đối tượng sinh viên đã được tạo: " + Student.getTotalStudent());
                    break;

                case 0:
                    System.out.println("\nĐã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("\nLựa chọn không hợp lệ, vui lòng thử lại!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
