package Bai1;

public class Lecturer extends Staff {
    private int teachingHours;

    public Lecturer(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    public int getTeachingHours() { return teachingHours; }
    public void setTeachingHours(int teachingHours) { this.teachingHours = teachingHours; }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + (teachingHours * 200_000);
    }

    @Override
    public void checkPerformance() {
        if (teachingHours > 40) {
            System.out.println("Đánh giá: Giảng viên xuất sắc (Vượt giờ dạy).");
        } else {
            System.out.println("Đánh giá: Giảng viên đạt yêu cầu.");
        }
    }

    @Override
    public String toString() {
        return "[Giảng Viên] " + super.toString() + String.format(" | Giờ dạy: %d | Tổng lương: %,.0f VNĐ", teachingHours, calculateTotalSalary());
    }
}