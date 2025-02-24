package Day2;

import java.util.Scanner;

public class study10 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("a값 : ");
        int a = scanner.nextInt();
        int b;

        do{
            System.out.print("b값 : ");
            b = scanner.nextInt();
            if(b <= a){
                System.out.println("a보다 큰 값을 입력하세요!");
            }
        }while(b <= a);

        int result = b - a;

        System.out.println("b - a는 " + result + "입니다.");
    }
}
