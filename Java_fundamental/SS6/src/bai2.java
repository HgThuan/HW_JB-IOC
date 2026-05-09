import java.util.Scanner;
import java.util.regex.Pattern;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int luaChon = 0;

        // Các biến lưu trữ thông tin của 1 người dùng
        String hoTen = "";
        String email = "";
        String dienThoai = "";
        String matKhau = "";

        do {
            System.out.println("\n***************** QUẢN LÝ NGƯỜI DÙNG *****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.println("******************************************************");
            System.out.print("Lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("-> Vui lòng nhập một số hợp lệ từ 1 đến 6!");
                continue;
            }

            // Kiểm tra xem đã nhập thông tin chưa (trừ khi chọn 1 hoặc 6)
            if (hoTen.isEmpty() && luaChon >= 2 && luaChon <= 5) {
                System.out.println("-> Bạn chưa nhập thông tin. Vui lòng chọn 1 để nhập dữ liệu trước!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập Thông Tin ---");
                    System.out.print("Nhập họ và tên: ");
                    hoTen = scanner.nextLine();

                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();

                    System.out.print("Nhập số điện thoại: ");
                    dienThoai = scanner.nextLine();

                    System.out.print("Nhập mật khẩu: ");
                    matKhau = scanner.nextLine();

                    System.out.println("-> Đã lưu thông tin thành công!");
                    break;

                case 2:
                    hoTen = chuanHoaTen(hoTen);
                    System.out.println("-> Họ tên sau khi chuẩn hóa: " + hoTen);
                    break;

                case 3:
                    if (kiemTraEmail(email)) {
                        System.out.println("-> Email \"" + email + "\" HỢP LỆ.");
                    } else {
                        System.out.println("-> Email \"" + email + "\" KHÔNG HỢP LỆ.");
                    }
                    break;

                case 4:
                    if (kiemTraSoDienThoai(dienThoai)) {
                        System.out.println("-> Số điện thoại \"" + dienThoai + "\" HỢP LỆ.");
                    } else {
                        System.out.println("-> Số điện thoại \"" + dienThoai + "\" KHÔNG HỢP LỆ.");
                    }
                    break;

                case 5:
                    if (kiemTraMatKhau(matKhau)) {
                        System.out.println("-> Mật khẩu HỢP LỆ.");
                    } else {
                        System.out.println("-> Mật khẩu KHÔNG HỢP LỆ (Cần >= 8 ký tự, gồm chữ hoa, chữ thường, số và ký tự đặc biệt).");
                    }
                    break;

                case 6:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("-> Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (luaChon != 6);

        scanner.close();
    }

    // --- CÁC HÀM XỬ LÝ NGHIỆP VỤ ---

    /**
     * Hàm chuẩn hóa họ tên: Xóa khoảng trắng thừa và viết hoa chữ cái đầu mỗi từ
     */
    public static String chuanHoaTen(String ten) {
        // Cắt khoảng trắng 2 đầu và tách các từ dựa trên 1 hoặc nhiều khoảng trắng
        String[] cacTu = ten.trim().split("\\s+");
        StringBuilder tenDaChuanHoa = new StringBuilder();

        for (String tu : cacTu) {
            if (!tu.isEmpty()) {
                // Viết hoa chữ cái đầu và viết thường phần còn lại của từ
                String chuCaiDau = tu.substring(0, 1).toUpperCase();
                String phanConLai = tu.substring(1).toLowerCase();

                tenDaChuanHoa.append(chuCaiDau).append(phanConLai).append(" ");
            }
        }
        // Xóa khoảng trắng dư thừa ở cuối sau khi nối và trả về
        return tenDaChuanHoa.toString().trim();
    }

    /**
     * Hàm kiểm tra Email bằng Regex
     */
    public static boolean kiemTraEmail(String email) {
        // Regex định dạng email cơ bản: [chữ/số/kí_tự_cho_phép] @ [chữ/số/kí_tự] . [tên_miền từ 2-6 kí tự]
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(regexEmail, email);
    }

    /**
     * Hàm kiểm tra Số điện thoại Việt Nam bằng Regex
     */
    public static boolean kiemTraSoDienThoai(String sdt) {
        // Regex số điện thoại VN: Bắt đầu bằng 0, tiếp theo là các đầu số hợp lệ (3, 5, 7, 8, 9), và đúng 8 chữ số tiếp theo (Tổng 10 số)
        String regexSdt = "^0[35789][0-9]{8}$";
        return Pattern.matches(regexSdt, sdt);
    }

    /**
     * Hàm kiểm tra Mật khẩu (Giữ nguyên logic duyệt vòng lặp)
     */
    public static boolean kiemTraMatKhau(String matKhau) {
        if (matKhau == null || matKhau.length() < 8) return false;

        boolean coChuHoa = false, coChuThuong = false, coSo = false, coKytuDacBiet = false;

        for (int i = 0; i < matKhau.length(); i++) {
            char c = matKhau.charAt(i);
            if (Character.isUpperCase(c)) coChuHoa = true;
            else if (Character.isLowerCase(c)) coChuThuong = true;
            else if (Character.isDigit(c)) coSo = true;
            else if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) coKytuDacBiet = true;
        }

        return coChuHoa && coChuThuong && coSo && coKytuDacBiet;
    }
}