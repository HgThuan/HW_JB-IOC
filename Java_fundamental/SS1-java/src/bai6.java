import java.util.Scanner;

public class bai6 {

 public static  void main(String[] args) {
     double vantoc ;
     double quangduong;
     double thoigian;
     Scanner scanner = new Scanner(System.in);
     System.out.println("Nhap van toc");
     vantoc = scanner.nextDouble();
     System.out.println("Nhap thoi gian");
     thoigian = scanner.nextDouble();
     quangduong = vantoc * thoigian;
     System.out.println("Quang duong di la "+quangduong);
 }
}
