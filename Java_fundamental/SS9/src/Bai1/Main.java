package Bai1;
import java.util.Scanner;

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public void printInfo() {
        System.out.println("\n--- THÔNG TIN HÌNH CHỮ NHẬT ---");
        System.out.println("Chiều rộng : " + this.width);
        System.out.println("Chiều cao  : " + this.height);
        System.out.println("Diện tích  : " + this.getArea());
        System.out.println("Chu vi     : " + this.getPerimeter());
        System.out.println("-------------------------------");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== CHƯƠNG TRÌNH TÍNH HÌNH CHỮ NHẬT =====");

        System.out.print("Nhập chiều rộng: ");
        double w = scanner.nextDouble();

        System.out.print("Nhập chiều cao: ");
        double h = scanner.nextDouble();

        Rectangle myRectangle = new Rectangle(w, h);
        myRectangle.printInfo();

        scanner.close();
    }
}
