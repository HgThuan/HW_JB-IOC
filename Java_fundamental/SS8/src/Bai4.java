import java.util.ArrayList;
import java.util.List;

// Lớp Rectangle biểu diễn hình chữ nhật
class Rectangle {
    // Thuộc tính private để đảm bảo tính đóng gói
    private double width;
    private double height;

    // Constructor có tham số, dùng 'this' để phân biệt thuộc tính và tham số
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getter cho width
    public double getWidth() {
        return this.width;
    }

    // Getter cho height
    public double getHeight() {
        return this.height;
    }

    // Phương thức tính diện tích
    public double getArea() {
        return this.width * this.height;
    }

    // Phương thức tính chu vi
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    // Phương thức toString() để trả về chuỗi mô tả thông tin hình chữ nhật
    @Override
    public String toString() {
        return "width=" + this.width + ", height=" + this.height +
                ", area=" + this.getArea() + ", perimeter=" + this.getPerimeter();
    }
}

// Lớp Main để kiểm thử
public class Bai4 {
    public static void main(String[] args) {
        // Khởi tạo 3 đối tượng Rectangle với các kích thước khác nhau
        Rectangle r1 = new Rectangle(3.0, 4.0);
        Rectangle r2 = new Rectangle(5.0, 2.0);
        Rectangle r3 = new Rectangle(4.5, 3.5);

        // Đưa các hình chữ nhật vào một mảng để dễ quản lý và duyệt
        Rectangle[] rectangles = {r1, r2, r3};

        // In thông tin từng đối tượng sử dụng phương thức toString()
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle " + (i + 1) + ": " + rectangles[i].toString());
        }

        System.out.println(); // In dòng trống cho dễ nhìn

        // Tìm diện tích lớn nhất
        double maxArea = rectangles[0].getArea();
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i].getArea() > maxArea) {
                maxArea = rectangles[i].getArea();
            }
        }

        // Tìm tất cả các hình chữ nhật có diện tích bằng với diện tích lớn nhất
        List<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i].getArea() == maxArea) {
                maxIndices.add(i);
            }
        }

        // In kết quả diện tích lớn nhất và xử lý trường hợp có nhiều hình bằng nhau
        if (maxIndices.size() > 1) {
            System.out.print("Largest area = " + maxArea + " (Có nhiều hình bằng nhau: ");
            for (int i = 0; i < maxIndices.size(); i++) {
                int index = maxIndices.get(i);
                System.out.print("Rectangle " + (index + 1));
                if (i < maxIndices.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        } else {
            // Chỉ có 1 hình có diện tích lớn nhất
            int maxIndex = maxIndices.get(0);
            Rectangle maxRect = rectangles[maxIndex];
            System.out.println("Largest area = " + maxArea + " (Rectangle " + (maxIndex + 1) +
                    ": width=" + maxRect.getWidth() + ", height=" + maxRect.getHeight() + ")");
        }
    }
}