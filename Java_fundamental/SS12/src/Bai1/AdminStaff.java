package Bai1;

public class AdminStaff extends Staff {
    private double bonus;

    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        if (bonus > 1_000_000) {
            System.out.println("Đánh giá: Nhân viên hoàn thành xuất sắc nhiệm vụ.");
        } else {
            System.out.println("Đánh giá: Nhân viên hoàn thành tốt nhiệm vụ.");
        }
    }

    @Override
    public String toString() {
        return "[Hành Chính] " + super.toString() + String.format(" | Thưởng: %,.0f | Tổng lương: %,.0f VNĐ", bonus, calculateTotalSalary());
    }
}