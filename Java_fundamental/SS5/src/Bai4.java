import java.util.Random;
import java.util.Scanner;
public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // 1. Nhập và kiểm tra điều kiện của n (1 <= n <= 1000)
        while (true) {
            System.out.print("Nhập độ dài chuỗi cần tạo n (1 <= n <= 1000): ");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n >= 1 && n <= 1000) {
                    break; // Thoát vòng lặp nếu n hợp lệ
                } else {
                    System.out.println("Lỗi: Độ dài n phải nằm trong khoảng từ 1 đến 1000!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            }
        }

        // 2. Gọi hàm tạo chuỗi ngẫu nhiên và in kết quả
        String ketQua = taoChuoi(n);
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Chuỗi ngẫu nhiên có độ dài " + n + " là:");
        System.out.println(ketQua);

        scanner.close();
    }

    /**
     * Hàm tạo chuỗi ngẫu nhiên gồm chữ hoa, chữ thường và số
     */
    public static String taoChuoi(int n) {
        // Tập hợp các ký tự cho phép (A-Z, a-z, 0-9)
        String tapKyTu = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Sử dụng StringBuilder với sức chứa (capacity) khởi tạo sẵn bằng n
        // Điều này giúp tối ưu hóa bộ nhớ, không cần cấp phát lại khi nối chuỗi
        StringBuilder chuoiNgauNhien = new StringBuilder(n);

        Random random = new Random();

        // Lặp n lần, mỗi lần chọn ngẫu nhiên 1 ký tự từ tapKyTu để ghép vào
        for (int i = 0; i < n; i++) {
            // Lấy một vị trí index ngẫu nhiên từ 0 đến chiều dài của tapKyTu - 1
            int viTriNgauNhien = random.nextInt(tapKyTu.length());

            // Lấy ký tự tại vị trí đó và nối vào StringBuilder
            char kyTu = tapKyTu.charAt(viTriNgauNhien);
            chuoiNgauNhien.append(kyTu);
        }

        // Chuyển đổi StringBuilder về lại dạng String thông thường và trả về
        return chuoiNgauNhien.toString();
    }
}
