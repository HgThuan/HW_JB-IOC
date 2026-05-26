package Bai3;

import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice> {
    private ArrayList<Invoice> invoiceList = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        invoiceList.add(item);
        System.out.println("Hóa đơn đã được thêm thành công.");
    }

    @Override
    public void update(int index, Invoice item) {
        if (index >= 0 && index < invoiceList.size()) {
            invoiceList.set(index, item);
            System.out.println("Hóa đơn đã được sửa thành công.");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < invoiceList.size()) {
            invoiceList.remove(index);
            System.out.println("Hóa đơn đã được xóa thành công.");
        }
    }

    @Override
    public void display() {
        if (invoiceList.isEmpty()) {
            System.out.println("Danh sách hóa đơn hiện đang trống.");
        } else {
            for (int i = 0; i < invoiceList.size(); i++) {
                System.out.println((i + 1) + ". " + invoiceList.get(i).toString());
            }
        }
    }

    // Hàm hỗ trợ: Tìm vị trí index của hóa đơn dựa vào Mã hóa đơn
    public int findIndexById(String id) {
        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getInvoiceId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    // Hàm hỗ trợ: Lấy đối tượng Invoice ra để xem mã cũ
    public Invoice getInvoice(int index) {
        return invoiceList.get(index);
    }
}