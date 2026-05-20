package Bai3;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo mảng danh sách nhân viên
        Employee[] employees = new Employee[3];
        employees[0] = new FullTimeEmployee(101, "Nguyễn Văn A", 15000000);
        employees[1] = new PartTimeEmployee(102, "Trần Thị B", 120, 50000);
        employees[2] = new FullTimeEmployee(103, "Lê Văn C", 20000000);

        System.out.println("====== HỆ THỐNG TÍNH LƯƠNG NHÂN VIÊN ======");

        // Duyệt qua mảng nhân viên
        for (Employee emp : employees) {
            System.out.println("-------------------------------------------");

            // In thông tin cơ bản
            emp.showInfo();

            // In mức lương
            System.out.println("Lương tính toán: " + emp.calculateSalary());

            // Kiểm tra điều kiện nhận thưởng bằng instanceof
            if (emp instanceof BonusEligible) {
                // Ép kiểu (Type-cast) về BonusEligible
                BonusEligible eligibleEmp = (BonusEligible) emp;
                System.out.println("Tiền thưởng: " + eligibleEmp.calculateBonus());
            } else {
                System.out.println("Tiền thưởng: Không có thưởng");
            }
        }

        System.out.println("-------------------------------------------");
    }
}