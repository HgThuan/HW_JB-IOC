package Bai2;
import java.util.ArrayList;

// Lớp Book mô tả thông tin cuốn sách
class Book {
    // Khai báo thuộc tính private (Đảm bảo tính đóng gói)
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println(); // In dòng trống để phân cách giữa các cuốn sách
    }
}
public class Main {
    public static void main(String[] args) {
        // 1. Tạo danh sách để lưu các cuốn sách
        ArrayList<Book> bookList = new ArrayList<>();

        // 2. Tạo 3 object Book với thông tin giống như trong kết quả mong muốn
        Book book1 = new Book("Java", "James", 100.0);
        Book book2 = new Book("Python", "Guido", 120.0);
        Book book3 = new Book("C++", "Bjarne", 150.0);

        // Thêm các object vào danh sách
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        // 3. In danh sách sách ra màn hình
        System.out.println("----- LIST OF BOOKS -----");

        // Dùng vòng lặp for-each để duyệt qua từng cuốn sách trong ArrayList
        for (Book b : bookList) {
            b.printInfo();
        }
    }
}
