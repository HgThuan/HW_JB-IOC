package Bai3;

public class FruitTea extends Drink {

    public FruitTea(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("-> Pha chế: Lắc với đá và trái cây tươi.");
    }
}
