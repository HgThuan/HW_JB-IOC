import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang : ");
        int n = sc.nextInt();
        if (n <0) {
            System.out.println("nhap lai");
            sc.close();
            return;
        };
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        };
        int result[] = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }
        for (int i=0;i<n;i++){
            if(arr[i]%2!=0){
                result[index++] = arr[i];
            }
        }
        System.out.print("Mảng sau khi sắp xếp: ");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

    }
}
