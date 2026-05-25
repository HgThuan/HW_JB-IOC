package Bai1;

public abstract class Staff implements ICapability {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    // Phương thức trừu tượng để tính lương
    public abstract double calculateTotalSalary();

    @Override
    public String toString() {
        return String.format("ID: %s | Tên: %s | Lương cơ bản: %,.0f VNĐ", id, name, baseSalary);
    }
}
