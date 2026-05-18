import java.util.Scanner;

// Lớp tiện ích (Utility Class) xử lý tiền tệ
class CurrencyConverter {
    // 1. Thuộc tính static: Quản lý trạng thái toàn cục của tỉ giá
    private static double rate = 25400.0; // Mặc định 1 USD = 25,400 VND
    private CurrencyConverter() {}

    // 2. Phương thức static: Thiết lập tỉ giá kèm theo validation
    public static void setRate(double r) {
        if (r <= 0) {
            System.out.println("Lỗi: Tỉ giá phải lớn hơn 0. Giữ nguyên tỉ giá cũ.");
        } else {
            rate = r;
        }
    }

    // Phương thức static: Lấy tỉ giá hiện tại
    public static double getRate() {
        return rate;
    }

    // 3. Phương thức static: Chuyển đổi VND sang USD (Theo yêu cầu đề bài dùng int)
    public static double toUSD(int vnd) {
        if (vnd < 0) {
            System.out.println("Lỗi: Số tiền không hợp lệ.");
            return 0;
        }
        return vnd / rate;
    }

    // Khắc phục giới hạn của int: Nạp chồng (Overload) hàm toUSD bằng kiểu long
    public static double toUSD(long vnd) {
        if (vnd < 0) {
            System.out.println("Lỗi: Số tiền không hợp lệ.");
            return 0;
        }
        return (double) vnd / rate;
    }

    // 4. Phương thức static: Format hiển thị tiền tệ
    public static String formatUSD(double usd) {
        return String.format("$%,.2f", usd);
    }
}

// Lớp Main để kiểm thử chương trình
public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== CÔNG CỤ QUY ĐỔI TIỀN TỆ =====");
        System.out.printf("Tỉ giá hiện hành: 1 USD = %,.0f VND\n", CurrencyConverter.getRate());

        // Test 1: Đổi tiền với hàm toUSD(int)
        int tienNho = 5000000; // 5 triệu VND
        double usd1 = CurrencyConverter.toUSD(tienNho);
        System.out.printf("Quy đổi %,d VND = %s\n", tienNho, CurrencyConverter.formatUSD(usd1));

        // Cập nhật tỉ giá toàn cục
        System.out.print("\nNhập tỉ giá mới (VND/USD): ");
        double newRate = Double.parseDouble(scanner.nextLine());
        CurrencyConverter.setRate(newRate);
        System.out.printf("=> Tỉ giá đã cập nhật: 1 USD = %,.0f VND\n", CurrencyConverter.getRate());

        // Test 2: Minh họa hậu quả khi dùng kiểu 'int' cho tiền tệ VND
        System.out.println("\n--- Vấn Đề Kiểu Dữ Liệu (int vs long) ---");
        System.out.println("Giới hạn lớn nhất của kiểu int trong Java là 2,147,483,647.");
        System.out.println("Nếu bạn có 3 TỶ VNĐ, biến int sẽ bị tràn bộ nhớ (Overflow) sinh ra số âm.");

        long tienLon = 3000000000L;
        double usd2 = CurrencyConverter.toUSD(tienLon);
        System.out.printf("Quy đổi %,d VND = %s\n", tienLon, CurrencyConverter.formatUSD(usd2));

        scanner.close();
    }
}