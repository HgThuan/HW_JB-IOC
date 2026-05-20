package Bai5.ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employees;
    private int empCountInProject = 0;
    private ProjectStatus status;

    public Project() {
        this.employees = new Employee[100]; // Tối đa 100 nhân viên / dự án
    }

    // Getters & Setters
    public String getProjectId() { return projectId; }
    public String getProjectName() { return projectName; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Employee[] getEmployees() { return employees; }
    public int getEmpCountInProject() { return empCountInProject; }
    public ProjectStatus getStatus() { return status; }
    public void setStatus(ProjectStatus status) { this.status = status; }

    public void inputData(Scanner scanner, Project[] arrProject, int index, Employee[] arrEmp, int empIndex) {
        // 1. Nhập Mã dự án
        while (true) {
            System.out.print("Nhập mã dự án (Bắt đầu bằng P, 5 ký tự): ");
            this.projectId = scanner.nextLine();
            if (this.projectId.matches("^P.{4}$")) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrProject[i].getProjectId().equals(this.projectId)) {
                        isExist = true; break;
                    }
                }
                if (!isExist) break;
                else System.out.println("Mã dự án đã tồn tại!");
            } else {
                System.out.println("Mã dự án không hợp lệ!");
            }
        }

        // 2. Nhập Tên dự án (Duy nhất)
        while (true) {
            System.out.print("Nhập tên dự án (10-50 ký tự): ");
            this.projectName = scanner.nextLine();
            if (this.projectName.length() >= 10 && this.projectName.length() <= 50) {
                boolean isExist = false;
                for (int i = 0; i < index; i++) {
                    if (arrProject[i].getProjectName().equalsIgnoreCase(this.projectName)) {
                        isExist = true; break;
                    }
                }
                if (!isExist) break;
                else System.out.println("Tên dự án đã tồn tại!");
            } else {
                System.out.println("Tên dự án phải từ 10 đến 50 ký tự!");
            }
        }

        // 3. Nhập Ngày
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Nhập ngày bắt đầu (dd/MM/yyyy): ");
                this.startDate = LocalDate.parse(scanner.nextLine(), dtf);
                break;
            } catch (Exception e) {
                System.out.println("Định dạng ngày không hợp lệ!");
            }
        }
        while (true) {
            try {
                System.out.print("Nhập ngày kết thúc (dd/MM/yyyy): ");
                this.endDate = LocalDate.parse(scanner.nextLine(), dtf);
                if (!this.endDate.isBefore(this.startDate)) break;
                else System.out.println("Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu!");
            } catch (Exception e) {
                System.out.println("Định dạng ngày không hợp lệ!");
            }
        }

        // 4. Nhập Trạng thái
        while (true) {
            System.out.println("Chọn trạng thái: 1. PLANNING | 2. RUNNING | 3. FINISHED");
            System.out.print("Lựa chọn: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: this.status = ProjectStatus.PLANNING; break;
                    case 2: this.status = ProjectStatus.RUNNING; break;
                    case 3: this.status = ProjectStatus.FINISHED; break;
                    default: System.out.println("Lựa chọn không hợp lệ!"); continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }

    public void addEmployee(Employee emp) {
        if (empCountInProject < employees.length) {
            employees[empCountInProject++] = emp;
            System.out.println("Thêm nhân viên vào dự án thành công!");
        } else {
            System.out.println("Dự án đã đủ số lượng nhân viên!");
        }
    }

    public void displayData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("Mã DA: %-6s | Tên DA: %-20s | Trạng thái: %-10s\n", projectId, projectName, status);
        System.out.printf("Ngày BĐ: %-12s | Ngày KT: %-12s | Số NV: %d\n", startDate.format(dtf), endDate.format(dtf), empCountInProject);
        if (empCountInProject > 0) {
            System.out.println("Danh sách nhân viên:");
            for (int i = 0; i < empCountInProject; i++) {
                System.out.print("  - ");
                employees[i].displayData();
            }
        }
        System.out.println("------------------------------------------------------------------");
    }
}