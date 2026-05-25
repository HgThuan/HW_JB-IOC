package Bai2;

public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice(String assetCode, String name, double purchasePrice, int yearsUsed, int numberOfPorts) {
        // Sử dụng super() để gán các thuộc tính chung
        super(assetCode, name, purchasePrice, yearsUsed);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        // Khấu hao 10% mỗi năm
        return purchasePrice * Math.pow(0.9, yearsUsed);
    }

    @Override
    public String toString() {
        return "[Thiết Bị Mạng] " + super.toString() + String.format(" | Số cổng: %d", numberOfPorts);
    }
}
