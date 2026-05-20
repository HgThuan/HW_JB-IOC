package Bai5.ra.entity;

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Role role;
    private double salary;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Role role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }

    // Getters & Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void inputData(Scanner scanner, Employee[] arrEmp, int index) {
        // 1. Nhập và validate Mã nhân viên
        while (true) {
            System.out.print("Nhập mã nhân viên (Bắt đầu bằng E, 5 ký tự): ");
            this.employeeId = scanner.nextLine();
            if (this.employeeId.matches("^E.{4}$")) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrEmp[i].getEmployeeId().equals(this.employeeId)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) break;
                else System.out.println("Mã nhân viên đã tồn tại, vui lòng nhập lại!");
            } else {
                System.out.println("Mã nhân viên không hợp lệ!");
            }
        }

        // 2. Nhập và validate Tên nhân viên
        while (true) {
            System.out.print("Nhập tên nhân viên (6-30 ký tự): ");
            this.employeeName = scanner.nextLine();
            if (this.employeeName.length() >= 6 && this.employeeName.length() <= 30) {
                break;
            } else {
                System.out.println("Tên nhân viên phải từ 6 đến 30 ký tự!");
            }
        }

        // 3. Nhập Role
        while (true) {
            System.out.println("Chọn vai trò: 1. DEV | 2. TESTER | 3. PM | 4. BA");
            System.out.print("Lựa chọn: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: this.role = Role.DEV; break;
                    case 2: this.role = Role.TESTER; break;
                    case 3: this.role = Role.PM; break;
                    case 4: this.role = Role.BA; break;
                    default: System.out.println("Lựa chọn không hợp lệ!"); continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }

        // 4. Nhập lương
        while (true) {
            System.out.print("Nhập lương (> 0): ");
            try {
                this.salary = Double.parseDouble(scanner.nextLine());
                if (this.salary > 0) break;
                else System.out.println("Lương phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public void displayData() {
        System.out.printf("Mã NV: %-6s | Tên NV: %-20s | Vai trò: %-6s | Lương: %.2f\n",
                employeeId, employeeName, role, salary);
    }
}