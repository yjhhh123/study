package Day2;

import java.util.Scanner;

public class study11 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        int num;
        int count = 0;
        do{
            System.out.print("양의 정수 입력");
            num = scanner.nextInt();
        }while(num <= 0);

        int temp = num;

        do {
            temp /= 10;
            count++;
        } while (temp > 0);
        //while안의 조건이 참일 때까지

        System.out.println(num + "는 " + count + "자리 입니다.");
    }
}
