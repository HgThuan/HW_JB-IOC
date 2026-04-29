import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Khởi tạo các biến để lưu trữ thống kê
        int tongSoHocVien = 0;
        double tongDiem = 0;
        double diemCaoNhat = -1; // Khởi tạo mốc cực nhỏ
        double diemThapNhat = 11; // Khởi tạo mốc cực lớn

        // Vòng lặp vô hạn để giữ Menu luôn hiển thị cho đến khi người dùng chọn Thoát
        while (true) {
            System.out.println("\n==================================");
            System.out.println("    CHƯƠNG TRÌNH QUẢN LÝ ĐIỂM     ");
            System.out.println("==================================");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát chương trình");
            System.out.print("Vui lòng chọn chức năng (1-3): ");

            int luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- CHỨC NĂNG 1: NHẬP ĐIỂM ---");
                    while (true) {
                        System.out.print("Nhập điểm (0-10) hoặc nhập -1 để kết thúc: ");
                        double diem = sc.nextDouble();

                        // Kiểm tra điều kiện thoát nhập
                        if (diem == -1) {
                            System.out.println(">> Đã dừng nhập điểm.");
                            break;
                        }

                        // Kiểm tra điểm không hợp lệ (ngoài 0-10)
                        if (diem < 0 || diem > 10) {
                            System.out.println("Cảnh báo: Điểm không hợp lệ! Yêu cầu nhập lại.");
                            continue; // Bỏ qua phần bên dưới, quay lại vòng lặp để nhập lại
                        }

                        // Phân loại học lực theo các mốc điểm
                        String xepLoai = "";
                        if (diem >= 9) {
                            xepLoai = "Xuất sắc";
                        } else if (diem >= 8) {
                            xepLoai = "Giỏi";
                        } else if (diem >= 7) {
                            xepLoai = "Khá";
                        } else if (diem >= 5) {
                            xepLoai = "Trung Bình";
                        } else {
                            xepLoai = "Yếu";
                        }
                        System.out.println("-> Xếp loại: " + xepLoai);

                        // Cập nhật các biến thống kê
                        tongSoHocVien++;
                        tongDiem += diem;

                        // Tìm điểm cao nhất và thấp nhất
                        if (tongSoHocVien == 1) {
                            // Nếu là học viên đầu tiên, điểm đó vừa là Max vừa là Min
                            diemCaoNhat = diem;
                            diemThapNhat = diem;
                        } else {
                            // Cập nhật Max, Min từ học viên thứ 2 trở đi
                            if (diem > diemCaoNhat) diemCaoNhat = diem;
                            if (diem < diemThapNhat) diemThapNhat = diem;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- CHỨC NĂNG 2: THỐNG KÊ ---");
                    // Kiểm tra xem đã có học viên nào được nhập chưa
                    if (tongSoHocVien == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        double diemTrungBinh = tongDiem / tongSoHocVien;
                        System.out.printf("Số học viên đã nhập : %d\n", tongSoHocVien);
                        System.out.printf("Điểm trung bình     : %.2f\n", diemTrungBinh);
                        System.out.printf("Điểm cao nhất       : %.2f\n", diemCaoNhat);
                        System.out.printf("Điểm thấp nhất      : %.2f\n", diemThapNhat);
                    }
                    break;

                case 3:
                    System.out.println("\nĐã thoát chương trình. Tạm biệt!");
                    sc.close();
                    System.exit(0); // Lệnh tắt chương trình ngay lập tức
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chỉ chọn từ 1 đến 3.");
                    break;
            }
        }
    }
}
