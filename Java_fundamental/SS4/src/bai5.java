import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien");
        int n = sc.nextInt();
        double point [] = new double[n];
        for (int i = 0; i <n; i++) {
            System.out.print("Nhap diem cho sinh vien "+(i+1)+":");
            point [i] = sc.nextDouble();
        }
        int choice;
        do{
            System.out.println("----QUAN LY DIEM SINH VIEN-----");
            System.out.println("1.Xem tat ca diem");
            System.out.println("2.Sap xep diem");
            System.out.println("3.Tim kiem diem");
            System.out.println("4.Thong ke diem");
            System.out.println("0.Thoat");
            System.out.print("Chon chuc nang:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:Xemdiem(point);break;
                case 2:Sapxep(point,sc);break;
                case 3:Timkiem(point,sc);break;
                case 4:Thongke(point);break;
                case 0:
                    System.out.println("Ket thuc");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }while (choice != 0);
    };

    public static void Xemdiem(double[] point){
       for(int i=0;i<point.length;i++){
           System.out.println("Diem cua sinh vien"+(i+1)+":"+ point[i]);
       }
    };
    public static  void Sapxep(double[] point, Scanner sc){
        int x;
        System.out.print("Lua chon sap xep (1.Tang/ 2.Giam)");
        x = sc.nextInt();
        if(x==1){
            int n=point.length;
            boolean  swapped;
            for(int i=0;i<n-1;i++){
                swapped=false;
                for(int j=0;j<n-1;j++){
                    if(point[i]>point[j]){
                        double temp = point[j];
                        point[j] = point[j+1];
                        point[j+1] = temp;
                        swapped=true;
                    }
                }
                System.out.println("Mang sau sap xep:");
                for (double s : point) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }else  if(x==2){
            int n=point.length;
            for(int i=0;i<n-1;i++){
                int Minindex=i;
                for(int j=i+1;j<n;j++){
                    if (point[j]>point[Minindex]){
                        Minindex=j;
                    }
                    double temp = point[Minindex];
                    point[Minindex] = point[j];
                    point[j] = temp;
                }
            };
            System.out.println("Mang sau sap xep:");
            for (double s : point) {
                System.out.print(s + " ");
            }
        }

    };
    static void Timkiem(double [] point, Scanner sc){
        System.out.print("Nhap so diem can tim :");
        double x = sc.nextDouble();
        int left =0, right = point.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(point[mid]==x){
                System.out.println("Tim thay tai vi tri: " + mid);
                return;
            }
            if(point[mid]<x){
                left=mid+1;

            } else {
                right=mid-1;
            }
        }
        System.out.println("Khong tim thay!");
    };

    static void Thongke(double [] point){
        double sum=0;
        double min=point[0];
        double max=point[0];
        for (double s : point) {
            sum += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }

        double avg = sum / point.length;

        int count = 0;
        for (double s : point) {
            if (s > avg) count++;
        }

        System.out.println("Tong diem: " + sum);
        System.out.println("Diem trung binh: " + avg);
        System.out.println("Diem cao nhat: " + max);
        System.out.println("Diem thap nhat: " + min);
        System.out.println("So sinh vien > trung binh: " + count);
    };

}
