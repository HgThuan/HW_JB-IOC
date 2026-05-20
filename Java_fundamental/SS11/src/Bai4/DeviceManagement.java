package Bai4;

public class DeviceManagement {
    public static void main(String[] args) {
        // 1. Quản lý danh sách Device[]
        Device[] devices = new Device[3];
        devices[0] = new SmartPhone(1, "iPhone 15 Pro");
        devices[1] = new Laptop(2, "MacBook Air M2");
        devices[2] = new Television(3, "Samsung Smart TV 4K");

        System.out.println("====== HỆ THỐNG QUẢN LÝ THIẾT BỊ ĐIỆN TỬ ======");

        // 2. Duyệt qua mảng và thực hiện các chức năng
        for (Device device : devices) {
            System.out.println("\n-------------------------------------------");

            // Bật thiết bị
            device.turnOn();

            // Nếu hỗ trợ wifi -> kết nối
            if (device instanceof Connectable) {
                ((Connectable) device).connectWifi();
            }

            // Nếu sạc được -> sạc
            if (device instanceof Chargeable) {
                ((Chargeable) device).charge();
            }

            // Tắt thiết bị
            device.turnOff();
        }
        System.out.println("-------------------------------------------");
    }
}
