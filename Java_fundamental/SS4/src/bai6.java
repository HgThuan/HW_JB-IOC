import java.util.Scanner;
import java.util.Arrays;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong nhan vien: ");
        int n = sc.nextInt();

        double[] salaries = new double[n];

        // Nhập lương
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap luong cho nhan vien thu " + (i + 1) + ": ");
            salaries[i] = sc.nextDouble();
        }

        int luachon;

        do {
            System.out.println("\n========= HE THONG QUAN LY LUONG =========");
            System.out.println("1. Xem danh sach luong");
            System.out.println("2. Sap xep luong");
            System.out.println("3. Tim kiem luong");
            System.out.println("4. Thong ke luong");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            luachon = sc.nextInt();

            switch (luachon) {
                case 1:
                    XemDanhSach(salaries);
                    break;
                case 2:
                    SapXep(salaries, sc);
                    break;
                case 3:
                    TimKiem(salaries, sc);
                    break;
                case 4:
                    ThongKe(salaries);
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (luachon != 0);

        sc.close();
    }

    // 1. Xem danh sách
    static void XemDanhSach(double[] salaries) {
        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Nhan vien " + (i + 1) + ": " + salaries[i]);
        }
    }

    // 2. Sắp xếp
    static void SapXep(double[] salaries, Scanner sc) {
        System.out.print("Chon kieu sap xep (1: Tang dan, 2: Giam dan): ");
        int type = sc.nextInt();

        Arrays.sort(salaries);

        if (type == 2) {
            // đảo mảng
            for (int i = 0; i < salaries.length / 2; i++) {
                double temp = salaries[i];
                salaries[i] = salaries[salaries.length - 1 - i];
                salaries[salaries.length - 1 - i] = temp;
            }
        }

        System.out.println("Mang sau sap xep:");
        for (double s : salaries) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // 3. Tìm kiếm
    static void TimKiem(double[] salaries, Scanner sc) {
        System.out.print("Nhap luong can tim: ");
        double x = sc.nextDouble();

        boolean found = false;

        for (int i = 0; i < salaries.length; i++) {
            if (salaries[i] == x) {
                System.out.println("Tim thay tai vi tri: " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay!");
        }
    }

    // 4. Thống kê
    static void ThongKe(double[] salaries) {
        double sum = 0;
        double max = salaries[0];
        double min = salaries[0];

        for (double s : salaries) {
            sum += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }

        double avg = sum / salaries.length;

        int count = 0;
        for (double s : salaries) {
            if (s > avg) count++;
        }

        System.out.println("Tong luong: " + sum);
        System.out.println("Luong trung binh: " + avg);
        System.out.println("Luong cao nhat: " + max);
        System.out.println("Luong thap nhat: " + min);
        System.out.println("So nhan vien > trung binh: " + count);
    }
}