import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu cua mang: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Nhap mang:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // Đã bỏ dấu ; thừa

        System.out.print("Mang ban dau: ");
        printArray(arr);

        // Sắp xếp chọn (Selection sort)
        Sapxep(arr);
        System.out.print("Mang sau khi sap xep giam dan: ");
        printArray(arr); // Đã thêm lệnh in mảng

        // Nhập số cần tìm
        System.out.print("Nhap so can tim kiem: ");
        int target = sc.nextInt(); // Sửa lỗi chính tả taget -> target

        // Tìm kiếm nhị phân
        int binaryResult = binarySearchDescending(arr, target);
        System.out.println("--- Tim kiem nhi phan ---");
        if (binaryResult != -1) {
            System.out.println("Phan tu nam o vi tri index: " + binaryResult);
        } else {
            System.out.println("Khong tim thay phan tu.");
        }

        // Tìm kiếm tuyến tính
        int linearResult = linearSearch(arr, target);
        System.out.println("--- Tim kiem tuyen tinh ---");
        if (linearResult != -1) {
            System.out.println("Phan tu nam o vi tri index: " + linearResult);
        } else {
            System.out.println("Khong tim thay phan tu.");
        }

        sc.close();
    }

    static void Sapxep(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int max_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[max_idx]) {
                    max_idx = j;
                }
            }
            if (max_idx != i) {
                int temp = arr[max_idx];
                arr[max_idx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearchDescending(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}