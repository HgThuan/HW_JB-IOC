import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if(a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Ba cạnh không tạo thành tam giác");
        }
         else if (a==b & a==c) {
            System.out.println("Tam giác đều: Ba cạnh bằng nhau.");
        } else if (a==b & a!=c) {
            System.out.println("Tam giác cân: Hai cạnh bằng nhau");
        } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            System.out.println("Tam giác vuông");
        } else {System.out.println("Tam giac thuong");}
    }
}
