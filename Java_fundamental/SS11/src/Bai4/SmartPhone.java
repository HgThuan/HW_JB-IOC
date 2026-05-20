package Bai4;

public class SmartPhone extends Device implements Connectable, Chargeable {

    public SmartPhone(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println("📱 SmartPhone [" + name + "] đang khởi động...");
    }

    @Override
    public void turnOff() {
        System.out.println("📱 SmartPhone [" + name + "] đang tắt nguồn.");
    }

    @Override
    public void connectWifi() {
        System.out.println("   -> SmartPhone [" + name + "] đã kết nối Wifi thành công.");
    }

    @Override
    public void charge() {
        System.out.println("   -> SmartPhone [" + name + "] đang sạc pin ⚡");
    }
}