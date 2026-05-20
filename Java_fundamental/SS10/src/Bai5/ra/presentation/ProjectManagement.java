package Bai5.ra.presentation;

import Bai5.ra.entity.Employee;
import Bai5.ra.entity.Project;
import Bai5.ra.entity.ProjectStatus;
import Bai5.ra.entity.Role;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ProjectManagement {
    static Employee[] arrEmp = new Employee[100];
    static int empIndex = 0;
    static Project[] arrProject = new Project[100];
    static int projIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n================ QUẢN LÝ DỰ ÁN ================");
            System.out.println("1. Quản lý nhân viên");
            System.out.println("2. Quản lý dự án");
            System.out.println("3. Thoát");
            System.out.println("===============================================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: employeeMenu(scanner); break;
                    case 2: projectMenu(scanner); break;
                    case 3:
                        System.out.println("Thoát chương trình!");
                        System.exit(0);
                    default: System.out.println("Vui lòng chọn từ 1-3.");
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void employeeMenu(Scanner scanner) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n============== QUẢN LÝ NHÂN VIÊN ==============");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Cập nhật thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên theo tên");
            System.out.println("6. Sắp xếp nhân viên theo lương giảm dần");
            System.out.println("7. Thoát");
            System.out.println("===============================================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Employee emp = new Employee();
                        emp.inputData(scanner, arrEmp, empIndex);
                        arrEmp[empIndex++] = emp;
                        System.out.println("Thêm nhân viên thành công!");
                        break;
                    case 2:
                        if (empIndex == 0) { System.out.println("Danh sách trống!"); }
                        for (int i = 0; i < empIndex; i++) arrEmp[i].displayData();
                        break;
                    case 3:
                        // Cập nhật (Viết rút gọn logic tìm kiếm)
                        System.out.print("Nhập mã NV cần cập nhật: ");
                        String idUpdate = scanner.nextLine();
                        boolean foundUpdate = false;
                        for (int i = 0; i < empIndex; i++) {
                            if (arrEmp[i].getEmployeeId().equals(idUpdate)) {
                                System.out.println("Nhập thông tin mới (Mã không đổi): ");
                                arrEmp[i].setEmployeeName(scanner.nextLine());
                                // Tương tự cho các trường khác...
                                System.out.println("Cập nhật thành công!");
                                foundUpdate = true; break;
                            }
                        }
                        if (!foundUpdate) System.out.println("Không tìm thấy NV!");
                        break;
                    case 4:
                        System.out.print("Nhập mã NV cần xóa: ");
                        String idDel = scanner.nextLine();
                        int delIndex = -1;
                        for (int i = 0; i < empIndex; i++) {
                            if (arrEmp[i].getEmployeeId().equals(idDel)) { delIndex = i; break; }
                        }
                        if (delIndex != -1) {
                            for (int i = delIndex; i < empIndex - 1; i++) { arrEmp[i] = arrEmp[i + 1]; }
                            arrEmp[--empIndex] = null;
                            System.out.println("Xóa thành công!");
                        } else System.out.println("Không tìm thấy NV!");
                        break;
                    case 5:
                        System.out.print("Nhập tên cần tìm: ");
                        String searchName = scanner.nextLine().toLowerCase();
                        for (int i = 0; i < empIndex; i++) {
                            if (arrEmp[i].getEmployeeName().toLowerCase().contains(searchName)) {
                                arrEmp[i].displayData();
                            }
                        }
                        break;
                    case 6:
                        for (int i = 0; i < empIndex - 1; i++) {
                            for (int j = i + 1; j < empIndex; j++) {
                                if (arrEmp[i].getSalary() < arrEmp[j].getSalary()) {
                                    Employee temp = arrEmp[i];
                                    arrEmp[i] = arrEmp[j];
                                    arrEmp[j] = temp;
                                }
                            }
                        }
                        System.out.println("Đã sắp xếp! Chọn mục 2 để xem.");
                        break;
                    case 7: isExit = true; break;
                    default: System.out.println("Vui lòng chọn từ 1-7.");
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void projectMenu(Scanner scanner) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("\n================ QUẢN LÝ DỰ ÁN ================");
            System.out.println("1. Thêm dự án");
            System.out.println("2. Hiển thị danh sách dự án");
            System.out.println("3. Cập nhật thông tin dự án");
            System.out.println("4. Xóa dự án (chỉ khi chưa có nhân viên tham gia)");
            System.out.println("5. Thêm nhân viên vào dự án");
            System.out.println("6. Tìm dự án theo tên");
            System.out.println("7. Thống kê số lượng nhân viên theo vai trò trong từng dự án");
            System.out.println("8. Tìm dự án đang chạy và gần kết thúc nhất");
            System.out.println("9. Thoát");
            System.out.println("===============================================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Project proj = new Project();
                        proj.inputData(scanner, arrProject, projIndex, arrEmp, empIndex);
                        arrProject[projIndex++] = proj;
                        System.out.println("Thêm dự án thành công!");
                        break;
                    case 2:
                        if (projIndex == 0) { System.out.println("Danh sách trống!"); }
                        for (int i = 0; i < projIndex; i++) arrProject[i].displayData();
                        break;
                    case 3:
                        System.out.println("Chức năng cập nhật đang hoàn thiện...");
                        break;
                    case 4:
                        System.out.print("Nhập mã dự án cần xóa: ");
                        String idDel = scanner.nextLine();
                        int delPIndex = -1;
                        for (int i = 0; i < projIndex; i++) {
                            if (arrProject[i].getProjectId().equals(idDel)) {
                                if (arrProject[i].getEmpCountInProject() == 0) {
                                    delPIndex = i;
                                } else {
                                    System.out.println("Dự án đã có nhân viên tham gia, không thể xóa!");
                                    return; // Thoát case 4
                                }
                                break;
                            }
                        }
                        if (delPIndex != -1) {
                            for (int i = delPIndex; i < projIndex - 1; i++) { arrProject[i] = arrProject[i + 1]; }
                            arrProject[--projIndex] = null;
                            System.out.println("Xóa dự án thành công!");
                        } else System.out.println("Không tìm thấy dự án hợp lệ để xóa!");
                        break;
                    case 5:
                        System.out.print("Nhập mã dự án muốn thêm nhân viên: ");
                        String pId = scanner.nextLine();
                        Project targetProject = null;
                        for (int i = 0; i < projIndex; i++) {
                            if (arrProject[i].getProjectId().equals(pId)) {
                                targetProject = arrProject[i]; break;
                            }
                        }
                        if (targetProject == null) {
                            System.out.println("Không tìm thấy dự án!"); break;
                        }

                        System.out.println("Danh sách nhân viên hiện có:");
                        for (int i = 0; i < empIndex; i++) {
                            System.out.printf("%d. %s - %s\n", (i+1), arrEmp[i].getEmployeeId(), arrEmp[i].getEmployeeName());
                        }
                        System.out.print("Nhập STT nhân viên muốn thêm: ");
                        int empChoice = Integer.parseInt(scanner.nextLine());
                        if (empChoice > 0 && empChoice <= empIndex) {
                            targetProject.addEmployee(arrEmp[empChoice - 1]);
                        } else {
                            System.out.println("STT không hợp lệ!");
                        }
                        break;
                    case 6:
                        System.out.print("Nhập tên dự án cần tìm: ");
                        String searchPName = scanner.nextLine().toLowerCase();
                        for (int i = 0; i < projIndex; i++) {
                            if (arrProject[i].getProjectName().toLowerCase().contains(searchPName)) {
                                arrProject[i].displayData();
                            }
                        }
                        break;
                    case 7:
                        for (int i = 0; i < projIndex; i++) {
                            int dev=0, tester=0, pm=0, ba=0;
                            Project p = arrProject[i];
                            for (int j = 0; j < p.getEmpCountInProject(); j++) {
                                Role r = p.getEmployees()[j].getRole();
                                if (r == Role.DEV) dev++;
                                else if (r == Role.TESTER) tester++;
                                else if (r == Role.PM) pm++;
                                else if (r == Role.BA) ba++;
                            }
                            System.out.printf("Dự án %s: DEV(%d), TESTER(%d), PM(%d), BA(%d)\n", p.getProjectName(), dev, tester, pm, ba);
                        }
                        break;
                    case 8:
                        Project nearestEndProject = null;
                        long minDays = Long.MAX_VALUE;
                        LocalDate now = LocalDate.now();

                        for (int i = 0; i < projIndex; i++) {
                            Project p = arrProject[i];
                            if (p.getStatus() == ProjectStatus.RUNNING) {
                                long daysBetween = ChronoUnit.DAYS.between(now, p.getEndDate());
                                if (daysBetween >= 0 && daysBetween < minDays) {
                                    minDays = daysBetween;
                                    nearestEndProject = p;
                                }
                            }
                        }

                        if (nearestEndProject != null) {
                            System.out.println("Dự án đang chạy gần kết thúc nhất:");
                            nearestEndProject.displayData();
                        } else {
                            System.out.println("Không có dự án nào đang chạy ở hiện tại!");
                        }
                        break;
                    case 9: isExit = true; break;
                    default: System.out.println("Vui lòng chọn từ 1-9.");
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}