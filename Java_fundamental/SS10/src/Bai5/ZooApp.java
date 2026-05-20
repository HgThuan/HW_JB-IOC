package Bai5;

import java.util.Scanner;

// ================= LỚP CHA: ANIMAL =================
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("Tên: " + name + " | Tuổi: " + age);
    }

    public void makeSound() {
        System.out.println(name + " đang tạo ra âm thanh...");
    }

    // Overloading (Nạp chồng phương thức)
    public void eat() {
        System.out.println(name + " đang ăn...");
    }

    public void eat(String food) {
        System.out.println(name + " đang ăn " + food + "...");
    }
}

// ================= LỚP KẾ THỪA: MAMMAL =================
class Mammal extends Animal {
    protected boolean hasFur;

    public Mammal(String name, int age, boolean hasFur) {
        super(name, age); // Gọi constructor của lớp cha
        this.hasFur = hasFur;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Có lông mao: " + (hasFur ? "Có" : "Không"));
    }
}

// ================= CÁC LỚP CON CỤ THỂ =================
class Dog extends Mammal {
    public Dog(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " sủa: Gâu gâu!");
    }

    public void fetchBall() {
        System.out.println(name + " đang nhặt bóng!");
    }
}

class Cat extends Mammal {
    public Cat(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " kêu: Meo meo!");
    }

    public void climbTree() {
        System.out.println(name + " đang trèo cây thoăn thoắt!");
    }
}

class Elephant extends Mammal {
    public Elephant(String name, int age, boolean hasFur) {
        super(name, age, hasFur);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " rống: Pa-ruuu!");
    }

    public void sprayWater() {
        System.out.println(name + " đang dùng vòi phun nước!");
    }
}

// ================= CHƯƠNG TRÌNH CHÍNH =================
public class ZooApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo sẵn đối tượng các con vật
        Dog dog = new Dog("Cún", 3, true);
        Cat cat = new Cat("Miu", 2, true);
        Elephant elephant = new Elephant("Voi Bản Đôn", 15, false);

        // Tạo mảng Animal để kiểm tra đa hình runtime
        Animal[] animals = {dog, cat, elephant};

        int choice;
        do {
            System.out.println("\n================= ZOO MANAGEMENT MENU =================");
            System.out.println("1. Tạo đối tượng và hiển thị thông tin (Kế thừa + super)");
            System.out.println("2. Kiểm tra Overriding: gọi makeSound() của từng con vật");
            System.out.println("3. Kiểm tra Overloading: gọi eat() và eat(String)");
            System.out.println("4. Kiểm tra đa hình runtime (Animal array)");
            System.out.println("5. Gọi phương thức đặc trưng của từng loài");
            System.out.println("0. Thoát chương trình");
            System.out.println("=======================================================");
            System.out.print("Lựa chọn của bạn: ");

            choice = scanner.nextInt();
            System.out.println(); // In dòng trống cho đẹp

            switch (choice) {
                case 1:
                    System.out.println("--- Thông tin Dog ---");
                    dog.showInfo();
                    System.out.println("--- Thông tin Cat ---");
                    cat.showInfo();
                    System.out.println("--- Thông tin Elephant ---");
                    elephant.showInfo();
                    break;
                case 2:
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;
                case 3:
                    dog.eat();
                    cat.eat("cá");
                    elephant.eat("mía");
                    break;
                case 4:
                    System.out.println("Duyệt mảng Animal và gọi makeSound() (Đa hình runtime):");
                    for (Animal animal : animals) {
                        animal.makeSound();
                    }
                    break;
                case 5:
                    dog.fetchBall();
                    cat.climbTree();
                    elephant.sprayWater();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình quản lý sở thú!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
        } while (choice != 0);

        scanner.close();
    }
}