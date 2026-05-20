package Bai3;

public class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public int getWorkingHours() { return workingHours; }
    public void setWorkingHours(int workingHours) { this.workingHours = workingHours; }
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    @Override
    public double calculateSalary() {
        return this.workingHours * this.hourlyRate;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Loại: Part-time | Giờ làm: " + workingHours + " | Lương/giờ: " + hourlyRate);
    }
}
