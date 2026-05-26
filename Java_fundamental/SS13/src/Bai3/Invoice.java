package Bai3;

public class Invoice {
    private String invoiceId;
    private double amount;

    public Invoice(String invoiceId, double amount) {
        this.invoiceId = invoiceId;
        this.amount = amount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        // Định dạng số tiền có dấu phẩy/chấm cho dễ đọc (tùy chọn)
        return "Mã hóa đơn: " + invoiceId + ", Số tiền: " + amount;
    }
}
