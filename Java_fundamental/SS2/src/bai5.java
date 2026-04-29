import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class bai5 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        num = sc.nextInt();
        if (num <100||num>999){
            System.out.println("Invalid number (100<num<999)");
            return ;
        };
        int hundred = num/100;
        int ten = (num/10)%10;
        int units = num%10;
        System.out.print( " Ket Qua");
        switch (hundred) {
            case 1: System.out.print(" Mot tram"); break;
            case 2: System.out.print(" Hai tram");break;
            case 3: System.out.print(" Ba tram");break;
            case 4: System.out.print(" Bon tram");break;
            case 5: System.out.print(" Nam tram");break;
            case 6: System.out.print(" Sau tram");break;
            case 7: System.out.print(" bay tram");break;
            case 8: System.out.print(" Tam tram");break;
            case 9: System.out.print(" Chin tram");break;
        }
        switch (ten) {
            case 0:
                if (units != 0) System.out.print("lẻ ");
                break;
            case 1: System.out.print("mười "); break;
            case 2: System.out.print("hai mươi "); break;
            case 3: System.out.print("ba mươi "); break;
            case 4: System.out.print("bốn mươi "); break;
            case 5: System.out.print("năm mươi "); break;
            case 6: System.out.print("sáu mươi "); break;
            case 7: System.out.print("bảy mươi "); break;
            case 8: System.out.print("tám mươi "); break;
            case 9: System.out.print("chín mươi "); break;
        }
        switch (units) {
            case 0:
                break; // Nếu hàng đơn vị là 0 thì không in gì thêm (VD: 120 -> Một trăm hai mươi)
            case 1:
                if (ten > 1) System.out.print("mốt"); // VD: 121 -> Một trăm hai mươi mốt
                else System.out.print("một");          // VD: 111 -> Một trăm mười một
                break;
            case 2: System.out.print("hai"); break;
            case 3: System.out.print("ba"); break;
            case 4:
                if (ten > 1) System.out.print("tư");  // VD: 124 -> Một trăm hai mươi tư
                else System.out.print("bốn");          // VD: 104 -> Một trăm lẻ bốn
                break;
            case 5:
                if (ten > 0) System.out.print("lăm"); // VD: 115 -> Một trăm mười lăm
                else System.out.print("năm");          // VD: 105 -> Một trăm lẻ năm
                break;
            case 6: System.out.print("sáu"); break;
            case 7: System.out.print("bảy"); break;
            case 8: System.out.print("tám"); break;
            case 9: System.out.print("chín"); break;
        }

        System.out.println();
        sc.close();
    }
}
