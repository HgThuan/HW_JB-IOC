//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
 Scanner sc = new Scanner(System.in);
 String s = sc.next();
 int lenString = s.length();
 int count = lenString;
 int sum = 0;
 while (count > 0) {
     char[] arr = new char[lenString];
     count = count - 1;
     for (int i = 0; i < lenString; i++) {
         for (int j = 0; j < lenString; j++) {
             if(arr[i]==arr[j]) {
                 sum = sum +1;
             }
         }
     }
 }
 System.out.print( sum+ " ");
}
