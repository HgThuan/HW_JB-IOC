package Bai3;

public class Coffee extends Drink {

    public Coffee(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("-> Pha chế: Pha bằng máy espresso.");
    }
}