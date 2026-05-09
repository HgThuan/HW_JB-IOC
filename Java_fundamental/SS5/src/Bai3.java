import java.util.Scanner;
public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Yêu cầu người dùng nhập mật khẩu
        System.out.print("Nhập mật khẩu cần kiểm tra: ");
        String matKhau = scanner.nextLine();

        // 2. Gọi hàm kiểm tra và in kết quả
        if (kiemTraHopLe(matKhau)) {
            System.out.println("Mật khẩu hợp lệ");
        } else {
            System.out.println("Mật khẩu không hợp lệ");
        }

        scanner.close();
    }

    /**
     * Hàm kiểm tra tính hợp lệ của mật khẩu
     */
    public static boolean kiemTraHopLe(String matKhau) {
        // Kiểm tra điều kiện 1: Ít nhất 8 ký tự
        if (matKhau == null || matKhau.length() < 8) {
            return false;
        }

        // Khởi tạo các cờ (flag) để theo dõi các điều kiện còn lại
        boolean coChuHoa = false;
        boolean coChuThuong = false;
        boolean coSo = false;
        boolean coKyTuDacBiet = false;

        // Duyệt qua từng ký tự trong chuỗi mật khẩu
        for (int i = 0; i < matKhau.length(); i++) {
            char kyTu = matKhau.charAt(i);

            if (Character.isUpperCase(kyTu)) {
                coChuHoa = true;
            } else if (Character.isLowerCase(kyTu)) {
                coChuThuong = true;
            } else if (Character.isDigit(kyTu)) {
                coSo = true;
            } else if (!Character.isLetterOrDigit(kyTu) && !Character.isWhitespace(kyTu)) {
                // Nếu ký tự không phải chữ, không phải số, và không phải khoảng trắng
                // thì nó được tính là ký tự đặc biệt (VD: @, #, $, %, v.v.)
                coKyTuDacBiet = true;
            }
        }

        // Mật khẩu chỉ hợp lệ khi TẤT CẢ các cờ đều là true
        return coChuHoa && coChuThuong && coSo && coKyTuDacBiet;
    }
}
