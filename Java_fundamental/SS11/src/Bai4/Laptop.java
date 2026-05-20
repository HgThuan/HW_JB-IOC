package Bai4;

public class Laptop extends Device implements Connectable, Chargeable {

    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println("💻 Laptop [" + name + "] đang boot vào hệ điều hành...");
    }

    @Override
    public void turnOff() {
        System.out.println("💻 Laptop [" + name + "] đang Shut down.");
    }

    @Override
    public void connectWifi() {
        System.out.println("   -> Laptop [" + name + "] đã kết nối mạng Wifi (Internet).");
    }

    @Override
    public void charge() {
        System.out.println("   -> Laptop [" + name + "] đã cắm sạc Adapter ⚡");
    }
}
