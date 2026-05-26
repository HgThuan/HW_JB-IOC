package Bai6;

import java.util.Objects;

public class Contact {
    // Biến static để tự động tăng ID cho mỗi đối tượng tạo mới
    private static int idCounter = 1;

    private int id;
    private String name;
    private String phoneNumber;

    // Constructor đầy đủ tham số (ID tự động tăng)
    public Contact(String name, String phoneNumber) {
        this.id = idCounter++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Constructor không tham số
    public Contact() {
        this.id = idCounter++;
    }

    // Constructor phụ: Dùng để tạo đối tượng "ảo" khi tìm kiếm/xóa
    // Không làm tăng idCounter để tránh hao hụt ID
    public Contact(String phoneNumber) {
        this.id = 0;
        this.phoneNumber = phoneNumber;
    }

    // --- Getters và Setters ---
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // --- BẮT BUỘC: Ghi đè equals và hashCode dựa trên phoneNumber ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Nếu trỏ cùng vùng nhớ
        if (o == null || getClass() != o.getClass()) return false; // Khác kiểu dữ liệu
        Contact contact = (Contact) o;
        // So sánh tính duy nhất qua số điện thoại
        return Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    // Phương thức hỗ trợ in thông tin
    @Override
    public String toString() {
        return String.format("ID: %-3d | Tên: %-15s | SĐT: %s", id, name, phoneNumber);
    }
}