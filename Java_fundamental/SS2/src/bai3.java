import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n<0) {n=Math.abs(n);};
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }
        System.out.println(sum);
        sc.close();
    }
}
