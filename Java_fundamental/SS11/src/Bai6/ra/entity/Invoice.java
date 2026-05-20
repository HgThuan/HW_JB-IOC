package Bai6.ra.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] invoiceDetails;
    private double totalAmount;
    private int detailCount = 0;

    public Invoice() {
        this.invoiceDetails = new InvoiceDetail[100]; // Giả sử tối đa 100 chi tiết mỗi hóa đơn
    }

    // Getters and Setters...
    public String getInvoiceId() { return invoiceId; }
    public String getCustomerName() { return customerName; }
    public Date getInvoiceDate() { return invoiceDate; }
    public double getTotalAmount() { return totalAmount; }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        while (true) {
            System.out.print("Nhập mã hóa đơn (HDxxxx): ");
            this.invoiceId = scanner.nextLine();
            if (this.invoiceId.matches("^HD\\d{4}$")) break;
            System.out.println("Mã hóa đơn không đúng định dạng!");
        }

        System.out.print("Nhập tên khách hàng: ");
        this.customerName = scanner.nextLine();

        while (true) {
            System.out.print("Nhập ngày lập hóa đơn (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                this.invoiceDate = sdf.parse(dateStr);
                break;
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ!");
            }
        }

        System.out.print("Nhập số lượng loại sản phẩm muốn mua: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập chi tiết sản phẩm thứ " + (i + 1) + ":");
            InvoiceDetail detail = new InvoiceDetail();
            detail.inputData(scanner, arrProd, prodIndex);
            invoiceDetails[detailCount++] = detail;
        }
        calculateTotalAmount();
    }

    public void calculateTotalAmount() {
        this.totalAmount = 0;
        for (int i = 0; i < detailCount; i++) {
            this.totalAmount += invoiceDetails[i].getSubTotal();
        }
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("---------------------------------------------------");
        System.out.printf("Mã HĐ: %s | Khách hàng: %s | Ngày: %s\n", invoiceId, customerName, sdf.format(invoiceDate));
        System.out.println("Chi tiết hóa đơn:");
        for (int i = 0; i < detailCount; i++) {
            invoiceDetails[i].displayData();
        }
        System.out.printf("Tổng tiền hóa đơn: %.2f\n", totalAmount);
        System.out.println("---------------------------------------------------");
    }
}