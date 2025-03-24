package Day14;

import java.util.Scanner;

public class Factorial {
   static int fac(int n){
       return (n > 0) ? n * fac(n - 1) : 1;
   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int x = scanner.nextInt();

        System.out.println(x + "의 팩토리얼은 " + fac(x) + " 입니다.");
    }
}
