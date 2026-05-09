import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chuoiHienTai = "";
        int luaChon = 0;

        do {
            System.out.println("\n============= XỬ LÝ CHUỖI =============");
            System.out.println("1. Nhập chuỗi mới");
            System.out.println("2. Đếm số lượng các loại ký tự");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome (chuỗi đối xứng)");
            System.out.println("5. Chuẩn hóa chuỗi");
            System.out.println("6. Thoát");
            System.out.println("=======================================");
            System.out.print("Nhập lựa chọn của bạn: ");

            // Xử lý việc nhập lỗi (người dùng nhập chữ thay vì số)
            try {
                luaChon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên!");
                continue;
            }

            // Kiểm tra xem đã nhập chuỗi chưa (ngoại trừ chọn 1 và 6)
            if (chuoiHienTai.isEmpty() && luaChon >= 2 && luaChon <= 5) {
                System.out.println("Bạn chưa nhập chuỗi nào. Vui lòng chọn 1 để nhập chuỗi trước!");
                continue;
            }

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập một chuỗi bất kỳ: ");
                    chuoiHienTai = sc.nextLine();
                    System.out.println("-> Đã lưu chuỗi: \"" + chuoiHienTai + "\"");
                    break;

                case 2:
                    demKyTu(chuoiHienTai);
                    break;

                case 3:
                    String chuoiDaoNguoc = new StringBuilder(chuoiHienTai).reverse().toString();
                    System.out.println("-> Chuỗi đảo ngược: " + chuoiDaoNguoc);
                    break;

                case 4:
                    if (kiemTraPalindrome(chuoiHienTai)) {
                        System.out.println("-> \"" + chuoiHienTai + "\" LÀ chuỗi đối xứng (Palindrome).");
                    } else {
                        System.out.println("-> \"" + chuoiHienTai + "\" KHÔNG PHẢI là chuỗi đối xứng.");
                    }
                    break;

                case 5:
                    chuoiHienTai = chuanHoaChuoi(chuoiHienTai);
                    System.out.println("-> Chuỗi sau khi chuẩn hóa: \"" + chuoiHienTai + "\"");
                    break;

                case 6:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 6.");
            }
        } while (luaChon != 6);

        sc.close();
    }

    // --- Các hàm hỗ trợ xử lý nghiệp vụ ---

    // Hàm đếm các loại ký tự
    public static void demKyTu(String str) {
        int chuThuong = 0, chuHoa = 0, chuSo = 0, dacBiet = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLowerCase(ch)) {
                chuThuong++;
            } else if (Character.isUpperCase(ch)) {
                chuHoa++;
            } else if (Character.isDigit(ch)) {
                chuSo++;
            } else {
                dacBiet++; // Bao gồm cả khoảng trắng, dấu câu...
            }
        }

        System.out.println("--- Kết quả phân loại ký tự ---");
        System.out.println("- Chữ thường: " + chuThuong);
        System.out.println("- Chữ hoa: " + chuHoa);
        System.out.println("- Chữ số: " + chuSo);
        System.out.println("- Ký tự đặc biệt (gồm khoảng trắng): " + dacBiet);
    }

    // Hàm kiểm tra chuỗi đối xứng
    public static boolean kiemTraPalindrome(String str) {
        // Loại bỏ khoảng trắng và chuyển về chữ thường để kiểm tra chính xác hơn
        // (Ví dụ: "Race car" vẫn được coi là palindrome nếu bỏ qua khoảng trắng và viết hoa)
        String chuoiGoc = str.replaceAll("\\s+", "").toLowerCase();

        // Đảo ngược chuỗi
        String chuoiDao = new StringBuilder(chuoiGoc).reverse().toString();

        // So sánh
        return chuoiGoc.equals(chuoiDao);
    }

    // Hàm chuẩn hóa chuỗi
    public static String chuanHoaChuoi(String str) {
        // 1. Xóa khoảng trắng ở đầu và cuối, thay thế nhiều khoảng trắng liền nhau bằng 1 khoảng trắng
        str = str.trim().replaceAll("\\s+", " ");

        // 2. Viết hoa chữ cái đầu tiên, các ký tự khác giữ nguyên
        if (str.isEmpty()) {
            return str;
        }

        // Tách chữ cái đầu (in hoa) và phần còn lại của chuỗi
        String chuCaiDau = str.substring(0, 1).toUpperCase();
        String phanConLai = str.substring(1); // Giữ nguyên, không dùng toLowerCase()

        return chuCaiDau + phanConLai;
    }
}
