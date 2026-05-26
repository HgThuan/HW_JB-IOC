package Bai5;

public class Student {
    // Biến static để đếm và cấp phát ID tự động
    private static int idCounter = 1;

    private int id;
    private String name;
    private double gpa;

    // Constructor không có ID vì ID sẽ tự động tăng
    public Student(String name, double gpa) {
        this.id = idCounter++;
        this.name = name;
        this.gpa = gpa;
    }

    // --- Getters và Setters ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Ghi đè phương thức toString để in thông tin sinh viên theo định dạng
    @Override
    public String toString() {
        return String.format("Mã SV: %-3d | Họ tên: %-20s | GPA: %-4.1f", id, name, gpa);
    }
}