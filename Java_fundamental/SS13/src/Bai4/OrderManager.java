package Bai4;

import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    private ArrayList<Order> orderList = new ArrayList<>();

    @Override
    public void add(Order item) {
        orderList.add(item);
        System.out.println("Đơn hàng đã được thêm thành công.");
    }

    @Override
    public void update(int index, Order item) {
        if (index >= 0 && index < orderList.size()) {
            orderList.set(index, item);
            System.out.println("Đơn hàng đã được sửa thành công.");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < orderList.size()) {
            orderList.remove(index);
            System.out.println("Đơn hàng đã được xóa thành công.");
        }
    }

    @Override
    public void display() {
        if (orderList.isEmpty()) {
            System.out.println("Danh sách đơn hàng hiện đang trống.");
        } else {
            for (int i = 0; i < orderList.size(); i++) {
                // In ra số thứ tự bắt đầu từ 1
                System.out.println((i + 1) + ". " + orderList.get(i).toString());
            }
        }
    }

    // Hàm hỗ trợ: Tìm vị trí (index) của đơn hàng thông qua Mã đơn hàng
    // ignoreCase để người dùng nhập "OD0001" hay "od0001" đều hợp lệ
    public int findIndexById(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    // Hàm hỗ trợ: Lấy đối tượng Order tại vị trí index
    public Order getOrder(int index) {
        return orderList.get(index);
    }
}