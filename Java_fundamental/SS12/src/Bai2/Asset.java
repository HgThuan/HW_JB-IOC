package Bai2;

public abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;
    protected int yearsUsed; // Bổ sung để tính khấu hao theo năm

    public Asset(String assetCode, String name, double purchasePrice, int yearsUsed) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.yearsUsed = yearsUsed;
    }

    public String getAssetCode() { return assetCode; }
    public double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }

    // Phương thức trừu tượng
    public abstract double getMarketValue();

    @Override
    public String toString() {
        return String.format("Mã: %s | Tên: %s | Giá mua gốc: %,.0f | Đã dùng: %d năm",
                assetCode, name, purchasePrice, yearsUsed);
    }
}