package Bai3;

public abstract class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Phương thức trừu tượng tính lương
    public abstract double calculateSalary();

    // Phương thức in thông tin cơ bản
    public void showInfo() {
        System.out.println("ID: " + id + " | Tên: " + name);
    }
}