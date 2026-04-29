import java.util.Scanner;

public class bai3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        // Các biến thống kê toàn cục
        int tongNhanVien = 0;
        double tongLuong = 0;
        double luongCaoNhat = 0;
        double luongThapNhat = 0;
        double tongTienThuong = 0; // Biến cộng dồn tổng tiền thưởng

        while (true) {
            System.out.println("\n========================================");
            System.out.println("    CHƯƠNG TRÌNH QUẢN LÝ LƯƠNG NV       ");
            System.out.println("========================================");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng");
            System.out.println("4. Thoát chương trình");
            System.out.print("Vui lòng chọn chức năng (1-4): ");

            int luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- CHỨC NĂNG 1: NHẬP LƯƠNG ---");
                    System.out.println("(Lưu ý: Nhập số tiền đầy đủ, ví dụ 5 triệu nhập là 5000000)");
                    while (true) {
                        System.out.print("Nhập lương (0 - 500,000,000) hoặc -1 để thoát: ");
                        double luong = sc.nextDouble();

                        // Kết thúc quá trình nhập
                        if (luong == -1) {
                            System.out.println(">> Đã dừng quá trình nhập lương.");
                            break;
                        }

                        // Kiểm tra tính hợp lệ
                        if (luong < 0 || luong > 500000000) {
                            System.out.println("Cảnh báo: Lương ngoài phạm vi cho phép! Vui lòng nhập lại.");
                            continue;
                        }

                        // Phân loại thu nhập
                        String phanLoai = "";
                        if (luong < 5000000) {
                            phanLoai = "Thu nhập thấp";
                        } else if (luong < 15000000) {
                            phanLoai = "Thu nhập trung bình";
                        } else if (luong < 50000000) {
                            phanLoai = "Thu nhập khá";
                        } else {
                            phanLoai = "Thu nhập cao";
                        }
                        System.out.println("-> Phân loại: " + phanLoai);

                        // Tính tiền thưởng cho nhân viên này và cộng dồn vào tổng
                        double tienThuong = 0;
                        if (luong < 5000000) {
                            tienThuong = luong * 0.05;
                        } else if (luong < 15000000) {
                            tienThuong = luong * 0.10;
                        } else if (luong < 50000000) {
                            tienThuong = luong * 0.15;
                        } else if (luong < 100000000) {
                            tienThuong = luong * 0.20;
                        } else { // >= 100M
                            tienThuong = luong * 0.25;
                        }
                        tongTienThuong += tienThuong; // Cộng dồn tiền thưởng

                        // Cập nhật thống kê cơ bản
                        tongNhanVien++;
                        tongLuong += luong;

                        // Cập nhật Min/Max
                        if (tongNhanVien == 1) {
                            luongCaoNhat = luong;
                            luongThapNhat = luong;
                        } else {
                            if (luong > luongCaoNhat) luongCaoNhat = luong;
                            if (luong < luongThapNhat) luongThapNhat = luong;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- CHỨC NĂNG 2: BẢNG THỐNG KÊ ---");
                    if (tongNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        double luongTrungBinh = tongLuong / tongNhanVien;
                        System.out.printf("Số nhân viên đã nhập : %d\n", tongNhanVien);
                        System.out.printf("Lương trung bình     : %,.2f VNĐ\n", luongTrungBinh);
                        System.out.printf("Lương cao nhất       : %,.2f VNĐ\n", luongCaoNhat);
                        System.out.printf("Lương thấp nhất      : %,.2f VNĐ\n", luongThapNhat);
                        System.out.printf("Tổng tiền lương      : %,.2f VNĐ\n", tongLuong);
                    }
                    break;

                case 3:
                    System.out.println("\n--- CHỨC NĂNG 3: THỐNG KÊ TIỀN THƯỞNG ---");
                    if (tongNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        System.out.printf("Tổng số tiền thưởng cần chi trả: %,.2f VNĐ\n", tongTienThuong);
                    }
                    break;

                case 4:
                    System.out.println("\nĐã thoát chương trình. Tạm biệt!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chỉ chọn từ 1 đến 4.");
                    break;
            }
        }
    }
}
