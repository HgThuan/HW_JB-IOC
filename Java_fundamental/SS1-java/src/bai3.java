import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int d;
        int x;
        int y;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        x= a*d + b*c;
        y= b*d;
        System.out.println(x+"/"+y);
    }
}
