package Bai2;

public class Computer extends Asset {
    private int ram;
    private String cpu;

    public Computer(String assetCode, String name, double purchasePrice, int yearsUsed, int ram, String cpu) {
        // Sử dụng super() để gán các thuộc tính chung
        super(assetCode, name, purchasePrice, yearsUsed);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        // Khấu hao 20% mỗi năm
        return purchasePrice * Math.pow(0.8, yearsUsed);
    }

    @Override
    public String toString() {
        return "[Máy Tính] " + super.toString() + String.format(" | RAM: %dGB | CPU: %s", ram, cpu);
    }
}