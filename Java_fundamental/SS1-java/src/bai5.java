import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        float cannang;
        float chieucao;
        float BMI;
        Scanner sc = new Scanner(System.in);
        cannang = sc.nextFloat();
        chieucao = sc.nextFloat();
        BMI = cannang/(chieucao*chieucao);
        System.out.println("BMI is "+BMI);
    }
}
