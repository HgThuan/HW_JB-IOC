import java.util.Scanner;

public class bai1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== NHẬP THÔNG TIN MUA HÀNG ===");
        System.out.print("Nhập tên khách hàng: ");
        String tenKhachHang = sc.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = sc.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double giaSanPham = sc.nextDouble();

        System.out.print("Nhập số lượng mua: ");
        int soLuong = sc.nextInt();

        System.out.print("Khách có thẻ thành viên không? (true/false): ");
        boolean coTheThanhVien = sc.nextBoolean();

        double thanhTien = giaSanPham * soLuong;

        double giamGia = 0;
        if (coTheThanhVien) {
            giamGia = thanhTien * 0.10;
        }

        double tienSauGiam = thanhTien - giamGia;
        double vat = tienSauGiam * 0.08;

        double tongThanhToan = thanhTien - giamGia + vat;

        System.out.println("\n=============================================");
        System.out.println("                HÓA ĐƠN BÁN HÀNG               ");
        System.out.println("=============================================");
        System.out.printf("Khách hàng     : %s\n", tenKhachHang);
        System.out.printf("Sản phẩm       : %s\n", tenSanPham);
        System.out.printf("Số lượng       : %d\n", soLuong);
        System.out.printf("Đơn giá        : %,.2f VNĐ\n", giaSanPham);
        System.out.println("---------------------------------------------");
        System.out.printf("Thành tiền     : %,.2f VNĐ\n", thanhTien);
        System.out.printf("Giảm giá (10%%) : %,.2f VNĐ\n", giamGia);
        System.out.printf("Thuế VAT (8%%)  : %,.2f VNĐ\n", vat);
        System.out.println("---------------------------------------------");
        System.out.printf("TỔNG THANH TOÁN: %,.2f VNĐ\n", tongThanhToan);
        System.out.println("=============================================");

        sc.close();
    }
}
