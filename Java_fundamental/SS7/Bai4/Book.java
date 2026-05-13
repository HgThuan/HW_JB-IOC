public class Book {
    public String title;
    public String author;
    public double price;

    public void printInfo() {
        System.out.println("Thông tin sách:");
        System.out.println("- Tiêu đề: " + title);
        System.out.println("- Tác giả: " + author);
        System.out.println("- Giá: " + price);
    }
}