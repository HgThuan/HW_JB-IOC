import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> danhsach = new ArrayList<>();
        int chon;

        do {
            System.out.println("\n========== QUẢN LÝ TÊN SINH VIÊN ==========");
            System.out.println("1. Thêm tên sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm số sinh viên có tên bắt đầu bằng chữ cái nhập vào");
            System.out.println("5. Sắp xếp danh sách tên theo thứ tự A-Z");
            System.out.println("6. Thoát");
            System.out.println("===========================================");
            System.out.print("Nhập lựa chọn của bạn: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhap ten sinh vien: ");
                    String ten = sc.nextLine();
                    danhsach.add(ten);
                    System.out.println("Da them: " + ten);
                    break;

                case 2:
                    System.out.println("-------Danh sach sinh vien--------");
                    if (danhsach.isEmpty()) {
                        System.out.println("Danh sach trong");
                    } else {
                        for (int i = 0; i < danhsach.size(); i++) {
                            System.out.println((i + 1) + ". " + danhsach.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhap tu khoa muon tim: ");
                    String tukhoa = sc.nextLine().toLowerCase();
                    boolean timthay = false;

                    for (String sv : danhsach) {
                        if (sv.toLowerCase().contains(tukhoa)) {
                            timthay = true;
                            System.out.println(sv);
                        }
                    }

                    if (!timthay) {
                        System.out.println("Khong tim thay sinh vien nao chua tu khoa: " + tukhoa);
                    }
                    break;

                case 4:
                    System.out.print("Nhập chữ cái bắt đầu cần đếm: ");
                    String chuCai = sc.nextLine().trim().toLowerCase();
                    int dem = 0;

                    for (String sv : danhsach) {
                        if (sv.toLowerCase().startsWith(chuCai)) {
                            dem++;
                        }
                    }
                    System.out.println("-> Có " + dem + " sinh viên có tên bắt đầu bằng chữ '" + chuCai + "'");
                    break;

                case 5:
                    Collections.sort(danhsach);
                    System.out.println("Danh sach da duoc sap xep tu A-Z");
                    break;

                case 6:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 6.");
            }
        } while (chon != 6);

        sc.close();
    }
}