import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> danhSachBienSo = new ArrayList<>();
        int luaChon = 0;

        do {
            // Hiển thị menu giống hệt trong ảnh
            System.out.println("\n**************** QUẢN LÝ BIỂN SỐ XE ****************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            // Bắt lỗi nhập chữ thay vì số
            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("-> Lỗi: Vui lòng nhập một số nguyên từ 1 đến 6!");
                continue;
            }

            // Kiểm tra danh sách rỗng (ngoại trừ chức năng thêm và thoát)
            if (danhSachBienSo.isEmpty() && luaChon >= 2 && luaChon <= 5) {
                System.out.println("-> Danh sách hiện đang trống. Vui lòng chọn 1 để thêm biển số trước!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.print("Bạn muốn thêm bao nhiêu biển số xe? ");
                    int soLuong = 0;
                    try {
                        soLuong = Integer.parseInt(scanner.nextLine());
                        if (soLuong <= 0) {
                            System.out.println("-> Số lượng phải lớn hơn 0.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("-> Lỗi: Vui lòng nhập một số nguyên!");
                        break;
                    }

                    for (int i = 0; i < soLuong; i++) {
                        System.out.print("Nhập biển số thứ " + (i + 1) + ": ");
                        String bienSo = scanner.nextLine().trim().toUpperCase(); // Viết hoa toàn bộ cho chuẩn form
                        danhSachBienSo.add(bienSo);
                    }
                    System.out.println("-> Đã thêm thành công " + soLuong + " biển số!");
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH BIỂN SỐ XE ---");
                    for (int i = 0; i < danhSachBienSo.size(); i++) {
                        System.out.println((i + 1) + ". " + danhSachBienSo.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Nhập biển số xe hoặc cụm ký tự cần tìm: ");
                    String tuKhoa = scanner.nextLine().toUpperCase();
                    boolean timThay = false;

                    System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                    for (String bs : danhSachBienSo) {
                        if (bs.contains(tuKhoa)) {
                            System.out.println("- " + bs);
                            timThay = true;
                        }
                    }
                    if (!timThay) {
                        System.out.println("-> Không tìm thấy biển số nào khớp với: " + tuKhoa);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã tỉnh (VD: 29, 30, 51...): ");
                    String maTinh = scanner.nextLine().trim();
                    boolean coBienMaTinh = false;

                    System.out.println("\n--- CÁC BIỂN SỐ THUỘC TỈNH " + maTinh + " ---");
                    for (String bs : danhSachBienSo) {
                        // Dùng startsWith để kiểm tra xem biển số có bắt đầu bằng mã tỉnh không
                        if (bs.startsWith(maTinh)) {
                            System.out.println("- " + bs);
                            coBienMaTinh = true;
                        }
                    }
                    if (!coBienMaTinh) {
                        System.out.println("-> Không có biển số nào thuộc mã tỉnh: " + maTinh);
                    }
                    break;

                case 5:
                    Collections.sort(danhSachBienSo);
                    System.out.println("-> Đã sắp xếp danh sách biển số xe theo thứ tự TĂNG DẦN thành công!");
                    System.out.println("   (Nhấn phím 2 để xem lại danh sách)");
                    break;

                case 6:
                    System.out.println("Đã thoát chương trình quản lý. Tạm biệt!");
                    break;

                default:
                    System.out.println("-> Lựa chọn không hợp lệ. Vui lòng chọn số từ 1 đến 6!");
            }
        } while (luaChon != 6);

        scanner.close();
    }
}