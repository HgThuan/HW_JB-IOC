package Bai4;

public class Television extends Device implements Connectable {

    public Television(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println("📺 Television [" + name + "] đang bật màn hình.");
    }

    @Override
    public void turnOff() {
        System.out.println("📺 Television [" + name + "] đã tắt (Chế độ Standby).");
    }

    @Override
    public void connectWifi() {
        System.out.println("   -> Television [" + name + "] đang bắt sóng Wifi gia đình.");
    }
}