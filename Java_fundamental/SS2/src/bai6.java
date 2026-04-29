import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n < 0 ) {
            System.out.println("Số nhập vào không hợp lệ");
            return ;
        };
        System.out.println("Các số Armstrong trong khoảng từ 0 đến " + n + " là:");
        for (int i = 0; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
    };
    public static boolean isArmstrong(int num){
        int totalSum = 0;
        int x = num;
        int k = (x == 0) ? 1 : (int) Math.log10(Math.abs(x)) + 1;
        while (x > 0) {
            int digit = x % 10;
            totalSum += Math.pow(digit, k);
            x = x / 10;
        }
        return totalSum == num;
    }
}

