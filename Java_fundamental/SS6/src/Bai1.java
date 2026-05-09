import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Double> danhsach = new ArrayList<>();
        int chon = 0;
        do {
            System.out.println("***********Quan ly diem sinh vien***********\n");
            System.out.println("1.Nhập danh sách điểm sinh viên ");
            System.out.println("2.In danh sach diem");
            System.out.println("3.Tinh diem trung binh cua sinh vien");
            System.out.println("4.Tim diem cao nhat");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            try {
                chon = Integer.parseInt(sc.nextLine());
                }catch(NumberFormatException e){
                System.out.println("Vui lòng nhập một số hợp lệ từ 1 đến 8!");
                continue;
            }
            if (danhsach.isEmpty() && chon >= 2 && chon <= 7) {
                System.out.println("-> Danh sách điểm đang trống. Vui lòng chọn 1 để nhập điểm trước!");
                continue;
            }
            switch (chon) {
                case 1:
                    System.out.print("Bạn muốn nhập điểm cho bao nhiêu sinh viên? ");
                    int soLuong = 0;
                    try {
                        soLuong = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Số lượng phải là số nguyên!");
                        break;
                    }

                    for (int i = 0; i < soLuong; i++) {
                        double diem = -1;
                        // Vòng lặp đảm bảo điểm nhập vào phải hợp lệ (từ 0 đến 10)
                        while (diem < 0 || diem > 10) {
                            System.out.print("Nhập điểm cho sinh viên thứ " + (danhsach.size() + 1) + " (0 - 10): ");
                            try {
                                diem = Double.parseDouble(sc.nextLine());
                                if (diem < 0 || diem > 10) {
                                    System.out.println("Điểm không hợp lệ. Vui lòng nhập từ 0 đến 10.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập một con số!");
                            }
                        }
                        danhsach.add(diem);
                    }
                    System.out.println("-> Nhập điểm thành công!");
                    break;

                    case 2:
                        System.out.println("\n--- Danh Sách Điểm Sinh Viên ---");
                        for (int i = 0; i < danhsach.size(); i++) {
                            System.out.println("Sinh viên " + (i + 1) + ": " + danhsach.get(i));
                        }
                        break;
                case 3:
                    double tong = 0;
                    for (Double diem : danhsach) {
                        tong += diem;
                    }
                    double diemTrungBinh = tong / danhsach.size();
                    // In ra với định dạng 2 chữ số thập phân
                    System.out.printf("-> Điểm trung bình của lớp là: %.2f\n", diemTrungBinh);
                    break;

                case 4:
                    // Sử dụng Collections.max và min cho ArrayList
                    double diemMax = Collections.max(danhsach);
                    double diemMin = Collections.min(danhsach);
                    System.out.println("-> Điểm cao nhất: " + diemMax);
                    System.out.println("-> Điểm thấp nhất: " + diemMin);
                    break;

                case 5:
                    int dat = 0, truot = 0;
                    for (Double diem : danhsach) {
                        if (diem >= 5.0) { // Yêu cầu: Đạt khi điểm >= 5
                            dat++;
                        } else {           // Trượt khi điểm < 5
                            truot++;
                        }
                    }
                    System.out.println("-> Số lượng sinh viên ĐẠT: " + dat);
                    System.out.println("-> Số lượng sinh viên TRƯỢT: " + truot);
                    break;

                case 6:
                    Collections.sort(danhsach);
                    System.out.println("-> Đã sắp xếp danh sách điểm TĂNG DẦN thành công!");
                    System.out.println("   (Bạn có thể chọn phím 2 để xem lại danh sách)");
                    break;

                case 7:
                    int gioiXuatSac = 0;
                    for (Double diem : danhsach) {
                        if (diem >= 8.0) { // Yêu cầu: Giỏi và xuất sắc khi điểm >= 8
                            gioiXuatSac++;
                        }
                    }
                    System.out.println("-> Số lượng sinh viên đạt loại GIỎI và XUẤT SẮC: " + gioiXuatSac);
                    break;

                case 8:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (chon != 8);


    }
}
