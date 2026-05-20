package Bai3;

public class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    @Override
    public double calculateSalary() {
        return this.baseSalary;
    }

    @Override
    public double calculateBonus() {
        return this.baseSalary * 0.10; // Thưởng 10% lương cơ bản
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Loại: Full-time | Lương cơ bản: " + baseSalary);
    }
}
