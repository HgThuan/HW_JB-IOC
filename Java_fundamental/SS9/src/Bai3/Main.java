package Bai3;
import java.util.ArrayList;

class Student {
    private String id;
    private String fullName;
    private int age;
    private double gpa;

    private static int count = 0;

    public final double MIN_GPA = 0.0;
    public final double MAX_GPA = 4.0;

    public Student(String id, String fullName, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;

        if (gpa >= MIN_GPA && gpa <= MAX_GPA) {
            this.gpa = gpa;
        } else {
            System.out.println("Cảnh báo: GPA của " + fullName + " không hợp lệ. Đang gán về mặc định (" + MIN_GPA + ").");
            this.gpa = MIN_GPA;
        }

        count++;
    }

    public void printInfo() {
        System.out.printf("ID: %-7s | Tên: %-20s | Tuổi: %-3d | GPA: %.2f\n",
                this.id, this.fullName, this.age, this.gpa);
    }

    public static int getCount() {
        return count;
    }
}
public class Main {
    public static void main(String[] args) {
        // Quản lý list object bằng ArrayList
        ArrayList<Student> studentList = new ArrayList<>();

        // 1. Tạo 3 object Student
        Student sv1 = new Student("SV001", "Nguyen Van A", 20, 3.2);
        Student sv2 = new Student("SV002", "Tran Thi B", 21, 3.8);
        Student sv3 = new Student("SV003", "Le Van C", 19, 2.5);
        // Thêm vào danh sách
        studentList.add(sv1);
        studentList.add(sv2);
        studentList.add(sv3);

        System.out.println("===== DANH SÁCH SINH VIÊN =====");

        // 2. In thông tin từng sinh viên
        for (Student sv : studentList) {
            sv.printInfo();
        }

        System.out.println("-------------------------------");

        System.out.println("Tổng số sinh viên hệ thống đã ghi nhận: " + Student.getCount());
    }
}
